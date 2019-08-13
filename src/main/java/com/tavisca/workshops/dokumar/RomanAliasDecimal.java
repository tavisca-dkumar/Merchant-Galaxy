package com.tavisca.workshops.dokumar;

import java.util.HashMap;

public class RomanAliasDecimal {


    public static final HashMap<Character,Double> romanDataMap
            =new HashMap<Character, Double>()
    {{
        put('I',1.0);
        put('V',5.0);
        put('X',10.0);
        put('L',50.0);
        put('C',100.0);
        put('D',500.0);
        put('M',1000.0);
    }};
}
