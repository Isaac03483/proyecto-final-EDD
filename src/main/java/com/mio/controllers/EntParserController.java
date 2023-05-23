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
    private List<String> errorMessages;

    public void compile(String input){
        CargaLexer lexer = new CargaLexer(new StringReader(input));

        errorMessages = new List<>();
        parser = new EntradaParser(lexer, errorMessages);
        try {
            parser.parse();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<String> getErrorMessages(){
        return errorMessages;
    }
}
