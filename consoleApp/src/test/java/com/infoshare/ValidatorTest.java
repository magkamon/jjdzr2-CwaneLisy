package com.infoshare;

import com.infoshare.util.DataValidator;
import com.infoshare.util.ValidatorEnum;
import org.junit.Test;

import static org.junit.Assert.*;

public class ValidatorTest {

    @Test
    public void testValidPhoneNumber() {
        String validPhoneNumber = "123456789";
        boolean isDataValid = DataValidator.isDataValid(validPhoneNumber, ValidatorEnum.PHONENUMBER);
        assertEquals(true, isDataValid);
    }

    @Test
    public void testNotValidPhoneNumber() {
        String validPhoneNumber = "dfsdfsf";
        boolean isDataValid = DataValidator.isDataValid(validPhoneNumber, ValidatorEnum.PHONENUMBER);
        assertEquals(false, isDataValid);
    }
}
