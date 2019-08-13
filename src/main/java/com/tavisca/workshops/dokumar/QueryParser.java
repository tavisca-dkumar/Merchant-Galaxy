package com.tavisca.workshops.dokumar;

public class QueryParser {

    public String muchParse(String inputSentence) {
        String [] splits = inputSentence.split(" is ");
        return splits[1].replace('?',' ').trim();
    }

    public String[] manyParse(String inputSentence) {
        String extractedInputSentence= muchParse(inputSentence);
        String item = extractedInputSentence.substring(extractedInputSentence.lastIndexOf(" ")+1);
        String splits[] =extractedInputSentence.split(item);
        String finalSplits[] = new String[]{splits[0].trim(),item};
        return finalSplits;
    }
}
