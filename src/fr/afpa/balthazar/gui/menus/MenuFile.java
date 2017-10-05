package fr.afpa.balthazar.gui.menus;

import javax.swing.*;

public class MenuFile extends JMenu {


    private ButtonGroup buttonGroup = new ButtonGroup();
    private SubMenu Nouveau = new SubMenu("Nouveau");
    private SubMenu Chercher = new SubMenu("Chercher");
    private JMenuItem quitter = new JMenuItem("Quitter", 'q');


    public MenuFile() {

        super("Fichier");
        buttonGroup.add(Nouveau);
        buttonGroup.add(Chercher);
        buttonGroup.add(quitter);
        this.add(Nouveau);
        this.add(Chercher);
        this.addSeparator();
        this.add(quitter);

    }

    public ButtonGroup getButtonGroup() {
        return buttonGroup;
    }

    public void setButtonGroup(ButtonGroup buttonGroup) {
        this.buttonGroup = buttonGroup;
    }


    public JMenuItem getQuitter() {
        return quitter;
    }

    public void setQuitter(JMenuItem quitter) {
        this.quitter = quitter;
    }

    public SubMenu getNouveau() {
        return Nouveau;
    }

    public void setNouveau(SubMenu nouveau) {
        Nouveau = nouveau;
    }

    public SubMenu getChercher() {
        return Chercher;
    }

    public void setChercher(SubMenu chercher) {
        Chercher = chercher;
    }


}
