# E-Commerce Shopping Cart Simulation 🛒

A Java console-based application simulating an e-commerce shopping cart. This project demonstrates intermediate OOP design, object associations, validation rules, and stock management.

## Project Structure
- `Produit.java`: Model representing a single product in the catalog.
- `LignePanier.java`: Represents a product added to the cart along with its chosen quantity.
- `Panier.java`: Handles the collection of selected products, calculates totals, and manages cart operations.
- `ECommerceManager.java`: Manages the catalog of products, monitors stock availability, and finalizes checkouts.
- `Main.java`: Point of entry that handles user interactions and input validation.

## Business Rules
- Real-time stock verification prevents adding more items to the cart than are available.
- Prices and quantities must be strictly positive.
- Finalizing the purchase decreases the catalog's product stock.
- The system prevents application crashes on invalid numeric inputs.
