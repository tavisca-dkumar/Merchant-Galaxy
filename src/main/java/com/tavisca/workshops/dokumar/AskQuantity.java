package com.tavisca.workshops.dokumar;

import java.util.regex.Pattern;

public class AskQuantity implements SolveQuery {
    @Override
    public String answer(String sentence) {
        QueryParser queryParser = new QueryParser();
        String creditString = queryParser.muchParse(sentence);
        RomanConvertor romanConvertor = new RomanConvertor();
        String roman= romanConvertor.convertToRoman(creditString);
        if(roman.equals("invalid"))
            return new ErrorMessage().getError();
        else {
            DecimalConvertor romanString = new DecimalConvertor();
            Double credits = romanString.convertToDecimal(roman);
            if (credits != -1.0) {
                String creditsAsString = credits.toString();
                if (Pattern.matches(".*\\.0", creditsAsString)) {
                    int credit = credits.intValue();
                    return creditString+" is " + credit;
                } else
                    return creditString+" is " + credits.toString();
            } else
                return new ErrorMessage().getError();
        }
    }
}
