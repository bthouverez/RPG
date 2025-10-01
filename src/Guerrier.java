import java.util.Random;

public class Guerrier extends Personnage {

    private int armure;

    public Guerrier() {
        super();
        this.armure = 10;
    }

    public Guerrier(String nom, int pointsDeVie, int force) {
        super(nom, pointsDeVie, force);
        this.armure = 10;
    }

    public Guerrier(String nom, int pointsDeVie, int force, int armure) {
        super(nom, pointsDeVie, force);
        this.armure = armure;
    }

    @Override
    public void recevoirCoups(int degats) {
        super.recevoirCoups(degats - this.armure);
    }

}
