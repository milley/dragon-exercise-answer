%{

%}

letter 	[a-zA-Z]
digit 	[0-9]

/* [w-W][h-H][i-I][l-L][e-E] works too. */
where (?i:where)

from	(?i:from)
select	(?i:select)
id	{letter}({letter}|{digit})*

%%
{where} 	{ printf("WHERE KEYWORD"); return (WHERE); }
{from} 		{ printf("FROM KEYWORD"); return (FROM); }
{select}	{ printf("SELECT KEYWORD"); return (SELECT); }
{id}		{ printf("ID"); yytext = lowercase(yytext); yylval = (int) installID(); return (ID); }	
%%


int installID(){
	/* We've to convert the lexeme to lowercase and install it 
	example:
		yytext: foO
		yytext = lowercase(yytext)
		yylval = (int) installID()
		yytext: Strstr
		yytext = lowercase(yytext)
		yylval = (int) installID()
		
		yytext: strstr (already exists in the symbol table)
		yytext = lowercase(yytext)
		yylval = (int) installID()
	*/
}
