package com.tavisca.workshops.dokumar;

import java.util.regex.Pattern;

public class AskCredits implements SolveQuery{

    @Override
    public String answer(String sentence) {
        QueryParser queryParser = new QueryParser();
        String[] strings = queryParser.manyParse(sentence);
        RomanConvertor convertor = new RomanConvertor();
        String roman=convertor.convertToRoman(strings[0]);
        if(roman.equals("invalid"))
            return new ErrorMessage().getError();
        else {
            DecimalConvertor romanString = new DecimalConvertor();
            Double romanValue=romanString.convertToDecimal(roman);
            if(romanValue==-1.0)
                return "I have no idea what you are talking about";
            ItemAliasPrice mapObject = new ItemAliasPrice();
            if(mapObject.itemAliasPrice.get(strings[1])!=null) {

                Double value= romanValue * mapObject.itemAliasPrice.get(strings[1]);
                String creditsInString=value.toString();
                if (Pattern.matches(".*\\.0", creditsInString)) {
                    int credit =value.intValue();
                    return strings[0] + " " + strings[1] + " " + "is " + credit + " Credits";
                } else
                    return strings[0] + " " + strings[1] + " " + "is " + creditsInString + " Credits";
            }
            else
                return new ErrorMessage().getError();
        }

    }
}
