package fr.afpa.balthazar.gui.frames.nouveaux;

import fr.afpa.balthazar.gui.frames.Frame;
import fr.afpa.balthazar.logic.controllers.MainController;
import fr.afpa.balthazar.logic.model.Auteur;
import fr.afpa.balthazar.logic.model.Livre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.util.*;


public class livreForm extends JInternalFrame {
    private static final String TITLE = "Nouveau Livre";

    private JLabel frameTitle;
    private JTextField titleInput;
    private JTextField subtitleInput;
    private JButton annulerButton;
    private JButton validerButton;
    private JComboBox collectionInput;
    private JComboBox authorInput;
    private JLabel LabelForTitle;
    private JLabel LabelForSubtitle;
    private JLabel LabelForCollection;
    private JLabel LabelForAuthor;
    private JButton createCollection;
    private JButton createAuthor;
    private JPanel rootPanel;
    private JComboBox author1Input;
    private JButton createAuthor1;
    private JButton createAuthor2;
    private JLabel labelForAuthor1;
    private JLabel labelForAuthor2;
    private JComboBox author2Input;
    private JTextField ISBNInput;
    private JLabel labelForISBN;
    private JLabel labelForErrorsISBN;
    private JLabel labelForErrorsSubtitle;
    private JLabel labeForErrorsTitle;
    private JTable tableForExemplaires;
    private JPanel rootPanelForExemplaireTable;
    private JCheckBox addSecondAuthorCheckbox;
    private JButton addAuthor;
    private JPanel addAuthorJpanel;
    private JLabel mode;
    private boolean addingAuthor = false;
    private boolean adingCollection = false;


    @Autowired
    Frame frame;

    public livreForm() {
        this.frame = frame;
        JScrollPane jsp = new JScrollPane(rootPanel);


        rootPanel.setVisible(true);
        this.author2Input.setEnabled(false);
        this.createAuthor2.setEnabled(false);
        this.setVisible(true);
        this.setResizable(true);
        this.setMaximizable(true);
        this.setClosable(true);
        this.setSize(500, 450);
        this.setTitle(TITLE);

        this.add(jsp);
    }


    //Populate methods fills in fields of jinternalframe
    public void populate(Livre livre){
        this.getTitleInput().setText(livre.getTitle());
        this.getSubtitleInput().setText(livre.getSub_title());
        this.getISBNInput().setText(livre.getISBN());

        //Method add...ToCombobox, fills in combobox with values form db.
        MainController mainController = new MainController();
        mainController.addAuthorsToComboBox(this.getAuthor1Input());
        mainController.addAuthorsToComboBox(this.getAuthor2Input());
        mainController.addCollectionToComboBox(this.getCollectionInput());

        Set<Auteur> sa = livre.getAuteurs();
        Map<String, Auteur> ma = new HashMap<String, Auteur>();
        List<?> list = new ArrayList<Auteur>(sa);


        //Loop on all results to set selected value to the author of book.
        for(int x = 0; x < this.getAuthor1Input().getItemCount(); x++){
            //If list value is the same as author name or alias - then set selected value.
            if(this.getAuthor1Input().getItemAt(x).equals(((Auteur) list.get(0)).getNom()) || this.getAuthor1Input().getItemAt(x).equals(((Auteur) list.get(0)).getAlias() )){

                this.getAuthor1Input().setSelectedIndex(x);
            }
        }
        if(livre.getAuteurs().size() == 2) {

            for (int x = 0; x < this.getAuthor2Input().getItemCount(); x++) {

                if (this.getAuthor2Input().getItemAt(x).equals(((Auteur) list.get(1)).getNom()) || this.getAuthor2Input().getItemAt(x).equals(((Auteur) list.get(1)).getAlias())) {

                    this.getAuthor2Input().setSelectedIndex(x);
                }
            }
        }
    }



    public JLabel getFrameTitle() {
        return frameTitle;
    }

    public void setFrameTitle(JLabel frameTitle) {
        this.frameTitle = frameTitle;
    }

    public JTextField getTitleInput() {
        return titleInput;
    }

    public void setTitleInput(JTextField titleInput) {
        this.titleInput = titleInput;
    }

    public JTextField getSubtitleInput() {
        return subtitleInput;
    }

    public void setSubtitleInput(JTextField subtitleInput) {
        this.subtitleInput = subtitleInput;
    }

    public JButton getAnnulerButton() {
        return annulerButton;
    }

    public void setAnnulerButton(JButton annulerButton) {
        this.annulerButton = annulerButton;
    }

    public JButton getValiderButton() {
        return validerButton;
    }

    public void setValiderButton(JButton validerButton) {
        this.validerButton = validerButton;
    }

    public JComboBox getCollectionInput() {
        return collectionInput;
    }

    public void setCollectionInput(JComboBox collectionInput) {
        this.collectionInput = collectionInput;
    }

    public JComboBox getAuthorInput() {
        return authorInput;
    }

    public void setAuthorInput(JComboBox authorInput) {
        this.authorInput = authorInput;
    }

    public JLabel getLabelForTitle() {
        return LabelForTitle;
    }

    public void setLabelForTitle(JLabel labelForTitle) {
        LabelForTitle = labelForTitle;
    }

    public JLabel getLabelForSubtitle() {
        return LabelForSubtitle;
    }

    public void setLabelForSubtitle(JLabel labelForSubtitle) {
        LabelForSubtitle = labelForSubtitle;
    }

    public JLabel getLabelForCollection() {
        return LabelForCollection;
    }

    public void setLabelForCollection(JLabel labelForCollection) {
        LabelForCollection = labelForCollection;
    }

    public JLabel getLabelForAuthor() {
        return LabelForAuthor;
    }

    public void setLabelForAuthor(JLabel labelForAuthor) {
        LabelForAuthor = labelForAuthor;
    }

    public JButton getCreateCollection() {
        return createCollection;
    }

    public void setCreateCollection(JButton createCollection) {
        this.createCollection = createCollection;
    }

    public JButton getCreateAuthor() {
        return createAuthor;
    }

    public void setCreateAuthor(JButton createAuthor) {
        this.createAuthor = createAuthor;
    }

    public JPanel getRootPanel() {
        return rootPanel;
    }

    public void setRootPanel(JPanel rootPanel) {
        this.rootPanel = rootPanel;
    }

    public JComboBox getAuthor1Input() {
        return author1Input;
    }

    public void setAuthor1Input(JComboBox author1Input) {
        this.author1Input = author1Input;
    }

    public JButton getCreateAuthor1() {
        return createAuthor1;
    }

    public void setCreateAuthor1(JButton createAuthor1) {
        this.createAuthor1 = createAuthor1;
    }

    public JButton getCreateAuthor2() {
        return createAuthor2;
    }

    public void setCreateAuthor2(JButton createAuthor2) {
        this.createAuthor2 = createAuthor2;
    }

    public JLabel getLabelForAuthor1() {
        return labelForAuthor1;
    }

    public void setLabelForAuthor1(JLabel labelForAuthor1) {
        this.labelForAuthor1 = labelForAuthor1;
    }

    public JLabel getLabelForAuthor2() {
        return labelForAuthor2;
    }

    public void setLabelForAuthor2(JLabel labelForAuthor2) {
        this.labelForAuthor2 = labelForAuthor2;
    }

    public JComboBox getAuthor2Input() {
        return author2Input;
    }

    public void setAuthor2Input(JComboBox author2Input) {
        this.author2Input = author2Input;
    }

    public JTextField getISBNInput() {
        return ISBNInput;
    }

    public void setISBNInput(JTextField ISBNInput) {
        this.ISBNInput = ISBNInput;
    }

    public JLabel getLabelForISBN() {
        return labelForISBN;
    }

    public void setLabelForISBN(JLabel labelForISBN) {
        this.labelForISBN = labelForISBN;
    }

    public JLabel getLabelForErrorsISBN() {
        return labelForErrorsISBN;
    }

    public void setLabelForErrorsISBN(JLabel labelForErrorsISBN) {
        this.labelForErrorsISBN = labelForErrorsISBN;
    }

    public JLabel getLabelForErrorsSubtitle() {
        return labelForErrorsSubtitle;
    }

    public void setLabelForErrorsSubtitle(JLabel labelForErrorsSubtitle) {
        this.labelForErrorsSubtitle = labelForErrorsSubtitle;
    }

    public JLabel getLabeForErrorsTitle() {
        return labeForErrorsTitle;
    }

    public void setLabeForErrorsTitle(JLabel labeForErrorsTitle) {
        this.labeForErrorsTitle = labeForErrorsTitle;
    }

    public JButton getAddAuthor() {
        return addAuthor;
    }

    public void setAddAuthor(JButton addAuthor) {
        this.addAuthor = addAuthor;
    }

    public JPanel getAddAuthorJpanel() {
        return addAuthorJpanel;
    }

    public void setAddAuthorJpanel(JPanel addAuthorJpanel) {
        this.addAuthorJpanel = addAuthorJpanel;
    }

    public JLabel getMode() {
        return mode;
    }

    public void setMode(JLabel mode) {
        this.mode = mode;
    }

    public Frame getFrame() {
        return frame;
    }

    public void setFrame(Frame frame) {
        this.frame = frame;
    }


    public boolean isAddingAuthor() {
        return addingAuthor;
    }

    public void setAddingAuthor(boolean addingAuthor) {
        this.addingAuthor = addingAuthor;
    }

    public boolean isAdingCollection() {
        return adingCollection;
    }

    public void setAdingCollection(boolean adingCollection) {
        this.adingCollection = adingCollection;
    }

    public JTable getTableForExemplaires() {
        return tableForExemplaires;
    }

    public void setTableForExemplaires(JTable tableForExemplaires) {
        this.tableForExemplaires = tableForExemplaires;
    }

    public JPanel getRootPanelForExemplaireTable() {
        return rootPanelForExemplaireTable;
    }

    public void setRootPanelForExemplaireTable(JPanel rootPanelForExemplaireTable) {
        this.rootPanelForExemplaireTable = rootPanelForExemplaireTable;
    }

    public JCheckBox getAddSecondAuthorCheckbox() {
        return addSecondAuthorCheckbox;
    }

    public void setAddSecondAuthorCheckbox(JCheckBox addSecondAuthorCheckbox) {
        this.addSecondAuthorCheckbox = addSecondAuthorCheckbox;
    }

    public String getTITLE() {
        return TITLE;
    }
}

