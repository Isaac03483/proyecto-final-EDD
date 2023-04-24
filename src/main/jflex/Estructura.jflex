package com.mio.compiler.lexer;

import com.mio.compiler.Token;
import java_cup.runtime.Symbol;

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
        return new Symbol(type, new Token(type, value.toString(), yyline+1, yycolumn+1 ));
    }

    private Symbol symbolWithoutValue(int type){
        return new Symbol(type, new Token(type, null, yyline+1, yycolumn+1 ));
    }

%}
%eofval{
    return symbolWithoutValue(EOF);
%eofval}
%eofclose

ESTRUCTURA = "estructura"
LBRACE = "<"
RBRACE = ">"
TABLA = "tabla"
CLAVE = "clave"
NAME = .+
DIAGONAL = "/"

%%

<YYINITIAL> {

    {ESTRUCTURA}                            {return symbolWithoutValue(ESTRUCTURA);}
    {CLAVE}                                 {return symbolWithoutValue(CLAVE);}
    {TABLA}                                 {return symbolWithoutValue(TABLA);}
    {DIAGONAL}                              {return symbolWithoutValue(DIAGONAL);}
    {LBRACE}                                {return symbolWithoutValue(LBRACE);}
    {RBRACE}                                {return symbolWithoutValue(RBRACE);}
    {NAME}                                  {return symbolWithValue(NAME, yytext());}

}