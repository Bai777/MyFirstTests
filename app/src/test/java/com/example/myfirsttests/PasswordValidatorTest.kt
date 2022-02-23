package com.example.myfirsttests

import org.junit.Assert
import org.junit.Test

class PasswordValidatorTest {
    @Test
    fun passwordValidator_CorrectPasswordSimple_ReturnsTrue() {
        Assert.assertTrue(PasswordValidator.isValidPassword("Jf@l$5"))
    }

    @Test
    fun passwordValidator_EmptyString_ReturnsFalse() {
        Assert.assertFalse(PasswordValidator.isValidPassword(""))
    }

    @Test
    fun passwordValidator_NullEmail_ReturnsFalse() {
        Assert.assertFalse(PasswordValidator.isValidPassword(null))
    }
}