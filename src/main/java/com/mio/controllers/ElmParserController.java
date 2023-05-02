package com.mio.controllers;

import com.mio.compiler.lexer.CargaLexer;
import com.mio.compiler.parser.EliminaParser;

import java.io.StringReader;

public class ElmParserController {

    private EliminaParser parser;

    public void compile(String input){
        CargaLexer lexer = new CargaLexer(new StringReader(input));
        parser = new EliminaParser(lexer);
        try {
            parser.parse();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
