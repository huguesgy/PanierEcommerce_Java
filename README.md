# E-Commerce Shopping Cart Simulation 🛒

A robust Java console application that simulates an e-commerce shopping cart. This project demonstrates intermediate Object-Oriented Programming (OOP) concepts, object associations, input validation, and stock management.

## 🚀 Features

- **Product Catalog**: View available products with prices and stock levels.
- **Cart Management**: Add products to the cart, modify quantities, or remove items.
- **Real-Time Stock Validation**: Prevents adding more items to the cart than are available in stock.
- **Price Calculations**: Automatically calculates total prices for both HT (before tax) and TTC (after tax - 20% VAT).
- **Secure Checkout**: Finalizing the purchase decreases the store's catalog stock and empties the cart.
- **Crash Prevention**: Robust console input handling to prevent the program from crashing on invalid inputs (e.g., text entered instead of numbers).

## 📂 Project Structure

- `src/Produit.java`: Represents a single product (ID, name, price HT, stock).
- `src/LignePanier.java`: Represents a product added to the cart along with its chosen quantity.
- `src/Panier.java`: Handles the collection of selected products, calculates totals, and manages cart operations.
- `src/ECommerceManager.java`: Manages the catalog of products, monitors stock availability, and finalizes checkouts.
- `src/Main.java`: Point of entry that handles the CLI menu loop and user input validation.

---

## 🛠️ How to Compile and Run

You can run this application using either an IDE or the terminal.

### Method 1: Using IntelliJ IDEA (Recommended)
Since the project contains IntelliJ configuration files, running it is simple:
1. Open **IntelliJ IDEA**.
2. Select **Open** and choose the `PanierEcommerce_Java` project folder.
3. Open the file **`src/Main.java`**.
4. Click the green **Run** button (play icon) at the top right, or right-click inside `Main.java` and select **Run 'Main.main()'**.

---

### Method 2: Using the Command Line (Windows Terminal)
If you prefer running it from the command line, follow these steps:

1. Open your terminal (Command Prompt or PowerShell) and navigate to the project directory:
   ```bash
   cd C:\Users\hglya\.gemini\antigravity\scratch\PanierEcommerce_Java
   ```

2. Create a compilation output directory:
   ```bash
   mkdir bin
   ```

3. Compile the Java source files:
   ```bash
   javac -d bin src/*.java
   ```

4. Run the application:
   ```bash
   java -cp bin Main
   ```

---

## ⚙️ Core OOP Concepts Demonstrated

- **Encapsulation**: Attributes are kept private and exposed via custom getters and setters with validation rules.
- **Object Association**: Modeling how a `Panier` interacts with `LignePanier` and `Produit`.
- **Exception Handling**: Using `try-catch` blocks and custom exception messages (`IllegalArgumentException`, `IllegalStateException`) to enforce business rules and secure inputs.
- **Java Collection Framework**: Utilizing `HashMap` for fast key-value lookups (Product ID -> Cart Line) instead of linear list searches.
