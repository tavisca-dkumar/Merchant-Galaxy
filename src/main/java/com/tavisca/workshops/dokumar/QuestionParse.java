package com.tavisca.workshops.dokumar;

public class QuestionParse {

    public String muchContainedQuestionParser(String inputSentence) {
        String [] splits = inputSentence.split(" is ");
        return splits[1].replace('?',' ').trim();
    }

    public String[] manyContainedQuestionParser(String inputSentence) {
        String extractedInputSentence=muchContainedQuestionParser(inputSentence);
        String item = extractedInputSentence.substring(extractedInputSentence.lastIndexOf(" ")+1);
        String splits[] =extractedInputSentence.split(item);
        String finalSplits[] = new String[]{splits[0].trim(),item};
        return finalSplits;
    }
}
