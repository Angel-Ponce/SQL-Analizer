package Main;

import com.formdev.flatlaf.FlatDarkLaf;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author angel_p11
 */
public class Main extends javax.swing.JFrame {
    Analizer analizer;
    /**
     * Creates new form Main
     */
    public Main() {
        initComponents();
        analizer = new Analizer("",this.inputArea,this.outputArea);
        setLocationRelativeTo(null);
        customCells();
    }
    
    public void customCells(){
        this.outputTable.getColumnModel().getColumn(0).setCellRenderer(new CustomCell("number"));
        this.outputTable.getColumnModel().getColumn(1).setCellRenderer(new CustomCell("text"));
        this.outputTable.getColumnModel().getColumn(2).setCellRenderer(new CustomCell("number"));
        this.outputTable.getColumnModel().getColumn(3).setCellRenderer(new CustomCell("text"));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        container = new javax.swing.JPanel();
        input = new javax.swing.JPanel();
        scroll1 = new javax.swing.JScrollPane();
        inputArea = new javax.swing.JTextArea();
        output = new javax.swing.JPanel();
        scroll2 = new javax.swing.JScrollPane();
        outputArea = new javax.swing.JTextArea();
        table = new javax.swing.JPanel();
        scroll3 = new javax.swing.JScrollPane();
        outputTable = new javax.swing.JTable();
        execute = new javax.swing.JButton();
        reset = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("SQL Analizer");
        setMinimumSize(new java.awt.Dimension(720, 500));

        container.setLayout(new java.awt.GridBagLayout());

        input.setPreferredSize(new java.awt.Dimension(720, 220));
        input.setRequestFocusEnabled(false);
        input.setLayout(new java.awt.GridLayout(1, 0));

        inputArea.setColumns(20);
        inputArea.setFont(new java.awt.Font("Lucida Grande", 0, 20)); // NOI18N
        inputArea.setRows(5);
        inputArea.setTabSize(2);
        inputArea.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Input", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Lucida Grande", 1, 15))); // NOI18N
        scroll1.setViewportView(inputArea);

        input.add(scroll1);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        container.add(input, gridBagConstraints);

        output.setPreferredSize(new java.awt.Dimension(360, 220));
        output.setLayout(new java.awt.GridLayout(1, 0));

        outputArea.setEditable(false);
        outputArea.setColumns(15);
        outputArea.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        outputArea.setRows(5);
        outputArea.setTabSize(2);
        outputArea.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Output", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Lucida Grande", 0, 15))); // NOI18N
        scroll2.setViewportView(outputArea);

        output.add(scroll2);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        container.add(output, gridBagConstraints);

        table.setPreferredSize(new java.awt.Dimension(360, 220));
        table.setLayout(new java.awt.GridLayout(1, 0));

        outputTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "NOMBRE", "EDAD", "ESTADO"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        scroll3.setViewportView(outputTable);

        table.add(scroll3);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        container.add(table, gridBagConstraints);

        execute.setBackground(new java.awt.Color(102, 255, 102));
        execute.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        execute.setForeground(new java.awt.Color(51, 51, 51));
        execute.setText("Execute");
        execute.setPreferredSize(new java.awt.Dimension(200, 30));
        execute.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                executeActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        container.add(execute, gridBagConstraints);

        reset.setBackground(new java.awt.Color(255, 51, 51));
        reset.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        reset.setText("Reset");
        reset.setPreferredSize(new java.awt.Dimension(200, 30));
        reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        container.add(reset, gridBagConstraints);

        getContentPane().add(container, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void executeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_executeActionPerformed
        analizer.setText(inputArea.getText());
        analizer.execute();
    }//GEN-LAST:event_executeActionPerformed

    private void resetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetActionPerformed
        inputArea.setText("");
        outputArea.setText("");
        DefaultTableModel model = (DefaultTableModel) outputTable.getModel();
        for (int i = outputTable.getRowCount() - 1; i >= 0; i--) {
            model.removeRow(i);
        }
        
    }//GEN-LAST:event_resetActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            javax.swing.UIManager.setLookAndFeel(new FlatDarkLaf());
        } catch (Exception e) {
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel container;
    private javax.swing.JButton execute;
    private javax.swing.JPanel input;
    private javax.swing.JTextArea inputArea;
    private javax.swing.JPanel output;
    private javax.swing.JTextArea outputArea;
    private javax.swing.JTable outputTable;
    private javax.swing.JButton reset;
    private javax.swing.JScrollPane scroll1;
    private javax.swing.JScrollPane scroll2;
    private javax.swing.JScrollPane scroll3;
    private javax.swing.JPanel table;
    // End of variables declaration//GEN-END:variables
}
