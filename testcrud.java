public class Test {
    public static void main(String[] args) {
        StudentDAO dao = new StudentDAO();

        Student s = new Student();
        s.setName("Anshu");
        s.setAge(21);
        dao.createStudent(s);

        Student fetched = dao.getStudent(1);
        System.out.println(fetched.getName());

        fetched.setAge(22);
        dao.updateStudent(fetched);

        dao.deleteStudent(1);
    }
}
