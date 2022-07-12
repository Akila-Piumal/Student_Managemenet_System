package controller;

import model.Student;
import util.CrudUtil;

import java.sql.SQLException;

public class StudentCrudController {
    public static boolean saveStudent(Student student) throws SQLException, ClassNotFoundException {
        return CrudUtil.executeUpdate("INSERT INTO student VALUES (?,?,?,?,?,?)",student.getId(),student.getName(),student.getEmail(),student.getContact(),student.getAddress(),student.getNic());
    }

    public static boolean deleteStudent(String studentId) throws SQLException, ClassNotFoundException {
        return CrudUtil.executeUpdate("DELETE FROM student WHERE student_id=?",studentId);
    }
}
