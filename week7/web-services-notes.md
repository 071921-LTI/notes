# Web Services
---
A web service is a business-to-business (B2B) technology which makes resources available over the Internet using a standardized messaging protocol or architecture (such as REST or SOAP). 

Web services are self-contained, modular, distributed, dynamic applications that can be described, published, located, or invoked over the network to create products, processes, and supply chains. These applications can be local, distributed, or web-based.

---
## REST
REST, or REpresentational State Transfer, is an architectural style for providing standards between computer systems on the web, making it easier for systems to communicate with each other. REST-compliant systems, often called RESTful systems, are characterized by how they are stateless and separate the concerns of client and server.

REST defines 6 architectural constraints which make a web service truly RESTful:

- Uniform interface
- Client–server
- Stateless
- Cacheable
- Layered system
- Code on demand (optional)

Resource: https://www.codecademy.com/articles/what-is-rest
Resource: https://restfulapi.net/rest-architectural-constraints

---
### Characteristics of RESTful APIs
All RESTful APIs have few characteristics in common that distinguish them from other types of web services. Such characteristics include:

- The explicit use of HTTP to facilitate client-server communication
- The use of HTTP status codes to indicate the success or failure of request processing
- The uniform naming convention used to define the application's endpoints
- The server that processes requests does so in a stateless manner
- The use of any one of a variety of data interchange formats (JSON, XML, etc.)

---
---
## SOAP
SOAP, or **Simple Object Access Protocol**, is a protocol designed to exchange information in the form of Web Services. It is primarily based on XML documents exchanged over HTTP, but it's possible to transmit messages through other mediums like email and JMS.

SOAP web services are generally based on a a Web Services Description Language or WSDL, which is an XML contract that defines all the data and services offered by a given web service. The client and the server both use this contract as a basis for exchanging information and making remote procedural calls.

---
### Characteristics of SOAP Web Services
Just as RESTful APIs have their own defining characteristics, there are also characteristics that are unique to SOAP web services. Such characteristics include:

- The server that processes requests does so in a stateless manner
- The explicit use of XML as the sole data interchange format
- Communication between the client and server commonly uses HTTP, though other protocols are permitted (FTP, SMTP, etc.)
- The XML messages between the client and server comply with the SOAP specification for Envelope structure
- The use of XML fault blocks (SOAP specification) to communicate request processing failures