package com.tavisca.workshops.dokumar;

public class MerchantParser {

    public void merchantParse(String inputSentance) {
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
