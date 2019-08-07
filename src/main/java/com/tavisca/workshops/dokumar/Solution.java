package com.tavisca.workshops.dokumar;

import java.util.regex.Pattern;

public class Solution {

    public Double howMuchQuestionSolver(String sentence) {
        SentenceToRomanString sentenceToRomanString= new SentenceToRomanString();
        String roman=sentenceToRomanString.romanConverter(sentence);
        if(roman.equals("invalid"))
            return -1.0;
        else {
            RomanNumeralToDecimalNumber romanString = new RomanNumeralToDecimalNumber();
            System.out.println(roman);
            Double credits = romanString.romanToDecimalConvertor(roman);
            return credits;
        }
    }

    public Double howManyTypeQuestionSolver(String[] strings) {
        SentenceToRomanString sentence = new SentenceToRomanString();
        String roman=sentence.romanConverter(strings[0]);
        if(roman.equals("invalid"))
            return -1.0;
        else {
            RomanNumeralToDecimalNumber romanString = new RomanNumeralToDecimalNumber();
            ItemCreditMap itemCredit = new ItemCreditMap();
            if(itemCredit.itemCreditMap.get(strings[1])!=null)
                return romanString.romanToDecimalConvertor(roman) * itemCredit.itemCreditMap.get(strings[1]);
            else
                return -1.0;
        }
    }
}
