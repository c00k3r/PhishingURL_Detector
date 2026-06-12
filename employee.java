import java.util.Scanner;
class employee{
   int salary;
   String name;
   
   public int getSalary(){
      return salary;
   }

   void setName(Scanner sc){
      System.out.println("Enter new name : ");
      String newName = sc.nextLine();
      name = newName;
   }

   void getName(){
      System.out.println("Name is : " +name);
   }

}
public class OOPS1 {
 public static void main(String[] args) {
   Scanner sc = new Scanner(System.in);
    employee moksh = new employee();
    moksh.salary = 120000;
    moksh.name = "Mrityunjay";

   System.out.println("Salary is : " + moksh.getSalary());
    moksh.setName(sc);
    moksh.getName();

 }
}
