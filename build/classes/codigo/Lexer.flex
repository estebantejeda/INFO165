package codigo;
import static codigo.Tokens.*;
%%
%class Lexer
%type Tokens
L=[a-zA-Z_]+
L1=[L]+
D=[0-9]+
P=[1-8]+
espacio=[]+
%{
    public String lexeme;
%}
%%

/* Espacios en blanco */
{espacio} {/*Ignore*/}

/* Palabras reservadas */
( PARTIR )   {lexeme=yytext(); return PARTIR;}
( INICIAR )  {lexeme=yytext(); return INICIAR;}
( METER )    {lexeme=yytext(); return METER;}
( SACAR )    {lexeme=yytext(); return SACAR;}
( MIRAR )    {lexeme=yytext(); return MIRAR;}
( DATO )     {lexeme=yytext(); return DATO;}
( FINALIZAR ) {lexeme=yytext(); return FINALIZAR;}

/* Simbolos */
( "(" ) {lexeme=yytext(); return PAR_A;}
( ")" ) {lexeme=yytext(); return PAR_C;}
( "," ) {lexeme=yytext(); return COMA;}

/* Identificadores */
{L1}({L}|{D})*{D} {lexeme=yytext(); return ID;}
{D}+ {lexeme=yytext(); return NUM;}
{P} {lexeme=yytext(); return POS;}

 . {return ERROR;}

