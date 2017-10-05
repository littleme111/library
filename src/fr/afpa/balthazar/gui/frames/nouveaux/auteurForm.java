package fr.afpa.balthazar.gui.frames.nouveaux;

import fr.afpa.balthazar.gui.frames.Frame;
import fr.afpa.balthazar.logic.model.Auteur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.*;


public class auteurForm extends JInternalFrame{
    private final String TITLE = "Nouveau Auteur";

    private JPanel rootPanel;
    private JTextField nameInput;
    private JTextField fNameInput;
    private JTextField dateInput;
    private JTextField aliasInput;
    private JButton cancel;
    private JButton submit;
    private JLabel labelForName;
    private JLabel labelForFname;
    private JLabel laelForDate;
    private JLabel labelForAlias;
    private JLabel labelErrorsNom;
    private JLabel labelErrorsPrenom;
    private JLabel labelErrorsDate;
    private JLabel labelErrorsAlias;
    private JLabel labelForAuteurId;
    private boolean fromBook = false;

    @Autowired
    Frame frame;

    public auteurForm() {
        this.frame = frame;

        rootPanel.setVisible(true);
        this.setVisible(true);
        this.setResizable(true);
        this.setMaximizable(true);
        this.setClosable(true);
        this.setSize(500, 400);
        this.setTitle(TITLE);

        this.add(rootPanel);
    }


    //Populate methods fills in fields of jinternalframe
    public void populate(Auteur auteur){
        this.getfNameInput().setText(auteur.getPrenom());
        this.getNameInput().setText(auteur.getNom());
        String date = auteur.getDate_naissance().toString();
        date = date.substring(0, 10);
        date = date.substring(8, 10) + "/" +date.substring(5,7) +"/"+ date.substring(0, 4);
        this.getDateInput().setText(date);
        this.getAliasInput().setText(auteur.getAlias());
        this.getLabelForAuteurId().setText("Id Auteur : " + auteur.getId().toString());
    }


    public JPanel getRootPanel() {
        return rootPanel;
    }

    public void setRootPanel(JPanel rootPanel) {
        this.rootPanel = rootPanel;
    }

    public JTextField getNameInput() {
        return nameInput;
    }

    public void setNameInput(JTextField nameInput) {
        this.nameInput = nameInput;
    }

    public JTextField getfNameInput() {
        return fNameInput;
    }

    public void setfNameInput(JTextField fNameInput) {
        this.fNameInput = fNameInput;
    }

    public JTextField getDateInput() {
        return dateInput;
    }

    public void setDateInput(JTextField dateInput) {
        this.dateInput = dateInput;
    }

    public JTextField getAliasInput() {
        return aliasInput;
    }

    public void setAliasInput(JTextField aliasInput) {
        this.aliasInput = aliasInput;
    }

    public JButton getCancel() {
        return cancel;
    }

    public void setCancel(JButton cancel) {
        this.cancel = cancel;
    }

    public JButton getSubmit() {
        return submit;
    }

    public void setSubmit(JButton submit) {
        this.submit = submit;
    }

    public JLabel getLabelForName() {
        return labelForName;
    }

    public void setLabelForName(JLabel labelForName) {
        this.labelForName = labelForName;
    }

    public JLabel getLabelForFname() {
        return labelForFname;
    }

    public void setLabelForFname(JLabel labelForFname) {
        this.labelForFname = labelForFname;
    }

    public JLabel getLaelForDate() {
        return laelForDate;
    }

    public void setLaelForDate(JLabel laelForDate) {
        this.laelForDate = laelForDate;
    }

    public JLabel getLabelForAlias() {
        return labelForAlias;
    }

    public void setLabelForAlias(JLabel labelForAlias) {
        this.labelForAlias = labelForAlias;
    }

    public Frame getFrame() {
        return frame;
    }

    public void setFrame(Frame frame) {
        this.frame = frame;
    }

    public boolean isFromBook() {
        return fromBook;
    }

    public void setFromBook(boolean fromBook) {
        this.fromBook = fromBook;
    }

    public JLabel getLabelErrorsNom() {
        return labelErrorsNom;
    }

    public void setLabelErrorsNom(JLabel labelErrorsNom) {
        this.labelErrorsNom = labelErrorsNom;
    }

    public JLabel getLabelErrorsPrenom() {
        return labelErrorsPrenom;
    }

    public void setLabelErrorsPrenom(JLabel labelErrorsPrenom) {
        this.labelErrorsPrenom = labelErrorsPrenom;
    }

    public JLabel getLabelErrorsDate() {
        return labelErrorsDate;
    }

    public void setLabelErrorsDate(JLabel labelErrorsDate) {
        this.labelErrorsDate = labelErrorsDate;
    }

    public JLabel getLabelErrorsAlias() {
        return labelErrorsAlias;
    }

    public void setLabelErrorsAlias(JLabel labelErrorsAlias) {
        this.labelErrorsAlias = labelErrorsAlias;
    }

    public JLabel getLabelForAuteurId() {
        return labelForAuteurId;
    }

    public void setLabelForAuteurId(JLabel labelForAuteurId) {
        this.labelForAuteurId = labelForAuteurId;
    }

    public String getTITLE() {
        return TITLE;
    }
}
