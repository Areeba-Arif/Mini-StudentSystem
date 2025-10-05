import java.time.format.SignStyle;
import java.util.ArrayList;


public class StudentList
{
    private Student[] students;
    private int size;
    private int capacity;

    private ArrayList<Student> studentArrayList;

    public StudentList(int capacity){

        this.capacity = capacity;
        this.size =0;
        this.students = new Student[capacity];
        studentArrayList = new ArrayList<>();

    }

    public ArrayList<Student> getStudentArrayList() {
        ArrayList<Student> arr = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            arr.add(students[i]);
        }
        return arr;
    }
    public void addStudent(Student s){
        Boolean flag = true;
        if(size>=capacity){
            flag = false;
            System.out.println("We move from static to dynamic");
            resize();
            if(capacity>size){
                flag = true;
            }
        }
        students[size++] = s;
        System.out.println("Student added!");


    }

    public boolean addStudent(int idx, Student newStudent){
        if(idx<0||idx>size){
            System.out.println("ERROR: Index out of bound exception.");
            return false;
        }

        for(int i=0; i<size; i++){
            System.out.println("ERROR: seat number already exists!");
            return false;
        }

        if(size>=capacity){
            resize();
        }

        for(int i=size; i>idx; i--){
            students[i]= students[i-1];
        }

        students[idx] = newStudent;
        size++;
        return true;
    }

    public void resize(){
      int newCapacity =  capacity *2;
      Student[] newArr = new Student[newCapacity];
      for(int i=0 ; i<size; i++){
          newArr[i] = students[i];
      }
      students = newArr;

      System.out.println("New capacity will be " + newCapacity);


    }

    public void removeBySeatNo(String seatNo){

        for (int i=0; i<size; i++){
            if(students[i].getSeatNo().equals(seatNo)){
                for(int j=i; j<size-1; j++){
                    students[j] = students[j+1];
                }
                students[--size] = null;
                System.out.println("Student of seatNo (" + seatNo + ") removed!");
                return;
            }
        }

    }




    public void searchByName(String name){
        for(int i=0; i<size; i++){
            if(students[i].getName().equals(name)){
                System.out.println(students[i]);
                return;
            }
        }
        System.out.println("Student not found of the name " + name);
    }

    public void searchBySeat(String seatNo){
        for(int i=0; i<size; i++){
            if(students[i].getSeatNo().equals(seatNo)){
                System.out.println(students[i]);
                return;
            }
        }
        System.out.println("Student not found of the name " + seatNo);
    }



    public void updateName(String seatNo , String newName){
        for(int i=0; i<size; i++){
            if(students[i].getSeatNo().equals(seatNo)){
                students[i].setName(newName);
                return;
            }
        }
    }

//    @Override
//    public int compareTo(Student that) {
//        return 0;
//    }







    @Override
    public String toString() {
        if(size==0){
            return "No Student found in list!";

        }
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<size; i++){
            sb.append(students[i] + "\n");
        }
        return sb.toString();
    }
}
