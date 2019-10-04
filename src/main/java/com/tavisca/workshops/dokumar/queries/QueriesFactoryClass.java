package com.tavisca.workshops.dokumar.queries;

import com.tavisca.workshops.dokumar.ErrorMessage;

import java.util.regex.Pattern;

public class QueriesFactoryClass {
    public String queryProcess(String sentence){
        if (Pattern.matches("how much is.*", sentence)) {
            AskQuantity askQuantity=new AskQuantity();
            return askQuantity.answer(sentence);

        } else if (Pattern.matches("how many Credits.*", sentence)) {
            AskCredits askCredits= new AskCredits();
            return askCredits.answer(sentence);

        } else
            return new ErrorMessage().getError();
    }
}
