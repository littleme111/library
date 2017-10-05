package fr.afpa.balthazar.gui.frames.nouveaux;

import fr.afpa.balthazar.gui.frames.Frame;
import fr.afpa.balthazar.logic.model.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.*;


public class collectionForm extends JInternalFrame{

    private final String TITLE = "Nouvelle Collection";

    private JPanel rootPanel;
    private JTextField collectionName;
    private JButton cancel;
    private JButton submit;
    private JLabel labelForCollectionName;
    private JLabel labelForErrosNom;
    private JLabel labelForIdCollection;
    private boolean isFromBook = false;

    @Autowired
    private Frame frame;

    public collectionForm( ) {
        this.frame = frame;

        this.setVisible(true);
        this.setResizable(true);
        this.setMaximizable(true);
        this.setClosable(true);
        this.setSize(500, 150);
        this.setTitle(TITLE);
        this.add(rootPanel);

    }

    //Populate methods fills in fields of jinternalframe
    public void populate(Collection collection){
        this.getLabelForIdCollection().setText("Id Collection" +collection.getId());
        this.getCollectionName().setText(collection.getNomCollection());
    }

    public JPanel getRootPanel() {
        return rootPanel;
    }

    public void setRootPanel(JPanel rootPanel) {
        this.rootPanel = rootPanel;
    }

    public JTextField getCollectionName() {
        return collectionName;
    }

    public void setCollectionName(JTextField collectionName) {
        this.collectionName = collectionName;
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

    public JLabel getLabelForCollectionName() {
        return labelForCollectionName;
    }

    public void setLabelForCollectionName(JLabel labelForCollectionName) {
        this.labelForCollectionName = labelForCollectionName;
    }

    public Frame getFrame() {
        return frame;
    }

    public void setFrame(Frame frame) {
        this.frame = frame;
    }

    public boolean isFromBook() {
        return isFromBook;
    }

    public void setFromBook(boolean fromBook) {
        isFromBook = fromBook;
    }

    public JLabel getLabelForErrosNom() {
        return labelForErrosNom;
    }

    public void setLabelForErrosNom(JLabel labelForErrosNom) {
        this.labelForErrosNom = labelForErrosNom;
    }

    public JLabel getLabelForIdCollection() {
        return labelForIdCollection;
    }

    public void setLabelForIdCollection(JLabel labelForIdCollection) {
        this.labelForIdCollection = labelForIdCollection;
    }

    public String getTITLE() {
        return TITLE;
    }
}
