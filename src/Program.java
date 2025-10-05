
import java.util.Collections;
import java.util.Scanner;
import java.util.ArrayList;

public class Program {
    void run(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter max number of students!");
        int cap = sc.nextInt();
        sc.nextLine();

        StudentList list = new StudentList(cap);

        while(true){
            System.out.println("=================");
            System.out.println("1- Add students");
            System.out.println("2- Display ");
            System.out.println("3- Update");
            System.out.println("4- Search by seat number");
            System.out.println("5- Search by name");
            System.out.println("6- Sort by seat number");
            System.out.println("7- Sort by name");
            System.out.println("8- Remove by seat number");
            System.out.println("9-Add student at given index");
            System.out.println("10- Exit");
            System.out.println("Your choice??");
            int choice = sc.nextInt();
            sc.nextLine();


            switch (choice){
                case 1:{ //add
                    System.out.print("Enter seat number: ");
                    String seatNo = sc.nextLine();

                    System.out.print("Enter name: ");
                    String name = sc.nextLine();

                    String[] courseName = new String[6];
                    String[] courseCode = new String[6];

                    System.out.println("Enter 6 course name with course code!");
                    for(int i=0; i<6; i++){
                        System.out.println("Course " + (i+1) + " name");
                        courseName[i] =sc.nextLine();
                        System.out.println("Course " + (i+1) + " code");
                        courseCode[i] =sc.nextLine();
                    }
                    Course c = new Course(courseName , courseCode);
                    Student s = new Student(seatNo , name , c);
                    list.addStudent(s);
                    break;
                }
                case 2: { // Display
                    System.out.println(list);
                    break;
                }
                case 3:{ //update
                    System.out.println("Enter seat number to update: ");
                    String updName = sc.nextLine();
                    System.out.println("Enter new Name: ");
                    String newName = sc.nextLine();
                    list.updateName(updName , newName);
                    break;
                }
                case 4:{ //search by seat number
                    System.out.println("Enter seat number to search student information");
                    String searchSeat = sc.nextLine();
                    list.searchBySeat(searchSeat);
                    break;

                }
                case 5:{ //search by seat number
                    System.out.println("Enter seat number to search student information");
                    String searchName = sc.nextLine();
                    list.searchByName(searchName);
                    break;

                }
                case 6: {
                    ArrayList<Student> arr = list.getStudentArrayList();
                    Collections.sort(arr, Student.sortBySeatNo());
                    System.out.println("Sort by seat number...");
                    for (Student myStud : arr) {
                        System.out.println(myStud);
                    }
                    break;
                }
                case 7: {
                    ArrayList<Student> arr = list.getStudentArrayList();
                    Collections.sort(arr, Student.sortByName());
                    System.out.println("Sort by name...");
                    for (Student myStud : arr) {
                        System.out.println(myStud);
                    }
                    break;
                }

                case 8:{ //remove by seat number
                    System.out.println("Enter which seat number you want to remove?");
                    String remseat = sc.nextLine();
                    list.removeBySeatNo(remseat);
                    break;
                }
                case 9 :{   //Add studnets at given index
                    System.out.print("Enter seat number: ");
                    String seatNo = sc.nextLine();

                    System.out.print("Enter name: ");
                    String name = sc.nextLine();

                    String[] courseName = new String[6];
                    String[] courseCode = new String[6];

                    System.out.println("Enter 6 course name with course code!");
                    for(int i=0; i<6; i++){
                        System.out.println("Course " + (i+1) + " name");
                        courseName[i] =sc.nextLine();
                        System.out.println("Course " + (i+1) + " code");
                        courseCode[i] =sc.nextLine();
                    }
                    Course c = new Course(courseName , courseCode);
                    Student s = new Student(seatNo , name , c);
                    System.out.println("At hich index u want to add?");
                    int index = sc.nextInt();
                    list.addStudent(index, s);
                    break;
                }
                case 10:{ //exiting
                    System.out.println("Exiting.....");
                    return;
                }
                default:
                    System.out.println("Invalid choice");
            }
        }

    }
}
