package com.tavisca.workshops.dokumar;

import java.util.ArrayList;
import java.util.List;

public class MerchantParser {

    public List<String> merchantParse(String[] input) {
        Merchant merchant=new Merchant();
        List<String> finalSolution = new ArrayList<>();
        for (String sentence :input) {
            if (sentence.contains("much")||sentence.contains("many")){
                //solvesGalaxyQuery
                String solution= merchant.ask(sentence);
                finalSolution.add(solution);
            }
            else
                merchant.tell(sentence); //updateGalaxyLanguageInfo
        }
        return finalSolution;
    }
    public static void main(String args[])
    {
        String input[]=new String[]{"glob is I",
                                    "prok is V",
                                    "pish is X",
                                    "tegj is L",
                                    "glob glob Silver is 34 Credits",
                                    "glob prok Gold is 57800 Credits",
                                    "pish pish Iron is 3910 Credits",
                                    "how much is pish tegj glob glob ?",
                                    "how many Credits is glob prok Silver ?",
                                    "how many Credits is glob prok Gold ?",
                                    "how many Credits is glob prok Iron ?",
                                    "how much wood could a woodchuck chuck if a woodchuck could chuck wood ?"};
        MerchantParser merchantParser=new MerchantParser();
        List<String> finalSolution= merchantParser.merchantParse(input);
        System.out.println(finalSolution);
    }
}
