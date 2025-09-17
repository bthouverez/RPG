//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Mage m1 = new Mage("Bob", 80, 8, 60, 20);
        Pretre p1 = new Pretre("Alice", 90, 7, 70, 25);
        Guerrier g1 = new Guerrier("Charlie", 110, 55);

        for(int ii = 0; ii < 5; ii++) {
            g1.attaquer(m1);
            m1.lancerSort(g1);
            p1.soigner(m1);
        }
    }
}