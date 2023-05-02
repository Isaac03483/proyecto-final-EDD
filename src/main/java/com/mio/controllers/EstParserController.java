package com.mio.controllers;

import com.mio.compiler.lexer.EstructuraLexer;
import com.mio.compiler.parser.EstructuraParser;
import com.mio.models.list.List;
import com.mio.models.list.Node;

import java.io.StringReader;

public class EstParserController {

    private EstructuraParser parser;
    private List<String> errorMessages;

    public void compile(String input){
        EstructuraLexer lexer = new EstructuraLexer(new StringReader(input));
        errorMessages= new List<>();
        parser = new EstructuraParser(lexer, errorMessages);
        try {
            parser.parse();
            printErrorMessages();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    public List<String> getErrorMessages() {
        return errorMessages;
    }

    public void printErrorMessages(){
        Node<String> node = errorMessages.firstNode;
        while(node != null){
            System.out.println(node.value);
            node = node.next;
        }
    }
}
