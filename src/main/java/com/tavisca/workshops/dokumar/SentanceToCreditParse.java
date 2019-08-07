package com.tavisca.workshops.dokumar;

public class SentanceToCreditParse {

    public static String[] parse(String sentance) {
        String splits[]=sentance.split(" is | Credits");
        String item = splits[0].substring(splits[0].lastIndexOf(" ")+1);
        String innersplits[] =splits[0].split(item);
        String finalSplits[] = new String[]{innersplits[0].trim(),item,splits[1]};
        return finalSplits;
    }
}
