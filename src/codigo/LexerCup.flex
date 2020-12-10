package codigo;
import java_cup.runtime.Symbol;
%%
%class LexerCup
%type java_cup.runtime.Symbol
%cup
%full
%line
%char
L=[a-zA-Z_]+
L1=[L]+
D=[0-9]+
P=[1-8]+
espacio=[]+
%{
    private Symbol symbol(int type, Object value){
        return new Symbol(type, yyline, yycolumn, value);
    }
    private Symbol symbol(int type){
        return new Symbol(type, yyline, yycolumn);
    }
%}
%%

/* Espacios en blanco */
{espacio} {/*Ignore*/}

/* Palabras reservadas */
( PARTIR )    {return new Symbol(sym.PARTIR, yychar, yyline, yytext());}
( INICIAR )   {return new Symbol(sym.INICIAR, yychar, yyline, yytext());}
( METER )     {return new Symbol(sym.METER, yychar, yyline, yytext());}
( SACAR )     {return new Symbol(sym.SACAR, yychar, yyline, yytext());}
( MIRAR )     {return new Symbol(sym.MIRAR, yychar, yyline, yytext());}
( DATO  )     {return new Symbol(sym.DATO, yychar, yyline, yytext());}
( FINALIZAR ) {return new Symbol(sym.FINALIZAR, yychar, yyline, yytext());}

/* Simbolos */
( "(" )       {return new Symbol(sym.PAR_A, yychar, yyline, yytext());}
( ")" )       {return new Symbol(sym.PAR_C, yychar, yyline, yytext());}
( "," )       {return new Symbol(sym.COMA, yychar, yyline, yytext());}

/* Identificadores */
{L1}({L}|{D})*{D} {return new Symbol(sym.ID, yychar, yyline, yytext());}
{D}+ {return new Symbol(sym.NUM, yychar, yyline, yytext());}
{P} {return new Symbol(sym.POS, yychar, yyline, yytext());}

 .  {return new Symbol(sym.ERROR, yychar, yyline, yytext());}
 
 