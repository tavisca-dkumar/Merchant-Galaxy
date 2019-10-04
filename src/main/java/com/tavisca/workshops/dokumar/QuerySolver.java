package com.tavisca.workshops.dokumar;

import com.tavisca.workshops.dokumar.queries.AskCredits;
import com.tavisca.workshops.dokumar.queries.AskQuantity;
import com.tavisca.workshops.dokumar.queries.QueriesFactoryClass;

import java.util.regex.Pattern;

public class QuerySolver {

    public String solveQuery(String sentence) {
        QueriesFactoryClass queriesFactoryClass=new QueriesFactoryClass();
        return queriesFactoryClass.queryProcess(sentence);
    }
}
