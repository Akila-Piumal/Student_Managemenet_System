package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.Student;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class AllStudentsFormController {
    public TableView<Student> tblStudentDetails;
    public AnchorPane allStudentsFormContext;

    public void initialize(){
        tblStudentDetails.getColumns().get(0).setCellValueFactory(new PropertyValueFactory("id"));
        tblStudentDetails.getColumns().get(1).setCellValueFactory(new PropertyValueFactory("name"));
        tblStudentDetails.getColumns().get(2).setCellValueFactory(new PropertyValueFactory("email"));
        tblStudentDetails.getColumns().get(3).setCellValueFactory(new PropertyValueFactory("contact"));
        tblStudentDetails.getColumns().get(4).setCellValueFactory(new PropertyValueFactory("address"));
        tblStudentDetails.getColumns().get(5).setCellValueFactory(new PropertyValueFactory("nic"));
        loadAllStudentDetails();
    }

    private void loadAllStudentDetails() {
        try {
            ArrayList<Student> allStudents = StudentCrudController.getAllStudents();
            for (Student student : allStudents) {
                tblStudentDetails.getItems().add(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void backToHomeOnAction(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) allStudentsFormContext.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../views/manageStudentsForm.fxml"))));
        stage.show();
    }
}
