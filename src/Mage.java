import java.util.Random;

public class Mage extends Personnage {
    private int mana;
    private int puissanceSort;


    public Mage() {
        super(); // appelle un constructeur de la classe mère
        this.nom = "Mage";
        this.forceFrappe = 5;
        this.mana = 50;
        this.puissanceSort = 15;
    }

    public Mage(String nom, int pointsDeVie, int force, int mana, int puissanceSort) {
        super(nom, pointsDeVie, force); // appelle un constructeur de la classe mère
        this.mana = 50;
        this.puissanceSort = 15;
    }

    public int getMana() {
        return mana;
    }
    public int getPuissanceSort() {
        return puissanceSort;
    }
    public void setMana(int mana) {
        this.mana = mana;
    }
    public void setPuissanceSort(int puissanceSort) {
        this.puissanceSort = puissanceSort;
    }

}
