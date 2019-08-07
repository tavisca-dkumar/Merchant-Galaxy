package com.tavisca.workshops.dokumar;

public class MainInputParser {

    public void mainParse(String inputSentance) {
        if (inputSentance.contains("much")||inputSentance.contains("many")){
            //solvesGalaxyQuery
            GalaxyQuery galaxyQuery=new GalaxyQuery();
            String solution=galaxyQuery.solveQuery(inputSentance);
            System.out.println(solution);
        }
        else
        {
            //galaxyLanguageInfo
            GalaxyLanguage galaxyLanguage=new GalaxyLanguage();
            galaxyLanguage.storeLanguageInfo(inputSentance);
        }
    }
}
