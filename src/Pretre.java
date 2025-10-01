import java.util.Random;

public class Pretre extends Personnage {
    private int mana;
    private int puissanceSoin;

    public Pretre() {
        super();
        this.mana = 60;
        this.puissanceSoin = 20;
    }

    public Pretre(String nom, int pointsDeVie, int force, int mana, int puissanceSoin) {
        super(nom, pointsDeVie, force);
        this.mana = mana;
        this.puissanceSoin = puissanceSoin;
    }

    public int getMana() {
        return mana;
    }
    public int getPuissanceSoin() {
        return puissanceSoin;
    }
    public void setMana(int mana) {
        this.mana = mana;
    }
    public void setPuissanceSoin(int puissanceSoin) {
        this.puissanceSoin = puissanceSoin;
    }

    public void soigner(Personnage p) {
        if (this.mana >= 10) {
            System.out.println(this.nom + " soigne " + p.nom + " et lui rend " + this.puissanceSoin + " points de vie.");
            p.pointsDeVie += this.puissanceSoin;
            if (p.pointsDeVie > p.pointsDeVieMax) {
                p.pointsDeVie = p.pointsDeVieMax;
                System.out.println("La vie de "+p.nom+" est au maximum.");
            }
            this.mana -= 10;
        } else {
            System.out.println(this.nom + " n'a pas assez de mana pour soigner.");
        }
    }

    @Override
    public void recevoirCoups(int degats) {
        Random rnd = new Random();
        int nb = rnd.nextInt(2);
        if(nb == 1) {
            super.recevoirCoups(degats);
        } else {
            System.out.println(this.nom + " a évité l'attaque !");
        }
    }

    @Override
    public String toString() {
        String s = super.toString();
        s += ", mana: " + mana + ", puissanceSoin: " + puissanceSoin;
        return s;
    }
}
