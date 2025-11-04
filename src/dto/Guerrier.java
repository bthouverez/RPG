package dto;

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

    @Override
    public String getType() {
        return "Guerrier";
    }

    public Guerrier(String nom, int pointsDeVie, int force, int armure) {
        super(nom, pointsDeVie, force);
        this.armure = armure;
    }

    @Override
    public void recevoirCoups(int degats) {
        super.recevoirCoups(degats - this.armure);
    }

    public int getArmure() {
        return armure;
    }
    public void setArmure(int armure) {
        this.armure = armure;
    }
}
