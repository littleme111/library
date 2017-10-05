package fr.afpa.balthazar.gui.menus;

import javax.swing.*;

public class MenuEdition extends JMenu {

    private ButtonGroup buttonGroup = new ButtonGroup();
    private JMenuItem editer = new JMenuItem("Editer");
    private JMenuItem supprimer = new JMenuItem("Supprimer");


    public MenuEdition() {
        super("Edition");
        buttonGroup.add(editer);
        buttonGroup.add(supprimer);

        this.add(editer);
        this.add(supprimer);

    }


    public ButtonGroup getButtonGroup() {
        return buttonGroup;
    }

    public void setButtonGroup(ButtonGroup buttonGroup) {
        this.buttonGroup = buttonGroup;
    }

    public JMenuItem getEditer() {
        return editer;
    }

    public void setEditer(JMenuItem editer) {
        this.editer = editer;
    }

    public JMenuItem getSupprimer() {
        return supprimer;
    }

    public void setSupprimer(JMenuItem supprimer) {
        this.supprimer = supprimer;
    }
}
