package fr.afpa.balthazar.gui.menus;

import javax.swing.*;

public class MenuHelp extends JMenu {

    private ButtonGroup buttonGroup = new ButtonGroup();

    private JMenuItem aPropos = new JMenuItem("A Propos", 'h');

    public MenuHelp() {
        super("?");
        buttonGroup.add(aPropos);
        this.add(aPropos);


    }

    public ButtonGroup getButtonGroup() {
        return buttonGroup;
    }

    public void setButtonGroup(ButtonGroup buttonGroup) {
        this.buttonGroup = buttonGroup;
    }

    public JMenuItem getaPropos() {
        return aPropos;
    }

    public void setaPropos(JMenuItem aPropos) {
        this.aPropos = aPropos;
    }
}
