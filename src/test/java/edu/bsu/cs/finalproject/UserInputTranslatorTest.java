package edu.bsu.cs.finalproject;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class UserInputTranslatorTest {

    @Test
    public void convert_f_to_Fahrenheit(){
        Assertions.assertEquals("Fahrenheit",UserInputTranslator.convert_keyword_to_word("f"));

    }
    @Test
    public void convert_F_to_Fahrenheit(){
        Assertions.assertEquals("Fahrenheit",UserInputTranslator.convert_keyword_to_word("F"));

    }
    @Test
    public void convert_lower_c_to_Celsius(){
        System.out.println("Testing convert_lower_c_to_Celsius");
        Assertions.assertEquals("Celsius",UserInputTranslator.convert_keyword_to_word("c"));
    }
    @Test
    public void convert_C_to_Celsius(){
        Assertions.assertEquals("Celsius",UserInputTranslator.convert_keyword_to_word("C"));
    }

    @Test
    public void testConvertNullToDefault() {
        Assertions.assertEquals("Fahrenheit", UserInputTranslator.convert_keyword_to_word(null));
    }




}