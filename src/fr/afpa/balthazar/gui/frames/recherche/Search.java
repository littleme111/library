package fr.afpa.balthazar.gui.frames.recherche;

import fr.afpa.balthazar.gui.frames.Frame;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.*;


public class Search extends JInternalFrame{
    private JTextField searchInput;
    private JList resultList;
    private JLabel labelForTypeOfSearch;
    private JLabel labelForErrors;
    private JPanel rootPanel;
    private JTable searchTable;
    private JPanel searchPanel;
    private JTable searchResultsTable;
    private JScrollPane searchScrollPane;
    private JButton editButtonForAbonneSearch;
    private JButton AnnulerButtonFroAbonneSearch;
    private JButton buttonLoanbooks;

    @Autowired
    private Frame frame;

    public Search() {

        this.frame = frame;
        this.setVisible(true);
        this.setSize(500, 300);
        buttonLoanbooks.setVisible(false);
        this.setVisible(true);
        this.setResizable(true);
        this.setMaximizable(true);
        this.setClosable(true);
        this.setSize(500, 450);
        this.add(rootPanel);

    }


    public JTextField getSearchInput() {
        return searchInput;
    }

    public void setSearchInput(JTextField searchInput) {
        this.searchInput = searchInput;
    }

    public JList getResultList() {
        return resultList;
    }

    public void setResultList(JList resultList) {
        this.resultList = resultList;
    }

    public JLabel getLabelForTypeOfSearch() {
        return labelForTypeOfSearch;
    }

    public void setLabelForTypeOfSearch(JLabel labelForTypeOfSearch) {
        this.labelForTypeOfSearch = labelForTypeOfSearch;
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

    public JTable getSearchTable() {
        return searchTable;
    }

    public void setSearchTable(JTable searchTable) {
        this.searchTable = searchTable;
    }

    public JPanel getSearchPanel() {
        return searchPanel;
    }

    public void setSearchPanel(JPanel searchPanel) {
        this.searchPanel = searchPanel;
    }

    public Frame getFrame() {
        return frame;
    }

    public void setFrame(Frame frame) {
        this.frame = frame;
    }

    public JTable getSearchResultsTable() {
        return searchResultsTable;
    }

    public void setSearchResultsTable(JTable searchResultsTable) {
        this.searchResultsTable = searchResultsTable;
    }

    public JScrollPane getSearchScrollPane() {
        return searchScrollPane;
    }

    public void setSearchScrollPane(JScrollPane searchScrollPane) {
        this.searchScrollPane = searchScrollPane;
    }

    public JButton getEditButtonForAbonneSearch() {
        return editButtonForAbonneSearch;
    }

    public void setEditButtonForAbonneSearch(JButton editButtonForAbonneSearch) {
        this.editButtonForAbonneSearch = editButtonForAbonneSearch;
    }

    public JButton getAnnulerButtonFroAbonneSearch() {
        return AnnulerButtonFroAbonneSearch;
    }

    public void setAnnulerButtonFroAbonneSearch(JButton annulerButtonFroAbonneSearch) {
        AnnulerButtonFroAbonneSearch = annulerButtonFroAbonneSearch;
    }

    public JButton getButtonLoanbooks() {
        return buttonLoanbooks;
    }

    public void setButtonLoanbooks(JButton buttonLoanbooks) {
        this.buttonLoanbooks = buttonLoanbooks;
    }


}
