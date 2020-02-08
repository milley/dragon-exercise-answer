/*
 * Copyright [2020] <Copyright milley>
 */
void S() {
  /* S->+ S S | - S S | a */
  switch (lookahead) {
    case "+":
      match("+");
      S();
      S();
      break;
    case "-":
      match("-");
      S();
      S();
      break;
    case "a":
      match("a");
      break;
    default:
      report("syntax error");
  }
}

void match(terminal t) {
  if (lookahead == t) {
    lookahead = nextTerminal;
  } else {
    report("syntax error");
  }
}
