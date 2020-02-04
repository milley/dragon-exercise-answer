/*
 * Copyright [2020] <Copyright milley>
 */
void S() {
  /* S->0 S 1 | 0 1 */
  switch(lookahead) {
    case "0":
      match("0");
      S();
      match("1");
    case "1":
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
