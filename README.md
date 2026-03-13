# Store API
Rest API for e-commerce made in spring boot. This project let's you manage producers, products, and individual attributes assigned to the products.

## Requirements
- Java 24+
- Maven
- Spring boot 3.5.11
- (for testing) Postman/Bruno for endpoint testing

## How to run
Clone this repository
```bash
git clone https://github.com/Juzix1/storeAPI_SpringBoot.git
cd storeAPI_SpringBoot

# then open the app in InteliJ, or by maven
mvn spring-boot:run
```
Project runs on: **http://localhost:8080**
- JDBC URL: `jdbc:h2:mem:testdb`
- User: `sa`
- Password is empty

## How to Use
You use this app with mentioned app which lets you test the endpoints.
First, you need to create Producer, next you need to create the product and pass in **requestbody** **ProducerId**, and lastly you need to create attributes which you assign to products in **request Body** by **ProductId**.
All request can be accessed in [directory](./requests) which can be used in [Bruno API Client](https://www.usebruno.com/)


## Used Libraries
- Spring Boot
- Spring Data JPA
- H2 Database
- Lombok
- Maven

## API Endpoints
### Producers
[**POST**] http://localhost:8080/producer - Creates producer.

[**GET**] http://localhost:8080/producers - Returns all producers in database.

[**GET**] http://localhost:8080/producers/ID - Returns one producer with provided **ID**.

[**DELETE**] http://localhost:8080/producers/ID - Deletes producer with provided **ID** and related products and attributes.
### Products
[**GET**] http://localhost:8080/products - Returns all items from database, has option to filter results by 
**name, producerId, minPrice and maxPrice**.

[**GET**] http://localhost:8080/product/ID - Returns one product by provided **ID**

[**POST**] http://localhost:8080/product - Creates Product and assigns it to the existing Producer.

[**PUT**] http://localhost:8080/product - Updates field of items, such as name, description and price, attributes are managed in [Attributes](#Attributes) section

[**DELETE**] http://localhost:8080/product - Deletes product by Id and it's related attributes

### Attributes

[**GET**] http://localhost:8080/attributes/ID - Returns one attribute by provided **ID**

[**GET**] http://localhost:8080/attributes - Returns all attributes from database.

[**POST**] http://localhost:8080/attribute - Creates Atribute and assigns it to the existing Product.

[**PUT**] http://localhost:8080/attribute - Updates the Attribute name and it's value, needs to provided it's **id** and **productId**

