package com.tavisca.workshops.dokumar;

public class ItemPriceCalculator {
    public Double itemPriceCalculation(String metalContainedSentence, String item, String totalCredit) {
       DecimalConvertor decimalConvertor =new DecimalConvertor();
        RomanConvertor romanConvertor =new RomanConvertor();
        String roman= romanConvertor.convertToRoman(metalContainedSentence);
        Double valueOfRomannumeral= decimalConvertor.convertToDecimal(roman);
        if(valueOfRomannumeral!=-1.0)
            return Double.parseDouble(totalCredit)/valueOfRomannumeral;
        else
            return -1.0;
    }
}
