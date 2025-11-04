package ui;

import dto.Pretre;

import javax.swing.*;

public class MainForm {

    JPanel panel1;
    private JLabel title;
    private JLabel name;
    private JLabel force;
    private JLabel mana;
    private JLabel puissance;
    private Pretre lePretre;

    public MainForm(Pretre m) {
        this.lePretre = m;
        name.setText(lePretre.getNom());
        force.setText(lePretre.getForceFrappe()+"");
        mana.setText(""+lePretre.getMana());
        puissance.setText(""+lePretre.getPointsDeVie());

    }
}
