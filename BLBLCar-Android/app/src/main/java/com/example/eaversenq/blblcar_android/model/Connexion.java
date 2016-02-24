package com.example.eaversenq.blblcar_android.model;

public class Connexion {

    private static Connexion cnx;

    private String login="toto";
    private String pwd="atoto";
    private String nom="Dupond";
    private String prenom="Marc";
    private String email="marc.dupond@gmail.com";
    private String adresse="1 rue des muguets";
    private String codePostal="31700";
    private String ville="Blagnac";
    private boolean passager=false;
    private boolean conducteur=true;
    private double distance; //distance avec abonnée.
    private double latitude=43.6391648;
    private double longitude=1.3826718999999912;

    public static Connexion getInstance() {
        if (cnx == null) cnx = new Connexion();
        return cnx;
    }

    public double getLongitude() {return longitude;}

    public void setLongitude(double longitude) {this.longitude = longitude;}

    public static Connexion getCnx() {return cnx;}

    public static void setCnx(Connexion cnx) {Connexion.cnx = cnx;}

    public String getLogin() {return login;}

    public void setLogin(String login) {this.login = login;}

    public String getPwd() {return pwd;}

    public void setPwd(String pwd) {this.pwd = pwd;}

    public String getNom() {return nom;}

    public void setNom(String nom) {this.nom = nom;}

    public String getPrenom() {return prenom;}

    public void setPrenom(String prenom) {this.prenom = prenom;}

    public String getEmail() {return email;}

    public void setEmail(String email) {this.email = email;}

    public String getAdresse() {return adresse;}

    public void setAdresse(String adresse) {this.adresse = adresse;}

    public String getCodePostal() {return codePostal;}

    public void setCodePostal(String codePostal) {this.codePostal = codePostal;}

    public String getVille() {return ville;}

    public void setVille(String ville) {this.ville = ville;}

    public boolean isPassager() {return passager;}

    public void setPassager(boolean passager) {this.passager = passager;}

    public boolean isConducteur() {return conducteur;}

    public void setConducteur(boolean conducteur) {this.conducteur = conducteur;}

    public double getDistance() {return distance;}

    public void setDistance(double distance) {this.distance = distance;}

    public double getLatitude() {return latitude;}

    public void setLatitude(double latitude) {this.latitude = latitude;}

    private Connexion(){}

    public void loudConnexion(String login, String pwd, String nom, String prenom, String email, String adresse, String codePostal,
                String ville, boolean passager, boolean conducteur, double distance, double latitude, double longitude) {
        this.login = login;
        this.pwd = pwd;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.adresse = adresse;
        this.codePostal = codePostal;
        this.ville = ville;
        this.passager = passager;
        this.conducteur = conducteur;
        this.distance = distance;
        this.latitude = latitude;
        this.longitude = longitude;
    }
}



