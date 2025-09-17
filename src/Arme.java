public class Arme {

    private String nom;
    private int degats;

    public Arme() {
        this.nom = "Epée";
        this.degats = 10;
    }

    public Arme(String nom, int degats) {
        this.nom = nom;
        this.degats = degats;
    }

    public String getNom() {
        return nom;
    }

    public int getDegats() {
        return degats;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setDegats(int degats) {
        this.degats = degats;
    }

    @Override
    public String toString() {
        return nom + " (dégâts: " + degats + ")";
    }
}
