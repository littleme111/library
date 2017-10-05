package fr.afpa.balthazar.gui.frames.nouveaux;

import org.springframework.stereotype.Component;

import javax.swing.*;
public class addAuthorForm extends JPanel{
    private JComboBox AuthorCombo;
    private JButton create;
    private JPanel rootPanel;
    private JLabel labelForAuthorInput;

    public addAuthorForm() {
        this.rootPanel.setSize(500, 100);
        this.rootPanel.setVisible(true);
        this.add(rootPanel);

    }


    public JComboBox getAuthorCombo() {
        return AuthorCombo;
    }

    public void setAuthorCombo(JComboBox authorCombo) {
        AuthorCombo = authorCombo;
    }

    public JButton getCreate() {
        return create;
    }

    public void setCreate(JButton create) {
        this.create = create;
    }

    public JPanel getRootPanel() {
        return rootPanel;
    }

    public void setRootPanel(JPanel rootPanel) {
        this.rootPanel = rootPanel;
    }

    public JLabel getLabelForAuthorInput() {
        return labelForAuthorInput;
    }

    public void setLabelForAuthorInput(JLabel labelForAuthorInput) {
        this.labelForAuthorInput = labelForAuthorInput;
    }


}
