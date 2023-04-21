package com.mio.controllers;

import com.mio.gui.MainFrame;

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
        int opcion = fileChooser.showOpenDialog(this.mainFrame);

        if(opcion == JFileChooser.APPROVE_OPTION){

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
