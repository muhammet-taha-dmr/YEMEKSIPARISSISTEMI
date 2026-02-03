# Online Food Ordering System

A Java-based console application for an Online Food Ordering System. This project demonstrates core Object-Oriented Programming (OOP) concepts including Inheritance, Encapsulation, Polymorphism, and Interfaces.

## Project Description

This system allows customers to browse menus from different restaurants, add items to their cart, place orders, and make payments using various methods. It is designed to simulate a real-world food ordering scenario with users, restaurants, and order management.

## Features

*   **Menu Browsing:** View menus from multiple restaurants.
*   **Ordering System:** Add items to cart and place orders.
*   **User Management:** Customer registration and profile management.
*   **Order Tracking:** View order summary and status.
*   **Discounts:** Apply coupon codes for discounts.
*   **Loyalty Program:** Earn points with every purchase.
*   **Multiple Payment Methods:** Pay via Credit Card, Cash, or Digital Wallet.

## OOP Concepts Implemented

## 1. Inheritance
*   **`User` Class:** Base class for all users.
*   **`Customer` Class:** Inherits from `User`. Adds specific fields like address and loyalty points.
    *   *Why?* To reuse common user properties (name, email, phone) and extend functionality for customers.

## 2. Encapsulation
*   All classes use `private` fields to hide internal state.
*   Access is controlled via `public` getters and setters with validation logic (e.g., preventing negative prices or invalid phone numbers).
    *   *Why?* To protect data integrity and control how data is accessed and modified.

## 3. Polymorphism
*   **`Payment` Interface:** Defines a common `pay()` method.
*   **Implementations:** `CreditCardPayment`, `CashPayment`, `DigitalWalletPayment` implement `pay()` differently.
    *   *Why?* To treat different payment methods uniformly while allowing specific behaviors for each.

## 4. Interfaces
*   **`Orderable` Interface:** Defines contract for items that can be ordered (`getName`, `getPrice`).
*   **`Payment` Interface:** Defines contract for payment processing.
    *   *Why?* To define common behaviors without dictating implementation details.

## 5. Composition
*   **`Restaurant` has-a `Menu` (List of MenuItems).**
*   **`Order` has-a `Customer` and `List<OrderItem>`.**
    *   *Why?* To build complex objects from simpler ones, representing real-world relationships.

# Class Structure

*   **`com.foodordering.models`**: Contains entity classes (`MenuItem`, `User`, `Customer`, `Order`, `Restaurant`, etc.).
*   **`com.foodordering.interfaces`**: Contains interfaces (`Payment`, `Orderable`).
*   **`com.foodordering.services`**: Contains system management logic (`FoodOrderingSystem`).
*   **`com.foodordering.Main`**: Entry point of the application, demonstrating the system flow.

# How to Run

1.  **Compile the project:**
    ```bash
    javac -d target/classes -sourcepath src/main/java src/main/java/com/foodordering/Main.java
    ```

2.  **Run the application:**
    ```bash
    java -cp target/classes com.foodordering.Main
    ```

## Project Status
*   [x] Basic Class Structure
*   [x] OOP Implementation
*   [x] Console Interface
*   [x] Payment Processing
*   [x] Discount System

## Author
[Muhammet Taha Demir / 230303041]
Fall 2025 - Object Oriented Programming Final Project
