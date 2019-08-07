package com.tavisca.workshops.dokumar;

public class SentenceToRomanString {
    public String romanConverter(String sentence)
    {
        String splits[]=sentence.split(" ");
        TokenRomanMap object = new TokenRomanMap();
        String roman="";
        for(String var:splits){
            if(object.tokenRomanHashMap.get(var)!=null)
                roman+=object.tokenRomanHashMap.get(var);
            else
                return "invalid";
        }
        return roman;
    }
}
