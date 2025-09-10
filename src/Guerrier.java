public class Guerrier {
    private String nom;
    private int pointsDeVie;
    private int forceFrappe;

    public Guerrier() {
        this.nom = "Guerrier";
        this.pointsDeVie = 100;
        this.forceFrappe = 10;
    }

    public Guerrier(String nom, int pointsDeVie, int force) {
        this.nom = nom;
        this.pointsDeVie = pointsDeVie;
        this.forceFrappe = force;
    }

    public String getNom() {
        return nom;
    }

    public int getPointsDeVie() {
        return pointsDeVie;
    }

    public int getForceFrappe() {
        return forceFrappe;
    }

    public void setForceFrappe(int forceFrappe) {
        this.forceFrappe = forceFrappe;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPointsDeVie(int pointsDeVie) {
        this.pointsDeVie = pointsDeVie;
    }

    public void attaquer(Guerrier adversaire) {
        System.out.println(this.nom + " attaque " + adversaire.getNom() + " avec une force de " + this.forceFrappe);
        // ???????????
    }

    public String toString() {
        return "Guerrier{" +
                "nom='" + nom + '\'' +
                ", pointsDeVie=" + pointsDeVie +
                ", forceFrappe=" + forceFrappe +
                '}';
    }


}
