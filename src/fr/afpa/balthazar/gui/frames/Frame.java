package fr.afpa.balthazar.gui.frames;

import javax.swing.*;
import java.awt.*;
import fr.afpa.balthazar.gui.menus.MenuBar;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;


//Class Frame is base frame with JDesktopPane.
//All other guis are JInternalFrames added to the desktop pane.
@Component
public class Frame extends JFrame {

    private MenuBar menuBar = new MenuBar();
    private JDesktopPane jDesktopPane = new JDesktopPane();



    public Frame() throws HeadlessException {

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("Library Manager");
        this.setSize(800, 800);
        this.setJMenuBar(menuBar);
        this.setVisible(true);
        this.add(jDesktopPane);
    }

    public MenuBar getMenuBars() {
        return menuBar;
    }

    public void setMenuBar(MenuBar menuBar) {
        this.menuBar = menuBar;
    }


    public JDesktopPane getjDesktopPane() {
        return jDesktopPane;
    }

    public void setjDesktopPane(JDesktopPane jDesktopPane) {
        this.jDesktopPane = jDesktopPane;
    }
}
