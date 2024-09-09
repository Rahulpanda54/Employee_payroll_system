import java.util.*;
abstract class Employee{
    private String name;
    private int id;

    public Employee(String name,int id){
        this.name = name;
        this.id = id;
    }
    public String getName(){
        return name;
    }
    public int getID(){
        return id;
    }
    public abstract double calculatesalary();
     public String toString(){
 return "Employee[name = "+name+" , id = "+id + ",salary = "+calculatesalary() + "]";
     } 
}
class fulltime_employee extends Employee{

   public double monthlysalary;
   public fulltime_employee(String name,int id,double monthlysalary){
    super(name, id);
    this.monthlysalary = monthlysalary;
   }
   public double calculatesalary(){
    return monthlysalary;
   }

}
class part_time_employee extends Employee{
     
    public int hoursworked;
    double hourlyrate;
    part_time_employee(String name,int id,int hoursworked,int hourlyrate){
        super(name, id);
        this.hoursworked = hoursworked;
        this.hourlyrate = hourlyrate;

    }
    public double calculatesalary(){
        return hoursworked * hourlyrate;
    }
}
class PayrollSystem{
    public ArrayList<Employee>employeelist;
    PayrollSystem(){
        employeelist = new ArrayList<>();
    }

    public void addemployee(Employee employee){
        employeelist.add(employee);
    } 
    public void removeEmployee(int id){
         Employee employee_to_remove = null;

         for(Employee employee : employeelist){
            if(employee.getID() == id){
                employee_to_remove = employee;
                break;
            }
         }
         if(employee_to_remove != null){
            employeelist.remove(employee_to_remove);
         }
    }
    public void displayEmployee(){
        for(Employee employee : employeelist){
            System.out.println(employee);
        }
    }
}
public class Employee_payroll_system {
    public static void main(String[] args) {
           
      PayrollSystem payrollSystem = new PayrollSystem();
  fulltime_employee emp1 = new fulltime_employee("vikas", 1, 10000);

  part_time_employee emp2 = new part_time_employee("manav", 2, 40, 100);
  fulltime_employee emp3 = new fulltime_employee("Ayush", 3, 10000);

  part_time_employee emp4 = new part_time_employee("saurabh", 5, 30, 80);
  fulltime_employee emp5 = new fulltime_employee("Apporv", 6, 50000);

  part_time_employee emp6 = new part_time_employee("vivek", 7, 20, 1000);

fulltime_employee emp7 = new fulltime_employee("mohak", 11, 27000);

  payrollSystem.addemployee(emp1);
  payrollSystem.addemployee(emp2);
  payrollSystem.addemployee(emp3);
  payrollSystem.addemployee(emp4);
  payrollSystem.addemployee(emp5);
  payrollSystem.addemployee(emp6);
  payrollSystem.addemployee(emp7);

  System.out.println("Initial employee Details: ");
  payrollSystem.displayEmployee();
  System.out.println();
  System.out.println("Removing Employee:  ");
  payrollSystem.removeEmployee(1);
  payrollSystem.removeEmployee(3);
  System.out.println();
  System.out.println("Remaining Employee Details: ");
  payrollSystem.displayEmployee();

    } 
}