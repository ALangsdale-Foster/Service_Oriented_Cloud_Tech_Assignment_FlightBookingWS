/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FlightsSetup;
import generated.*;
import java.io.File;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author n0650128
 */
public class UnmarshallerClass {
    public static void main(String[] args) {
        UnmarshallerClass unmarshal = new UnmarshallerClass();
        unmarshal.getFlights();
    }

    public List<Flight> getFlights() {
        File xml = new File("flights.xml");
        Flights flights = new Flights();
        
        try {
            javax.xml.bind.JAXBContext jaxbCtx = javax.xml.bind.JAXBContext.newInstance(flights.getClass().getPackage().getName());
            javax.xml.bind.Unmarshaller unmarshaller = jaxbCtx.createUnmarshaller();
            flights = (Flights) unmarshaller.unmarshal(xml); //NOI18N
        } catch (javax.xml.bind.JAXBException ex) {
            // XXXTODO Handle exception
            java.util.logging.Logger.getLogger("global").log(java.util.logging.Level.SEVERE, null, ex); //NOI18N
        }
        
        List<Flight> output = flights.getFlight();
        return output;
    }
}
