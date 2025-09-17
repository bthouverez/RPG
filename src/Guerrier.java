import java.util.Random;

public class Guerrier extends Personnage {
    public Guerrier() {
        super();
    }

    public Guerrier(String nom, int pointsDeVie, int force) {
        super(nom, pointsDeVie, force);
    }

    public void attaquer(Personnage adversaire) {
        Random rnd = new Random();

        // Chance de rater
        if(rnd.nextInt(100) <= 1) {
            System.out.println(this.nom + " a raté son attaque contre " + adversaire.getNom() + " !");
            return;
        }

        int forceFrappeBase = 0;
        if(this.arme != null) {
            forceFrappeBase = (int) (this.forceFrappe*1.25 + this.arme.getDegats());
        } else {
            forceFrappeBase = (int) (this.forceFrappe*1.25);
        }

        int degats = 0;
        if(rnd.nextInt(100) < 3) { // Chance de critique
            System.out.println(this.nom + " attaque critique " + adversaire.getNom() + " avec une force de " + 2*forceFrappeBase);
            degats = 2*forceFrappeBase;
        } else {
            System.out.println(this.nom + " attaque " + adversaire.getNom() + " avec une force de " + forceFrappeBase);
            degats = forceFrappeBase;
        }
        adversaire.setPointsDeVie(adversaire.getPointsDeVie() - degats);
        if(adversaire.getPointsDeVie() < 0) {
            adversaire.setPointsDeVie(0);
            System.out.println(adversaire.getNom() + " est mort !");
        }

    }
}
