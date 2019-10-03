package com.tavisca.workshops.dokumar;

import java.util.HashMap;

public class NumberAliasStatements implements LanguageTrainer {
    public static HashMap<String,Character> numberAliasStatement = new HashMap<>();

    @Override
    public void train(String sentence) {
        NumberStatementParser numberStatementParser = new NumberStatementParser();
        String splits[]= numberStatementParser.parse(sentence);
        numberAliasStatement.put(splits[0],splits[1].charAt(0));
    }
}
