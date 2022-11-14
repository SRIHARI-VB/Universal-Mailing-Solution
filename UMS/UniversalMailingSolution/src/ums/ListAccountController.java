package ums;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class ListAccountController {

    @FXML
    private Button btnAddAccount;

    @FXML
    private Button btnLoadAllAccount;

    @FXML
    void addAccount(ActionEvent event) {
        try{
            FXMLLoader fxmlLoader=new FXMLLoader(getClass().getResource("./layout/addAccount.fxml"));
            Parent root=(Parent)fxmlLoader.load();
            Stage stage=new Stage();
            
            stage.setTitle("YeeKnoM UMS");
            stage.setScene(new Scene(root));
            stage.show();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    @FXML
    void loadAllAccount(ActionEvent event) {
        try{
            FXMLLoader fxmlLoader=new FXMLLoader(getClass().getResource("./layout/home.fxml"));
            Parent root=(Parent)fxmlLoader.load();
            Stage stage=new Stage();
            stage.setResizable(false);
            stage.setTitle("YeeKnoM UMS");
            stage.setScene(new Scene(root));
            stage.show();
            
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

}
