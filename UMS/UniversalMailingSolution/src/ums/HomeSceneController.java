package ums;

import java.net.URL;
import java.util.Comparator;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import ums.emailEvents.*;

public class HomeSceneController implements Initializable{

    @FXML
    private TreeView<String> emailFoldersTreeView;
    private TreeItem<String> root=new TreeItem<>();

    @FXML
    private AnchorPane homeScene;

    @FXML
    private TableView<MaintainEmailMessages> emailTableView;

    @FXML
    private TableColumn<MaintainEmailMessages, String> senderColumn;

    @FXML
    private TableColumn<MaintainEmailMessages, String> sizeColumn;

    @FXML
    private TableColumn<MaintainEmailMessages, String> subjectColumn;

    @FXML
    private WebView viewContent;
    
    @FXML
    private Button btnComposeEmail;

    @FXML
    private Button btnAddAccount;

    private String email;
    

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @FXML
    void composeEmail(ActionEvent event) {
        try{
            FXMLLoader fxmlLoader=new FXMLLoader(getClass().getResource("./layout/mailCompose.fxml"));
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

    @FXML
    void addAccount(ActionEvent event) {
        try{
            FXMLLoader fxmlLoader=new FXMLLoader(getClass().getResource("./layout/addAccount.fxml"));
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

    //Temporary TestCase
    final ObservableList<MaintainEmailMessages> data=FXCollections.observableArrayList(
        new MaintainEmailMessages("Google", "Password Reset", 20),
        new MaintainEmailMessages("Instagram", "New Login", 50000000),
        new MaintainEmailMessages("Google", "Security Alert", 20000)
        
    );


    

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        viewContent.getEngine().loadContent("<html><body><h1>Welcome</h1></body></html>");
        senderColumn.setCellValueFactory(new PropertyValueFactory<>("sender"));
        subjectColumn.setCellValueFactory(new PropertyValueFactory<>("subject"));
        sizeColumn.setCellValueFactory(new PropertyValueFactory<>("size"));

        emailTableView.setItems(data);

        sizeColumn.setComparator(new Comparator<String>() {
            Integer a, b;
            @Override
            public int compare(String o1, String o2){
                a=MaintainEmailMessages.formatted.get(o1);
                b=MaintainEmailMessages.formatted.get(o2);
                return a.compareTo(b);            
            }
        });

        emailFoldersTreeView.setRoot(root);
        root.setValue("20p151@kce.ac.in");
        root.setGraphic(getIcon(root.getValue()));
        root.setExpanded(true);//always the tree view in expanded form

        TreeItem<String> inbox=new TreeItem<>("Inbox", getIcon("Inbox"));
        TreeItem<String> sent=new TreeItem<>("Sent", getIcon("Sent"));
        TreeItem<String> spam=new TreeItem<>("Spam", getIcon("Spam"));
        TreeItem<String> trash=new TreeItem<>("Trash", getIcon("Trash"));
        
        root.getChildren().addAll(inbox, sent, spam, trash);
    }

    private Node getIcon(String treeItem){
        String lowerTreeItem=treeItem.toLowerCase();
        ImageView returnIcon;
        if(lowerTreeItem.contains("inbox")){
            returnIcon=new ImageView(new Image(getClass().getResourceAsStream("images/inbox.png")));
        } 
        else if(lowerTreeItem.contains("sent")){
            returnIcon=new ImageView(new Image(getClass().getResourceAsStream("images/sent.png")));
        } 
        else if(lowerTreeItem.contains("spam")){
            returnIcon=new ImageView(new Image(getClass().getResourceAsStream("images/spam.png")));
        }
        else if(lowerTreeItem.contains("trash")){
            returnIcon=new ImageView(new Image(getClass().getResourceAsStream("images/trash.png")));
        }
        else if(lowerTreeItem.contains("@")){
            returnIcon=new ImageView(new Image(getClass().getResourceAsStream("images/account.png")));
            returnIcon.setFitHeight(24);
            returnIcon.setFitWidth(24);
        }
        else{
            returnIcon=new ImageView(new Image(getClass().getResourceAsStream("images/folder.png")));
        }
        if(!lowerTreeItem.contains("@")){
            returnIcon.setFitHeight(16);
            returnIcon.setFitWidth(16);
        }
        
        return returnIcon;
    }

}
