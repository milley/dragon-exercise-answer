package com.milley.dragon.ch02.lexer;

/**
 * @author milley
 */
public class Token {
    public final int tag;
    public Token(int t) {
        tag = t;
    }

    @Override
    public String toString() {
        return "Token{" +
                "tag=" + tag +
                '}';
    }
}
