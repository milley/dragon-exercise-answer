package com.milley.dragon.ch02;

import java.io.IOException;

/**
 * @author milley
 */
class Parser{
    private static int lookahead;

    Parser() throws IOException {
        lookahead = System.in.read();
    }

    void expr() throws IOException {
        term();
        while (true) {
            if (lookahead == '+') {
                match('+');
                term();
                System.out.write('+');
            } else if (lookahead == '-') {
                match('-');
                term();
                System.out.write('-');
            } else {
                return;
            }
        }
    }

    void term() throws IOException {
        if (Character.isDigit((char)lookahead)) {
            System.out.write((char)lookahead);
            match(lookahead);
        } else {
            throw new Error("syntax error");
        }
    }

    void match(int t) throws IOException {
        if (lookahead == t) {
            lookahead = System.in.read();
        } else {
            throw new Error("syntax error");
        }
    }
}

/**
 * @author milley
 */
public class Postfix {
    public static void main(String[] args) throws IOException {
        Parser parser = new Parser();
        parser.expr();
        System.out.write('\n');
    }
}
