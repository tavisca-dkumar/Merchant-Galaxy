package com.tavisca.workshops.dokumar;

import java.util.regex.Pattern;

public class GalaxyLanguage {
    public void storeLanguageInfo(String inputSentance) {
        if(Pattern.matches(".*is .",inputSentance)){
            NumberStatementParser numberStatementParser = new NumberStatementParser();
            String splits[]= numberStatementParser.parse(inputSentance);
            NumberAliasStatements mapObject = new NumberAliasStatements();
            mapObject.numberAliasStatement.put(splits[0],splits[1].charAt(0));
        }
        else if(Pattern.matches(".*Credits",inputSentance))
        {
            ItemParse itemParse =new ItemParse();
            String splits[]= itemParse.parser(inputSentance);
            ItemPriceCalculator itemPriceCalculator =new ItemPriceCalculator();
            Double value= itemPriceCalculator.itemPriceCalculation(splits[0],splits[1],splits[2]);
            ItemAliasPrice metalObject = new ItemAliasPrice();
            if(value!=-1.0)
                metalObject.itemAliasPrice.put(splits[1],value);
        }
        else
            System.out.println("I have no idea what you are talking about");
    }
}
