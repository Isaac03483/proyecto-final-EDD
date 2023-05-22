package com.mio.compiler.lexer;

/*
java -jar jflex-full-1.9.0.jar /home/mio/Escritorio/2023/EDD/proyecto-final-EDD/src/main/jflex/Estructura.jflex
*/
import com.mio.compiler.Token;
import java_cup.runtime.Symbol;
import com.mio.compiler.parser.EstructuraParserSym;
import static com.mio.compiler.parser.EstructuraParserSym.*;

%%

%public
%class EstructuraLexer
%unicode
%line
%column
%type java_cup.runtime.Symbol
%cup

%{
    private Symbol symbolWithValue(int type, Object value){
        System.out.println("Encontrando: "+value.toString()+" "+EstructuraParserSym.terminalNames[type]);
        return new Symbol(type, new Token(type, value.toString(), yyline+1, yycolumn+1 ));
    }

    private Symbol symbolWithoutValue(int type){
        System.out.println("Encontrando: "+EstructuraParserSym.terminalNames[type]);
        return new Symbol(type, new Token(type, null, yyline+1, yycolumn+1 ));
    }

%}
%eofval{
    return symbolWithoutValue(EOF);
%eofval}
%eofclose

SALTO_LINEA = \r|\n|\r\n
ESPACIO_BLANCO = {SALTO_LINEA}|[ \t\f]
ESTRUCTURA = "estructura"
ESTRUCTURAS = "estructuras"
RELACION = "relacion"
INT = "int"
DOUBLE = "double"
BOOLEAN = "boolean"
CHAR = "char"
STRING = "String" | "string"
LESS = "<"
GREATER = ">"
TABLA = "tabla"
CLAVE = "clave"
PADRE = "padre"
NAME = [a-zA-Z0-9_#\|!\?\"½~¬]+
DIAGONAL = "/"

%%

<YYINITIAL> {

    {ESPACIO_BLANCO}    {;}
    {LESS}                                  {return symbolWithoutValue(LESS);}
    {GREATER}                               {return symbolWithoutValue(GREATER);}
    {ESTRUCTURA}                            {return symbolWithoutValue(ESTRUCTURA);}
    {ESTRUCTURAS}                           {return symbolWithoutValue(ESTRUCTURAS);}
    {RELACION}                              {return symbolWithoutValue(RELACION);}
    {CLAVE}                                 {return symbolWithoutValue(CLAVE);}
    {TABLA}                                 {return symbolWithoutValue(TABLA);}
    {PADRE}                                 {return symbolWithoutValue(PADRE);}
    {INT}                                   {return symbolWithoutValue(INT);}
    {DOUBLE}                                {return symbolWithoutValue(DOUBLE);}
    {CHAR}                                  {return symbolWithoutValue(CHAR);}
    {BOOLEAN}                               {return symbolWithoutValue(BOOLEAN);}
    {STRING}                                {return symbolWithoutValue(STRING);}
    {DIAGONAL}                              {return symbolWithoutValue(DIAGONAL);}
    {NAME}                                  {return symbolWithValue(NAME, yytext());}

}