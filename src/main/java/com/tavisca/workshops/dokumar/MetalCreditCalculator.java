package com.tavisca.workshops.dokumar;

public class MetalCreditCalculator {
    public Double metalCreditCalculation(String metalContainedSentence, String item, String totalCredit) {
       RomanNumeralToDecimalNumber romanNumeralToDecimalNumber=new RomanNumeralToDecimalNumber();
        SentenceToRomanString sentenceToRomanString=new SentenceToRomanString();
        String roman=sentenceToRomanString.romanConverter(metalContainedSentence);
        Double valueOfRomannumeral= romanNumeralToDecimalNumber.decimalConvertor(roman);
        if(valueOfRomannumeral!=-1.0)
            return Double.parseDouble(totalCredit)/valueOfRomannumeral;
        else
            return -1.0;
    }
}
