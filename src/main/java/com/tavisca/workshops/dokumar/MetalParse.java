package com.tavisca.workshops.dokumar;

public class MetalParse {

    public static String[] metalParser(String sentance) {
        String splits[]=sentance.split(" is | Credits");
        String totalCredit=splits[1];
        String metal = splits[0].substring(splits[0].lastIndexOf(" ")+1);
        String innersplits[] =splits[0].split(metal);
        String galaxyRomanString=innersplits[0].trim();
        String finalSplits[] = new String[]{galaxyRomanString,metal,totalCredit}                                                                                                                                                                                        ;
        return finalSplits;
    }
}
