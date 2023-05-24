package com.mio.controllers;

import com.mio.gui.MainFrame;
import com.mio.models.list.List;
import com.mio.models.list.Node;

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
        this.mainFrame.getMessageArea().setText("");
        try {

            Scanner scanner = new Scanner(file);

            StringBuilder content = new StringBuilder();
            while(scanner.hasNext()){
                content.append(scanner.nextLine()).append("\n");
            }

            mainFrame.getContentArea().setText(content.toString());

            mainFrame.getTextLabel().setText(file.getName());
//            switch (fileName){
//                case "Estructura.xml"-> {
//                    System.out.println("Parseando estructuras...");
//                    EstParserController eParserHandler = new EstParserController();
//                    eParserHandler.compile(content.toString());
//                    List<String> out = eParserHandler.getErrorMessages();
//                    addMessages(out);
//                }
//                case "entrada.dat" -> {
//                    System.out.println("Parseando entrada...");
//                    EntParserController entParserController = new EntParserController();
//                    entParserController.compile(content.toString());
//                    List<String> out = entParserController.getErrorMessages();
//                    addMessages(out);
//                }
//                case "elimina.dat" -> {
//                    System.out.println("Parseando eliminacion...");
//                    ElmParserController elmParserController = new ElmParserController();
//                    elmParserController.compile(content.toString());
//                }
//                case "reportes.rpt" -> {
//                    System.out.println("Parseando reportes...");
//                    RepParserController repParserController = new RepParserController();
//                    repParserController.compile(content.toString());
//
//                }
//                default -> {
//                    System.out.println("No se reconoce el documento: "+fileName);
//                }
//            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

    public void readContent(String fileName, String content){
        switch (fileName){
            case "Estructura.xml"-> {
                System.out.println("Parseando estructuras...");
                EstParserController eParserHandler = new EstParserController();
                eParserHandler.compile(content);
                List<String> out = eParserHandler.getErrorMessages();
                addMessages(out);
            }
            case "entrada.dat" -> {
                System.out.println("Parseando entrada...");
                EntParserController entParserController = new EntParserController();
                entParserController.compile(content);
                List<String> out = entParserController.getErrorMessages();
                addMessages(out);
            }
            case "elimina.dat" -> {
                System.out.println("Parseando eliminacion...");
                ElmParserController elmParserController = new ElmParserController();
                elmParserController.compile(content);
            }
            case "reportes.rpt" -> {
                System.out.println("Parseando reportes...");
                RepParserController repParserController = new RepParserController();
                repParserController.compile(content);

            }
            default -> {
                System.out.println("No se reconoce el documento: "+fileName);
            }
        }
    }

    public void addMessages(List<String> out){
        Node<String> currentNode = out.firstNode;
        while(currentNode != null){
            this.mainFrame.getMessageArea().append(currentNode.value+"\n");
            currentNode = currentNode.next;
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
