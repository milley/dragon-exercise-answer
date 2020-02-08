package com.milley.dragon.ch02.lexer;

/**
 * @author milley
 */
public class Word extends Token {
    public final String lexeme;
    public Word(int t, String n) {
        super(t);
        lexeme = n;
    }

    @Override
    public String toString() {
        return "Word{" +
                "lexeme='" + lexeme + '\'' +
                ", tag=" + tag +
                '}';
    }
}
