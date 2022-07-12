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

public class SaveStudentFormController {
    public TextField txtId;
    public TextField txtName;
    public TextField txtEmail;
    public TextField txtContact;
    public TextField txtAddress;
    public TextField txtNic;
    public AnchorPane saveStudentFormContext;

    public void btnSaveOnAction(ActionEvent actionEvent) {

        try {
            ResultSet resultSet = StudentCrudController.searchStudent(txtId.getText());
            if (resultSet.next()){
                new Alert(Alert.AlertType.WARNING,"Student id Already exists").show();
            }else{
                if (StudentCrudController.saveStudent(new Student(txtId.getText(),txtName.getText(),txtEmail.getText(),txtContact.getText(),txtAddress.getText(),txtNic.getText()))) {
                    new Alert(Alert.AlertType.CONFIRMATION,"Saved").show();
                    txtId.clear();
                    txtName.clear();
                    txtAddress.clear();
                    txtContact.clear();
                    txtEmail.clear();
                    txtNic.clear();
                }else{
                    new Alert(Alert.AlertType.WARNING,"Something went Wrong").show();
                }
            }


        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void backToHomeOnAction(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) saveStudentFormContext.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../views/manageStudentsForm.fxml"))));
        stage.show();
    }
}
