package com.milley.dragon.ch02.lexer;

/**
 * @author milley
 */
public class Num extends Token {
    public final float value;
    public Num(float f) {
        super(Tag.NUM);
        value = f;
    }

    @Override
    public String toString() {
        return "Num{" +
                "value=" + value +
                ", tag=" + tag +
                '}';
    }
}
