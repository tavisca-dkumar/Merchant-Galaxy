package com.tavisca.workshops.dokumar;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class InputParseTest {
    @Test
     void canParseGalaxyRomanNumberStatement(){
         GalaxyRomanNumberParse galaxyRomanNumberParser=new GalaxyRomanNumberParse();
         assertArrayEquals(new String[]{"glob","I"},
                galaxyRomanNumberParser.parser("glob is I"));
    }
    @Test
     void canParseMetalInSentence(){
         MetalParse metalParse= new MetalParse();
        assertArrayEquals((new String[]{"glob glob","Silver","34"}),
                metalParse.metalParser("glob glob Silver is 34 Credits"));
        assertArrayEquals((new String[]{"pish pish","Iron","3910"}),
                metalParse.metalParser("pish pish Iron is 3910 Credits"));
        assertArrayEquals((new String[]{"glob prok","Gold","57800"}),
                metalParse.metalParser("glob prok Gold is 57800 Credits"));
    }

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
       assertEquals(1984,romanNumeralToDecimalNumber.decimalConvertor("MCMLXXXIV"));
       assertEquals(2,romanNumeralToDecimalNumber.decimalConvertor("II"));
       assertEquals(42,romanNumeralToDecimalNumber.decimalConvertor("XLII"));
       assertEquals(-1.0,romanNumeralToDecimalNumber.decimalConvertor("IL"));
   }
   @Test
   void isGalaxyWordsMappedIntoGalaxyRomanMap()
   {
       MerchantParse merchantParse= new MerchantParse();
       merchantParse.merchantParser("glob is I");
       merchantParse.merchantParser("prok is V");
       merchantParse.merchantParser("pish is X");
       merchantParse.merchantParser("tegj is L");
       assertEquals('I',GalaxyRomanMap.galaxyRomanMapper.get("glob"));
       assertEquals('V',GalaxyRomanMap.galaxyRomanMapper.get("prok"));
       assertEquals('X',GalaxyRomanMap.galaxyRomanMapper.get("pish"));
       assertEquals('L',GalaxyRomanMap.galaxyRomanMapper.get("tegj"));
   }

    @Test
    void isSentenceToRoman(){
        MerchantParse merchantParse= new MerchantParse();
        merchantParse.merchantParser("glob is I");
        merchantParse.merchantParser("prok is V");
        merchantParse.merchantParser("pish is X");
        merchantParse.merchantParser("tegj is L");
        assertEquals('L',GalaxyRomanMap.galaxyRomanMapper.get("tegj"));
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
       MetalCreditMap itemobject=new MetalCreditMap();
       assertEquals(17,itemobject.metalCreditMapper.get("Silver"));
       assertEquals(14450,itemobject.metalCreditMapper.get("Gold"));
       assertEquals(195.5,itemobject.metalCreditMapper.get("Iron"));
   }

   @Test
    void canParseSentenceContainingHowMuch()
   {
       QuestionParse questionParse =new QuestionParse();
       assertEquals("pish tegj glob glob",
               questionParse.muchParser("how much is pish tegj glob glob ?"));
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
        QuestionParse questionParse=new QuestionParse();
        assertArrayEquals(new String[]{"glob prok","Silver"},
                questionParse.manyParser("how many Credits is glob prok Silver ?"));
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
