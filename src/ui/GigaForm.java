package ui;

import javax.swing.*;

public class GigaForm {
    private JPanel infoPanel;
    private JPanel combatPanel;
    private JPanel mainPanel;



    public GigaForm(JPanel p1, JPanel p2) {
        this.mainPanel = new JPanel();
        this.infoPanel = p1;
        this.combatPanel = p2;
        mainPanel.add(infoPanel);
        mainPanel.add(combatPanel);
    }

    public JPanel getMainPanel() {
        return this.mainPanel;
    }
}
