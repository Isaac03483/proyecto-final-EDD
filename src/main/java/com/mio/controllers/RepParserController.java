package com.mio.controllers;

import com.mio.compiler.lexer.ReporteLexer;
import com.mio.compiler.parser.ReporteParser;

import java.io.StringReader;

public class RepParserController {

    private ReporteParser parser;

    public void compile(String input){
        ReporteLexer lexer = new ReporteLexer(new StringReader(input));
        parser = new ReporteParser(lexer);

        try {
            parser.parse();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
