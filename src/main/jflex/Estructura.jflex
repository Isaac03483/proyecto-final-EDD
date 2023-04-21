package com.mio.compiler.lexer;

import com.mio.compiler.Token;

%%

%public
%class JsonLexer
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


%%