/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mio.gui;

import com.mio.models.abbTree.Tree;
import com.mio.utils.Painter;

import javax.swing.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author mio
 */
public class GraphicFrame extends javax.swing.JDialog {

    /**
     * Creates new form GraphicFrame
     */
    public GraphicFrame(JFrame parent, boolean bool) {
        super(parent, bool);
        initComponents();
        this.setLocationRelativeTo(parent);
        this.createGraphic();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        imageLabel = new javax.swing.JLabel();

        imageLabel.setText(".");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(imageLabel)
                .addContainerGap(390, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(imageLabel)
                .addContainerGap(240, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void createGraphic(){

        System.out.println("creando archivo");
        String fileContent = Painter.createImage(Tree.getInstance());
        File file = new File("graph.dot");
        try(FileWriter writer = new FileWriter(file)){
            writer.write(fileContent);
//            ProcessBuilder processBuilder = new ProcessBuilder("dot"," -Tpng"," graph.dot"," -o"," graph.png");
//            processBuilder.redirectErrorStream(true);
//            processBuilder.start();
//            System.out.println("archivo creado");
//            imageLabel.setIcon(new ImageIcon("graph.png"));
//            System.out.println("mostrando archivo en label.");
            imageLabel.setText(fileContent);
        } catch (IOException e){
//            System.err.println("Error al crear el archivo.");
            e.printStackTrace();
        }



    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel imageLabel;
    // End of variables declaration//GEN-END:variables
}