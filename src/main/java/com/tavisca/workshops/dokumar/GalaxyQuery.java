package com.tavisca.workshops.dokumar;

import java.util.regex.Pattern;

public class GalaxyQuery {
    private int credit=0;
    public String solveQuery(String inputSentance) {
        if(Pattern.matches("how much is.*",inputSentance))
        {
            QuestionParse questionParse=new QuestionParse();
            String creditString=questionParse.muchParser(inputSentance);
            Solution solution=new Solution();
            Double credits=solution.howMuchQuestionSolver(creditString);
            if(credits!=-1.0){
                String creditsAsString = credits.toString();
                if(Pattern.matches(".*\\.0",creditsAsString)) {
                    credit = credits.intValue();
                    return "pish tegj glob glob is " + credit;
                }
                else
                    return "pish tegj glob glob is " +(solution.howMuchQuestionSolver(creditString)).toString() ;
            }
            else
                return "I have no idea what you are talking about";
        }
        else if(Pattern.matches("how many Credits.*",inputSentance))
        {
            QuestionParse questionParse= new QuestionParse();
            String[] strings=questionParse.manyParser(inputSentance);
            Solution solution = new Solution();
            if(solution.howManyTypeQuestionSolver(strings)!=-1.0) {
                String creditsAsString=solution.howManyTypeQuestionSolver(strings).toString();
                if(Pattern.matches(".*\\.0",creditsAsString)){
                    credit=solution.howManyTypeQuestionSolver(strings).intValue();
                    return strings[0] + " " + strings[1] + " " +"is "+ credit +" Credits";
                }
                else
                    return strings[0] + " " + strings[1] + " " + "is "+creditsAsString+" Credits";
            }
            else
                return "I have no idea what you are talking about";
        }
        else
            return "I have no idea what you are talking about";
    }
}
