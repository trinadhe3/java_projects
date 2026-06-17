import java.util.*;

class Student
{

    static int count;
    int id;
    String name;
    int age;
    String dept;
    
    public void setDetails(int id,String name,int age,String dept){

        Student.count++;
        this.age = age;
        this.name= name;
        this.id = id;
        this.dept = dept;

    }


    public static void getCount(){

        System.out.println("Total no. of Students : " + count);

    }


    public void showDetails(){

        System.out.println("Student Name : " + name + "\nStudent Roll : " + id + "\nStudent Age : " + age + "\nStudent Department : " + dept );

    }

    public static void print(HashMap<Integer,Student> record)
    {
        if(record.isEmpty()){
            System.out.println("No Student record found!!");
        }
        else{
        for(Student obj : record.values())
            {
                System.out.println("\nStudent Name : " + obj.name + "\nStudent Roll : " + obj.id + "\nStudent Age : " + obj.age + "\nStudent Department : " + obj.dept );

            }
        }
    }

    public void deptChange(String dept){


        System.out.println("Current Department : " + this.dept);
        this.dept = dept;
        System.out.println("New Department : " + dept);

    }

}



class Sample{

    public static void main(String args[]){
        int choice;
        HashMap<Integer,Student> record = new HashMap<>();

        Scanner sc = new Scanner(System.in);
        
        do {
            System.out.println("\n===== Student Management System =====");
            System.out.println("1. Add Student");
            System.out.println("2. View Student");
            System.out.println("3. Update Department");
            System.out.println("4. Display Student Count");
            System.out.println("5.Display all Students Records");
            System.out.println("6. Exit");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Add Student");
                    System.out.print("Enter Student ID: ");
                    int id = sc.nextInt();
                    if (record.containsKey(id))
                        {
                            System.out.println("Student Id already exists");
                            break;
                        }
                    sc.nextLine(); 

                    System.out.print("Enter Student Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Age: ");
                    int age = sc.nextInt();
                    sc.nextLine(); 

                    System.out.print("Enter Department: ");
                    String dept = sc.nextLine();
                    Student obj = new Student();
                    obj.setDetails(id,name,age,dept);
                    record.put(id,obj);
                    break;

                case 2:
                    System.out.println("View Student");
                    System.out.println("Enter Student ID");
                    int sid = sc.nextInt();
                    Student obj1 = record.get(sid);
                    if(obj1 == null) {System.out.println("Student not found");break;}
                    obj1.showDetails();
                    break;

                case 3:
                    System.out.println("Update Department");
                    System.out.println("Enter Student ID:");
                    int sidd = sc.nextInt();
                    Student obj2 = record.get(sidd);
                    if(obj2 == null) {System.out.println("Student not found");break;}
                    System.out.print("Enter New Department: ");
                    sc.nextLine();
                    String changeDept = sc.nextLine();
                    obj2.deptChange(changeDept);
                    break;

                case 4:
                    System.out.println("Display Student Count");
                    Student.getCount();
                    break;
                
                case 5:
                    System.out.println("All Students Records:\n");
                    Student.print(record);
                    break;

                case 6:
                    System.out.println("Thank you!");
                    break;

                default:
                    System.out.println("Invalid Choice! Please try again.");
                    System.out.println("Do u want to Continue ? ");
                    choice = sc.nextInt();
            }

        } while (choice != 6);

        sc.close();

    }


}