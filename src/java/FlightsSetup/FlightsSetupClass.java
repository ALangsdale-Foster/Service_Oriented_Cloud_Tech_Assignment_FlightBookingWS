/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FlightsSetup;
import java.io.File;
import java.util.List;
import generated.*;
import java.math.BigInteger;

/**
 *
 * @author 7734
 */
public class FlightsSetupClass {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        File storageFile = new File("flights.xml");
        Flights flights = new Flights();
        List<Flight> flightsList = flights.getFlight();
        Flight flight;
        FlightPrice flightPrice;
        
        flight = new Flight();
        flight.setOriginCity("nottingham");
        flight.setDestinationCity("Derby");
        flight.setFlightAirline("Test Airline");
        flight.setConnectionsNumber(BigInteger.valueOf(0));
        flight.setAvailableSeats(BigInteger.valueOf(10));
        flightPrice = new FlightPrice();
        flightPrice.setCurrencyValue((float)4.20);
        flightPrice.setCurrencyName("GBP");
        flight.getFlightPrice().add(flightPrice);
        flight.setOriginAirportAddress("TestHouse");
        flight.setDestinationAirportAddress("TestBuilding");
        flightsList.add(flight);
        
        flight = new Flight();
        flight.setOriginCity("London");
        flight.setDestinationCity("Pyongyang");
        flight.setFlightAirline("British Air");
        flight.setConnectionsNumber(BigInteger.valueOf(0));
        flight.setAvailableSeats(BigInteger.valueOf(100));
        flightPrice = new FlightPrice();
        flightPrice.setCurrencyValue((float)4.30);
        flightPrice.setCurrencyName("GBP");
        flight.getFlightPrice().add(flightPrice);
        flightsList.add(flight);
        
        flight = new Flight();
        flight.setOriginCity("London");
        flight.setDestinationCity("Pyongyang");
        flight.setFlightAirline("Air Koryo");
        flight.setConnectionsNumber(BigInteger.valueOf(2));
        flight.setAvailableSeats(BigInteger.valueOf(100));
        flightPrice = new FlightPrice();
        flightPrice.setCurrencyValue((float)4.30);
        flightPrice.setCurrencyName("GBP");
        flight.getFlightPrice().add(flightPrice);
        flightsList.add(flight);
        
        flight = new Flight();
        flight.setOriginCity("Sofia");
        flight.setDestinationCity("Budapest");
        flight.setFlightAirline("Air Air");
        flight.setConnectionsNumber(BigInteger.valueOf(2));
        flight.setAvailableSeats(BigInteger.valueOf(100));
        flightPrice = new FlightPrice();
        flightPrice.setCurrencyValue((float)54);
        flightPrice.setCurrencyName("GBP");
        flight.getFlightPrice().add(flightPrice);
        flightsList.add(flight);
        
        flight = new Flight();
        flight.setOriginCity("Caracas");
        flight.setDestinationCity("Porto");
        flight.setFlightAirline("Air Air");
        flight.setConnectionsNumber(BigInteger.valueOf(2));
        flight.setAvailableSeats(BigInteger.valueOf(100));
        flightPrice = new FlightPrice();
        flightPrice.setCurrencyValue((float)54);
        flightPrice.setCurrencyName("GBP");
        flight.getFlightPrice().add(flightPrice);
        flightsList.add(flight);
        
        flight = new Flight();
        flight.setOriginCity("Santiago");
        flight.setDestinationCity("Monaco");
        flight.setFlightAirline("Air Air");
        flight.setConnectionsNumber(BigInteger.valueOf(2));
        flight.setAvailableSeats(BigInteger.valueOf(100));
        flightPrice = new FlightPrice();
        flightPrice.setCurrencyValue((float)54);
        flightPrice.setCurrencyName("GBP");
        flight.getFlightPrice().add(flightPrice);
        flightsList.add(flight);

        try {
           javax.xml.bind.JAXBContext jaxbCtx = javax.xml.bind.JAXBContext.newInstance(flights.getClass().getPackage().getName());
           javax.xml.bind.Marshaller marshaller = jaxbCtx.createMarshaller();
           marshaller.setProperty(javax.xml.bind.Marshaller.JAXB_ENCODING, "UTF-8"); //NOI18N
           marshaller.setProperty(javax.xml.bind.Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
           marshaller.marshal(flights, storageFile);
        } catch (javax.xml.bind.JAXBException ex) {
            java.util.logging.Logger.getLogger("global").log(java.util.logging.Level.SEVERE, null, ex);
        }
    
    }
}