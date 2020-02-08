package com.milley.dragon.ch02.lexer;

/**
 * @author milley
 */
public class Rel extends Token {
    public final String lexeme;
    public Rel (String s) {
        super(Tag.REL);
        lexeme = s;
    }
}
