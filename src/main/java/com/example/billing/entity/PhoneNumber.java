package com.example.billing.entity;

import com.example.billing.exception.PhoneNumberFormatException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by MrSteveAndrews on 11/24/15.
 */
public class PhoneNumber {

    private String value;

    private static final Pattern PHONE_NUMBER_PATTERN = Pattern.compile("^\\(?([0-9]{3})\\)?[-.\\s]?([0-9]{3})[-.\\s]?([0-9]{4})$");

    public PhoneNumber(String value) throws PhoneNumberFormatException {
        setValue(value);
    }

    private void validate() throws PhoneNumberFormatException {
        Matcher matcher = PHONE_NUMBER_PATTERN.matcher(value);
        if(! matcher.matches()) {
            throw new PhoneNumberFormatException(this);
        }
    }

    /**
     * Normalize the getValue of the phone number to the standard format.
     */
    private void normalize() {
        StringBuilder sb = new StringBuilder();
        char[] chars = value.toCharArray();
        int pos = 0;
        for(int i=0; i<chars.length; i++) {
            if(Character.isDigit(chars[i])) {
                sb.append(chars[i]);
                pos++;
                if(pos==3 || pos==7) {
                    sb.append('-');
                    pos++;
                }
            }
        }

        this.value = sb.toString();
    }

    public void setValue(String value) throws PhoneNumberFormatException {
        this.value = value;
        validate();
        normalize();
    }

    public String getValue() {
        return this.value;
    }
}
