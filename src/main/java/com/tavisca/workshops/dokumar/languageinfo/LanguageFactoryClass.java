package com.tavisca.workshops.dokumar.languageinfo;

import com.tavisca.workshops.dokumar.languageinfo.ItemAliasPrice;
import com.tavisca.workshops.dokumar.languageinfo.NumberAliasStatements;

import java.util.regex.Pattern;

public class LanguageFactoryClass {
    public void storeLanguageProcess(String sentence) {
        if(Pattern.matches(".*is .",sentence)){
            NumberAliasStatements numberAliasStatements=new NumberAliasStatements();
            numberAliasStatements.train(sentence);
        }
        else if(Pattern.matches(".*Credits",sentence))
        {
           ItemAliasPrice itemAliasPrice=new ItemAliasPrice();
           itemAliasPrice.train(sentence);
        }
        else
            System.out.println("I have no idea what you are talking about");
    }
}
