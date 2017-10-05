package fr.afpa.balthazar.gui.frames.nouveaux;

import fr.afpa.balthazar.gui.frames.Frame;
import fr.afpa.balthazar.logic.model.Abonne;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.*;


public class abonneForm extends JInternalFrame {

    private final String TITLE = "Nouveau Abonne";

    private JPanel rootPanel;
    private JTextField nameInput;
    private JTextField fNameInput;
    private JTextField emailInput;
    private JTextField dateInput;
    private JButton cancel;
    private JButton submit;
    private JLabel labelForName;
    private JLabel labelForFname;
    private JLabel labelForEmail;
    private JLabel labeForDate;
    private JLabel labelForErrorsNom;
    private JLabel labelForErrosPrenom;
    private JLabel labelForErrorsEmail;
    private JLabel labelForErrorsDate;
    private JLabel labelForNoAbonne;

    @Autowired
    private Frame frame;



    public abonneForm() {
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

    //Populate method fills in all fields, and formats date for view.
    public void populate(Abonne abonne){
        this.getEmailInput().setText(abonne.getEmail());
        this.getNameInput().setText(abonne.getNom());
        this.getfNameInput().setText(abonne.getPrenom());
        this.getLabelForNoAbonne().setText(abonne.getNoAbonne());
        String date = abonne.getDate_naissance().toString();
        date = date.substring(0, 10);
        date = date.substring(8, 10) + "/" +date.substring(5,7) +"/"+ date.substring(0, 4);
        System.out.println(date);
        this.getLabelForNoAbonne().setText("Numero Abonne : "+ abonne.getNoAbonne());
        this.getDateInput().setText(date);
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

    public JTextField getEmailInput() {
        return emailInput;
    }

    public void setEmailInput(JTextField emailInput) {
        this.emailInput = emailInput;
    }

    public JTextField getDateInput() {
        return dateInput;
    }

    public void setDateInput(JTextField dateInput) {
        this.dateInput = dateInput;
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

    public JLabel getLabelForEmail() {
        return labelForEmail;
    }

    public void setLabelForEmail(JLabel labelForEmail) {
        this.labelForEmail = labelForEmail;
    }

    public JLabel getLabeForDate() {
        return labeForDate;
    }

    public void setLabeForDate(JLabel labeForDate) {
        this.labeForDate = labeForDate;
    }

    public Frame getFrame() {
        return frame;
    }

    public void setFrame(Frame frame) {
        this.frame = frame;
    }

    public JLabel getLabelForErrorsNom() {
        return labelForErrorsNom;
    }

    public void setLabelForErrorsNom(JLabel labelForErrorsNom) {
        this.labelForErrorsNom = labelForErrorsNom;
    }

    public JLabel getLabelForErrosPrenom() {
        return labelForErrosPrenom;
    }

    public void setLabelForErrosPrenom(JLabel labelForErrosPrenom) {
        this.labelForErrosPrenom = labelForErrosPrenom;
    }

    public JLabel getLabelForErrorsEmail() {
        return labelForErrorsEmail;
    }

    public void setLabelForErrorsEmail(JLabel labelForErrorsEmail) {
        this.labelForErrorsEmail = labelForErrorsEmail;
    }

    public JLabel getLabelForErrorsDate() {
        return labelForErrorsDate;
    }

    public void setLabelForErrorsDate(JLabel labelForErrorsDate) {
        this.labelForErrorsDate = labelForErrorsDate;
    }

    public JLabel getLabelForNoAbonne() {
        return labelForNoAbonne;
    }

    public void setLabelForNoAbonne(JLabel labelForNoAbonne) {
        this.labelForNoAbonne = labelForNoAbonne;
    }

    public String getTITLE() {
        return TITLE;
    }
}

