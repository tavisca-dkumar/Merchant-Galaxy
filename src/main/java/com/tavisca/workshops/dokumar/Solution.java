package com.tavisca.workshops.dokumar;

public class Solution {

    public Double howMuchQuestionSolver(String sentence) {
        SentenceToRomanString sentenceToRomanString= new SentenceToRomanString();
        String roman=sentenceToRomanString.romanConverter(sentence);
        if(roman.equals("invalid"))
            return -1.0;
        else {
            RomanNumeralToDecimalNumber romanString = new RomanNumeralToDecimalNumber();
            Double credits = romanString.decimalConvertor(roman);
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
            Double romanValue=romanString.decimalConvertor(roman);
            if(romanValue==-1.0)
                    return -1.0;
            MetalCreditMap mapObject = new MetalCreditMap();
            if(mapObject.metalCreditMapper.get(strings[1])!=null)
                return romanValue * mapObject.metalCreditMapper.get(strings[1]);
            else
                return -1.0;
        }
    }
}
