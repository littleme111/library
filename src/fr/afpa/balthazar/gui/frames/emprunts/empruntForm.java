package fr.afpa.balthazar.gui.frames.emprunts;

import com.sun.xml.internal.bind.v2.runtime.reflect.opt.Const;
import fr.afpa.balthazar.gui.frames.Frame;
import fr.afpa.balthazar.logic.model.Abonne;
import fr.afpa.balthazar.logic.model.Exemplaire;
import fr.afpa.balthazar.logic.model.Historique;
import fr.afpa.balthazar.logic.model.Livre;
import org.springframework.beans.factory.annotation.Autowired;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class empruntForm extends JInternalFrame{


    private final String TITLE = "Emprunter Rendre Livres";


    private JButton cancel;
    private JButton submit;
    private JLabel labelForAbonneName;
    private JLabel labelForAboId;
    private JLabel labelForErrors;
    private JPanel rootPanel;
    private JTable tableForActualBorrows;
    private JTable tableForSearchbooks;
    private JScrollPane scrollForActualBorrows;
    private JScrollPane scrollForSearchbooks;
    private JButton emprunterButton;
    private JButton rendreButton;
    private JCheckBox checkBoxForOnlyActiveBorrows;

    @Autowired
    private Frame frame;

    public empruntForm() {
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


    //Populate method is called to fill form fields with object values.
    public void populate(Abonne abonne, List<Livre> ll, Boolean allBorrows){
        //Set name and noAbonne
        this.labelForAboId.setText(abonne.getNoAbonne());
        this.labelForAbonneName.setText(abonne.getNom()+ " "+ abonne.getPrenom());

        //Create TableModel, from Abo Historique.
        Set<Historique> la = abonne.getHistorique();
        List<?> list = new ArrayList<Historique>(la);
        HashMap<Long, Exemplaire> data = new HashMap<Long, Exemplaire>();
        DefaultTableModel userTableModel;

        userTableModel = new DefaultTableModel(new Object[]{"ISBN", "Titre", "Date Emprunt", "Date Retour", "Id Exemplaire", "Id Historique"}, 0) {
            //Override method, to disallow editing of cells.
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        //Loop on all historique.
        for (int x = 0; x < list.size(); x++) {

            //Cast object to historique.
            Historique ex = (Historique) list.get(x);

            //AllBorrows boolean is used by Check box on EmpruntForm to toggle only active borrows.
            //If book has already been returned - continue.
            if(!allBorrows && ex.getDate_ret() != null){
                continue;
            }


//            Create and fill String array.
            String[] datas = new String[6];
            datas[0] = ex.getExemplaire().getLivre().getISBN();
            datas[1] = ex.getExemplaire().getLivre().getTitle();
            //Reformat date for view.
            String date = ex.getDate_emp().toString();
            date = date.substring(0, 10);
            date = date.substring(8, 10) + "/" +date.substring(5,7) +"/"+ date.substring(0, 4);
            datas[2] = date;

            if(ex.getDate_ret() != null){
                String dateR = ex.getDate_ret().toString();
                dateR = dateR.substring(0, 10);
                dateR = dateR.substring(8, 10) + "/" +dateR.substring(5,7) +"/"+ dateR.substring(0, 4);

                datas[3] = dateR;
            }else{
                datas[3] = "";
            }
            datas[4] = ex.getExemplaire().getId_exemplaire().toString();
            datas[5] = ex.getId_historique().toString();
            userTableModel.addRow(datas);
        }
        //Get Column model to hide last row containing id.
        TableColumnModel tcm = this.tableForActualBorrows.getColumnModel();
        this.tableForActualBorrows.setModel(userTableModel);
        this.tableForActualBorrows.setColumnModel(tcm);
        this.tableForActualBorrows.getColumnModel().removeColumn(this.tableForActualBorrows.getColumnModel().getColumn(5));


        //Same logic on all books.
        DefaultTableModel userTableModelAllBooks = new DefaultTableModel(new Object[]{"ISBN", "Titre", "Disponible"}, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };


        for (int x = 0; x < ll.size(); x++) {
            Livre l =  ll.get(x);

            String[] datas = new String[3];

            datas[0] = l.getISBN();
            datas[1] = l.getTitle();
            if(l.isDisponible()){
                datas[2] = "Disponible";
            }else{
                datas[2] = "Indisponible";
            }

            userTableModelAllBooks.addRow(datas);
        }
        this.tableForSearchbooks.setModel(userTableModelAllBooks);


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

    public JLabel getLabelForAbonneName() {
        return labelForAbonneName;
    }

    public void setLabelForAbonneName(JLabel labelForAbonneName) {
        this.labelForAbonneName = labelForAbonneName;
    }

    public JLabel getLabelForAboId() {
        return labelForAboId;
    }

    public void setLabelForAboId(JLabel labelForAboId) {
        this.labelForAboId = labelForAboId;
    }

    public JLabel getLabelForErrors() {
        return labelForErrors;
    }

    public void setLabelForErrors(JLabel labelForErrors) {
        this.labelForErrors = labelForErrors;
    }

    public JPanel getRootPanel() {
        return rootPanel;
    }

    public void setRootPanel(JPanel rootPanel) {
        this.rootPanel = rootPanel;
    }

    public JTable getTableForActualBorrows() {
        return tableForActualBorrows;
    }

    public void setTableForActualBorrows(JTable tableForActualBorrows) {
        this.tableForActualBorrows = tableForActualBorrows;
    }

    public JTable getTableForSearchbooks() {
        return tableForSearchbooks;
    }

    public void setTableForSearchbooks(JTable tableForSearchbooks) {
        this.tableForSearchbooks = tableForSearchbooks;
    }

    public JScrollPane getScrollForActualBorrows() {
        return scrollForActualBorrows;
    }

    public void setScrollForActualBorrows(JScrollPane scrollForActualBorrows) {
        this.scrollForActualBorrows = scrollForActualBorrows;
    }

    public JScrollPane getScrollForSearchbooks() {
        return scrollForSearchbooks;
    }

    public void setScrollForSearchbooks(JScrollPane scrollForSearchbooks) {
        this.scrollForSearchbooks = scrollForSearchbooks;
    }

    public JButton getEmprunterButton() {
        return emprunterButton;
    }

    public void setEmprunterButton(JButton emprunterButton) {
        this.emprunterButton = emprunterButton;
    }

    public JButton getRendreButton() {
        return rendreButton;
    }

    public void setRendreButton(JButton rendreButton) {
        this.rendreButton = rendreButton;
    }

    public Frame getFrame() {
        return frame;
    }

    public void setFrame(Frame frame) {
        this.frame = frame;
    }

    public JCheckBox getCheckBoxForOnlyActiveBorrows() {
        return checkBoxForOnlyActiveBorrows;
    }

    public void setCheckBoxForOnlyActiveBorrows(JCheckBox checkBoxForOnlyActiveBorrows) {
        this.checkBoxForOnlyActiveBorrows = checkBoxForOnlyActiveBorrows;
    }

    public String getTITLE() {
        return TITLE;
    }
}
