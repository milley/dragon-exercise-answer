package com.milley.dragon.ch02.lexer;

/**
 * @author milley
 */
public class Num extends Token {
    public final int value;
    public Num(int v) {
        super(Tag.NUM);
        value = v;
    }

    @Override
    public String toString() {
        return "Num{" +
                "value=" + value +
                ", tag=" + tag +
                '}';
    }
}
