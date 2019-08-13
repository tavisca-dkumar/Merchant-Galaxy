package com.tavisca.workshops.dokumar;

public class Solution {

    public Double howMuchQuestionSolver(String sentence) {
        RomanConvertor romanConvertor = new RomanConvertor();
        String roman= romanConvertor.convertToRoman(sentence);
        if(roman.equals("invalid"))
            return -1.0;
        else {
            DecimalConvertor romanString = new DecimalConvertor();
            Double credits = romanString.convertToDecimal(roman);
            return credits;
        }
    }

    public Double howManyTypeQuestionSolver(String[] strings) {
        RomanConvertor sentence = new RomanConvertor();
        String roman=sentence.convertToRoman(strings[0]);
        if(roman.equals("invalid"))
            return -1.0;
        else {
            DecimalConvertor romanString = new DecimalConvertor();
            Double romanValue=romanString.convertToDecimal(roman);
            if(romanValue==-1.0)
                    return -1.0;
            ItemAliasPrice mapObject = new ItemAliasPrice();
            if(mapObject.itemAliasPrice.get(strings[1])!=null)
                return romanValue * mapObject.itemAliasPrice.get(strings[1]);
            else
                return -1.0;
        }
    }
}
