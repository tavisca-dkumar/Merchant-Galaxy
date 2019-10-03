package com.tavisca.workshops.dokumar;

import com.tavisca.workshops.dokumar.queries.AskCredits;
import com.tavisca.workshops.dokumar.queries.AskQuantity;

import java.util.regex.Pattern;

public class QuerySolver {
    private int credit = 0;

    public String solveQuery(String sentence) {
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
