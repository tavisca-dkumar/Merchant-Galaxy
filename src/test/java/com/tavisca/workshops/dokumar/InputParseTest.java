package com.tavisca.workshops.dokumar;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class InputParseTest {
    @Test
     void canParseNumberStatement(){
         NumberStatementParser numberStatementParser =new NumberStatementParser();
         assertArrayEquals(new String[]{"glob","I"},
                numberStatementParser.parse("glob is I"));
    }
    @Test
     void canParseItemStatementPrice(){
         ItemParse itemParse = new ItemParse();
        assertArrayEquals((new String[]{"glob glob","Silver","34"}),
                itemParse.parser("glob glob Silver is 34 Credits"));
        assertArrayEquals((new String[]{"pish pish","Iron","3910"}),
                itemParse.parser("pish pish Iron is 3910 Credits"));
        assertArrayEquals((new String[]{"glob prok","Gold","57800"}),
                itemParse.parser("glob prok Gold is 57800 Credits"));
    }

    @Test
    void isRomanSymbolsAndValuesAreCorrect()
    {
        RomanAliasDecimal romanAliasDecimal = new RomanAliasDecimal() ;
        assertEquals(1.0, romanAliasDecimal.romanDataMap.get('I'));
    }

   @Test
   void isRomanNumeralValid()
   {
       DecimalConvertor decimalConvertor =new DecimalConvertor();
       assertEquals(true, decimalConvertor.isValidRomanNumeral("MCMLXXXIV"));
       assertEquals(false, decimalConvertor.isValidRomanNumeral("MMMIL"));
   }
   @Test
   void canConvertRomanToDecimal()
   {
       DecimalConvertor decimalConvertor =new DecimalConvertor();
       assertEquals(1984, decimalConvertor.convertToDecimal("MCMLXXXIV"));
       assertEquals(2, decimalConvertor.convertToDecimal("II"));
       assertEquals(42, decimalConvertor.convertToDecimal("XLII"));
       assertEquals(-1.0, decimalConvertor.convertToDecimal("IL"));
   }
   @Test
   void isStatementHasNumber()
   {
       GalaxyLanguage galaxyLanguage=new GalaxyLanguage();
       galaxyLanguage.storeLanguageInfo("glob is I");
       galaxyLanguage.storeLanguageInfo("prok is V");
       galaxyLanguage.storeLanguageInfo("pish is X");
       galaxyLanguage.storeLanguageInfo("tegj is L");
       assertEquals('I', NumberAliasStatements.numberAliasStatement.get("glob"));
       assertEquals('V', NumberAliasStatements.numberAliasStatement.get("prok"));
       assertEquals('X', NumberAliasStatements.numberAliasStatement.get("pish"));
       assertEquals('L', NumberAliasStatements.numberAliasStatement.get("tegj"));
   }

    @Test
    void isSentenceToRoman(){
        GalaxyLanguage galaxyLanguage=new GalaxyLanguage();
        galaxyLanguage.storeLanguageInfo("glob is I");
        galaxyLanguage.storeLanguageInfo("prok is V");
        galaxyLanguage.storeLanguageInfo("pish is X");
        galaxyLanguage.storeLanguageInfo("tegj is L");
        assertEquals('L', NumberAliasStatements.numberAliasStatement.get("tegj"));
        RomanConvertor romanConvertor =new RomanConvertor();
        assertEquals("XLII", romanConvertor.convertToRoman("pish tegj glob glob"));
    }
   @Test
   void isItemAndCreditsAreMapped()
   {
       GalaxyLanguage galaxyLanguage=new GalaxyLanguage();
       galaxyLanguage.storeLanguageInfo("glob is I");
       galaxyLanguage.storeLanguageInfo("prok is V");
       galaxyLanguage.storeLanguageInfo("pish is X");
       galaxyLanguage.storeLanguageInfo("tegj is L");
       galaxyLanguage.storeLanguageInfo("glob glob Silver is 34 Credits");
       galaxyLanguage.storeLanguageInfo("glob prok Gold is 57800 Credits");
       galaxyLanguage.storeLanguageInfo("pish pish Iron is 3910 Credits");
       ItemAliasPrice itemobject=new ItemAliasPrice();
       assertEquals(17,itemobject.itemAliasPrice.get("Silver"));
       assertEquals(14450,itemobject.itemAliasPrice.get("Gold"));
       assertEquals(195.5,itemobject.itemAliasPrice.get("Iron"));
   }

   @Test
    void canParseSentenceContainingHowMuch()
   {
       QueryParser queryParser =new QueryParser();
       assertEquals("pish tegj glob glob",
               queryParser.muchParse("how much is pish tegj glob glob ?"));
   }

   @Test
    void isSentenceContainedHowMuchQuestionSolved(){

       GalaxyLanguage galaxyLanguage = new GalaxyLanguage();
       galaxyLanguage.storeLanguageInfo("glob is I");
       galaxyLanguage.storeLanguageInfo("prok is V");
       galaxyLanguage.storeLanguageInfo("pish is X");
       galaxyLanguage.storeLanguageInfo("tegj is L");
       galaxyLanguage.storeLanguageInfo("glob glob Silver is 34 Credits");
       galaxyLanguage.storeLanguageInfo("glob prok Gold is 57800 Credits");
       galaxyLanguage.storeLanguageInfo("pish pish Iron is 3910 Credits");
       GalaxyQuery galaxyQuery=new GalaxyQuery();
       assertEquals("I have no idea what you are talking about",
               galaxyQuery.solveQuery("how much is glob tegj ?"));
   }

   @Test
    void canParseSentenceContainingHowMany(){
        QueryParser queryParser =new QueryParser();
        assertArrayEquals(new String[]{"glob prok","Silver"},
                queryParser.manyParse("how many Credits is glob prok Silver ?"));
   }

   @Test
   void isSentenceContainedHowManyTypeQuestionSolved(){
       GalaxyLanguage galaxyLanguage = new GalaxyLanguage();
       galaxyLanguage.storeLanguageInfo("glob is I");
       galaxyLanguage.storeLanguageInfo("prok is V");
       galaxyLanguage.storeLanguageInfo("pish is X");
       galaxyLanguage.storeLanguageInfo("tegj is L");
       galaxyLanguage.storeLanguageInfo("glob tegj Silver is 34 Credits");
       galaxyLanguage.storeLanguageInfo("glob prok Gold is 57800 Credits");
       galaxyLanguage.storeLanguageInfo("pish pish Iron is 3910 Credits");
       GalaxyQuery galaxyQuery=new GalaxyQuery();
       assertEquals("I have no idea what you are talking about",galaxyQuery.solveQuery("how many Credits is glob tegj Silver ?"));
       assertEquals("glob prok Gold is 57800 Credits",galaxyQuery.solveQuery("how many Credits is glob prok Gold ?"));
       assertEquals("glob prok Iron is 782 Credits",galaxyQuery.solveQuery("how many Credits is glob prok Iron ?"));
       assertEquals("I have no idea what you are talking about",galaxyQuery.solveQuery("how much wood could a woodchuck chuck if a woodchuck could chuck wood ?"));
   }

   @Test
    void isSolveUnknownQuery(){
       GalaxyQuery galaxyQuery = new GalaxyQuery();
       assertEquals("I have no idea what you are talking about",galaxyQuery.solveQuery("wuefwdufu fhsdfsd fusdhfsd ffhd fhsduif"));
       assertEquals("I have no idea what you are talking about",galaxyQuery.solveQuery("how much wood could a woodchuck chuck if a woodchuck could chuck wood ?"));
   }
   @Test
    void merchantParserTest(){
        String input[]=new String[]{"glob is I","prok is V","pish is X","tegj is L","glob tegj Silver is 34 Credits",
                "glob prok Gold is 57800 Credits","pish pish Iron is 3910 Credits","how many Credits is glob tegj Silver ?",
                "how many Credits is glob prok Gold ?","how many Credits is glob prok Iron ?",
                "how much wood could a woodchuck chuck if a woodchuck could chuck wood ?"};
        String excpectedOutput[]={"I have no idea what you are talking about","glob prok Gold is 57800 Credits",
                "glob prok Iron is 782 Credits","I have no idea what you are talking about"};
        MerchantParser merchantParser= new MerchantParser();
        assertArrayEquals(excpectedOutput,merchantParser.merchantParse(input).toArray());
   }


}
