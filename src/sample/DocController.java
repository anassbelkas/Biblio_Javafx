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

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DocController {

    @FXML
    private Button livre;
    @FXML
    private Button magazine;
    @FXML
    private Button dictionnaire;
    @FXML
    private Button document;
    @FXML
    private Button historique;
    @FXML
    private Button parametre;
    @FXML
    private Button deconnecter;
    @FXML
    private Button search;
    @FXML
    private Button emprunter;
    @FXML
    private TextField chercher;
    @FXML
    private TableView tableau;
    @FXML
    private TableView tableauEmpr;
    @FXML
    private AnchorPane doc;

    public void ButtonDocummentAction(ActionEvent event) {
        doc.getScene().getWindow().hide();
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("Doc.fxml"));
        } catch (IOException ex) {
            Logger.getLogger(DocController.class.getName()).log(Level.SEVERE, null, ex);
        }
        Stage stage = new Stage();
        Scene scene = new Scene(root) ;
        stage.setScene(scene);
        stage.show();
    }

    public void ButtonHistoriqueAction(ActionEvent event) {
        doc.getScene().getWindow().hide();
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("Historique.fxml"));
        } catch (IOException ex) {
            Logger.getLogger(DocController.class.getName()).log(Level.SEVERE, null, ex);
        }
        Stage stage = new Stage();
        Scene scene = new Scene(root) ;
        stage.setScene(scene);
        stage.show();
    }

    public void ButtonParametreAction(ActionEvent event) {
        doc.getScene().getWindow().hide();
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("Param.fxml"));
        } catch (IOException ex) {
            Logger.getLogger(DocController.class.getName()).log(Level.SEVERE, null, ex);
        }
        Stage stage = new Stage();
        Scene scene = new Scene(root) ;
        stage.setScene(scene);
        stage.show();
    }

    public void ButtonDeconnecterAction(ActionEvent event) {
        doc.getScene().getWindow().hide();
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("Connection.fxml"));
        } catch (IOException ex) {
            Logger.getLogger(DocController.class.getName()).log(Level.SEVERE, null, ex);
        }
        Stage stage = new Stage();
        Scene scene = new Scene(root) ;
        stage.setScene(scene);
        stage.show();
    }

}
