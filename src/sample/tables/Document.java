package sample.tables;

import javafx.scene.control.Button;

import javax.swing.*;

public class Document {
     String isbn;
    String titre;
    String qteStock;
    Button button;

    public Document(String isbn, String titre, String qteStock) {
        this.isbn = isbn;
        this.titre = titre;
        this.qteStock = qteStock;

        this.button= new Button("emprunter");
    }

    public Document(String titre) {
        this.titre = titre;
    }

    public Document(String isbn, String titre) {
        this.isbn = isbn;
        this.titre = titre;
    }

    public Button getButton() {
        return button;
    }

    public void setButton(Button button) {
        this.button = button;
    }

    public Document() {
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getQteStock() {
        return qteStock;
    }

    public void setQteStock(String qteStock) {
        this.qteStock = qteStock;
    }


}
