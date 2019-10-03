package com.tavisca.workshops.dokumar;

public class Merchant {
    public  void tell(String sentance){
        GalaxyLanguage galaxyLanguage=new GalaxyLanguage();
        galaxyLanguage.storeLanguageInfo(sentance);
    }

    public String ask(String sentance){
        QuerySolver querySolver =new QuerySolver();
        String answer= querySolver.solveQuery(sentance);
        return answer;
    }
}
