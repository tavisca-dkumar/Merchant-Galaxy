package com.tavisca.workshops.dokumar;

import java.util.regex.Pattern;

public class GalaxyLanguage {
    public void storeLanguageInfo(String inputSentance) {
        if(Pattern.matches(".*is .",inputSentance)){
            WordToRomanParse wordToRomanParse = new WordToRomanParse();
            String splits[]=wordToRomanParse.parse(inputSentance);
            TokenRomanMap tokenObject = new TokenRomanMap();
            tokenObject.tokenRomanHashMap.put(splits[0],splits[1].charAt(0));
        }
        else if(Pattern.matches(".*Credits",inputSentance))
        {
            SentanceToCreditParse sentanceToCreditParse=new SentanceToCreditParse();
            String splits[]=sentanceToCreditParse.parse(inputSentance);
            ItemCreditCalculator itemCreditCalculator=new ItemCreditCalculator();
            Double value=itemCreditCalculator.metalCreditCalculation(splits[0],splits[1],splits[2]);
            ItemCreditMap itemObject = new ItemCreditMap();
            itemObject.itemCreditMap.put(splits[1],value);
        }
        else
            System.out.println("I have no idea what you are talking about");
    }
}
