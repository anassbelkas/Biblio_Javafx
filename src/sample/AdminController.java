package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import javax.swing.text.TabableView;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AdminController {

    @FXML
    private Button document;
    @FXML
    private Button historique;
    @FXML
    private Button parametre;
    @FXML
    private Button deconnecter;
    @FXML
    private Button admin_btn;
    @FXML
    private TextField entrer_isbn;
    @FXML
    private TextField entrer_titre;
    @FXML
    private TextField entrer_qte;
    @FXML
    private Button btn_entrer;
    @FXML
    private TableView table;
    @FXML
    private AnchorPane administration_pane;

    public void ButtonDocummentAction(ActionEvent event) {
        administration_pane.getScene().getWindow().hide();
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("Doc.fxml"));
        } catch (IOException ex) {
            Logger.getLogger(AdminController.class.getName()).log(Level.SEVERE, null, ex);
        }
        Stage stage = new Stage();
        Scene scene = new Scene(root) ;
        stage.setScene(scene);
        stage.setTitle("MyBiblio");
        stage.show();
    }

    public void ButtonAdminAction(ActionEvent event) {
        administration_pane.getScene().getWindow().hide();
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("Admin.fxml"));
        } catch (IOException ex) {
            Logger.getLogger(AdminController.class.getName()).log(Level.SEVERE, null, ex);
        }
        Stage stage = new Stage();
        Scene scene = new Scene(root) ;
        stage.setScene(scene);
        stage.setTitle("MyBiblio");
        stage.show();
    }

    public void ButtonHistoriqueAction(ActionEvent event) {
        administration_pane.getScene().getWindow().hide();
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("Historique.fxml"));
        } catch (IOException ex) {
            Logger.getLogger(AdminController.class.getName()).log(Level.SEVERE, null, ex);
        }
        Stage stage = new Stage();
        Scene scene = new Scene(root) ;
        stage.setScene(scene);
        stage.setTitle("MyBiblio");
        stage.show();
    }

    public void ButtonParametreAction(ActionEvent event) {
        administration_pane.getScene().getWindow().hide();
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("Param.fxml"));
        } catch (IOException ex) {
            Logger.getLogger(AdminController.class.getName()).log(Level.SEVERE, null, ex);
        }
        Stage stage = new Stage();
        Scene scene = new Scene(root) ;
        stage.setScene(scene);
        stage.setTitle("MyBiblio");
        stage.show();
    }

    public void ButtonDeconnecterAction(ActionEvent event) {
        administration_pane.getScene().getWindow().hide();
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("Connection.fxml"));
        } catch (IOException ex) {
            Logger.getLogger(AdminController.class.getName()).log(Level.SEVERE, null, ex);
        }
        Stage stage = new Stage();
        Scene scene = new Scene(root) ;
        stage.setScene(scene);
        stage.setTitle("MyBiblio");
        stage.show();
    }

}
