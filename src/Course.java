public class Course {
    private final String[] courseName;
    private final String[] courseCode;

    public Course(String[] courseName , String[] courseCode){
        this.courseName = courseName;
        this.courseCode = courseCode;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<6; i++){
            sb.append(" Course "+(i+1)+ " : "+courseName[i] + "("+courseCode[i]+")\n");
        }
        return sb.toString();
    }

}
