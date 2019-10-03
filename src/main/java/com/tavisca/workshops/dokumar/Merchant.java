package com.tavisca.workshops.dokumar;

public class Merchant {
    public  void tell(String sentance){
        GalaxyLanguage galaxyLanguage=new GalaxyLanguage();
        galaxyLanguage.storeLanguageInfo(sentance);
    }

    public String ask(String sentance){
        GalaxyQuery galaxyQuery=new GalaxyQuery();
        String answer=galaxyQuery.solveQuery(sentance);
        return answer;
    }
}
