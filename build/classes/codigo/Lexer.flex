package codigo;
import static codigo.Tokens.*;
%%
%class Lexer
%type Tokens
L1= [L]+
L=[a-zA-Z]+
D=[0-9]+
espacio=[ ]+
%{
    public String lexeme;
%}
%%
PARTIR |
INICIAR |
METER |
SACAR |
MIRAR |
DATO |
FINALIZAR {lexeme=yytext(); return Reservada;}
{espacio} {/*Ignore*/}
{L1}({L}|{D})* {D} {lexeme=yytext(); return Identificador;}
{D}+ {lexeme=yytext(); return Constante_Entera;}
"("|")"|"," {lexeme=yytext(); return Simbolo;}
 . {return ERROR;}
