package ums;

import java.lang.Thread.State;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TreeView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

public class HomeSceneController {
    @FXML
    private AnchorPane InboxTree;

    @FXML
    private WebView viewContent;
    
    @FXML
    private Button btnAddAccount;

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

}
