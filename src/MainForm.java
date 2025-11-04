import javax.swing.*;

public class MainForm {

    JPanel panel1;
    private JLabel title;
    private JLabel name;
    private JLabel force;
    private JLabel mana;
    private JLabel puissance;
    private Pretre leMage;

    public MainForm(Pretre m) {
        this.leMage = m;
        name.setText(leMage.getNom());
        force.setText(leMage.getForceFrappe()+"");
        mana.setText(""+leMage.getMana());
        puissance.setText(""+leMage.getPointsDeVie());

    }
}
