
/*** Definition Section has one variable
which can be accessed inside yylex()
and main() ***/
%{
  #include<string.h>

  char *string[1024] = {NULL};
  int count[1024] = {0};
%}
 
/*** Rule Section has three rules, first rule
matches with capital letters, second rule
matches with any character except newline and
third rule does not take input after the enter***/
%%
" " { /* DO NOTHING ON SPACE */}

[a-zA-Z]* {
  int i = 0;
  for (i = 0; i < 1024; i++){
    if (string[i] == NULL){
      // add the string to array
      string[i] = malloc(sizeof(char) * strlen(yytext));
      memcpy(string[i], yytext, strlen(yytext));
      count[i] = 1;
      break;
    } 
    if (strcmp(string[i], yytext) == 0) {
      count[i] += 1;
      break;
    }
  }
}

\n {
  return 0;
}
%%
 
/*** Code Section prints the number of
capital letter present in the given input***/
int yywrap(){}
int main(){
 
// Explanation:
// yywrap() - wraps the above rule section
/* yyin - takes the file pointer
          which contains the input*/
/* yylex() - this is the main flex function
          which runs the Rule Section*/
// yytext is the text in the buffer
 
// Uncomment the lines below
// to take input from file
// FILE *fp;
// char filename[50];
// printf("Enter the filename: \n");
// scanf("%s",filename);
// fp = fopen(filename,"r");
// yyin = fp;
 
yylex();
// printf("\nNumber of Capital letters "
//      "in the given input - %d\n", count);

for (int j = 0; j < 1024; j++){
  if (string[j] == NULL) break;

  printf("%s : %d\n", string[j], count[j]);
}

return 0;
}
