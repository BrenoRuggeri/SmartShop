# 🛒 SmartShop

SmartShop is a Java console application developed to demonstrate Object-Oriented Programming (OOP) concepts, domain modeling, and basic business rules for a purchase system.

The application simulates a simple shopping flow where customers can add products to a cart, manage quantities, validate balance and stock, and complete a checkout process.

This project was created as part of a course challenge and is designed to be portfolio-ready, emphasizing clean architecture, good modeling decisions, and clear responsibility separation.

---

## 📌 Features

* Customer registration with balance control
* Product creation with price and stock management
* Shopping cart (purchase) associated with a customer
* Add and remove products from the cart
* Automatic quantity aggregation for repeated products
* Stock availability validation
* Customer balance validation before checkout
* Checkout process with:

  * balance debit
  * product stock update

---

## 🧠 Object-Oriented Design

The system was designed using **UML Class Diagrams** before implementation, focusing on:

* Clear separation of responsibilities
* High cohesion and low coupling
* Proper use of composition and associations
* Correct use of `Set` with `equals()` and `hashCode()`

### 📐 UML Class Diagram

Below is the UML diagram representing the core domain of the application:

> 📷 **UML Diagram**

<img width="884" height="730" alt="image" src="https://github.com/user-attachments/assets/22f30264-ef27-4be0-8804-b13c9f414e8f" 
   />
 
---

## 🏗️ Project Structure

```text
br.com.smartshop
├── app
│   └── Main.java
├── model
│   ├── Customer.java
│   ├── Product.java
│   ├── Purchase.java
│   └── PurchaseItem.java
```

---

## 🧩 Main Domain Classes

### `Customer`

Represents a customer with a balance used to complete purchases.

**Responsibilities:**

* Store customer data
* Control balance debit

---

### `Product`

Represents a product available for purchase.

**Responsibilities:**

* Store product data
* Manage stock quantity

---

### `Purchase`

Represents a shopping cart associated with a single customer.

**Responsibilities:**

* Manage cart items
* Calculate total amount
* Validate customer balance
* Finalize checkout

---

### `PurchaseItem`

Represents a product and its quantity inside a purchase.

**Responsibilities:**

* Aggregate quantities of the same product
* Validate stock availability
* Define equality based on product

---

## 🧪 How to Run

1. Clone the repository:

```bash
git clone https://github.com/your-username/smartshop.git
```

2. Open the project in your IDE (IntelliJ, Eclipse, VS Code)

3. Run the `Main` class

4. Use the console menu to interact with the system

---

## 🚀 Technologies Used

* Java (JDK 17+ recommended)
* Java Collections (`Set`)
* `BigDecimal` for monetary values
* UML for system design

---

## 📚 Concepts Applied

* Object-Oriented Programming (OOP)
* Encapsulation
* Composition vs Association
* Equality contract (`equals` and `hashCode`)
* Domain-driven design (basic concepts)
* Input handling with `Scanner`

---

## 🔮 Future Improvements

* Persist data using files or a database
* Apply design patterns (Factory, Service layer)
* Implement unit tests
* Extend the system using queues and stacks (Algorithms & Data Structures)
* Convert to a REST API

---

## 👤 Author

**Breno Ruggeri Ristic**
Computer Science Student

---

⭐ If you found this project interesting, feel free to explore, fork, or improve it!
