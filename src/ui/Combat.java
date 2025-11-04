package ui;

import dto.Personnage;
import dto.Pretre;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Combat {
    private Personnage perso1;
    private Personnage perso2;

    private JLabel nomP1;
    private JLabel nomP2;
    private JPanel mainPanel;
    private JButton btnFrapper;
    private JLabel logs;
    private JButton btnSoigner;

    public Combat(Personnage p1, Personnage p2) {
        this.perso1 = p1;
        this.perso2 = p2;
        this.nomP1.setText("     "+perso1.getNom() + "("+perso1.getPointsDeVie()+")");
        this.nomP2.setText(perso2.getNom() + "("+perso2.getPointsDeVie()+")     ");
        if(!(perso1 instanceof Pretre)) {
            btnSoigner.setEnabled(false);
        }

        btnFrapper.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                perso1.attaquer(perso2);
                logs.setText(perso1.getNom() + " frappe " + perso2.getNom() + " !");


                perso2.attaquer(perso1);
                logs.setText(perso2.getNom() + " frappe " + perso1.getNom() + " !");

                nomP1.setText("     "+perso1.getNom() + "("+perso1.getPointsDeVie()+")");
                nomP2.setText(perso2.getNom() + "("+perso2.getPointsDeVie()+")     ");


                if(perso2.getPointsDeVie() <= 0) {
                    btnFrapper.setEnabled(false);
                    JOptionPane.showMessageDialog(mainPanel, perso2.getNom() + " est mort !");
                }
            }
        });
        btnSoigner.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(perso1 instanceof Pretre) {
                    ((Pretre) perso1).soigner(perso1);
                    nomP1.setText("     "+perso1.getNom() + "("+perso1.getPointsDeVie()+")");
                }
            }
        });
    }

    public JPanel getMainPanel() {
        return this.mainPanel;
    }
}
