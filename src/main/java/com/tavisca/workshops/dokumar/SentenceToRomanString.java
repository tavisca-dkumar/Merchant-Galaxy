package com.tavisca.workshops.dokumar;

public class SentenceToRomanString {
    public String romanConverter(String sentence)
    {
        String splits[]=sentence.split(" ");
        GalaxyRomanMap object = new GalaxyRomanMap();
        String roman="";
        for(String var:splits){
            if(object.galaxyRomanMapper.get(var)!=null)
                roman+=object.galaxyRomanMapper.get(var);
            else
                return "invalid";
        }
        return roman;
    }
}
