package com.tavisca.workshops.dokumar;

public class RomanConvertor {
    public String convertToRoman(String sentence)
    {
        String splits[]=sentence.split(" ");
        NumberAliasStatements object = new NumberAliasStatements();
        String roman="";
        for(String var:splits){
            if(object.numberAliasStatement.get(var)!=null)
                roman+=object.numberAliasStatement.get(var);
            else
                return "invalid";
        }
        return roman;
    }
}
