package sample;

import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConnectionController {

    @FXML
    private Label error;

    @FXML
    private Button inscriptionButton;
    @FXML
    private Button connecter;
    @FXML
    private TextField nom;
    @FXML
    private PasswordField mdp;
    @FXML
    private PasswordField mdp_inscription;
    @FXML
    private TextField nom_utilisateur;
    @FXML
    private TextField prenom;
    @FXML
    private TextField email;
    @FXML
    private Button inscriptionConfirm;
    @FXML
    private Button annuler;

    @FXML
    private ImageView img;
    @FXML
    private AnchorPane log;


    public void ButtonConneteAction(ActionEvent event) {
        log.getScene().getWindow().hide();
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("Doc.fxml"));
        } catch (IOException ex) {
            Logger.getLogger(ConnectionController.class.getName()).log(Level.SEVERE, null, ex);
        }
        Stage stage = new Stage();
        Scene scene = new Scene(root) ;
        stage.setScene(scene);
        stage.show();
    }

    public void Translate(ActionEvent event){
            TranslateTransition translateTransition = new TranslateTransition();
            translateTransition.setDuration(Duration.millis(1200));
            translateTransition.setNode(img);
            translateTransition.setByX(350);
            translateTransition.setAutoReverse(false);
            translateTransition.play();

    }

    public void TranslateReverse(ActionEvent event){
        TranslateTransition translateTransition = new TranslateTransition();
        translateTransition.setDuration(Duration.millis(1200));
        translateTransition.setNode(img);
        translateTransition.setByX(-350);
        translateTransition.setAutoReverse(false);
        translateTransition.play();

    }


}
