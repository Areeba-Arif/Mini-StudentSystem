import java.util.Comparator;
import java.lang.Comparable;

public class Student implements Comparable<Student> {
    private final String seatNo;
    private String name;
    Course course;

    public Student(String seatNo , String name, Course course){
        this.seatNo = seatNo;
        this.name = name;
        this.course = course;
    }

    public String getSeatNo() {
        return seatNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    @Override
    public int compareTo(Student o) {
        return 0;
    }

    public static Comparator<Student> sortBySeatNo(){
        return (Student i ,Student j)-> i.getSeatNo().compareTo(j.getSeatNo());
    }

    public static Comparator<Student> sortByName(){
        return (Student x , Student y) ->x.getName().compareTo(y.getName());
    }



    @Override
    public String toString() {
        return "SeatNo : " +getSeatNo() + " Name : " + getName() + course.toString();
    }
}
