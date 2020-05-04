package com.onoh.ewallet01.model;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import com.google.android.material.textfield.TextInputEditText;


import java.text.DecimalFormat;


import static java.lang.Math.max;
import static java.lang.Math.min;

public class MoneyTextWatcher implements TextWatcher {
    private TextInputEditText editText;

    private String lastAmount = "";

    private int lastCursorPosition = -1;

    public MoneyTextWatcher(TextInputEditText editText) {
        super();
        this.editText = editText;
    }

    @Override
    public void onTextChanged(CharSequence amount, int start, int before, int count) {

        if (!amount.toString().equals(lastAmount)) {

            String cleanString = clearCurrencyToNumber(amount.toString());

            try {

                String formattedAmount = currencyFormat(cleanString);
                editText.removeTextChangedListener(this);
                editText.setText(formattedAmount);
                editText.setSelection(formattedAmount.length());
                editText.addTextChangedListener(this);

                if (lastCursorPosition != lastAmount.length() && lastCursorPosition != -1) {
                    int lengthDelta = formattedAmount.length() - lastAmount.length();
                    int newCursorOffset = max(0, min(formattedAmount.length(), lastCursorPosition + lengthDelta));
                    editText.setSelection(newCursorOffset);
                }
            } catch (Exception e) {
                //log something
            }
        }
    }

    @Override
    public void afterTextChanged(Editable s) {
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        String value = s.toString();
        if(!value.equals("")){
            String cleanString = clearCurrencyToNumber(value);
            String formattedAmount = currencyFormat(cleanString);
            lastAmount = formattedAmount;
            lastCursorPosition = editText.getSelectionStart();
        }
    }

    public static String clearCurrencyToNumber(String currencyValue) {
        String result = null;

        if (currencyValue == null) {
            result = "";
        } else {
            result = currencyValue.replaceAll("[(a-z)|(A-Z)|($,. )]", "");
        }
        return result;
    }

    public static boolean isCurrencyValue(String currencyValue, boolean podeSerZero) {
        boolean result;

        if (currencyValue == null || currencyValue.length() == 0) {
            result = false;
        } else {
            if (!podeSerZero && currencyValue.equals("")) {
                result = false;
            } else {
                result = true;
            }
        }
        return result;
    }


    public static String currencyFormat(String value) {
//        Locale localeID = new Locale("in", "ID");
//        NumberFormat formatRupiah = NumberFormat.getCurrencyInstance(localeID);

        DecimalFormat formatter = new DecimalFormat("###,###,###");
        return formatter.format(Double.parseDouble(value));
    }
}