package com.tavisca.workshops.dokumar;

import java.util.regex.Pattern;

public class GalaxyLanguage {
    public void storeLanguageInfo(String inputSentance) {
        if(Pattern.matches(".*is .",inputSentance)){
            GalaxyRomanNumberParse galaxyRomanNumberParse = new GalaxyRomanNumberParse();
            String splits[]=galaxyRomanNumberParse.parser(inputSentance);
            GalaxyRomanMap mapObject = new GalaxyRomanMap();
            mapObject.galaxyRomanMapper.put(splits[0],splits[1].charAt(0));
        }
        else if(Pattern.matches(".*Credits",inputSentance))
        {
            MetalParse metalParse=new MetalParse();
            String splits[]=metalParse.metalParser(inputSentance);
            MetalCreditCalculator metalCreditCalculator=new MetalCreditCalculator();
            Double value=metalCreditCalculator.metalCreditCalculation(splits[0],splits[1],splits[2]);
            MetalCreditMap metalObject = new MetalCreditMap();
            if(value!=-1.0)
                metalObject.metalCreditMapper.put(splits[1],value);
        }
        else
            System.out.println("I have no idea what you are talking about");
    }
}
