# Food Delivery Web Application

A Java-based food delivery web application built using **JSP, Servlets, Hibernate ORM, MySQL, Maven, and Apache Tomcat**.

The application demonstrates a traditional Java web application architecture with user authentication, menu browsing, order management, order history, and payment method selection.

## Features

* **User Registration** — Create a user account.
* **User Login** — Authenticate registered users.
* **Food Menu** — Browse available food items.
* **Place Order** — Select food items and place orders.
* **Order History** — View previously placed orders.
* **Payment Method Selection** — Select a payment method during the ordering process.

## Technology Stack

| Layer              | Technologies   |
| ------------------ | -------------- |
| Language           | Java           |
| Presentation       | JSP, HTML, CSS |
| Web Layer          | Java Servlets  |
| ORM                | Hibernate      |
| Database           | MySQL          |
| Build Tool         | Maven          |
| Application Server | Apache Tomcat  |

## Application Flow

```text
User
 │
 ▼
JSP Pages
 │
 ▼
Servlets
 │
 ▼
Application Logic
 │
 ▼
Hibernate ORM
 │
 ▼
MySQL
```

## Project Structure

The application follows a Java web application structure with JSP pages, Servlets, Hibernate configuration, and database interaction components.

```text
fooddelivery/
├── src/
│   └── ...
├── pom.xml
└── README.md
```

## Running Locally

### Prerequisites

* Java JDK
* Maven
* MySQL
* Apache Tomcat

### Setup

1. Clone the repository:

```bash
git clone https://github.com/Jyoti678/fooddelivery-full.git
```

2. Open the project in your preferred Java IDE.

3. Configure the MySQL database connection according to the project's Hibernate/database configuration.

4. Build the project using Maven:

```bash
mvn clean package
```

5. Deploy the generated application to Apache Tomcat.

6. Start Tomcat and open the application in your browser.

## What I Practiced

This project helped me gain practical experience with:

* Java web application development
* JSP and Servlet-based request handling
* Hibernate ORM and database interaction
* MySQL integration
* Maven project management
* Deploying Java web applications on Apache Tomcat
* Implementing basic authentication and order workflows

## Limitations

This is a learning project and is not intended to represent a production-grade food delivery platform.

Potential improvements include:

* Administrative management interface
* Online payment gateway integration
* Improved authentication and authorization
* Input validation and error handling
* Automated testing
* REST API integration
* Improved UI/UX
* Production deployment and monitoring

## Author

**Jyoti Airey**

BCA, DBS Global University

[GitHub](https://github.com/Jyoti678) · [LinkedIn](https://www.linkedin.com/in/jyotiairey/)
