# CustmizedDBMS

## Description

CustomizedDBMS is a Java-based Customized Database Management System designed to manage employee records efficiently.
It supports all basic CRUD operations (Create, Read, Update, Delete), along with advanced features such as backup, restore, sorting, and aggregate functions (COUNT, SUM, AVG, MAX, MIN).

-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

## Features

1. Insert Employee – Add new employee records with Name, Age, Address, and Salary.
2. Select All Employees – Display all employee records in a formatted table.
3. Select by ID or Name – Search and display specific employees by ID or Name.
4. Update Employee – Modify employee details by ID or Name.
5. Delete Employee – Remove employee records by ID or Name.
6. Backup & Restore – Save the current database to a file and restore it later.
7. Sorting – Sort employees by Name or Salary.
8. Aggregate Function – COUNT employees, SUM of salaries, Average salary, Maximum and Minimum salary.
9. Search by Salary Range – Find employees within a specific salary range.

-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

## Installation

1. Clone the repository or download the ZIP.

   ```bash
   git clone https://github.com/your-username/MarvellousDBMS.git
   ```
2. Open the project folder in your favorite IDE (e.g., Eclipse, IntelliJ IDEA, VS Code).
3. Compile the program:

   ```bash
   javac CustmizedDBMS/program847.java
   ```
4. Run the program:

   ```bash
   java CustmizedDBMS.program847
   ```

-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

## Usage

* The program displays a menu for selecting various operations.
* Follow on-screen prompts to insert, update, delete, or search employees.
* Backup your database before making major changes.
* Restore from backup to revert the database to a previous state.

-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

## Sample Menu:
1: Insert into Employee 
2: Select * from Employee 
3: Take a backup of table 
4: Restore DBMS from backup
5: Select * from Employee WHERE EmpID 
6: Select * from Employee WHERE EmpName 
7: Delete Employee WHERE EmpID 
8: Delete Employee WHERE EmpName 
9: COUNT employees
10: SUM of salaries
11: AVG of salaries
12: MAX salary
13: MIN salary
14: Search employees with salary between range
15: Sort employees by salary
16: Sort employees by name
20: Terminate DBMS

-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

## Sample Data

| EmpID | Name      | Age | Address  | Salary |
| ----- | --------- | --- | -------- | ------ |
| 1     | Sandesh   | 28  | Pune     | 50000  |
| 2     | Omkar     | 30  | Mumbai   | 55000  |
| 3     | Mangesh   | 27  | Nagpur   | 48000  |
| 4     | Rushikesh | 31  | Nashik   | 53000  |
| 5     | Pradnya   | 29  | Kolhapur | 47000  |

-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

## Authors
Sandesh Khatal – MCA Student – Developer of CustomizedDBMS

-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

## License

This project is for educational purposes and can be freely used or modified.
