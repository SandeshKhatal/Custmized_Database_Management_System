package CustmizedDBMS;

import java.util.*;
import java.io.*;

class Employee implements Serializable 
{
    public int EmpId;
    public String EmpName;
    public int EmpAge;
    public String EmpAddress;
    public int EmpSalary;

    private static int Counter;

    static 
    {
        Counter = 1;
    }

    public Employee(String b, int c, String d, int e) 
    {
        this.EmpId = Counter++;
        this.EmpName = b;
        this.EmpAge = c;
        this.EmpAddress = d;
        this.EmpSalary = e;
    }

    public String toString() 
    {
        return "EID: " + this.EmpId +
                " Name: " + this.EmpName +
                " Age: " + this.EmpAge +
                " Address: " + this.EmpAddress +
                " Salary: " + this.EmpSalary;
    }
}

class MarvellousDBMS implements Serializable 
{
    private LinkedList<Employee> Table;

    public MarvellousDBMS() 
    {
        System.out.println("Marvellous DBMS STARTED SUCCESSFULLY");
        Table = new LinkedList<>();
    }

    // ---------------- INSERT ----------------
    public void InsertIntoTable(String name, int age, String address, int salary) 
    {
        Employee eobj = new Employee(name, age, address, salary);
        Table.add(eobj);
        System.out.println("Marvellous DBMS : -> Data inserted successfully");
    }

    // ---------------- SELECT ----------------
    public void SelectStarFrom() 
    {
        System.out.println("----------------------------------------------------------");
        System.out.println("Data from employee table:");
        System.out.println("----------------------------------------------------------");

        for(Employee eref : Table) 
        {
            System.out.println(eref);
        }

        System.out.println("----------------------------------------------------------");
    }

    public void SelectSpecificID(int id) 
    {
        boolean found = false;
        for(Employee eref : Table) 
        {
            if(eref.EmpId == id) 
            {
                System.out.println("Record Found : " + eref);
                found = true;
                break;
            }
        }
        if (!found) 
        {
            System.out.println("No employee found with ID: " + id);
        }
    }

    public void SelectSpecificName(String Name) 
    {
        boolean found = false;
        for(Employee eref : Table) 
        {
            if(eref.EmpName.equalsIgnoreCase(Name)) 
            {
                System.out.println("Record Found : " + eref);
                found = true;
            }
        }
        if(!found) 
        {
            System.out.println("No employee found with Name: " + Name);
        }
    }

    public void SelectBySalaryRange(int min, int max) 
    {
        boolean found = false;
        for(Employee e : Table) 
        {
            if(e.EmpSalary >= min && e.EmpSalary <= max) 
            {
                System.out.println(e);
                found = true;
            }
        }
        if(!found) 
        {
            System.out.println("No employees found in salary range " + min + " - " + max);
        }
    }

    // ---------------- DELETE ----------------
    public void DeleteSpecificID(int id) 
    {
        Iterator<Employee> it = Table.iterator();
        boolean found = false;
        while(it.hasNext()) 
        {
            Employee eref = it.next();
            if(eref.EmpId == id) 
            {
                System.out.println("Deleting record : " + eref);
                it.remove();
                found = true;
                break;
            }
        }
        if(!found) 
        {
            System.out.println("No employee found with ID: " + id);
        }
    }

    public void DeleteSpecificName(String Name) 
    {
        Iterator<Employee> it = Table.iterator();
        boolean found = false;
        while(it.hasNext()) 
        {
            Employee eref = it.next();
            if(eref.EmpName.equalsIgnoreCase(Name)) 
            {
                System.out.println("Deleting record : " + eref);
                it.remove();
                found = true;
            }
        }
        if(!found) 
        {
            System.out.println("No employee found with Name: " + Name);
        }
    }

    // ---------------- UPDATE ----------------
    public void UpdateEmployeeByID(int id, String newName, Integer newAge, String newAddress, Integer newSalary) {
        boolean found = false;
        for(Employee eref : Table) 
        {
            if(eref.EmpId == id) 
            {
                System.out.println("Before Update: " + eref);

                if(newName != null && !newName.isEmpty()) 
                {
                    eref.EmpName = newName;
                }
                if(newAge != null) 
                {
                    eref.EmpAge = newAge;
                }
                if(newAddress != null && !newAddress.isEmpty()) 
                {
                    eref.EmpAddress = newAddress;
                }
                if(newSalary != null) 
                {
                    eref.EmpSalary = newSalary;
                }

                System.out.println("After Update: " + eref);
                found = true;
                break;
            }
        }
        if(!found) 
        {
            System.out.println("No employee found with ID: " + id);
        }
    }

    public void UpdateEmployeeByName(String name, String newName, Integer newAge, String newAddress, Integer newSalary) 
    {
        boolean found = false;
        for(Employee eref : Table) 
        {
            if(eref.EmpName.equalsIgnoreCase(name)) 
            {
                System.out.println("Before Update: " + eref);

                if(newName != null && !newName.isEmpty()) 
                {
                    eref.EmpName = newName;
                }
                if(newAge != null) 
                {
                    eref.EmpAge = newAge;
                }
                if(newAddress != null && !newAddress.isEmpty()) 
                {
                    eref.EmpAddress = newAddress;
                }
                if(newSalary != null) 
                {
                    eref.EmpSalary = newSalary;
                }

                System.out.println("After Update: " + eref);
                found = true;
            }
        }
        if(!found) 
        {
            System.out.println("No employee found with Name: " + name);
        }
    }

    // ---------------- AGGREGATE ----------------
    public void CountEmployees() 
    {
        System.out.println("Total employees: " + Table.size());
    }

    public void MaxSalary() 
    {
        int max = Integer.MIN_VALUE;
        Employee temp = null;
        for(Employee e : Table) 
        {
            if (e.EmpSalary > max) 
            {
                max = e.EmpSalary;
                temp = e;
            }
        }
        if(temp != null)
            System.out.println("Employee with Max Salary: " + temp);
    }

    public void MinSalary() 
    {
        int min = Integer.MAX_VALUE;
        Employee temp = null;
        for(Employee e : Table) 
        {
            if(e.EmpSalary < min) 
            {
                min = e.EmpSalary;
                temp = e;
            }
        }
        if(temp != null)
            System.out.println("Employee with Min Salary: " + temp);
    }

    public void AverageSalary() 
    {
        if(Table.isEmpty()) 
        {
            System.out.println("No employees in table.");
            return;
        }
        int sum = 0;
        for(Employee e : Table) 
        {
            sum += e.EmpSalary;
        }
        double avg = (double) sum / Table.size();
        System.out.println("Average Salary: " + avg);
    }

    public void SumSalary() 
    {
        int sum = 0;
        for(Employee e : Table) 
        {
            sum += e.EmpSalary;
        }
        System.out.println("Total Salary (SUM): " + sum);
    }

    // ---------------- SORTING ----------------
    public void SortByName() 
    {
        Table.sort(Comparator.comparing(e -> e.EmpName.toLowerCase()));
        System.out.println("Employees sorted by Name:");
        SelectStarFrom();
    }

    public void SortBySalary() 
    {
        Table.sort(Comparator.comparingInt(e -> e.EmpSalary));
        System.out.println("Employees sorted by Salary:");
        SelectStarFrom();
    }

    // ---------------- BACKUP / RESTORE ----------------
    public void TakeBackup() 
    {
        try 
        {
            FileOutputStream fos = new FileOutputStream("MarvellousDBMS.ser");
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            oos.writeObject(this);

            oos.close();
            fos.close();

            System.out.println("Data is stored into secondary storage successfully.");
        } 
        catch(Exception e) 
        {
            System.out.println("Exception occurred: " + e);
        }
    }

    public static MarvellousDBMS RestoreBackup(String path) 
    {
        MarvellousDBMS obj = null;
        try 
        {
            FileInputStream fis = new FileInputStream(path);
            ObjectInputStream ois = new ObjectInputStream(fis);

            obj = (MarvellousDBMS) ois.readObject();

            ois.close();
            fis.close();

            System.out.println("Data restored successfully from secondary storage.");
        } 
        catch(Exception e) 
        {
            System.out.println("Exception occurred: " + e);
        }
        return obj;
    }
}

// ---------------- MAIN PROGRAM ----------------
public class program848
{
    public static void main(String[] args) throws Exception 
    {
        MarvellousDBMS mobj = new MarvellousDBMS();
        Scanner sobj = new Scanner(System.in);

        int iOption;

        System.out.println("----------------------------------------------------------");
        System.out.println("-------- Marvellous Database Management System --------");
        System.out.println("----------------------------------------------------------");

        while(true) 
        {
            System.out.println("----------------------------------------------------------");
            System.out.println("1: Insert into Employee ");
            System.out.println("2: Select * from Employee ");
            System.out.println("3: Take a backup of table ");
            System.out.println("4: Restore DBMS from backup");
            System.out.println("5: Select * from Employee WHERE EmpID ");
            System.out.println("6: Select * from Employee WHERE EmpName ");
            System.out.println("7: Delete Employee WHERE EmpID ");
            System.out.println("8: Delete Employee WHERE EmpName ");
            System.out.println("9: Update Employee WHERE EmpID ");
            System.out.println("10: Update Employee WHERE EmpName ");
            System.out.println("11: COUNT employees ");
            System.out.println("12: MAX Salary Employee ");
            System.out.println("13: MIN Salary Employee ");
            System.out.println("14: AVG Salary ");
            System.out.println("15: SUM of Salaries ");
            System.out.println("16: Select Employees by Salary Range ");
            System.out.println("17: Sort Employees by Name ");
            System.out.println("18: Sort Employees by Salary ");
            System.out.println("20: Terminate DBMS");
            System.out.println("----------------------------------------------------------");

            System.out.print("Please select the desired operation on the database: ");
            iOption = sobj.nextInt();
            sobj.nextLine();

            if(iOption == 1) 
            {
                String name, address;
                int age, salary;

                System.out.print("Enter the name: ");
                name = sobj.nextLine();

                System.out.print("Enter the age: ");
                age = sobj.nextInt();
                sobj.nextLine();

                System.out.print("Enter the address: ");
                address = sobj.nextLine();

                System.out.print("Enter the salary: ");
                salary = sobj.nextInt();
                sobj.nextLine();

                mobj.InsertIntoTable(name, age, address, salary);

            } 
            else if(iOption == 2) 
            {
                mobj.SelectStarFrom();
            } 
            else if(iOption == 3) 
            {
                mobj.TakeBackup();
            } 
            else if(iOption == 4) 
            {
                MarvellousDBMS temp = MarvellousDBMS.RestoreBackup("MarvellousDBMS.ser");
                if (temp != null) 
                {
                    mobj = temp;
                }
            } 
            else if(iOption == 5) 
            {
                System.out.print("Enter EmpID to search: ");
                int id = sobj.nextInt();
                sobj.nextLine();
                mobj.SelectSpecificID(id);
            } 
            else if(iOption == 6) 
            {
                System.out.print("Enter EmpName to search: ");
                String name = sobj.nextLine();
                mobj.SelectSpecificName(name);
            } 
            else if(iOption == 7) 
            {
                System.out.print("Enter EmpID to delete: ");
                int id = sobj.nextInt();
                sobj.nextLine();
                mobj.DeleteSpecificID(id);
            } 
            else if(iOption == 8) 
            {
                System.out.print("Enter EmpName to delete: ");
                String name = sobj.nextLine();
                mobj.DeleteSpecificName(name);
            } 
            else if(iOption == 9) 
            {
                System.out.print("Enter EmpID to update: ");
                int id = sobj.nextInt();
                sobj.nextLine();

                System.out.print("Enter new name (or press Enter to skip): ");
                String name = sobj.nextLine();

                System.out.print("Enter new age (or -1 to skip): ");
                int age = sobj.nextInt();
                sobj.nextLine();

                System.out.print("Enter new address (or press Enter to skip): ");
                String address = sobj.nextLine();

                System.out.print("Enter new salary (or -1 to skip): ");
                int salary = sobj.nextInt();
                sobj.nextLine();

                String newName = name.isEmpty() ? null : name;
                Integer newAge = (age == -1) ? null : age;
                String newAddress = address.isEmpty() ? null : address;
                Integer newSalary = (salary == -1) ? null : salary;

                mobj.UpdateEmployeeByID(id, newName, newAge, newAddress, newSalary);

            } 
            else if(iOption == 10) 
            {
                System.out.print("Enter EmpName to update: ");
                String oldName = sobj.nextLine();

                System.out.print("Enter new name (or press Enter to skip): ");
                String name = sobj.nextLine();

                System.out.print("Enter new age (or -1 to skip): ");
                int age = sobj.nextInt();
                sobj.nextLine();

                System.out.print("Enter new address (or press Enter to skip): ");
                String address = sobj.nextLine();

                System.out.print("Enter new salary (or -1 to skip): ");
                int salary = sobj.nextInt();
                sobj.nextLine();

                String newName = name.isEmpty() ? null : name;
                Integer newAge = (age == -1) ? null : age;
                String newAddress = address.isEmpty() ? null : address;
                Integer newSalary = (salary == -1) ? null : salary;

                mobj.UpdateEmployeeByName(oldName, newName, newAge, newAddress, newSalary);

            } 
            else if(iOption == 11) 
            {
                mobj.CountEmployees();
            } 
            else if(iOption == 12) 
            {
                mobj.MaxSalary();
            } 
            else if(iOption == 13) 
            {
                mobj.MinSalary();
            } 
            else if(iOption == 14) 
            {
                mobj.AverageSalary();
            } 
            else if(iOption == 15) 
            {
                mobj.SumSalary();
            } 
            else if(iOption == 16) 
            {
                System.out.print("Enter min salary: ");
                int min = sobj.nextInt();
                System.out.print("Enter max salary: ");
                int max = sobj.nextInt();
                sobj.nextLine();
                mobj.SelectBySalaryRange(min, max);
            } 
            else if(iOption == 17) 
            {
                mobj.SortByName();
            } 
            else if(iOption == 18) 
            {
                mobj.SortBySalary();
            } 
            else if(iOption == 20) 
            {
                System.out.println("Thank you for using MDBMS");
                mobj = null;
                System.gc();
                break;
            } 
            else 
            {
                System.out.println("Invalid Option. Try again.");
            }
        }

        sobj.close();
    }
}
