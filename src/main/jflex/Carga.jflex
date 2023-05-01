package com.mio.compiler.lexer;

import com.mio.compiler.Token;
import com.mio.compiler.parser.EntradaParserSym;
import java_cup.runtime.Symbol;

import static com.mio.compiler.parser.EntradaParserSym.*;

%%

%public
%class CargaLexer
%unicode
%line
%column
%type java_cup.runtime.Symbol
%cup

%{
    private Symbol symbolWithValue(int type, Object value){

        System.out.println("Encontrando: "+value.toString()+" "+EntradaParserSym.terminalNames[type]);

        if(type != INT){
            return new Symbol(type, new Token(type, value.toString(), yyline+1, yycolumn+1 ));
        }

        int number = Integer.parseInt(value.toString());
        if(number < Byte.MIN_VALUE || number > Byte.MAX_VALUE){

            if(number < Short.MIN_VALUE || number > Short.MAX_VALUE){

                return new Symbol(INT, new Token(INT, value.toString(), yyline+1, yycolumn+1 ));

            }

            return new Symbol(SHORT, new Token(SHORT, value.toString(), yyline+1, yycolumn+1 ));

        }

        return new Symbol(BYTE, new Token(BYTE, value.toString(), yyline+1, yycolumn+1 ));

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
DIGIT = [0-9]
NUMBER = {DIGIT}+
FLOAT = {DIGIT}+\.{DIGIT}+[fF]
DOUBLE = {DIGIT}+\.{DIGIT}+
LONG = {DIGIT}+[lL]
CHAR = [a-zA-Z0-9]
NAME = [a-zA-Z0-9_#\|!\?\"½~¬]+
BOOLEAN = ("true"|"false")
DIAGONAL = "/"

%%

<YYINITIAL> {

    {ESPACIO_BLANCO}    {;}
    {DIAGONAL}                              {return symbolWithoutValue(DIAGONAL);}
    {LESS}                                  {return symbolWithoutValue(LESS);}
    {GREATER}                               {return symbolWithoutValue(GREATER);}
    {NUMBER}                                {return symbolWithValue(INT, yytext());}
    {FLOAT}                                 {return symbolWithValue(FLOAT, yytext());}
    {DOUBLE}                                {return symbolWithValue(DOUBLE, yytext());}
    {LONG}                                  {return symbolWithValue(LONG, yytext());}
    {CHAR}                                  {return symbolWithValue(CHAR, yytext());}
    {BOOLEAN}                               {return symbolWithValue(BOOLEAN, yytext());}
    {NAME}                                  {return symbolWithValue(NAME, yytext());}

}