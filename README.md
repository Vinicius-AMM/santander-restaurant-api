# Santander Bootcamp 2024

Java RESTful API for Santander Bootcamp

## Class Diagram

```mermaid
classDiagram
    class Restaurant {
        int id
        string name
        string urlPicture
        Address address
        string[] operatingDays
        Product[] products
    }

    class Address {
        int id
        string cep
        string city
        string state
        string neighborhood
        string street
        string number
    }

    class Product {
        int id
        string name
        string urlPicture
        float price
        string category
        string description
    }

    Restaurant "1" *-- "1" Address
    Restaurant "1" *-- "N" Product
```
