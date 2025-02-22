package ums;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class AddAccountController {

    @FXML
    private TextField emailAddress;

    @FXML
    private PasswordField emailPassword;

    @FXML
    private AnchorPane homeScene;

    @FXML
    private AnchorPane addAccountScene;

    @FXML
    private Button btnCancel;

    @FXML
    private Button btnAdd;

    @FXML
    void cancel(ActionEvent event) {
        try{
            Alert alert=new Alert(AlertType.CONFIRMATION);
            alert.setTitle("Cancel");
            alert.setHeaderText("You're about to cancel");
            alert.setContentText("Do you want to cancel? ");
            if(alert.showAndWait().get()==ButtonType.OK){
                Stage stage=(Stage)addAccountScene.getScene().getWindow();
                stage.close();
            }
            
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    @FXML
    void add(ActionEvent event) {
        
        
        
        
        
    }
}