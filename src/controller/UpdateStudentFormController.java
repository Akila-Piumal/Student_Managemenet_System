package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.Student;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UpdateStudentFormController {
    public TextField txtId;
    public TextField txtName;
    public TextField txtEmail;
    public TextField txtContact;
    public TextField txtAddress;
    public TextField txtNic;
    public AnchorPane updateStudentFormContext;

    public void btnUpdateOnAction(ActionEvent actionEvent) {
        Student student=new Student(txtId.getText(),txtName.getText(),txtEmail.getText(),txtContact.getText(),txtAddress.getText(),txtNic.getText());
        try {
            if (StudentCrudController.updateStudent(student)) {
                new Alert(Alert.AlertType.CONFIRMATION,"Updated").show();
                txtId.clear();
                txtName.clear();
                txtAddress.clear();
                txtContact.clear();
                txtEmail.clear();
                txtNic.clear();
            }else {
                new Alert(Alert.AlertType.WARNING,"Something went Wrong").show();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void backToHomeOnAction(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) updateStudentFormContext.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../views/manageStudentsForm.fxml"))));
        stage.show();
    }

    public void txtSearchOnAction(ActionEvent actionEvent) {
        try {
            ResultSet resultSet = StudentCrudController.searchStudent(txtId.getText());
            if (resultSet.next()){
                txtName.setText(resultSet.getString(2));
                txtEmail.setText(resultSet.getString(3));
                txtContact.setText(resultSet.getString(4));
                txtAddress.setText(resultSet.getString(5));
                txtNic.setText(resultSet.getString(6));
            }else {
                new Alert(Alert.AlertType.WARNING,"Invalid student Id").show();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
