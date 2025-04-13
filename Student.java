public class Student {
    private String name;
    private Course course;

    public Student(String name, Course course) {
        this.name = name;
        this.course = course;
    }

    public void printDetails() {
        System.out.println("Name: " + name);
        System.out.println("Course: " + course.getCourseName() + ", Duration: " + course.getDuration() + " months");
    }
}
