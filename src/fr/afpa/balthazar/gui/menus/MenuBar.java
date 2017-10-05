package fr.afpa.balthazar.gui.menus;

import javax.swing.*;

public class MenuBar extends JMenuBar {


    private MenuFile menuFile = new MenuFile();
    private MenuHelp menuHelp = new MenuHelp();
    private MenuEdition menuEdition = new MenuEdition();
    public MenuBar() {
        //Exemplaire search is deactivated as there is no valid search fileter for a user.
        menuFile.getChercher().getExemplaire().setEnabled(false);
        this.add(menuFile);

//        Secondary menus were removed as their functionnality has not yet been implemented.

//        this.add(menuEdition);
//        this.add(menuHelp);


    }

    public MenuFile getMenuFile() {
        return menuFile;
    }

    public void setMenuFile(MenuFile menuFile) {
        this.menuFile = menuFile;
    }

    public MenuHelp getMenuHelp() {
        return menuHelp;
    }

    public void setMenuHelp(MenuHelp menuHelp) {
        this.menuHelp = menuHelp;
    }

    public MenuEdition getMenuEdition() {
        return menuEdition;
    }

    public void setMenuEdition(MenuEdition menuEdition) {
        this.menuEdition = menuEdition;
    }
}
