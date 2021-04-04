package sample.tables;

public class User {
    private static int id;
    private String nom;
    private String prenom;
    private String email;
    private String password;

    public User() {
        super();
    }

    public User(String nom, String prenom, String email, String password) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.password = password;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public static int getId() {
        return id;
    }

    public static void setId(int id) {
        User.id = id;
    }
    public void function (){
        id++;
    }
}
