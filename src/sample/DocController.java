package sample;

import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
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

import javax.swing.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collections;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DocController {
    @FXML
    private TableColumn<Document,String> isbn_column;
    @FXML
    private TableColumn<Document,String> titre_column;
    @FXML
    private TableColumn<Document,String> qteStock_column;
    @FXML
    private TableColumn<Document,String> qteLouee_column;
    @FXML
    private TableColumn<Document,Button> emprunter_column;



    @FXML
    private TableColumn<Document,String> emprunter_titre_column;



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
    private Button Admin;
    @FXML
    private Button search;
    @FXML
    private Button emprunter;
    @FXML
    private TextField chercher;
    @FXML
    private TableView tableau;
    @FXML
    private TableView<Document> tableauEmpr;
    @FXML
    private AnchorPane doc;
    @FXML
    private Label label;



    public void ButtonDocummentAction(ActionEvent event) {
        doc.getScene().getWindow().hide();
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("Doc.fxml"));
        }
        catch (IOException ex) {
            Logger.getLogger(DocController.class.getName()).log(Level.SEVERE, null, ex);
        }
        Stage stage = new Stage();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("MyBiblio");
        stage.show();
    }
    public void ButtonAdminAction(ActionEvent event) {
        doc.getScene().getWindow().hide();
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("Admin.fxml"));
        } catch (IOException ex) {
            Logger.getLogger(DocController.class.getName()).log(Level.SEVERE, null, ex);
        }
        Stage stage = new Stage();
        Scene scene = new Scene(root) ;
        stage.setScene(scene);
        stage.setTitle("MyBiblio");
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
        stage.setTitle("MyBiblio");
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
        stage.setTitle("MyBiblio");
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
        stage.setTitle("MyBiblio");
        stage.show();
    }
    public void livre(ActionEvent e){
        isbn_column.setCellValueFactory(new PropertyValueFactory<>("isbn"));
        titre_column.setCellValueFactory(new PropertyValueFactory<>("titre"));
        qteStock_column.setCellValueFactory(new PropertyValueFactory<>("qteStock"));
        qteLouee_column.setCellValueFactory(new PropertyValueFactory<>("qteLouee"));
        emprunter_column.setCellValueFactory(new PropertyValueFactory<>("button"));
        emprunter_titre_column.setCellValueFactory(new PropertyValueFactory<>("titre"));
        ObservableList<Document> list = FXCollections.observableArrayList();
        ConnectionClass connectionClass = new ConnectionClass();
        Connection connection = connectionClass.getConnection();
        String sql2 = "select * from document where isbn='livre'";
        System.out.println(sql2);
        try {
            Statement statement = connection.createStatement();
            ResultSet queryOutput = statement.executeQuery(sql2);
            while (queryOutput.next()) {
                Document document = new Document(queryOutput.getString("isbn"),queryOutput.getString("titre"),queryOutput.getString("qteStock"),queryOutput.getString("qteLouee"));
                list.add(document);
                document.getButton().setOnAction((event)->{
                    ObservableList<Document> list1 = FXCollections.observableArrayList();
                    list1.add(document);
                    tableauEmpr.setItems(list1);
                    Static.titre=document.getTitre();
                    System.out.println(Static.titre);
                });
            }

            Collections.sort(list,(o1, o2)->{
                if(o1.getTitre().compareTo(o2.getTitre())>0)
                    return 1;
                if(o1.getTitre().compareTo(o2.getTitre())<0)
                    return -1;
                else
                    return 0;
            });
            tableau.setItems(list);
        }
        catch (Exception ee) {
            ee.printStackTrace();
        }
    }
    public void magazine(ActionEvent e){
        isbn_column.setCellValueFactory(new PropertyValueFactory<>("isbn"));
        titre_column.setCellValueFactory(new PropertyValueFactory<>("titre"));
        qteStock_column.setCellValueFactory(new PropertyValueFactory<>("qteStock"));
        qteLouee_column.setCellValueFactory(new PropertyValueFactory<>("qteLouee"));
        emprunter_column.setCellValueFactory(new PropertyValueFactory<>("button"));
        emprunter_titre_column.setCellValueFactory(new PropertyValueFactory<>("titre"));
        ObservableList<Document> list = FXCollections.observableArrayList();
        ConnectionClass connectionClass = new ConnectionClass();
        Connection connection = connectionClass.getConnection();
        String sql2 = "select * from document where isbn='magazine'";
        System.out.println(sql2);
        try {
            Statement statement = connection.createStatement();
            ResultSet queryOutput = statement.executeQuery(sql2);
            while (queryOutput.next()) {
                Document document = new Document(queryOutput.getString("isbn"),queryOutput.getString("titre"),queryOutput.getString("qteStock"),queryOutput.getString("qteLouee"));
                list.add(document);
                document.getButton().setOnAction((event)->{
                    ObservableList<Document> list1 = FXCollections.observableArrayList();
                    list1.add(document);
                    tableauEmpr.setItems(list1);
                    Static.titre=document.getTitre();
                    System.out.println(Static.titre);
                });
            }

            Collections.sort(list,(o1, o2)->{
                if(o1.getTitre().compareTo(o2.getTitre())>0)
                    return 1;
                if(o1.getTitre().compareTo(o2.getTitre())<0)
                    return -1;
                else
                    return 0;
            });
            tableau.setItems(list);
        }
        catch (Exception ee) {
            ee.printStackTrace();
        }
    }
    public void dictionnaire(ActionEvent e){
        isbn_column.setCellValueFactory(new PropertyValueFactory<>("isbn"));
        titre_column.setCellValueFactory(new PropertyValueFactory<>("titre"));
        qteStock_column.setCellValueFactory(new PropertyValueFactory<>("qteStock"));
        qteLouee_column.setCellValueFactory(new PropertyValueFactory<>("qteLouee"));
        emprunter_column.setCellValueFactory(new PropertyValueFactory<>("button"));
        emprunter_titre_column.setCellValueFactory(new PropertyValueFactory<>("titre"));
        ObservableList<Document> list = FXCollections.observableArrayList();
        ConnectionClass connectionClass = new ConnectionClass();
        Connection connection = connectionClass.getConnection();
        String sql2 = "select * from document where isbn='dictionnaire'";
        System.out.println(sql2);
        try {
            Statement statement = connection.createStatement();
            ResultSet queryOutput = statement.executeQuery(sql2);
            while (queryOutput.next()) {
                Document document = new Document(queryOutput.getString("isbn"),queryOutput.getString("titre"),queryOutput.getString("qteStock"),queryOutput.getString("qteLouee"));
                list.add(document);
                document.getButton().setOnAction((event)->{
                    ObservableList<Document> list1 = FXCollections.observableArrayList();
                    list1.add(document);
                    tableauEmpr.setItems(list1);
                    Static.titre=document.getTitre();
                    System.out.println(Static.titre);
                });
            }

            Collections.sort(list,(o1, o2)->{
                if(o1.getTitre().compareTo(o2.getTitre())>0)
                    return 1;
                if(o1.getTitre().compareTo(o2.getTitre())<0)
                    return -1;
                else
                    return 0;
            });
            tableau.setItems(list);
        }
        catch (Exception ee) {
            ee.printStackTrace();
        }
    }
    public void search(ActionEvent e) {
        isbn_column.setCellValueFactory(new PropertyValueFactory<>("isbn"));
        titre_column.setCellValueFactory(new PropertyValueFactory<>("titre"));
        qteStock_column.setCellValueFactory(new PropertyValueFactory<>("qteStock"));
        qteLouee_column.setCellValueFactory(new PropertyValueFactory<>("qteLouee"));
        emprunter_column.setCellValueFactory(new PropertyValueFactory<>("button"));
        emprunter_titre_column.setCellValueFactory(new PropertyValueFactory<>("titre"));
        ObservableList<Document> list = FXCollections.observableArrayList();
        ConnectionClass connectionClass = new ConnectionClass();
        Connection connection = connectionClass.getConnection();
        String sql2 = "select * from document where isbn='"+chercher.getText()+"'";
        System.out.println(sql2);
        try {
            Statement statement = connection.createStatement();
            ResultSet queryOutput = statement.executeQuery(sql2);
            while (queryOutput.next()) {
                Document document = new Document(queryOutput.getString("isbn"),queryOutput.getString("titre"),queryOutput.getString("qteStock"),queryOutput.getString("qteLouee"));
                list.add(document);
                document.getButton().setOnAction((event)->{
                    ObservableList<Document> list1 = FXCollections.observableArrayList();
                    list1.add(document);
                    tableauEmpr.setItems(list1);
                    Static.titre=document.getTitre();
                    System.out.println(Static.titre);
                });
            }

            Collections.sort(list,(o1, o2)->{
                if(o1.getTitre().compareTo(o2.getTitre())>0)
                    return 1;
                if(o1.getTitre().compareTo(o2.getTitre())<0)
                    return -1;
                else
                    return 0;
            });
            tableau.setItems(list);
        }
        catch (Exception ee) {
            ee.printStackTrace();
        }
    }
    public int emprunter(ActionEvent e){
        if(Static.titre=="")
            return -1;
        ConnectionClass connectionClass = new ConnectionClass();
        Connection connection = connectionClass.getConnection();
        Random rd = new Random();
        int random = rd.nextInt(1000);
        String isbn="";
        String titre="";
        String sql2 = "select * from document where titre='"+Static.titre+"'";
        try {
            Statement statement = connection.createStatement();
            ResultSet queryOutput = statement.executeQuery(sql2);
            while (queryOutput.next()) {
            isbn=queryOutput.getString("isbn");
            titre=queryOutput.getString("titre");
                }
        }
        catch (Exception ess) {
            ess.printStackTrace();
        }
        try {
            ConnectionClass connectionClass1 = new ConnectionClass();
            Connection connection1 = connectionClass1.getConnection();
            String sql="insert into empreint values("+random+",'"+isbn+"','"+titre+"')";
            System.out.println(sql);
            Statement statement = connection1.createStatement();
            statement.executeUpdate(sql);
        }
        catch (SQLException ees){
            System.out.println(ees.getErrorCode());
        }
        return 1;
    }
}
