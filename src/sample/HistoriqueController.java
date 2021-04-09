package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import sample.connection.ConnectionClass;
import sample.tables.Document;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collections;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class HistoriqueController {
    @FXML
    private TableColumn<Document,String> isbn_emprunter_column;
    @FXML
    private TableColumn<Document,String> titre_emprunter_column;
    @FXML
    private Label livre;
    @FXML
    private Label magazine;
    @FXML
    private Label dictionnaire;
    @FXML
    private Button document;
    @FXML
    private Button historique;
    @FXML
    private Button parametre;
    @FXML
    private Button deconnecter;
    @FXML
    private Button admin;
    @FXML
    private Button search;
    @FXML
    private Button corbeille;
    @FXML
    private TextField chercher;
    @FXML
    private TableView<Document> table;
    @FXML
    private AnchorPane hist;

    public void ButtonDocummentAction(ActionEvent event) {
        hist.getScene().getWindow().hide();
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("Doc.fxml"));
        } catch (IOException ex) {
            Logger.getLogger(HistoriqueController.class.getName()).log(Level.SEVERE, null, ex);
        }
        Stage stage = new Stage();
        Scene scene = new Scene(root) ;
        stage.setScene(scene);
        stage.setTitle("MyBiblio");

        stage.show();
    }

    public void ButtonHistoriqueAction(ActionEvent event) {
        hist.getScene().getWindow().hide();
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("Historique.fxml"));
        } catch (IOException ex) {
            Logger.getLogger(HistoriqueController.class.getName()).log(Level.SEVERE, null, ex);
        }
        Stage stage = new Stage();
        Scene scene = new Scene(root) ;
        stage.setScene(scene);
        stage.setTitle("MyBiblio");
        stage.show();
    }

    public void ButtonParametreAction(ActionEvent event) {
        hist.getScene().getWindow().hide();
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("Param.fxml"));
        } catch (IOException ex) {
            Logger.getLogger(HistoriqueController.class.getName()).log(Level.SEVERE, null, ex);
        }
        Stage stage = new Stage();
        Scene scene = new Scene(root) ;
        stage.setScene(scene);
        stage.setTitle("MyBiblio");
        stage.show();
    }

    public void ButtonAdminAction(ActionEvent event) {
        hist.getScene().getWindow().hide();
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("Admin.fxml"));
        } catch (IOException ex) {
            Logger.getLogger(HistoriqueController.class.getName()).log(Level.SEVERE, null, ex);
        }
        Stage stage = new Stage();
        Scene scene = new Scene(root) ;
        stage.setScene(scene);
        stage.setTitle("MyBiblio");
        stage.show();
    }

    public void ButtonDeconnecterAction(ActionEvent event) {
        hist.getScene().getWindow().hide();
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("Connection.fxml"));
        } catch (IOException ex) {
            Logger.getLogger(HistoriqueController.class.getName()).log(Level.SEVERE, null, ex);
        }
        Stage stage = new Stage();
        Scene scene = new Scene(root) ;
        stage.setScene(scene);
        stage.setTitle("MyBiblio");
        stage.show();
    }
    public void afficher(ActionEvent e){
        isbn_emprunter_column.setCellValueFactory(new PropertyValueFactory<>("isbn"));
        titre_emprunter_column.setCellValueFactory(new PropertyValueFactory<>("titre"));
        ObservableList<Document> list = FXCollections.observableArrayList();
        ConnectionClass connectionClass = new ConnectionClass();
        Connection connection = connectionClass.getConnection();
        String sql2 = "select * from empreint";
        System.out.println(sql2);
        try {
            Statement statement = connection.createStatement();
            ResultSet queryOutput = statement.executeQuery(sql2);
            while (queryOutput.next()) {
                Document document = new Document(queryOutput.getString("isbn"),queryOutput.getString("titre"));
                list.add(document);
            }

            Collections.sort(list,(o1, o2)->{
                if(o1.getTitre().compareTo(o2.getTitre())>0)
                    return 1;
                if(o1.getTitre().compareTo(o2.getTitre())<0)
                    return -1;
                else
                    return 0;
            });
            table.setItems(list);
        }
        catch (Exception ee) {
            ee.printStackTrace();
        }
    }

    public void corbeille(ActionEvent e){
        ConnectionClass connectionClass = new ConnectionClass();
        Connection connection=connectionClass.getConnection();

        String sql="";
        try{
            Statement statement=connection.createStatement();
            statement.executeUpdate(sql);
        }
        catch (SQLException se){
            System.out.println(se.getMessage());
        }
    }
}
