package com.tavisca.workshops.dokumar;

public class DecimalConvertor {
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

    public Double convertToDecimal(String romanNumeral) {
        if(isValidRomanNumeral(romanNumeral))
        {
            Double sum=0.0;
            for(int i=0;i<romanNumeral.length();i++)
            {
                if((i!=romanNumeral.length()-1)&&
                        (RomanAliasDecimal.romanDataMap.get(romanNumeral.charAt(i))< RomanAliasDecimal.romanDataMap.get(romanNumeral.charAt(i+1))))
                {
                    sum = sum + RomanAliasDecimal.romanDataMap.get(romanNumeral.charAt(i+1)) - RomanAliasDecimal.romanDataMap.get(romanNumeral.charAt(i));
                    i++;
                }
                else
                    sum = sum + RomanAliasDecimal.romanDataMap.get(romanNumeral.charAt(i));
            }
            return sum;
        }
        else
            return -1.0;
    }
}
