# Simple Object Access Protocol (SOAP)
---
SOAP, or Simple Object Access Protocol, is a protocol designed to exchange information in the form of web services. It is primarily based on XML documents (_envelopes_) exchanged over HTTP, but it's possible to transmit messages through other mediums like email and JMS.

SOAP web services are generally based on a _Web Services Description Language (WSDL)_, which is an XML contract that defines all the data and services offered by a given web service. The client and the server both use this contract as a basis for exchanging information.

---
## Web Service Description Language (WSDL)
An XML format for describing network services as a set of endpoints operating on messages containing either document-oriented or procedure-oriented information. The operations and messages are described abstractly, and then bound to a concrete network protocol and message format to define an endpoint. Related concrete endpoints are combined into abstract endpoints (services).

![](https://s3.amazonaws.com/revature-note-assets/wsdl-diagrams.png)
---
## WSDL Structure

#### Definitions
The root element of the WSDL, it contains the declarations for the various components that define the web service's functionality.

#### Types
Describes the data used within the web service. The XML Schema language (also known as XSD) is used (inline or referenced) for this purpose.

#### Interface
Defines a Web service, the operations that can be performed, and the messages that are used to perform the operation. Formerly known as the `portType` element in WSDL 1.0.

#### Operation
Defines the SOAP actions and the way the message is encoded, for example, "literal." An operation is like a method or function call in a traditional programming language.

#### Binding
Specifies the interface and defines the SOAP binding style (RPC/Document) and transport (SOAP Protocol). The binding section also defines the operations.

#### Service
Contains a set of system functions that have been exposed to the Web-based protocols through the `<endpoint>` tag. Attributes include: `name` and `interface`

#### Endpoint
Used to create an association between a binding class and a specified URL, through the use of the `binding` and `address` attributes respectively. Formerly known as the `port` element in WSDL 1.0.

#### Message _(WSDL 1.0 only)_
No WSDL 2.0 equivalent. Contains the information needed to perform an operation. Messages were removed in WSDL 2.0, in which XML schema types for defining bodies of inputs, outputs and faults are referred to simply and directly.

---
## Creating SOAP Web Services
There are two primary methods that can be utilized to create a SOAP web service: **contract-first** and **contract-last**. 

In both techniques, the "contract" refers to the WSDL. Contract-first means that the WSDL will be used to generate the Java classes for the web service. Contract-last means that the Java classes will be used to generate the WSDL. 

Java developers will likely feel more comfortable following contract-last methodology, whereas non-developer roles (i.e. business analysts) will feel more comfortable following the contract-first technique.

---
## SOAP Envelope

A SOAP message is encoded as an XML document, consisting of an `<Envelope>` element, which contains an optional `<Header>` element, and a mandatory `<Body>` element. The `<Fault>` element, contained in the `<Body>`, is used for reporting errors.

- The SOAP envelope
    - The SOAP `<Envelope>` is the root element in every SOAP message. It contains two child elements, an optional `<Header>`, and a mandatory `<Body>`.


- The SOAP header
    - The SOAP `<Header>` is an optional subelement of the SOAP envelope. It is used to pass application-related information that is to be processed by SOAP nodes along the message path.


- The SOAP body
    - The SOAP `<Body>` is a mandatory subelement of the SOAP envelope. It contains information intended for the ultimate recipient of the message.


- The SOAP fault
    - The SOAP `<Fault>` is a subelement of the SOAP body, which is used for reporting errors.

---
## SOAP Fault

If an error occurs in a web service, a fault message is returned to the client. The basic structure of the fault message is defined in the SOAP specifications. Each fault message can include XML that describes the specific error condition. A SOAP 1.1 Fault block is comprised of the following tags:

- `<faultcode>`
    - mandatory element
	- provides information about the fault in a form that can be processed by software
	- SOAP defines a small set of SOAP fault codes covering basic SOAP faults, and this set can be extended by applications


- `<faultstring>`
    - mandatory element
	- provides information about the fault in a form intended for a human reader


- `<faultactor>`
    - contains the URI of the SOAP node that generated the fault
	- a SOAP node that is not the ultimate SOAP receiver must include the <faultactor> element when it creates a fault
	- an ultimate SOAP receiver is not obliged to include this element, but may do so.


- `<detail>`
    - carries application-specific error information related to the `<Body>` element. 
	- must be present if the contents of the `<Body>` element were not successfully processed. 
	- must not be used to carry information about error information belonging to header entries. Detailed error information belonging to header entries must be carried in header entries.




