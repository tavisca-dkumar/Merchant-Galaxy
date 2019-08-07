package com.tavisca.workshops.dokumar;

import org.junit.jupiter.api.Test;

import javax.naming.directory.Attribute;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class InputParseTest {
    @Test
     void canParseWordToRomanNumeralStatement(){
         WordToRomanParse wordToromanParser=new WordToRomanParse();
         assertArrayEquals(new String[]{"glob","I"},
                WordToRomanParse.parse("glob is I"));
    }
    @Test
     void canParseSentanceToCredits(){
         SentanceToCreditParse sentanceToCreditParse= new SentanceToCreditParse();
        assertArrayEquals((new String[]{"glob glob","Silver","34"}),
                SentanceToCreditParse.parse("glob glob Silver is 34 Credits"));
        assertArrayEquals((new String[]{"pish pish","Iron","3910"}),
                SentanceToCreditParse.parse("pish pish Iron is 3910 Credits"));
        assertArrayEquals((new String[]{"glob prok","Gold","57800"}),
                SentanceToCreditParse.parse("glob prok Gold is 57800 Credits"));
    }
//    @Test
//    void canParseQuestionTypeSentanceToSolve(){
//        assertArrayEquals(new String[]{});
//    }
//    @Test
//    void canParseBothWordToRomanNumeralStatementAndSentanceToCredits(){
//        MainInputParser mainInputParser= new MainInputParser();
//        assertArrayEquals(new String[]{"glob","I"},
//                mainInputParser.mainParse("glob is I"));
//        assertArrayEquals((new String[]{"glob glob","Silver","34"}),
//                mainInputParser.mainParse("glob glob Silver is 34 credits"));
//    }
    @Test
    void isRomanSymbolsAndValuesAreCorrect()
    {
        ValuesOfRomanData valuesOfRomanData = new ValuesOfRomanData() ;
        assertEquals(1.0,valuesOfRomanData.romanDataMap.get('I'));
    }
   @Test
   void isRomanNumeralIsValid()
   {
       RomanNumeralToDecimalNumber romanNumeralToDecimalNumber=new RomanNumeralToDecimalNumber();
       assertEquals(true,romanNumeralToDecimalNumber.isValidRomanNumeral("MCMLXXXIV"));
       assertEquals(false,romanNumeralToDecimalNumber.isValidRomanNumeral("MMMIL"));

   }
   @Test
   void canConvertRomanToDecimal()
   {
       RomanNumeralToDecimalNumber romanNumeralToDecimalNumber=new RomanNumeralToDecimalNumber();
       assertEquals(1984,romanNumeralToDecimalNumber.romanToDecimalConvertor("MCMLXXXIV"));
       assertEquals(2,romanNumeralToDecimalNumber.romanToDecimalConvertor("II"));
       assertEquals(42,romanNumeralToDecimalNumber.romanToDecimalConvertor("XLII"));
   }
   @Test
   void isTokenMappedIntoRomanMap()
   {
       MainInputParser mainInputParser= new MainInputParser();
       mainInputParser.mainParse("glob is I");
       mainInputParser.mainParse("prok is V");
       mainInputParser.mainParse("pish is X");
       mainInputParser.mainParse("tegj is L");
       assertEquals('I',TokenRomanMap.tokenRomanHashMap.get("glob"));
       assertEquals('V',TokenRomanMap.tokenRomanHashMap.get("prok"));
       assertEquals('X',TokenRomanMap.tokenRomanHashMap.get("pish"));
       assertEquals('L',TokenRomanMap.tokenRomanHashMap.get("tegj"));
   }

//   @Test
//    void isCalculatingItemsCredits()
//   {
//       MainInputParser mainInputParser= new MainInputParser();
//       mainInputParser.mainParse("glob is I");
//       mainInputParser.mainParse("prok is V");
//       mainInputParser.mainParse("pish is X");
//       mainInputParser.mainParse("tegj is L");
//       assertEquals(17,mainInputParser.mainParse("glob glob Silver is 34 Credits"));
//       assertEquals(14450,mainInputParser.mainParse("glob prok Gold is 57800 Credits"));
//       assertEquals(195.5,mainInputParser.mainParse("pish pish Iron is 3910 Credits"));
//   }
    @Test
    void isSentenceToRoman(){
        MainInputParser mainInputParser= new MainInputParser();
        mainInputParser.mainParse("glob is I");
        mainInputParser.mainParse("prok is V");
        mainInputParser.mainParse("pish is X");
        mainInputParser.mainParse("tegj is L");
        assertEquals('L',TokenRomanMap.tokenRomanHashMap.get("tegj"));
        SentenceToRomanString sentenceToRomanString=new SentenceToRomanString();
        assertEquals("XLII",sentenceToRomanString.romanConverter("pish tegj glob glob"));
    }
   @Test
   void isItemAndCreditsAreMapped()
   {
       MainInputParser mainInputParser= new MainInputParser();
       mainInputParser.mainParse("glob is I");
       mainInputParser.mainParse("prok is V");
       mainInputParser.mainParse("pish is X");
       mainInputParser.mainParse("tegj is L");
       mainInputParser.mainParse("glob glob Silver is 34 Credits");
       mainInputParser.mainParse("glob prok Gold is 57800 Credits");
       mainInputParser.mainParse("pish pish Iron is 3910 Credits");
       ItemCreditMap itemobject=new ItemCreditMap();
       assertEquals(17,itemobject.itemCreditMap.get("Silver"));
       assertEquals(14450,itemobject.itemCreditMap.get("Gold"));
       assertEquals(195.5,itemobject.itemCreditMap.get("Iron"));
   }

   @Test
    void canParseSentenceContainingHowMuch()
   {
//       MuchContainedSentenceParse muchContainedSentanceParse = new MuchContainedSentenceParse();
       QuestionParse questionParse =new QuestionParse();
       assertEquals("pish tegj glob glob",
               questionParse.muchContainedQuestionParser("how much is pish tegj glob glob ?"));
   }

   @Test
    void isSentenceContainedHowMuchQuestionSolved(){
       MainInputParser mainInputParser= new MainInputParser();
       mainInputParser.mainParse("glob is I");
       mainInputParser.mainParse("prok is V");
       mainInputParser.mainParse("pish is X");
       mainInputParser.mainParse("tegj is L");
       mainInputParser.mainParse("glob glob Silver is 34 Credits");
       mainInputParser.mainParse("glob prok Gold is 57800 Credits");
       mainInputParser.mainParse("pish pish Iron is 3910 Credits");
       GalaxyQuery galaxyQuery=new GalaxyQuery();

       //Solution solution = new Solution();
       assertEquals("pish tegj glob glob is 42",
               galaxyQuery.solveQuery("how much is pish tegj glob glob ?"));
   }

   @Test
    void canParseSentenceContainingHowMany(){
        QuestionParse questionParse=new QuestionParse();
        assertArrayEquals(new String[]{"glob prok","Silver"},
                questionParse.manyContainedQuestionParser("how many Credits is glob prok Silver ?"));
   }

   @Test
   void isSentenceContainedHowManyTypeQuestionSolved(){
       MainInputParser mainInputParser= new MainInputParser();
       mainInputParser.mainParse("glob is I");
       mainInputParser.mainParse("prok is V");
       mainInputParser.mainParse("pish is X");
       mainInputParser.mainParse("tegj is L");
       mainInputParser.mainParse("glob glob Silver is 34 Credits");
       mainInputParser.mainParse("glob prok Gold is 57800 Credits");
       mainInputParser.mainParse("pish pish Iron is 3910 Credits");
       GalaxyQuery galaxyQuery=new GalaxyQuery();
       assertEquals("glob prok Silver is 68 Credits",galaxyQuery.solveQuery("how many Credits is glob prok Silver ?"));
       assertEquals("glob prok Gold is 57800 Credits",galaxyQuery.solveQuery("how many Credits is glob prok Gold ?"));
       assertEquals("glob prok Iron is 782 Credits",galaxyQuery.solveQuery("how many Credits is glob prok Iron ?"));

   }

}
