# REST Architecture

Representational State Transfer is a software architectural style that defines a set of constraints to be used for creating web services.

## Architectural Constraints

In order to be considered a "true" RESTful API, our API must correctly implement the follow architectural constraints:

1. Uniform Interface

This constraint requires that we be consistent in the naming of our API's endpoints. Our resources should only one logical URI and they should provide recipients a way to obtain other related resources that it may encapsulate. This constraint also includes the consistent use of some language-agnostic format as response payload (JSON, XML, BSON, etc.). Additionally, this constraint requires that we leverage HTTP as the protocol for interacting with our API. The HTTP verbs (GET, POST, PUT, etc.) combined with the consistent and intuitive naming of resource endpoints helps our API to achieve a uniform interface.


2. Client-server

This constraint emphasizes that our server application (the API) and the client application (the consumer of the API) must be able to evolve separately from one another. The client application only needs to know the URIs to resources exposed by the API.


3. Stateless

This constraint requires that the interaction between our client and our server is a stateless one. The server will not store anything about the client's request, and every request is a new request from the perspective of the API. The client is responsible for maintaining the state of the application.


4. Cacheable

Resources which will not change often should always be cached (either by the client or the server). This is done in order to decrease latency for the retrieval of frequently accessed, often immutable (or rarely changed) resources.


5. Layered System

As the name implies, this constraints requires that our system architecture is layered. This means that the different domains of our application are physically and logically separate from one another.

## Richardson Maturity Model

Resource: https://restfulapi.net/richardson-maturity-model/