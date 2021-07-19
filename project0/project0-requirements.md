# Some kind of Shop

## Description (Due: 08/04/2021)

   The Some kind of Shop app is a console-based application that facilitates the purchasing of some kind of item, the choice is up to you. 
	An employee can add these items to an inventory and manage offers for those those items while a customer can view the available items and make offers.
	
## Purpose

   We want to see that you can meet deadlines and that you can code. You are expected to complete the following requirements and give a 5 minute presentation of your project to our QC team.

## Requirements
1. Functionality should reflect the below user stories.
2. Data is stored in a database.
3. Data Access is performed through the use of JDBC in a data layer consisting of Data Access Objects.
4. All input is received using the java.util.Scanner class.
5. All public service layer methods must have at least one JUnit test.
6. Log4j is implemented to log events to a file.


## User Stories
Total Points: 25 Points

* As a user, I can login.
	* 2 points
* As an employee, I can add an item to the shop.
	* 3 points
* As a customer, I can view the available items.
	* 1 point
* As a customer, I can make an offer for an item.
	* 3 points
* As an employee, I can accept or reject a pending offer for an item.
	* 2 points
* As the system, I update an item to an owned state when an offer is accepted.
	* 2 points
* As the system, I reject all other pending offers for an item when an offer is accepted.
	* 3 points
* As a user, I can register for a customer account.
	* 3 points
* As an employee, I can remove an item from the shop.
	* 2 points
* As a customer, I can view the items that I own.
	* 1 point
* As a customer, I can view my remaining payments for an item.
	* 1 point
* As an employee, I can view all payments.
	* 1 point
* As the system, I can calculate the weekly payment.
	* 1 point

## Bonus

* As a user, I can make a payment.
* As a manager, I can make employee accounts.
* As an employee, I can edit existing items.
* As a manager, I can fire employees.
* As a manager, I can view sales history of all offers.

## Extra bonus

Be creative and incorporate other topics into your project, they do not have to have been covered by our curriculum. Here are some suggestions:
* File I/O
* Threading
* Mocking
* Password hashing
