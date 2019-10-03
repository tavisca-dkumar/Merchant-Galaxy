package com.tavisca.workshops.dokumar.languageinfo;

import com.tavisca.workshops.dokumar.ItemPriceCalculator;
import com.tavisca.workshops.dokumar.LanguageTrainer;
import com.tavisca.workshops.dokumar.parsers.ItemParser;

import java.util.HashMap;

public class ItemAliasPrice implements LanguageTrainer {
    public static HashMap<String,Double> itemAliasPrice = new HashMap<>();

    @Override
    public void train(String sentence) {
        ItemParser itemParser =new ItemParser();
        String splits[]= itemParser.parser(sentence);
        ItemPriceCalculator itemPriceCalculator =new ItemPriceCalculator();
        Double value= itemPriceCalculator.itemPriceCalculation(splits[0],splits[1],splits[2]);
        if(value!=-1.0)
            itemAliasPrice.put(splits[1], value);
    }
}
