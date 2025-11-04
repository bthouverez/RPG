import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
            mainBDD();

//        Mage m1 = new Mage("Bob", 80, 8, 60, 20);
//        Pretre p1 = new Pretre("Alice", 90, 7, 70, 25);
//       Guerrier g1 = new Guerrier("Charlie", 110, 55, 4);
//
//
//        GigaForm gf = new GigaForm(new MainForm(p1).panel1, new Combat(p1, g1).getMainPanel());
//
//        JFrame frame = new JFrame("RPG");
//        frame.setContentPane(gf.getMainPanel());
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.setLocationRelativeTo(null);
//        frame.setSize(800,300);
//        frame.setVisible(true);

//        JFrame frame2 = new JFrame("RPG");
//        frame2.setContentPane(new MainForm(m1).panel1);
//        frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame2.setLocationRelativeTo(null);
//        frame2.setSize(400,300);
//        frame2.setVisible(true);



        // INTERDIT car classe Personnage abstraite
        //Personnage perso = new Personnage();
        //System.out.println(perso);

        /*System.out.println(p1);
        System.out.println(g1);

        m1.attaquer(p1);
        System.out.println(p1);
        m1.attaquer(g1);
        System.out.println(g1);*/
    }


    public static void mainBDD() {
        try {
            // Connexion à la BDD (exemple avec MySQL)
            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/rpgjava",
                    "bthouverez",
                    "321654"
            );

            PersonnageDAO dao = new PersonnageDAO(conn);

            // Créer des personnages
            Mage gandalf = new Mage("Gandalf", 10, 100, 200, 50);
            dao.creer(gandalf);
            System.out.println("Mage créé avec ID: " + gandalf.getId());

            Guerrier conan = new Guerrier("Conan", 80, 150, 30);
            dao.creer(conan);
            System.out.println("Guerrier créé avec ID: " + conan.getId());

            Pretre medivh = new Pretre("Medivh", 15, 120, 180, 40);
            dao.creer(medivh);
            System.out.println("Prêtre créé avec ID: " + medivh.getId());

            // Lire un personnage
            Personnage p = dao.lire(gandalf.getId());
            System.out.println("\nPersonnage lu: " + p.getNom() + " (" + p.getType() + ")");

            // Lire tous les personnages
            System.out.println("\nTous les personnages:");
            List<Personnage> tous = dao.lireTous();
            for (Personnage perso : tous) {
                System.out.println("- " + perso.getNom() + " (" + perso.getType() + ")");
            }

            // Mettre à jour
            gandalf.setPointsDeVie(90);
            dao.mettreAJour(gandalf);
            System.out.println("\nGandalf mis à jour");

            // Supprimer
            dao.supprimer(conan.getId());
            System.out.println("Conan supprimé");

            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}