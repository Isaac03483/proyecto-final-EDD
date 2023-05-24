package com.mio.gui;


import com.mio.controllers.MainController;
import com.mio.utils.LineNumber;

import javax.swing.*;

public class MainFrame extends javax.swing.JFrame {

    /**
     * Creates new form MainFrame
     */
    public MainFrame() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.controller = new MainController(this);
        LineNumber lineNumber = new LineNumber(this.contentArea);
        jScrollPane1.setRowHeaderView(lineNumber);
        this.contentArea.setEditable(true);
    }

    public JTextArea getContentArea() {
        return contentArea;
    }

    public JTextArea getMessageArea() {
        return messageArea;
    }

    public JLabel getTextLabel(){return this.textLabel;}

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        contentArea = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        messageArea = new javax.swing.JTextArea();
        textLabel = new javax.swing.JLabel();
        chargeButton = new javax.swing.JButton();
        reportButton = new javax.swing.JButton();
        graphButton = new javax.swing.JButton();
        CompileButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        contentArea.setEditable(false);
        contentArea.setBackground(new java.awt.Color(255, 255, 255));
        contentArea.setColumns(20);
        contentArea.setRows(5);
        jScrollPane1.setViewportView(contentArea);

        messageArea.setEditable(false);
        messageArea.setBackground(new java.awt.Color(255, 255, 255));
        messageArea.setColumns(20);
        messageArea.setRows(5);
        jScrollPane2.setViewportView(messageArea);

        textLabel.setText("Previsualización del texto:");

        chargeButton.setText("Cargar Archivo");
        chargeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chargeButtonActionPerformed(evt);
            }
        });

        reportButton.setText("Reportes");
        reportButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reportButtonActionPerformed(evt);
            }
        });

        graphButton.setText("Gráfica");
        graphButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                graphButtonActionPerformed(evt);
            }
        });

        CompileButton.setText("Ejecutar");
        CompileButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CompileButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(textLabel)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(chargeButton)
                                .addGap(18, 18, 18)
                                .addComponent(reportButton)
                                .addGap(18, 18, 18)
                                .addComponent(graphButton)))
                        .addGap(0, 515, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(CompileButton)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(chargeButton)
                    .addComponent(reportButton)
                    .addComponent(graphButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(textLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(CompileButton)
                .addGap(12, 12, 12)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void chargeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chargeButtonActionPerformed
        // TODO add your handling code here:
        controller.run();
    }//GEN-LAST:event_chargeButtonActionPerformed

    private void reportButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reportButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_reportButtonActionPerformed

    private void graphButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_graphButtonActionPerformed
        // TODO add your handling code here:
        GraphicFrame graphicFrame = new GraphicFrame(this, true);
        graphicFrame.setVisible(true);
    }//GEN-LAST:event_graphButtonActionPerformed

    private void CompileButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CompileButtonActionPerformed
        // TODO add your handling code here:
        messageArea.setText("");
        controller.readContent(textLabel.getText(), contentArea.getText());
    }//GEN-LAST:event_CompileButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CompileButton;
    private javax.swing.JButton chargeButton;
    private javax.swing.JTextArea contentArea;
    private javax.swing.JButton graphButton;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea messageArea;
    private javax.swing.JButton reportButton;
    private javax.swing.JLabel textLabel;
    // End of variables declaration//GEN-END:variables

    private MainController controller;
}
