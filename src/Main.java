//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws InterruptedException {
//        Guerrier g1 = new Guerrier();
//        g1.setNom("Achille");
//        g1.setPointsDeVie(120);
//        g1.setForceFrappe(15);
//
//        Guerrier g2 = new Guerrier("Xena", 110, 12);
//
//        Arme a1 = new Arme("Marteau", 25);
//        Arme a2 = new Arme("Baton ultrapuissant", 35);
//        g1.setArme(a1);
//        g2.setArme(a2);
//
//        while(g1.getPointsDeVie() > 0 && g2.getPointsDeVie() > 0) {
//            g1.attaquer(g2);
//            Thread.sleep(1500);
//            if(g2.getPointsDeVie() <= 0) break;
//            g2.attaquer(g1);
//            Thread.sleep(1500);
//            System.out.println(g1);
//            System.out.println(g2);
//        }
//        if(g1.getPointsDeVie() > 0) {
//            System.out.println(g1.getNom() + " a gagné !");
//        } else {
//            System.out.println(g2.getNom() + " a gagné !");
//        }

        Mage m1 = new Mage("Bob", 80, 8);
        System.out.println(m1.toString());
    }
}