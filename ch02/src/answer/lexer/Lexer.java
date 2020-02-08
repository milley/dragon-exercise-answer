package com.milley.dragon.ch02.lexer;

import java.io.IOException;
import java.util.Hashtable;

/**
 * @author milley
 */
public class Lexer {
    private static final char SLASH = '/';
    private static final char STAR = '*';
    private static final char EQUAL = '=';
    private static final char POINT = '.';
    private static final String RELATION_STRINGS = "<=!>";

    public int line = 1;
    private char peek = ' ';
    private Hashtable words = new Hashtable();

    void reserve(Word t) {
        words.put(t.lexeme, t);
    }

    public Lexer() {
        reserve(new Word(Tag.TRUE, "true"));
        reserve(new Word(Tag.FALSE, "false"));
    }

    public Token scan() throws IOException, SyntaxException, NumberFormatException {
        for (; ; peek = (char)System.in.read()) {
            if (peek == ' ' || peek == '\t') {
                continue;
            }
            else if (peek == '\n') {
                line = line + 1;
            } else {
                break;
            }
        }
        // Handle comment
        if (peek == SLASH) {
            peek = (char)System.in.read();
            if (peek == SLASH) {
                for (; ; peek = (char)System.in.read()) {
                    if (peek == '\n') {
                        break;
                    }
                }
            } else if (peek == STAR) {
                char prevPeek = ' ';
                for (; ; prevPeek = peek, peek = (char)System.in.read()) {
                    if (prevPeek == STAR && peek == SLASH) {
                        break;
                    }
                }
            } else {
                throw new SyntaxException();
            }
        }

        // Handle relation operator
        if (RELATION_STRINGS.indexOf(peek) != -1) {
            StringBuffer b = new StringBuffer();
            b.append(peek);
            peek = (char)System.in.read();
            if (peek == EQUAL) {
                b.append(peek);
            }
            return new Rel(b.toString());
        }

        if (Character.isDigit(peek) || peek == POINT) {
            boolean isDotExist = false;
            StringBuffer b = new StringBuffer();

            do {
                if (peek == POINT) {
                    isDotExist = true;
                }
                b.append(peek);
                peek = (char)System.in.read();
            } while (isDotExist ? Character.isDigit(peek) : Character.isDigit(peek) || peek == POINT);
            return new Num(Float.parseFloat(b.toString()));
        }
        if (Character.isLetter(peek)) {
            StringBuffer b = new StringBuffer();
            do {
                b.append(peek);
                peek = (char)System.in.read();
            } while (Character.isLetterOrDigit(peek));
            String s = b.toString();
            Word w = (Word)words.get(s);
            if (w != null) {
                return w;
            }
            w = new Word(Tag.ID, s);
            words.put(s, w);
            return w;
        }
        Token t = new Token(peek);
        peek = ' ';
        return t;
    }

    public static void main(String[] args) {
        Lexer lexer = new Lexer();
        try {
            Token t = lexer.scan();
            System.out.println(t);
        } catch (IOException | SyntaxException e) {
            e.printStackTrace();
        }
    }
}
