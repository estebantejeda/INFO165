package codigo;
import java_cup.runtime.*;
import java_cup.runtime.*;
import static codigo.Tokens.*;
%%
%class Lexer
%type Tokens
L1= [L]+
L=[a-zA-Z]+
D=[0-9]+

espacio=[ \t\r\f\n]+
%{
    public String lexeme;
%}
%%
( "PARTIR" ) {lexeme=yytext(); return PARTIR;}
( "INICIAR" ) {lexeme=yytext(); return INICIAR;}
( "METER" ) {lexeme=yytext(); return METER;}

( "SACAR" ) {lexeme=yytext(); return SACAR;}
( "MIRAR" ) {lexeme=yytext(); return MIRAR;}
( "DATO"  ) {lexeme=yytext(); return DATO;}
( "FINALIZAR" ) {lexeme=yytext(); return FINALIZAR;}

("(") {lexeme=yytext(); return Pa;}
(")") {lexeme=yytext(); return Pc;}
(",") {lexeme=yytext(); return COMA;}

{espacio} {/*Ignore*/}
{L1}({L}|{D})* {D} {lexeme=yytext(); return ID;}
{D}+ {lexeme=yytext(); return NUM;}


  . {return ERROR;}
































