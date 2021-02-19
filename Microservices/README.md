## Products
A microservice that connect to a products MySQL data base and expose diferents services:

- Get the price of one product
- Update an existing product in the data base
- Save a new product in the data base
- Get all the products in the data base

## Orders
A microservice that connect to a orders MySQL data base and to the products microservice too:

- Save or update a order of a product. An order have a product, total price, and date of the order

This microservice connect to the product microservice to get the price of the product and make the order, then connect again with this microservice to update the products in his data base and subtract stock of that product

## Client
A little microclient made in front end with JavaScript and angular that create orders and get a table with all orders made.

This client connect with all microservices to obtain all necesary data.
