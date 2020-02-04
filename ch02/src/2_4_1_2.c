/*
 * Copyright [2020] <Copyright milley>
 */
void S() {
  /* S->S ( S ) S | ε */
  if (lookahead == "(") {
    match("(");
    S();
    match(")");
    S();
  }
}

void match(terminal t) {
  if (lookahead == t) {
    lookahead = nextTerminal;
  } else {
    report("syntax error");
  }
}
