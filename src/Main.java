//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Guerrier g1 = new Guerrier();
        g1.setNom("Achille");
        g1.setPointsDeVie(120);
        g1.setForceFrappe(15);

        Guerrier g2 = new Guerrier("Xena", 110, 12);

        System.out.println(g1);
        System.out.println(g2);
    }
}