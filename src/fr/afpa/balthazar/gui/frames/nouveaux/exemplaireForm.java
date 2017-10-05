package fr.afpa.balthazar.gui.frames.nouveaux;

import fr.afpa.balthazar.gui.frames.Frame;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.*;


public class exemplaireForm extends JInternalFrame{

    private final String TITLE = "Nouveau Exemplaire";

    private JPanel rootPanel;
    private JComboBox bookSelect;
    private JButton cancel;
    private JButton submit;
    private JLabel labelForBookSelect;

    @Autowired
    private Frame frame;

    public exemplaireForm() {
        this.frame = frame;
        rootPanel.setVisible(true);

        this.setVisible(true);
        this.setResizable(true);
        this.setMaximizable(true);
        this.setClosable(true);
        this.setSize(500, 300);
        this.setTitle(TITLE);
        this.add(rootPanel);
    }


    public JPanel getRootPanel() {
        return rootPanel;
    }

    public void setRootPanel(JPanel rootPanel) {
        this.rootPanel = rootPanel;
    }

    public JComboBox getBookSelect() {
        return bookSelect;
    }

    public void setBookSelect(JComboBox bookSelect) {
        this.bookSelect = bookSelect;
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

    public JLabel getLabelForBookSelect() {
        return labelForBookSelect;
    }

    public void setLabelForBookSelect(JLabel labelForBookSelect) {
        this.labelForBookSelect = labelForBookSelect;
    }

    public Frame getFrame() {
        return frame;
    }

    public void setFrame(Frame frame) {
        this.frame = frame;
    }

    public String getTITLE() {
        return TITLE;
    }
}
