class For extends Stmt {
  Expr E1, E2, E3;
  Stmp S;
  public For(Expr expr1, Expr expr2, Expr expr3, Stmt stmt) {
    E1 = expr1;
    E2 = expr2;
    E3 = expr3;
    S = stmt;
  }

  public void gen() {
    E1.gen();
    Label start = new Label();
    Label end = new Label();
    emit("ifFalse " + E2.rvalue().toString() + " goto " + end);
    S.gen();
    E3.gen();
    emit("goto " + start);
    emit(end + ":");
  }
}