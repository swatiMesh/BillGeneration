# Bill Generation System (Java, NetBeans, MySQL)

## 📌 Project Overview
The **Bill Generation System** is a Java-based application developed using **NetBeans IDE**, with **Java Swing for UI, MySQL for database connectivity, and iText for PDF generation**. The system allows users to:  
- **Enter buyer details** (Name, Contact Number, Address).  
- **Add product details** (Name, Quantity, Price).  
- **Calculate the total amount dynamically**.  
- **Store bill records in a MySQL database**.  
- **Generate a PDF invoice** with all details.  

---

## 🛠️ Technologies Used
- **NetBeans IDE** (for Java development)  
- **Java Swing** (for GUI development)  
- **JDBC (Java Database Connectivity)** (for MySQL interaction)  
- **MySQL Workbench** (for database management)  
- **iText PDF Library** (for generating PDF invoices)  

---

## ⚙️ Setting Up the Project

### 🔹 Step 1: Install Required Software
Ensure you have the following installed on your system:
- **NetBeans IDE** (Download from [NetBeans Website](https://netbeans.apache.org/))
- **MySQL Workbench** (Download from [MySQL Website](https://www.mysql.com/))
- **JDK 8 or above** (Java Development Kit)

### 🔹 Step 2: Create a MySQL Database
1. Open **MySQL Workbench**.

2. Create a new database by running the following SQL query:
   ```sql
   CREATE DATABASE billing_db;

3. Select the database:
    ```sql 
    USE billing_db;

4. Create buyers and products tables:
    ```sql
    CREATE TABLE buyers (
        id INT PRIMARY KEY AUTO_INCREMENT,
        name VARCHAR(255),
        contract VARCHAR(20),
        address TEXT
    );

    CREATE TABLE products (
        id INT PRIMARY KEY AUTO_INCREMENT,
        name VARCHAR(255),
        quantity INT,
        price DECIMAL(10,2)
    );
5. Insert sample data:
    ```sql
    INSERT INTO buyers (name, contract, address) VALUES 
    ('John Doe', '9876543210', '123 Main Street, New York');

    INSERT INTO products (name, quantity, price) VALUES 
    ('Laptop', 1, 800.00),
    ('Mouse', 2, 20.00),
    ('Keyboard', 1, 50.00);

## 🏗️ Setting Up the Java Project in NetBeans

### 🔹 Step 3: Create a New Java Application
1. Open **NetBeans IDE**.
3. Go to **File → New Project → Java Application**.
4. Name the project **BillGenerationApp**.
5. Click **Finish**.

### 🔹 Step 4: Add Required Libraries
1. **Right-click on the project** in the **Projects** panel.
2. Click **Properties**.
3. Select **Libraries** from the left panel.
4. Click **Add JAR/Folder**.
6. Add the following libraries:
   - `mysql-connector-java-x.x.x.jar` (for MySQL database connectivity).
   - `itextpdf-x.x.x.jar` (for generating PDF invoices).
7. Click **OK** to save the changes.



## ▶️ Running the Project

1. **Right-click `BillGenerationUI.java`** in the **Projects** panel.  
2. Select **Run File**.  
3. The **Billing System UI** will open.  
4. Enter **Buyer Details** (Name, Contact Number, Address).  
5. Add **Product Details** (Product Name, Quantity, Price).  
7. Click **"Generate Bill"** to create a **PDF invoice**.  
8. The generated bill will be saved as **`Bill.pdf`** in the project folder.  


## Sample Bill

```
Buyer Name: John Doe
Contract Number: 98765411111
Address: 123 Main Street, New York

-----------------------------------------------
Product    | Quantity | Price  | Total
-----------------------------------------------
Laptop     | 1        | 800.00 | 800.00
Mouse      | 2        | 20.00  | 40.00
Keyboard   | 1        | 50.00  | 50.00
-----------------------------------------------

Total Amount: 890.00

Thank you for visiting us!
```