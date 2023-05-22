package com.mio.controllers;

import com.mio.compiler.lexer.CargaLexer;
import com.mio.compiler.lexer.EstructuraLexer;
import com.mio.compiler.parser.EntradaParser;
import com.mio.compiler.parser.EstructuraParser;
import com.mio.models.list.List;
import com.mio.models.list.Node;

import java.io.StringReader;

public class EntParserController {

    private EntradaParser parser;
    private List<String> errorList;

    public void compile(String input){
        CargaLexer lexer = new CargaLexer(new StringReader(input));

        errorList = new List<>();
        parser = new EntradaParser(lexer, errorList);
        try {
            parser.parse();
            printErrorMessages();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    public void printErrorMessages(){
        Node<String> node = errorList.firstNode;
        while(node != null){
            System.out.println(node.value);
            node = node.next;
        }
    }
}
