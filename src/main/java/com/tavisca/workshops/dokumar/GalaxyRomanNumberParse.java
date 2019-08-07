package com.tavisca.workshops.dokumar;

public class GalaxyRomanNumberParse {

    public static String[] parser(String input) {
        String splits[]=input.split(" ");
        return new String[]{splits[0],splits[2]};
    }
}
