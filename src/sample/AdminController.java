package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
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
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AdminController {
    @FXML
    private TableView<Document> table;
    @FXML
    private TableColumn<Document,String> isbn_column;
    @FXML
    private TableColumn<Document,String> titre_column;
    @FXML
    private TableColumn<Document,String> qteStock_column;
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
        Scene scene = new Scene(root);
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
        Scene scene = new Scene(root);
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
    public int entrer(ActionEvent e){
        isbn_column.setCellValueFactory(new PropertyValueFactory<>("isbn"));
        titre_column.setCellValueFactory(new PropertyValueFactory<>("titre"));
        qteStock_column.setCellValueFactory(new PropertyValueFactory<>("qteStock"));
        ObservableList<Document> list = FXCollections.observableArrayList();
        ConnectionClass connectionClass = new ConnectionClass();
        Connection connection = connectionClass.getConnection();
        String sql2 = "select * from document";
        int i=0;
        try {
            Statement statement = connection.createStatement();
            ResultSet queryOutput = statement.executeQuery(sql2);
            while (queryOutput.next()) {
            list.add(new Document(queryOutput.getString("isbn"),queryOutput.getString("titre"),queryOutput.getString("qteStock")));
                }
            Collections.sort(list,(o1,o2)->{
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

        if(entrer_isbn.getText()=="")
            return -1;
        if(entrer_titre.getText()=="")
            return -2;
        if(entrer_qte.getText()=="")
            return -3;
        ConnectionClass connectionClass1 = new ConnectionClass();
        Connection connection1 = connectionClass1.getConnection();
        Random rd = new Random();
        double random = rd.nextInt(10000);
        System.out.println(rd);
        String sql="INSERT INTO document values ('"+random+"','"+entrer_isbn.getText()+"','"+entrer_titre.getText()+"','"+entrer_qte.getText()+"',"+0+")";
        System.out.println(sql);
        try{
            Statement statement= connection1.createStatement();
            statement.executeUpdate(sql);
        }
        catch (SQLException se){
            System.out.println(se.getMessage());
        }
        table.setItems(list);
        entrer_isbn.setText("");
        entrer_titre.setText("");
        entrer_qte.setText("");
    return 1;
    }

}
