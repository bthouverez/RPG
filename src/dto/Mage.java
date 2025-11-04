package dto;

public class Mage extends Personnage {
    private int mana;
    private int puissanceSort;


    public Mage() {
        super(); // appelle un constructeur de la classe mère
        this.nom = "dto.Mage";
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

    public void lancerSort(Personnage p) {
        if (this.mana >= 10) {
            System.out.println(this.nom + " lance un sort sur " + p.nom + " et lui inflige " + this.puissanceSort + " points de dégâts.");
            p.pointsDeVie -= this.puissanceSort;
            this.mana -= 10;
        } else {
            System.out.println(this.nom + " n'a pas assez de mana pour lancer un sort.");
        }
    }


    @Override
    public String toString() {
        String s = super.toString();
        s += ", mana: " + mana + ", puissanceSort: " + puissanceSort;
        return s;
    }

    @Override
    public String getType() {
        return "Mage";
    }
}
