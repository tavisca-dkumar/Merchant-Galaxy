package com.tavisca.workshops.dokumar;

import com.tavisca.workshops.dokumar.convertors.DecimalConvertor;
import com.tavisca.workshops.dokumar.convertors.RomanConvertor;
import com.tavisca.workshops.dokumar.languageinfo.ItemAliasPrice;
import com.tavisca.workshops.dokumar.languageinfo.LanguageFactoryClass;
import com.tavisca.workshops.dokumar.languageinfo.NumberAliasStatements;
import com.tavisca.workshops.dokumar.languageinfo.RomanAliasDecimal;
import com.tavisca.workshops.dokumar.parsers.ItemParser;
import com.tavisca.workshops.dokumar.parsers.NumberStatementParser;
import com.tavisca.workshops.dokumar.parsers.QueryParser;
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
         ItemParser itemParser = new ItemParser();
        assertArrayEquals((new String[]{"glob glob","Silver","34"}),
                itemParser.parser("glob glob Silver is 34 Credits"));
        assertArrayEquals((new String[]{"pish pish","Iron","3910"}),
                itemParser.parser("pish pish Iron is 3910 Credits"));
        assertArrayEquals((new String[]{"glob prok","Gold","57800"}),
                itemParser.parser("glob prok Gold is 57800 Credits"));
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
       LanguageFactoryClass languageFactoryClass =new LanguageFactoryClass();
       languageFactoryClass.storeLanguageProcess("glob is I");
       languageFactoryClass.storeLanguageProcess("prok is V");
       languageFactoryClass.storeLanguageProcess("pish is X");
       languageFactoryClass.storeLanguageProcess("tegj is L");
       assertEquals('I', NumberAliasStatements.numberAliasStatement.get("glob"));
       assertEquals('V', NumberAliasStatements.numberAliasStatement.get("prok"));
       assertEquals('X', NumberAliasStatements.numberAliasStatement.get("pish"));
       assertEquals('L', NumberAliasStatements.numberAliasStatement.get("tegj"));
   }

    @Test
    void isSentenceToRoman(){
        LanguageFactoryClass languageFactoryClass =new LanguageFactoryClass();
        languageFactoryClass.storeLanguageProcess("glob is I");
        languageFactoryClass.storeLanguageProcess("prok is V");
        languageFactoryClass.storeLanguageProcess("pish is X");
        languageFactoryClass.storeLanguageProcess("tegj is L");
        assertEquals('L', NumberAliasStatements.numberAliasStatement.get("tegj"));
        RomanConvertor romanConvertor =new RomanConvertor();
        assertEquals("XLII", romanConvertor.convertToRoman("pish tegj glob glob"));
    }
   @Test
   void isItemAndCreditsAreMapped()
   {
       LanguageFactoryClass languageFactoryClass =new LanguageFactoryClass();
       languageFactoryClass.storeLanguageProcess("glob is I");
       languageFactoryClass.storeLanguageProcess("prok is V");
       languageFactoryClass.storeLanguageProcess("pish is X");
       languageFactoryClass.storeLanguageProcess("tegj is L");
       languageFactoryClass.storeLanguageProcess("glob glob Silver is 34 Credits");
       languageFactoryClass.storeLanguageProcess("glob prok Gold is 57800 Credits");
       languageFactoryClass.storeLanguageProcess("pish pish Iron is 3910 Credits");
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

       LanguageFactoryClass languageFactoryClass = new LanguageFactoryClass();
       languageFactoryClass.storeLanguageProcess("glob is I");
       languageFactoryClass.storeLanguageProcess("prok is V");
       languageFactoryClass.storeLanguageProcess("pish is X");
       languageFactoryClass.storeLanguageProcess("tegj is L");
       languageFactoryClass.storeLanguageProcess("glob glob Silver is 34 Credits");
       languageFactoryClass.storeLanguageProcess("glob prok Gold is 57800 Credits");
       languageFactoryClass.storeLanguageProcess("pish pish Iron is 3910 Credits");
       QuerySolver querySolver =new QuerySolver();
       assertEquals("I have no idea what you are talking about",
               querySolver.solveQuery("how much is glob tegj ?"));
   }

   @Test
    void canParseSentenceContainingHowMany(){
        QueryParser queryParser =new QueryParser();
        assertArrayEquals(new String[]{"glob prok","Silver"},
                queryParser.manyParse("how many Credits is glob prok Silver ?"));
   }

   @Test
   void isSentenceContainedHowManyTypeQuestionSolved(){
       LanguageFactoryClass languageFactoryClass = new LanguageFactoryClass();
       languageFactoryClass.storeLanguageProcess("glob is I");
       languageFactoryClass.storeLanguageProcess("prok is V");
       languageFactoryClass.storeLanguageProcess("pish is X");
       languageFactoryClass.storeLanguageProcess("tegj is L");
       languageFactoryClass.storeLanguageProcess("glob tegj Silver is 34 Credits");
       languageFactoryClass.storeLanguageProcess("glob prok Gold is 57800 Credits");
       languageFactoryClass.storeLanguageProcess("pish pish Iron is 3910 Credits");
       QuerySolver querySolver =new QuerySolver();
       assertEquals("I have no idea what you are talking about", querySolver.solveQuery("how many Credits is glob tegj Silver ?"));
       assertEquals("glob prok Gold is 57800 Credits", querySolver.solveQuery("how many Credits is glob prok Gold ?"));
       assertEquals("glob prok Iron is 782 Credits", querySolver.solveQuery("how many Credits is glob prok Iron ?"));
       assertEquals("I have no idea what you are talking about", querySolver.solveQuery("how much wood could a woodchuck chuck if a woodchuck could chuck wood ?"));
   }

   @Test
    void isSolveUnknownQuery(){
       QuerySolver querySolver = new QuerySolver();
       assertEquals("I have no idea what you are talking about", querySolver.solveQuery("wuefwdufu fhsdfsd fusdhfsd ffhd fhsduif"));
       assertEquals("I have no idea what you are talking about", querySolver.solveQuery("how much wood could a woodchuck chuck if a woodchuck could chuck wood ?"));
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
