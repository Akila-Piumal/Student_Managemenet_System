package controller;

import model.Student;
import util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class StudentCrudController {
    public static boolean saveStudent(Student student) throws SQLException, ClassNotFoundException {
        return CrudUtil.executeUpdate("INSERT INTO student VALUES (?,?,?,?,?,?)",student.getId(),student.getName(),student.getEmail(),student.getContact(),student.getAddress(),student.getNic());
    }

    public static boolean deleteStudent(String studentId) throws SQLException, ClassNotFoundException {
        return CrudUtil.executeUpdate("DELETE FROM student WHERE student_id=?",studentId);
    }

    public static ResultSet searchStudent(String id) throws SQLException, ClassNotFoundException {
        ResultSet resultSet = CrudUtil.executeQuery("SELECT * FROM student WHERE student_id=?", id);
        return resultSet;
    }

    public static boolean updateStudent(Student student) throws SQLException, ClassNotFoundException {
        return CrudUtil.executeUpdate("UPDATE student SET student_name=?,email=?,contact=?,address=?,nic=? WHERE student_id=?",student.getName(),student.getEmail(),student.getContact(),student.getAddress(),student.getNic(),student.getId());
    }

    public static ArrayList<Student> getAllStudents() throws SQLException, ClassNotFoundException {
        ResultSet resultSet = CrudUtil.executeQuery("SELECT * FROM student");
        ArrayList<Student> students=new ArrayList<>();
        while (resultSet.next()){
            students.add(new Student(resultSet.getString(1),resultSet.getString(2),resultSet.getString(3),resultSet.getString(4),resultSet.getString(5),resultSet.getString(6)));
        }
        return students;
    }
}
