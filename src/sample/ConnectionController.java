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
import sample.connection.ConnectionClass;
import sample.tables.User;

import javax.swing.*;
import java.io.IOException;
import java.net.UnknownServiceException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConnectionController {

    @FXML
    private Label error_nom;
    @FXML
    private Label error_prenom;
    @FXML
    private Label error_email;
    @FXML
    private Label error_mdp;

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
        ConnectionClass connectionClass = new ConnectionClass();
        Connection connection = connectionClass.getConnection();
        String sql2 = "select * from user";
        int i=0;
        try {
            Statement statement = connection.createStatement();
            ResultSet queryOutput = statement.executeQuery(sql2);
            while (queryOutput.next()) {
                if(queryOutput.getString("nom").equals(nom.getText())&&queryOutput.getString("password").equals(mdp.getText())) {
                    i++;
                }
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        if(i!=0) {
            error.setText("");
            log.getScene().getWindow().hide();
            Parent root = null;
            try {
                root = FXMLLoader.load(getClass().getResource("Doc.fxml"));
            } catch (IOException ex) {
                Logger.getLogger(ConnectionController.class.getName()).log(Level.SEVERE, null, ex);
            }
            Stage stage = new Stage();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("MyBiblio");
            stage.show();
        }
        else{
            error.setText("Invalid login ou mot de passe !");
        }
    }

    public void Translate(ActionEvent event) {
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
        nom_utilisateur.setText("");
        prenom.setText("");
        email.setText("");
        mdp_inscription.setText("");

    }
 public int inscrire() throws SQLException {
        if(nom_utilisateur.getText()==""){
            error_nom.setText("Entrer votre nom");
            return -1;
        }
        else{
            error_nom.setText("");
        }
        if(prenom.getText()==""){
            error_prenom.setText("inserer votre prenom");
            return -2;
        }
        else{
            error_prenom.setText("");
        }
        if(email.getText()==""){
            error_email.setText("inserer votre email");
            return -3;
        }
        else{
            error_email.setText("");
        }
        if(mdp_inscription.getText()==""){
            error_mdp.setText("inserer votre mot de passe");
            return -4;
        }
        else{
            error_mdp.setText("");
        }

     User user1 = new User(nom_utilisateur.getText(),prenom.getText(),email.getText(), mdp_inscription.getText());
         ConnectionClass connectionClass = new ConnectionClass();
         Connection connection=connectionClass.getConnection();
     Random rd = new Random();
     double random = rd.nextInt(10000);
     System.out.println(rd);
         String sql="INSERT INTO user values ('"+random+"','"+user1.getNom()+"','"+user1.getPrenom()+"','"+user1.getEmail()+"','"+user1.getPassword()+"')";
     System.out.println(sql);
         Statement statement=connection.createStatement();

         statement.executeUpdate(sql);
         nom_utilisateur.setText("");
         prenom.setText("");
         email.setText("");
         mdp_inscription.setText("");



     TranslateTransition translateTransition = new TranslateTransition();
     translateTransition.setDuration(Duration.millis(1200));
     translateTransition.setNode(img);
     translateTransition.setByX(-350);
     translateTransition.setAutoReverse(false);
     translateTransition.play();
     return 1;
 }


}
