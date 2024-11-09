# FuzzyProducts
Product Catalog with Fuzzy Search

For running backend there are two options.
1) Simply double click on the StartFuzzyProducts.bat file, this should run the Spring application in a console window
2) Import the project into Eclipse of other IDE as a Maven Project and then run it like normal

Port 8080 on localhost is used by this application: http://localhost:8080

All returned structures are JSON structure

URL endpoints available:
GET
/products
Fetches all Products and returns them back in a JSON structure

POST
/products
JSON input in body of request will add a new product to the database

PUT
/products/<id>
Updates a specific product id with updates from a JSON body input

GET
/products/<id>
Fetch a specific product with related id from database

DELETE
/products/<id>
Delete a specific product from the database

GET
/search/<query>
Search for products in the database. Will look for exact matches first then it will fuzzy search and find the closest match using edit Levenshtein distance
