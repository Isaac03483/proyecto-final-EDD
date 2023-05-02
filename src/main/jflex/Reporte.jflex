package com.mio.compiler.lexer;

import com.mio.compiler.Token;
import com.mio.compiler.parser.ReporteParserSym;
import java_cup.runtime.Symbol;

import static com.mio.compiler.parser.ReporteParserSym.*;


%%

%public
%class ReporteLexer
%unicode
%line
%column
%type java_cup.runtime.Symbol
%cup

%{
    private Symbol symbolWithValue(int type, Object value){

        System.out.println("Encontrando: "+value.toString()+" "+ReporteParserSym.terminalNames[type]);
        return new Symbol(type, new Token(type, value.toString(), yyline+1, yycolumn+1 ));

    }

    private Symbol symbolWithoutValue(int type){
        System.out.println("Encontrando: "+EntradaParserSym.terminalNames[type]);

        return new Symbol(type, new Token(type, null, yyline+1, yycolumn+1 ));
    }

%}
%eofval{
    return symbolWithoutValue(EOF);
%eofval}
%eofclose

SALTO_LINEA = \r|\n|\r\n
ESPACIO_BLANCO = {SALTO_LINEA}|[ \t\f]
LESS = "<"
GREATER = ">"
REPORTE = "reporte"
COMA = ","
NAME = [a-zA-Z0-9_#\|!\?\"½~¬]+
DIAGONAL = "/"

%%

<YYINITIAL> {

    {ESPACIO_BLANCO}    {;}
    {LESS}                                  {return symbolWithoutValue(LESS);}
    {GREATER}                               {return symbolWithoutValue(GREATER);}
    {DIAGONAL}                              {return symbolWithoutValue(DIAGONAL);}
    {REPORTE}                               {return symbolWithoutValue(REPORTE);}
    {COMA}                                  {return symbolWithoutValue(COMA);}
    {NAME}                                  {return symbolWithValue(NAME, yytext());}

}