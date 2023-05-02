package com.mio.controllers;

import com.mio.gui.MainFrame;
import com.mio.models.abbTree.Tree;

import javax.swing.JFileChooser;
import java.io.*;
import java.util.Optional;
import java.util.Scanner;

public class MainController implements Runnable{

    MainFrame mainFrame;

    public MainController(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
    }

    private Optional<File> findFile(){
        JFileChooser fileChooser = new JFileChooser();
        int option = fileChooser.showOpenDialog(this.mainFrame);

        if(option == JFileChooser.APPROVE_OPTION){

            String archivo = fileChooser.getSelectedFile().getAbsolutePath();

            File file = new File(archivo);
            if(file.exists()){

                return Optional.of(file);
            }
        }

        return Optional.empty();
    }

    private void readFile(File file) {
        try {

            Scanner scanner = new Scanner(file);

            StringBuilder content = new StringBuilder();
            while(scanner.hasNext()){
                content.append(scanner.nextLine()).append("\n");
            }

            mainFrame.getContentArea().setText(content.toString());

            String fileName = file.getName();
            switch (fileName){
                case "Estructura.xml"-> {
                    System.out.println("Parseando estructuras...");
                    EstParserController eParserHandler = new EstParserController();
                    eParserHandler.compile(content.toString());
                    Tree.getInstance().print();
                }
                case "entrada.dat" -> {
                    System.out.println("Parseando entrada...");
                    EntParserController entParserController = new EntParserController();
                    entParserController.compile(content.toString());
                }
                case "elimina.dat" -> {
                    System.out.println("Parseando eliminacion...");

                }
                case "reportes.rpt" -> {

                }
                default -> {
                    System.out.println("No se reconoce el documento: "+fileName);
                }
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

    }


    @Override
    public void run() {
        try {
            Optional<File> optionalFile = findFile();

            optionalFile.ifPresent(this::readFile);

            Thread.sleep(1);
        } catch (InterruptedException e) {
            System.err.println(e.getMessage());
        }
    }
}
