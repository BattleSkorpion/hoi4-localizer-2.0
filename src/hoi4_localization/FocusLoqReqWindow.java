package hoi4_localization;

import hoi4_localization.country.CountryTag;
import hoi4_localization.focus.FocusTree;
import hoi4_localization.focus.FocusTrees;

import javax.swing.*;
import java.io.IOException;
import java.util.ArrayList;

public class FocusLoqReqWindow extends JFrame {
    private JPanel FocusLoqReqJPanel;
    private JLabel focusloqreqlabel;
    private JLabel localizedFocusTreesLabel;
    private JLabel partiallyLocalizedFocusTreesLabel;
    private JLabel unlocalizedFocusTreesLabel;

    DefaultListModel<CountryTag> localizedTreeListModel;
    private JList localizedTreeList;

    DefaultListModel<CountryTag> partialLocalizedTreeListModel;
    private JList partialLocalizedTreeList;

    DefaultListModel<CountryTag> unlocalizedTreeListModel;
    private JList unlocalizedTreeList;

    public FocusLoqReqWindow() {
        setContentPane(FocusLoqReqJPanel);
        setTitle("focus loq req");

        setSize(700, 500);
        try {
            addLists(FocusTrees.unlocalizedFocusTrees(), FocusTrees.partiallyLocalizedFocusTrees(),
                    FocusTrees.localizedFocusTrees());
        } catch (IOException exc) {
            exc.printStackTrace();
            System.exit(-1);
        }
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        FocusLoqReqWindow window = new FocusLoqReqWindow();
    }

    private void addLists(ArrayList<FocusTree> unlocalizedFocusTrees, ArrayList<FocusTree> partialLocalizedFocusTrees,
                          ArrayList<FocusTree> localizedFocusTrees) {
        int i = 0;
        for (FocusTree tree : unlocalizedFocusTrees) {
            unlocalizedTreeListModel.add(i, tree.country());
            i++;
        }
        i = 0;
        for (FocusTree tree : partialLocalizedFocusTrees) {
            partialLocalizedTreeListModel.add(i, tree.country());
            i++;
        }
        i = 0;
        for (FocusTree tree : localizedFocusTrees) {
            localizedTreeListModel.add(i, tree.country());
            i++;
        }
        revalidate();
        repaint();
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
        localizedTreeListModel = new DefaultListModel<>();
        partialLocalizedTreeListModel = new DefaultListModel<>();
        unlocalizedTreeListModel = new DefaultListModel<>();
        localizedTreeList = new JList(localizedTreeListModel);
        partialLocalizedTreeList = new JList(partialLocalizedTreeListModel);
        unlocalizedTreeList = new JList(unlocalizedTreeListModel);
    }
}
