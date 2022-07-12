package controller;

import model.Student;
import util.CrudUtil;

import java.sql.SQLException;

public class CustomerCrudController {
    public static boolean saveStudent(Student student) throws SQLException, ClassNotFoundException {
        return CrudUtil.executeUpdate("INSERT INTO student VALUES (?,?,?,?,?,?)",student.getId(),student.getName(),student.getEmail(),student.getContact(),student.getAddress(),student.getNic());
    }
}
