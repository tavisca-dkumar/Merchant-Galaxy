package com.tavisca.workshops.dokumar;

import com.tavisca.workshops.dokumar.languageinfo.LanguageFactoryClass;

public class Merchant {
    public  void tell(String sentance){
        LanguageFactoryClass languageFactoryClass =new LanguageFactoryClass();
        languageFactoryClass.storeLanguageProcess(sentance);
    }

    public String ask(String sentance){
        QuerySolver querySolver =new QuerySolver();
        String answer= querySolver.solveQuery(sentance);
        return answer;
    }
}
