package com.tavisca.workshops.dokumar;

public class WordToRomanParse {

    public static String[] parse(String input) {
        String splits[]=input.split(" ");
        return new String[]{splits[0],splits[2]};
    }
}
