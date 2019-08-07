package com.tavisca.workshops.dokumar;

public class ItemCreditCalculator {
    public Double metalCreditCalculation(String metalContainedSentence, String item, String totalCredit) {
//        String splits[]=metalContainedSentence.split(" ");
////        Double metalCredits;
       RomanNumeralToDecimalNumber romanNumeralToDecimalNumber=new RomanNumeralToDecimalNumber();
//        TokenRomanMap object = new TokenRomanMap();
//        String roman="";
//        for(String var:splits){
//            roman+=object.tokenRomanHashMap.get(var);
//        }
        SentenceToRomanString sentenceToRomanString=new SentenceToRomanString();
        String roman=sentenceToRomanString.romanConverter(metalContainedSentence);
        Double valueOfRomannumeral= romanNumeralToDecimalNumber.romanToDecimalConvertor(roman);
        return Double.parseDouble(totalCredit)/valueOfRomannumeral;
    }
}
