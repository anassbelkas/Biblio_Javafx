package sample;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import sample.connection.ConnectionClass;


import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ParametreController {
    @FXML
    private Label error;


    @FXML
    private TextField email;
    @FXML
    private PasswordField motdepasse;
    @FXML
    private PasswordField nvmptdepasse;
    @FXML
    private PasswordField confirmation;
    @FXML
    private Button modifier;
    @FXML
    private Button document;
    @FXML
    private Button historique;
    @FXML
    private Button admin;
    @FXML
    private Button parametre;
    @FXML
    private Button deconnecter;
    @FXML
    private AnchorPane param;


    public void ButtonDocummentAction(ActionEvent event) {
        param.getScene().getWindow().hide();
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("Doc.fxml"));
        } catch (IOException ex) {
            Logger.getLogger(ParametreController.class.getName()).log(Level.SEVERE, null, ex);
        }
        Stage stage = new Stage();
        Scene scene = new Scene(root) ;
        stage.setScene(scene);
        stage.setTitle("MyBiblio");
        stage.show();
    }
    public void ButtonAdminAction(ActionEvent event) {
        param.getScene().getWindow().hide();
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("Admin.fxml"));
        } catch (IOException ex) {
            Logger.getLogger(ParametreController.class.getName()).log(Level.SEVERE, null, ex);
        }
        Stage stage = new Stage();
        Scene scene = new Scene(root) ;
        stage.setScene(scene);
        stage.setTitle("MyBiblio");
        stage.show();
    }

    public void ButtonHistoriqueAction(ActionEvent event) {
        param.getScene().getWindow().hide();
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("Historique.fxml"));
        } catch (IOException ex) {
            Logger.getLogger(ParametreController.class.getName()).log(Level.SEVERE, null, ex);
        }
        Stage stage = new Stage();
        Scene scene = new Scene(root) ;
        stage.setScene(scene);
        stage.setTitle("MyBiblio");
        stage.show();
    }

    public void ButtonParametreAction(ActionEvent event) {
        param.getScene().getWindow().hide();
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("Param.fxml"));
        } catch (IOException ex) {
            Logger.getLogger(ParametreController.class.getName()).log(Level.SEVERE, null, ex);
        }
        Stage stage = new Stage();
        Scene scene = new Scene(root) ;
        stage.setScene(scene);
        stage.setTitle("MyBiblio");
        stage.show();
    }

    public void ButtonDeconnecterAction(ActionEvent event) {
        param.getScene().getWindow().hide();
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("Connection.fxml"));
        } catch (IOException ex) {
            Logger.getLogger(ParametreController.class.getName()).log(Level.SEVERE, null, ex);
        }
        Stage stage = new Stage();
        Scene scene = new Scene(root) ;
        stage.setScene(scene);
        stage.setTitle("MyBiblio");
        stage.show();
    }
    public int modifier(ActionEvent event){
        if(email.getText()==""){
            error.setText("données incorrectes");
            return -1;
        }
        if(motdepasse.getText()==""){
            error.setText("données incorrectes");
            return -2;
        }

        if(nvmptdepasse.getText()==""){
            error.setText("données incorrectes");
            return -3;
        }
        if(confirmation.getText()==""){
            error.setText("données incorrectes");
            return -4;
        }

        if(!nvmptdepasse.getText().equals(confirmation.getText())){
            error.setText("données incorrectes");
            return -4;
        }
        else{
            error.setText("");
        }
        ConnectionClass connectionClass = new ConnectionClass();
        Connection connection = connectionClass.getConnection();
        String sql2 = "select * from user";
        int i=0;
        try {
            Statement statement = connection.createStatement();
            ResultSet queryOutput = statement.executeQuery(sql2);
            while (queryOutput.next()) {
                if(queryOutput.getString("email").equals(email.getText())&&queryOutput.getString("password").equals(motdepasse.getText())){
                    i++;
                }
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        if(i!=0){
            error.setText("Succes !");
            error.setTextFill(Color.GREEN);
            try {
                ConnectionClass connectionClass1 = new ConnectionClass();
                Connection connection1 = connectionClass1.getConnection();
                String sql = "update user set password='"+nvmptdepasse.getText()+"' where email='"+email.getText()+"'";
                Statement statement = connection1.createStatement();
                statement.executeUpdate(sql);
                email.setText("");
                nvmptdepasse.setText("");
                motdepasse.setText("");
                confirmation.setText("");
            }
            catch (SQLException e){
                System.out.println(e.getErrorCode());
            }
        }
        return 1;
    }
}
