package com.tavisca.workshops.dokumar;

public class MerchantParse {

    public void merchantParser(String inputSentance) {
        if (inputSentance.contains("much")||inputSentance.contains("many")){
            //solvesGalaxyQuery
            GalaxyQuery galaxyQuery=new GalaxyQuery();
            String solution=galaxyQuery.solveQuery(inputSentance);
            System.out.println(solution);
        }
        else
        {
            //updateGalaxyLanguageInfo
            GalaxyLanguage galaxyLanguage=new GalaxyLanguage();
            galaxyLanguage.storeLanguageInfo(inputSentance);
        }
    }
}
