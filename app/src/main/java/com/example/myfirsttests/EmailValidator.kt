package com.example.myfirsttests

import android.text.Editable
import android.text.TextWatcher
import java.util.regex.Pattern

class EmailValidator: TextWatcher {
    internal var isValidEmail = false

    override fun beforeTextChanged(editableText: CharSequence?, start: Int, count: Int, after: Int) = Unit

    override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) = Unit

    override fun afterTextChanged(editableText: Editable?) {
        isValidEmail = isValidEmail(editableText)
    }

    companion object {

        private val EMAIL_PATTERN = Pattern.compile(
            "[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}" +
                    "\\@" +
                    "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}" +
                    "(" +
                    "\\." +
                    "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25}" +
                    ")+"
        )
        fun isValidEmail(email: CharSequence?): Boolean {
            return email != null && EMAIL_PATTERN.matcher(email).matches()
        }
    }
}