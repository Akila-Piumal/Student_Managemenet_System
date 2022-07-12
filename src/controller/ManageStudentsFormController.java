package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.IOException;

public class ManageStudentsFormController {
    public AnchorPane dashBoardContext;

    public void saveStudentFormOnAction(ActionEvent actionEvent) throws IOException {
        setUI("saveStudentForm");
    }

    public void updateStudentFormOnAction(ActionEvent actionEvent) throws IOException {
        setUI("updateStudentForm");
    }

    public void deleteStudentFormOnAction(ActionEvent actionEvent) throws IOException {
        setUI("deleteStudentForm");
    }

    public void searchStudentFormOnAction(ActionEvent actionEvent) throws IOException {
        setUI("searchStudentForm");
    }

    public void allStudentsFormOnAction(ActionEvent actionEvent) throws IOException {
        setUI("allStudentsForm");
    }

    private void setUI(String URI) throws IOException {
        Stage stage = (Stage) dashBoardContext.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../views/"+URI+".fxml"))));
        stage.setTitle(URI);
        stage.show();
    }
}
