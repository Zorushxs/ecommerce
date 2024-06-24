<p align="center">
  <img src="https://cdn-icons-png.flaticon.com/512/6295/6295417.png" width="100" />
</p>
<p align="center">
    <h1 align="center">ECOMMERCE</h1>
</p>

<p align="center">
	<img src="https://img.shields.io/github/license/Zorushxs/ecommerce?style=flat&color=0080ff" alt="license">
	<img src="https://img.shields.io/github/last-commit/Zorushxs/ecommerce?style=flat&logo=git&logoColor=white&color=0080ff" alt="last-commit">
	<img src="https://img.shields.io/github/languages/top/Zorushxs/ecommerce?style=flat&color=0080ff" alt="repo-top-language">
	<img src="https://img.shields.io/github/languages/count/Zorushxs/ecommerce?style=flat&color=0080ff" alt="repo-language-count">
<p>
<p align="center">
		<em>Developed with the software and tools below.</em>
</p>
<p align="center">
	<img src="https://img.shields.io/badge/java-%23ED8B00.svg?style=flat&logo=openjdk&logoColor=white" alt="java">
</p>
<hr>

##  Getting Started

***Requirements***

Ensure you have the following dependencies installed on your system:

* **Java**: `version 17.0.2`

---

##  Technologies Used

- Java 17
- Spring Boot 3.3.1
- Maven
- Lombok
- SLF4J for logging

---

##  Features

- Create a shopping cart
- Get a cart information given its id
- Add a product to a shopping cart (the cart can hold multiple products)
- Delete a shopping cart
- The cart will be deleted in 10 minutes if no action it's done

---

##  Installation and Execution

1. Clone the Repository:

```sh
git clone https://github.com/Zorushxs/ecommerce.git
cd ecommerce

```
2. Install the dependencies
```sh
mvn clean install
```

3. Compile and Package with Maven:

```sh
mvn clean package
```

4. Run the Application:

```sh
java -jar target/ecommerce-0.0.1-SNAPSHOT.jar
```


###  Tests

To execute tests, run:

```sh
mvn test
```

---

##  Using the API

Here you will see the coded enpoints and its parameters to try them (cURL). The URLs are intended to be run locally on port 8080, please modify them if necessary.
You must modify cartId and the product to the data you obtain when you prove. 
Products are not generated, you should generate them:
> '{
  "id": 234,
  "description": "jacket",
  "amount": 45
  }'

- Create a Shopping Cart
  Endpoint:
```sh
curl --location --request POST 'http://localhost:8080/carts' \
--data ''
```

- Get a Shopping Cart with it's id
  Endpoint:
```sh
curl --location 'http://localhost:8080/carts/c2a42a98-0db4-45f1-867c-609de483ad3c' \
--header 'cart;' \
--data ''
```

- Add a product on a Cart
  Endpoint:
```sh
curl --location 'http://localhost:8080/carts/c2a42a98-0db4-45f1-867c-609de483ad3c/products' \
--header 'cart;' \
--header 'Content-Type: application/json' \
--data '{
    "id": 234,
    "description": "jacket",
    "amount": 45
}'
```
- Delete a Cart and all it's products
  Endpoint:
```sh
curl --location --request POST 'http://localhost:8080/carts/bbd7a221-3218-4a82-9c85-99fcc34319a9' \
--header 'cart;' \
--data ''
```

---

