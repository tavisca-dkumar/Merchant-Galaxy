package com.tavisca.workshops.dokumar;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class InputParseTest {
    @Test
     void canParseNumberStatement(){
         NumberStatementParse numberStatementParser =new NumberStatementParse();
         assertArrayEquals(new String[]{"glob","I"},
                numberStatementParser.parser("glob is I"));
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
        ValuesOfRomanData valuesOfRomanData = new ValuesOfRomanData() ;
        assertEquals(1.0,valuesOfRomanData.romanDataMap.get('I'));
    }

   @Test
   void isRomanNumeralValid()
   {
       RomanNumeralToDecimalNumber romanNumeralToDecimalNumber=new RomanNumeralToDecimalNumber();
       assertEquals(true,romanNumeralToDecimalNumber.isValidRomanNumeral("MCMLXXXIV"));
       assertEquals(false,romanNumeralToDecimalNumber.isValidRomanNumeral("MMMIL"));
   }
   @Test
   void canConvertRomanToDecimal()
   {
       RomanNumeralToDecimalNumber romanNumeralToDecimalNumber=new RomanNumeralToDecimalNumber();
       assertEquals(1984,romanNumeralToDecimalNumber.decimalConvertor("MCMLXXXIV"));
       assertEquals(2,romanNumeralToDecimalNumber.decimalConvertor("II"));
       assertEquals(42,romanNumeralToDecimalNumber.decimalConvertor("XLII"));
       assertEquals(-1.0,romanNumeralToDecimalNumber.decimalConvertor("IL"));
   }
   @Test
   void isStatementHasNumber()
   {
       MerchantParse merchantParse= new MerchantParse();
       merchantParse.merchantParser("glob is I");
       merchantParse.merchantParser("prok is V");
       merchantParse.merchantParser("pish is X");
       merchantParse.merchantParser("tegj is L");
       assertEquals('I', NumberAliasStatements.numberAliasStatement.get("glob"));
       assertEquals('V', NumberAliasStatements.numberAliasStatement.get("prok"));
       assertEquals('X', NumberAliasStatements.numberAliasStatement.get("pish"));
       assertEquals('L', NumberAliasStatements.numberAliasStatement.get("tegj"));
   }

    @Test
    void isSentenceToRoman(){
        MerchantParse merchantParse= new MerchantParse();
        merchantParse.merchantParser("glob is I");
        merchantParse.merchantParser("prok is V");
        merchantParse.merchantParser("pish is X");
        merchantParse.merchantParser("tegj is L");
        assertEquals('L', NumberAliasStatements.numberAliasStatement.get("tegj"));
        SentenceToRomanString sentenceToRomanString=new SentenceToRomanString();
        assertEquals("XLII",sentenceToRomanString.romanConverter("pish tegj glob glob"));
    }
   @Test
   void isItemAndCreditsAreMapped()
   {
       MerchantParse merchantParse= new MerchantParse();
       merchantParse.merchantParser("glob is I");
       merchantParse.merchantParser("prok is V");
       merchantParse.merchantParser("pish is X");
       merchantParse.merchantParser("tegj is L");
       merchantParse.merchantParser("glob glob Silver is 34 Credits");
       merchantParse.merchantParser("glob prok Gold is 57800 Credits");
       merchantParse.merchantParser("pish pish Iron is 3910 Credits");
       ItemAliasPrice itemobject=new ItemAliasPrice();
       assertEquals(17,itemobject.itemAliasPrice.get("Silver"));
       assertEquals(14450,itemobject.itemAliasPrice.get("Gold"));
       assertEquals(195.5,itemobject.itemAliasPrice.get("Iron"));
   }

   @Test
    void canParseSentenceContainingHowMuch()
   {
       QueryParse queryParse =new QueryParse();
       assertEquals("pish tegj glob glob",
               queryParse.muchParser("how much is pish tegj glob glob ?"));
   }

   @Test
    void isSentenceContainedHowMuchQuestionSolved(){
       MerchantParse merchantParse= new MerchantParse();
       merchantParse.merchantParser("glob is I");
       merchantParse.merchantParser("prok is V");
       merchantParse.merchantParser("pish is X");
       merchantParse.merchantParser("tegj is L");
       merchantParse.merchantParser("glob glob Silver is 34 Credits");
       merchantParse.merchantParser("glob prok Gold is 57800 Credits");
       merchantParse.merchantParser("pish pish Iron is 3910 Credits");
       GalaxyQuery galaxyQuery=new GalaxyQuery();
       assertEquals("I have no idea what you are talking about",
               galaxyQuery.solveQuery("how much is glob tegj ?"));
   }

   @Test
    void canParseSentenceContainingHowMany(){
        QueryParse queryParse =new QueryParse();
        assertArrayEquals(new String[]{"glob prok","Silver"},
                queryParse.manyParser("how many Credits is glob prok Silver ?"));
   }

   @Test
   void isSentenceContainedHowManyTypeQuestionSolved(){
       MerchantParse merchantParse= new MerchantParse();
       merchantParse.merchantParser("glob is I");
       merchantParse.merchantParser("prok is V");
       merchantParse.merchantParser("pish is X");
       merchantParse.merchantParser("tegj is L");
       merchantParse.merchantParser("glob tegj Silver is 34 Credits");
       merchantParse.merchantParser("glob prok Gold is 57800 Credits");
       merchantParse.merchantParser("pish pish Iron is 3910 Credits");
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

}
