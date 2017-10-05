package fr.afpa.balthazar.gui.menus;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

public class SubMenu extends JMenu {

    private ButtonGroup buttonGroup = new ButtonGroup();
    private JMenuItem livre = new JMenuItem("Livre", KeyEvent.VK_N);
    private JMenuItem exemplaire = new JMenuItem("Exemplaire");
    private JMenuItem  auteur = new JMenuItem("Auteur");
    private JMenuItem  collection = new JMenuItem("Collection");
    private JMenuItem  abonne = new JMenuItem("Abonne");


    public SubMenu(String nom) {
        super(nom);
        buttonGroup.add(livre);
        buttonGroup.add(exemplaire);
        buttonGroup.add(auteur);
        buttonGroup.add(collection);
        buttonGroup.add(abonne);
        this.add(livre);
        this.add(exemplaire);
        this.add(auteur);
        this.add(collection);
        this.add(abonne);
    }

    public ButtonGroup getButtonGroup() {
        return buttonGroup;
    }

    public void setButtonGroup(ButtonGroup buttonGroup) {
        this.buttonGroup = buttonGroup;
    }

    public JMenuItem getLivre() {
        return livre;
    }

    public void setLivre(JMenuItem livre) {
        this.livre = livre;
    }

    public JMenuItem getExemplaire() {
        return exemplaire;
    }

    public void setExemplaire(JMenuItem exemplaire) {
        this.exemplaire = exemplaire;
    }

    public JMenuItem getAuteur() {
        return auteur;
    }

    public void setAuteur(JMenuItem auteur) {
        this.auteur = auteur;
    }

    public JMenuItem getCollection() {
        return collection;
    }

    public void setCollection(JMenuItem collection) {
        this.collection = collection;
    }

    public JMenuItem getAbonne() {
        return abonne;
    }

    public void setAbonne(JMenuItem abonne) {
        this.abonne = abonne;
    }
}
