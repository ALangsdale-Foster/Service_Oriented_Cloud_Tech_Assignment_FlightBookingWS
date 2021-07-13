### ISYS40061 Service-Oriented Cloud Technologies
The goal of this coursework is to demonstrate an understanding of using Service Oriented
Architecture principles in software applications integration. In the first section you will
utilise web services to compose a travel agency. The travel agency consists of a flight
reservation service that you should build yourself and an external currency conversion
service that you need to consume and integrate with the reservation service. The valueadded functionality resulting from the integration should also be exposed to the travel
agency clients as a web service. The research element of the coursework investigates
using advanced semantic-based techniques to further extend your application.
Google Directions
Web Service
Currency Conversion
Web service
Maps API
(Google, Openstreet)
Flight Booking
Web Service
Client
Application
(C#/Java/JSP)

1. Implement flight booking service
a) Currently available offers should be held in an XML file based on an XSD schema
containing: origin city, destination city, airline, available seats, number of
connections, and a complex ‘fare’ element containing currency and value.
❖ You can opt to use conventional structures to store the data (arrays, Lists, etc.) instead of XML
objects. However, this will affect the standard of your work and also progression into Section-B.
b) The web service should return a number of available offers and update seat
availability when a booking is made. You might opt to utilise JAXB to generate
helper Java classes, which allow reading and populating the XML documents.
c) Implement a search functionality allowing customers to find suitable flights
using various criteria such as origin/destination, date, direct flights, etc. More
sophisticated search functionality will merit higher marks.
❖ The choice of client is your decision. Java GUI Apps or JSP are more appreciated, but should not be
attempted at the expense of providing core functionality.
B – Web Service Composition (weighting - 30%)
2. Integrate currency conversion service
Download the pre-coded project with the currency conversion web service from the
module’s NOW room site and deploy it. Create a web service client that integrates
both services by consuming the flight service to reserve flights, and consuming the
currency conversion service to auto-convert the flight booking fare to that preferred
by the customer.
3. Extend functionality by utilising external REST APIs
Add an ‘Airport_Address’ XML element to the flight reservation XML schema, making
sure that your flight routes contain few origin-destination combinations located within
the same country (e.g. London-Edinburgh, Marseille-Paris, etc.), then use public
RESTful web services (APIs) to implement the following functionality:
1. Use a Directions API, such MAPQUEST1 to offer a ‘driving’ alternative for the
selected origin-destination route. The REST service returns driving directions in
XML or JSON formats.
2. Use an external API to get more information about the destination city or country,
such as nearby attractions, population, cuisine, etc.
In order to achieve the highest marks, you must show initiative and inventiveness
beyond the stated specification. Examples include implementing non-java clients to
demonstrate SOA’s platform independence, using Flickr API to display interesting
public images of the destination city, using an open API to replace the currency
conversion service, etc.
