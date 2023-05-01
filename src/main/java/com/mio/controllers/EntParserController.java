package com.mio.controllers;

import com.mio.compiler.lexer.CargaLexer;
import com.mio.compiler.lexer.EstructuraLexer;
import com.mio.compiler.parser.EntradaParser;
import com.mio.compiler.parser.EstructuraParser;

import java.io.StringReader;

public class EntParserController {

    private EntradaParser parser;

    public void compile(String input){
        CargaLexer lexer = new CargaLexer(new StringReader(input));

        parser = new EntradaParser(lexer);
        try {
            parser.parse();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
