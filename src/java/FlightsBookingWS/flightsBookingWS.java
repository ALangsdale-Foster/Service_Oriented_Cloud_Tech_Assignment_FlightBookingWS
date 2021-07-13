/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FlightsBookingWS;

import generated.*;
import java.io.File;
import static java.lang.System.out;
import java.math.BigInteger;
import java.util.Iterator;
import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 *
 * @author Anthony Langsdale-Foster
 */
@WebService(serviceName = "flightsBookingWS")
public class flightsBookingWS {
    
    @WebMethod(operationName = "Unmarshaller")
    public Flights Unmarshaller() {
        Flights flights = new Flights();
        String filepath = "C:\\Users\\7734\\Desktop\\SERVICE COMPUTING\\Courseowrk\\FlightBookingWS\\flights.xml";
        try {
            javax.xml.bind.JAXBContext jaxbCtx = javax.xml.bind.JAXBContext.newInstance(flights.getClass().getPackage().getName());
            javax.xml.bind.Unmarshaller unmarshaller = jaxbCtx.createUnmarshaller();
            flights = (Flights) unmarshaller.unmarshal(new java.io.File(filepath));//NOI18N
        } catch (javax.xml.bind.JAXBException ex) {
            // XXXTODO Handle exception
            java.util.logging.Logger.getLogger("global").log(java.util.logging.Level.SEVERE, null, ex); //NOI18N
        }
        
        return flights;
    }
    
    @WebMethod(operationName = "getAvailableFlights")
    public List<Flight> getAvailableFlights() {
        Flights flightsList = Unmarshaller();
        List<Flight> returnFlights = flightsList.getFlight();
        Iterator availableList = returnFlights.iterator();
        Flight nextFlight;
        Flights outputFlights = new Flights();
        List<Flight> returnFlight = outputFlights.getFlight();
        
        while(availableList.hasNext()){                                         //loop through flights list returned by unmarshalling XML
            nextFlight = (Flight) availableList.next();
            int seats = nextFlight.getAvailableSeats().intValue();              //call get seats method and convert value to integer
            out.println("test");
            if (seats > 0) {                                                    //check if seats value is greater than zero, if true add flight to return list else do nothing
                returnFlight.add(nextFlight);
            }
        }
        
        return returnFlight;
    }

    @WebMethod(operationName = "bookFlight")
    public List<Flight> bookFlight(@WebParam(name = "origin") String origin, @WebParam(name = "destination") String destination, @WebParam(name = "price") float price, @WebParam(name = "airline") String airline) {
        String filepath = "C:\\Users\\7734\\Desktop\\SERVICE COMPUTING\\Courseowrk\\FlightBookingWS\\flights.xml";
        File xml = new File(filepath);
        //process user inputs to ensure case match
        origin = origin.toUpperCase();
        destination = destination.toUpperCase();
        airline = airline.toUpperCase();

        Flights flights = Unmarshaller();
        List<Flight> listFlights = flights.getFlight();
        
        for (int x = 0; x < listFlights.size(); x++) {
            if(listFlights.get(x).getDestinationCity().toUpperCase().equals(destination) && listFlights.get(x).getOriginCity().toUpperCase().equals(origin) && listFlights.get(x).getFlightAirline().toUpperCase().equals(airline)){
                if(listFlights.get(x).getAvailableSeats().intValue() > 0) {
                    BigInteger newSeatVal = listFlights.get(x).getAvailableSeats().subtract(BigInteger.valueOf(1));
                    listFlights.get(x).setAvailableSeats(newSeatVal);
                }
            }
        }
        
        try {
            javax.xml.bind.JAXBContext jaxbCtx = javax.xml.bind.JAXBContext.newInstance(flights.getClass().getPackage().getName());
            javax.xml.bind.Marshaller marshaller = jaxbCtx.createMarshaller();
            marshaller.setProperty(javax.xml.bind.Marshaller.JAXB_ENCODING, "UTF-8");
            marshaller.setProperty(javax.xml.bind.Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marshaller.marshal(flights, xml);
            
        } catch (javax.xml.bind.JAXBException ex) {
            java.util.logging.Logger.getLogger("global").log(java.util.logging.Level.SEVERE, null, ex);
        }
        return listFlights;
    }

    @WebMethod(operationName = "searchFlightCityToCity")
    public List<Flight> searchFlightCityToCity(@WebParam(name = "Type") String Type, @WebParam(name = "City1") String City1, @WebParam(name = "Type2") String Type2, @WebParam(name = "City2") String City2) {
        Flights flightsList = Unmarshaller();
        List<Flight> returnFlights = flightsList.getFlight();
        Iterator availableList = returnFlights.iterator();
        Flight nextFlight;
        Flights outputFlights = new Flights();
        List<Flight> returnFlight = outputFlights.getFlight();
        
        String originCity = new String();
        String destinationCity = new String();
        if (Type.toUpperCase().equals("ORIGIN")) {                                                    
            originCity = City1;
        }
        if (Type.toUpperCase().equals("DESTINATION")) {
            destinationCity = City1;
        }
        if (Type2.toUpperCase().equals("ORIGIN")) {                                                    
            originCity = City2;
        }
        if (Type2.toUpperCase().equals("DESTINATION")) {
            destinationCity = City2;
        }
        
        while(availableList.hasNext()){                                         //loop through flights list returned by unmarshalling XML
            nextFlight = (Flight) availableList.next();
            if ((nextFlight.getOriginCity().toUpperCase().equals(originCity.toUpperCase())) && (nextFlight.getDestinationCity().toUpperCase().equals(destinationCity.toUpperCase()))) {                                                    
                returnFlight.add(nextFlight);
            }
        }
        
        return returnFlight;
    }
    
    @WebMethod(operationName = "searchFlightForCity")
    public List<Flight> searchFlightForCity(@WebParam(name = "Type") String Type, @WebParam(name = "City1") String City1) {
        Flights flightsList = Unmarshaller();
        List<Flight> returnFlights = flightsList.getFlight();
        Iterator availableList = returnFlights.iterator();
        Flight nextFlight;
        Flights outputFlights = new Flights();
        List<Flight> returnFlight = outputFlights.getFlight();
        
        String originCity = new String();
        String destinationCity = new String();
        if (Type.toUpperCase().equals("ORIGIN")) {                                                    
            originCity = City1;
            
            while(availableList.hasNext()){                                         //loop through flights list returned by unmarshalling XML
            nextFlight = (Flight) availableList.next();
            if (nextFlight.getOriginCity().toUpperCase().equals(originCity.toUpperCase())) {                                                    
                returnFlight.add(nextFlight);
                }
            }
        }
        if (Type.toUpperCase().equals("DESTINATION")) {
            destinationCity = City1;
            
            while(availableList.hasNext()){                                         //loop through flights list returned by unmarshalling XML
            nextFlight = (Flight) availableList.next();
            if (nextFlight.getDestinationCity().toUpperCase().equals(destinationCity.toUpperCase())) {                                                    
                returnFlight.add(nextFlight);
                }
            }
        }
        
    
        return returnFlight;
    }
    
    @WebMethod(operationName = "searchFlightToOrFromCity")
    public List<Flight> searchFlightWithCity(@WebParam(name = "City1") String City1) {
        Flights flightsList = Unmarshaller();
        List<Flight> returnFlights = flightsList.getFlight();
        Iterator availableList = returnFlights.iterator();
        Flight nextFlight;
        Flights outputFlights = new Flights();
        List<Flight> returnFlight = outputFlights.getFlight();
        
        
        while(availableList.hasNext()){                                         //loop through flights list returned by unmarshalling XML
            nextFlight = (Flight) availableList.next();
            if ((nextFlight.getOriginCity().toUpperCase().equals(City1.toUpperCase())) || nextFlight.getDestinationCity().toUpperCase().equals(City1.toUpperCase())) {                                                    //check if seats value is greater than zero, if true add flight to return list else do nothing
                returnFlight.add(nextFlight);
            }
        }
        
        return returnFlight;
    }
    
    @WebMethod(operationName = "searchFlightDirectFlight")
    public List<Flight> searchFlightDirectFlight(@WebParam(name = "origin") String origin, @WebParam(name = "destination") String destination) {
        Flights flightsList = Unmarshaller();
        List<Flight> returnFlights = flightsList.getFlight();
        Iterator availableList = returnFlights.iterator();
        Flight nextFlight;
        Flights outputFlights = new Flights();
        List<Flight> returnFlight = outputFlights.getFlight();
        
        System.err.println("starting loop");
        while(availableList.hasNext()){                                         //loop through flights list returned by unmarshalling XML
            nextFlight = (Flight) availableList.next();
            if ((nextFlight.getOriginCity().toUpperCase().equals(origin.toUpperCase())) || nextFlight.getDestinationCity().toUpperCase().equals(destination.toUpperCase())) {    
                if (nextFlight.getConnectionsNumber().compareTo(BigInteger.valueOf(1)) == -1) {
                    returnFlight.add(nextFlight);
                }
            }
        }
        
        return returnFlight;
    }
}
