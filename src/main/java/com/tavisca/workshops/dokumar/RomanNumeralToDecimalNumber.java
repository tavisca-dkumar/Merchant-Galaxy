package com.tavisca.workshops.dokumar;

public class RomanNumeralToDecimalNumber {
    private final String[] inValidRoman=new String[]{"VV","LL","DD","IIII","XXXX","CCCC","MMMM","VL","VC","VD",
            "VM","VX","LC","LD","LM","DM","XD","IL","IC","ID","IM"};
    public Boolean isValidRomanNumeral(String romanNumeral)
    {
        for(String var: inValidRoman){
            if(romanNumeral.contains(var))
                return false;
        }
        return true;
    }

    public Double decimalConvertor(String romanNumeral) {
        if(isValidRomanNumeral(romanNumeral))
        {
            Double sum=0.0;
            for(int i=0;i<romanNumeral.length();i++)
            {
                if((i!=romanNumeral.length()-1)&&
                        (ValuesOfRomanData.romanDataMap.get(romanNumeral.charAt(i))<ValuesOfRomanData.romanDataMap.get(romanNumeral.charAt(i+1))))
                {
                    sum = sum + ValuesOfRomanData.romanDataMap.get(romanNumeral.charAt(i+1)) - ValuesOfRomanData.romanDataMap.get(romanNumeral.charAt(i));
                    i++;
                }
                else
                    sum = sum + ValuesOfRomanData.romanDataMap.get(romanNumeral.charAt(i));
            }
            return sum;
        }
        else
            return -1.0;
    }
}
