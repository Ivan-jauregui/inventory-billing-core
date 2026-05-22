# Enterprise Order & Inventory Processor

A robust, object-oriented Java backend module designed to manage corporate infrastructure, track real-time stock availability, and execute secure, transactional order workflows.

##  Key Features

* **Atomic Order Validation:** Ensures all items in a shopping cart have sufficient stock before processing payments, preventing partial or corrupted orders.
* **Smart Shipping Consolidation:** Implements a cost-optimization logic that applies only the highest shipping fee among the items in the order instead of stacking them blindly.
* **Transactional Balances:** Automatically deducts user funds and updates inventory levels seamlessly during checkout.

##  Architecture & Design Decisions

* **Interface-Driven Development:** Core services (`Company`, `Product`, `User`) are decoupled through interfaces (`ICompany`, `IProduct`, `IUser`) to facilitate scalability and future dependency injection.
* **Domain-Driven Entities:** Data is structured cleanly around business logic, keeping the code highly maintainable and readable.

##  Tech Stack

* **Language:** Java 17 / 21
* **Paradigm:** Object-Oriented Programming (OOP)
