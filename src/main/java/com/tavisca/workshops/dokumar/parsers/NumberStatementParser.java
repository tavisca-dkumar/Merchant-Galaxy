package com.tavisca.workshops.dokumar.parsers;

public class NumberStatementParser {

    public static String[] parse(String input) {
        String splits[]=input.split(" ");
        return new String[]{splits[0],splits[2]};
    }
}
