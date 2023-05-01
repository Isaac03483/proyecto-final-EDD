package com.mio.controllers;

import com.mio.compiler.lexer.EstructuraLexer;
import com.mio.compiler.parser.EstructuraParser;

import java.io.StringReader;

public class EstParserController {

    private EstructuraParser parser;

    public void compile(String input){
        EstructuraLexer lexer = new EstructuraLexer(new StringReader(input));

        parser = new EstructuraParser(lexer);
        try {
            parser.parse();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
