//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Mage m1 = new Mage("Bob", 80, 8, 60, 20);
        Pretre p1 = new Pretre("Alice", 90, 7, 70, 25);
        Guerrier g1 = new Guerrier("Charlie", 110, 55, 4);

        // INTERDIT car classe Personnage abstraite
        //Personnage perso = new Personnage();
        //System.out.println(perso);

        System.out.println(p1);
        System.out.println(g1);

        m1.attaquer(p1);
        System.out.println(p1);
        m1.attaquer(g1);
        System.out.println(g1);
    }
}