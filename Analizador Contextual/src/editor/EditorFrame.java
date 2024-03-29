/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package editor;

import AST.AGoal;
import AST.AST;
import Imprimir.imprimir_arbol;
import java.awt.BorderLayout;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import javax.swing.filechooser.FileFilter;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import proyecto.ContextAnalizer;
import proyecto.Driver;
import proyecto.ErrorReporter;
import proyecto.IdentifierTable;

/**
 *
 * @author Alonso
 */
public class EditorFrame extends javax.swing.JFrame implements ErrorReporter {

    private JFileChooser fileChooser = new JFileChooser(System.getProperty("user.dir"));

    /**
     * Creates new form Editor
     */
    public EditorFrame() {
        initComponents();

        // Lets create a border layout to make positioning of items easy and quick.
        setLayout(new BorderLayout());
        setDefaultCloseOperation(EXIT_ON_CLOSE);


        // Add a caretListener to the editor. This is an anonymous class because it is inline and has no specific name.
        EditorPane.addCaretListener(new CaretListener() {
            // Each time the caret is moved, it will trigger the listener and its method caretUpdate.
            // It will then pass the event to the update method including the source of the event (which is our textarea control)

            @Override
            public void caretUpdate(CaretEvent e) {
                JTextArea editArea = (JTextArea) e.getSource();

                // Lets start with some default values for the line and column.
                int linenum = 1;
                int columnnum = 1;

                // We create a try catch to catch any exceptions. We will simply ignore such an error for our demonstration.
                try {
                    // First we find the position of the caret. This is the number of where the caret is in relation to the start of the JTextArea
                    // in the upper left corner. We use this position to find offset values (eg what line we are on for the given position as well as
                    // what position that line starts on.
                    int caretpos = editArea.getCaretPosition();
                    linenum = editArea.getLineOfOffset(caretpos);

                    // We subtract the offset of where our line starts from the overall caret position.
                    // So lets say that we are on line 5 and that line starts at caret position 100, if our caret position is currently 106
                    // we know that we must be on column 6 of line 5.
                    columnnum = caretpos - editArea.getLineStartOffset(linenum);

                    // We have to add one here because line numbers start at 0 for getLineOfOffset and we want it to start at 1 for display.
                    linenum += 1;
                } catch (Exception ex) {
                }

                // Once we know the position of the line and the column, pass it to a helper function for updating the status bar.
                updateStatus(linenum, columnnum);
            }
        });

        status = new JTextField();
        add(status, BorderLayout.SOUTH);

        // Give the status update value
        updateStatus(1, 1);

        fileChooser.setFileFilter(new FileFilter() {

            @Override
            public boolean accept(File f) {
                if (f.isDirectory()) {
                    return true;
                }
                return (f.getName().endsWith(".txt") || f.getName().endsWith(".java"));
            }

            @Override
            public String getDescription() {
                return "Java source";
            }
        });

        add(jSplitPane1, BorderLayout.CENTER);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToolBar1 = new javax.swing.JToolBar();
        jButton1 = new javax.swing.JButton();
        jSplitPane1 = new javax.swing.JSplitPane();
        SplitPanel = new javax.swing.JSplitPane();
        jScrollPane4 = new javax.swing.JScrollPane();
        EditorPane = new javax.swing.JTextArea();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        Tree = new javax.swing.JTree();
        jScrollPane3 = new javax.swing.JScrollPane();
        TableIdentifiers = new javax.swing.JTable();
        jScrollPane1 = new javax.swing.JScrollPane();
        TerminalPane = new javax.swing.JEditorPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        FileMenu = new javax.swing.JMenu();
        OpenFileMenuItem = new javax.swing.JMenuItem();
        SaveFileMenuItem = new javax.swing.JMenuItem();
        QuitMenuItem = new javax.swing.JMenuItem();
        RunMenu = new javax.swing.JMenu();
        CompileMenuItem = new javax.swing.JMenuItem();
        TreeMenu = new javax.swing.JMenu();
        ExpandAllTreeMenu = new javax.swing.JMenuItem();
        CollapseAllMenuItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("ACompiler");
        setName("frame");

        jToolBar1.setRollover(true);

        jButton1.setText("jButton1");
        jButton1.setFocusable(false);
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(jButton1);

        jSplitPane1.setDividerLocation(400);
        jSplitPane1.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);

        SplitPanel.setDividerLocation(600);
        SplitPanel.setMinimumSize(new java.awt.Dimension(600, 300));

        EditorPane.setColumns(20);
        EditorPane.setFont(new java.awt.Font("Ubuntu Mono", 0, 14)); // NOI18N
        EditorPane.setRows(5);
        jScrollPane4.setViewportView(EditorPane);

        SplitPanel.setLeftComponent(jScrollPane4);

        javax.swing.tree.DefaultMutableTreeNode treeNode1 = new javax.swing.tree.DefaultMutableTreeNode("Goal");
        Tree.setModel(new javax.swing.tree.DefaultTreeModel(treeNode1));
        Tree.setMaximumSize(new java.awt.Dimension(300, 64));
        jScrollPane2.setViewportView(Tree);

        jTabbedPane1.addTab("AST", jScrollPane2);

        TableIdentifiers.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(TableIdentifiers);

        jTabbedPane1.addTab("Tabla de identificadores", jScrollPane3);

        SplitPanel.setRightComponent(jTabbedPane1);

        jSplitPane1.setTopComponent(SplitPanel);

        TerminalPane.setEditable(false);
        TerminalPane.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        jScrollPane1.setViewportView(TerminalPane);

        jSplitPane1.setRightComponent(jScrollPane1);

        FileMenu.setText("File");

        OpenFileMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_MASK));
        OpenFileMenuItem.setText("Open");
        OpenFileMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OpenFileMenuItemActionPerformed(evt);
            }
        });
        FileMenu.add(OpenFileMenuItem);

        SaveFileMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        SaveFileMenuItem.setText("Save");
        SaveFileMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SaveFileMenuItemActionPerformed(evt);
            }
        });
        FileMenu.add(SaveFileMenuItem);

        QuitMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Q, java.awt.event.InputEvent.CTRL_MASK));
        QuitMenuItem.setText("Quit");
        QuitMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                QuitMenuItemActionPerformed(evt);
            }
        });
        FileMenu.add(QuitMenuItem);

        jMenuBar1.add(FileMenu);

        RunMenu.setText("Run");

        CompileMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, java.awt.event.InputEvent.CTRL_MASK));
        CompileMenuItem.setText("Compile");
        CompileMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CompileMenuItemActionPerformed(evt);
            }
        });
        RunMenu.add(CompileMenuItem);

        jMenuBar1.add(RunMenu);

        TreeMenu.setText("Tree");

        ExpandAllTreeMenu.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.CTRL_MASK));
        ExpandAllTreeMenu.setText("Expand all");
        ExpandAllTreeMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExpandAllTreeMenuActionPerformed(evt);
            }
        });
        TreeMenu.add(ExpandAllTreeMenu);

        CollapseAllMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.CTRL_MASK));
        CollapseAllMenuItem.setText("Collapse all");
        CollapseAllMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CollapseAllMenuItemActionPerformed(evt);
            }
        });
        TreeMenu.add(CollapseAllMenuItem);

        jMenuBar1.add(TreeMenu);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 547, Short.MAX_VALUE)
        );

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-902)/2, (screenSize.height-602)/2, 902, 602);
    }// </editor-fold>//GEN-END:initComponents

    private void OpenFileMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OpenFileMenuItemActionPerformed

        fileChooser.showOpenDialog(this);
        if (fileChooser.getSelectedFile() != null) {
            try {
                EditorPane.setText(new Scanner(fileChooser.getSelectedFile()).useDelimiter("\\Z").next());
                ReportMessage("File loaded: " + fileChooser.getSelectedFile().getName());
            } catch (FileNotFoundException ex) {
            }
        }

    }//GEN-LAST:event_OpenFileMenuItemActionPerformed

    private void SaveFileMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaveFileMenuItemActionPerformed

        fileChooser.showSaveDialog(this);
        File selectedFile = fileChooser.getSelectedFile();
        if (fileChooser.getSelectedFile() == null) {
            return;
        }
        String filePath = selectedFile.getPath();
        if (!filePath.toLowerCase().endsWith(".txt") && !filePath.toLowerCase().endsWith(".java")) {
            selectedFile = new File(filePath + ".java");
        }
        try {
            if (selectedFile != null) {
                if (selectedFile.exists()) {
                    selectedFile.delete();
                }
                if (selectedFile.createNewFile()) {
                    PrintWriter pw = new PrintWriter(selectedFile);
                    String text = EditorPane.getText();
                    pw.println(text);
                    pw.close();
                    ReportMessage("File saved: " + selectedFile.getName());
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(EditorFrame.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_SaveFileMenuItemActionPerformed

    private void QuitMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_QuitMenuItemActionPerformed

        System.exit(0);

    }//GEN-LAST:event_QuitMenuItemActionPerformed

    private void CompileMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CompileMenuItemActionPerformed

        // Obtener código del editor
        String source = EditorPane.getText();
        this.TerminalPane.setText("");

        Driver d = new Driver(this);
//        try {
        AST arbol = null;
        try {
            arbol = d.parse(source);
        } catch (Exception ex) {
            Logger.getLogger(EditorFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (arbol != null) {
            Imprimir.imprimir_arbol imp = new imprimir_arbol();
            DefaultMutableTreeNode tree = new DefaultMutableTreeNode();
            AGoal goal = (AGoal) arbol;
            imp.visitAGoal(goal, tree);
            Tree.setModel(new DefaultTreeModel(tree));

            IdentifierTable table = new IdentifierTable();
            ContextAnalizer ca = new ContextAnalizer(table, this);
            ca.visit(goal);
            TableIdentifiers.setModel(table.getTableModel());

            ReportMessage("Successfully compiled.");
        }
//        } catch (NullPointerException npe) {
//            // reportError("Null pointer");
//            System.out.println("Null pointer");
//        } catch (Exception ex) {
//            ReportError(ex.getMessage());
//        }

    }//GEN-LAST:event_CompileMenuItemActionPerformed

    private void ExpandAllTreeMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExpandAllTreeMenuActionPerformed

        for (int i = 0; i < Tree.getRowCount(); i++) {
            Tree.expandRow(i);
        }

    }//GEN-LAST:event_ExpandAllTreeMenuActionPerformed

    private void CollapseAllMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CollapseAllMenuItemActionPerformed

        for (int i = 0; i < Tree.getRowCount(); i++) {
            Tree.collapseRow(i);
        }

    }//GEN-LAST:event_CollapseAllMenuItemActionPerformed

    @Override
    public void ReportError(String message) {
        TerminalPane.setText(TerminalPane.getText() + "\n" + message);
    }

    @Override
    public void ReportMessage(String message) {
        TerminalPane.setText(TerminalPane.getText() + "\n" + message);
    }
    // Two controls, one is the editor and the other is our little status bar at the bottom.
    // When we update the editor, the change in caret will update the status text field.
    private JTextField status;

    // This helper function updates the status bar with the line number and column number.
    private void updateStatus(int linenumber, int columnnumber) {
        status.setText("Line: " + linenumber + " Column: " + columnnumber);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /*
         * Set the Nimbus look and feel
         */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the
         * default look and feel. For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(EditorFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EditorFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EditorFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EditorFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                new EditorFrame().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem CollapseAllMenuItem;
    private javax.swing.JMenuItem CompileMenuItem;
    private javax.swing.JTextArea EditorPane;
    private javax.swing.JMenuItem ExpandAllTreeMenu;
    private javax.swing.JMenu FileMenu;
    private javax.swing.JMenuItem OpenFileMenuItem;
    private javax.swing.JMenuItem QuitMenuItem;
    private javax.swing.JMenu RunMenu;
    private javax.swing.JMenuItem SaveFileMenuItem;
    private javax.swing.JSplitPane SplitPanel;
    private javax.swing.JTable TableIdentifiers;
    private javax.swing.JEditorPane TerminalPane;
    private javax.swing.JTree Tree;
    private javax.swing.JMenu TreeMenu;
    private javax.swing.JButton jButton1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JToolBar jToolBar1;
    // End of variables declaration//GEN-END:variables
}
