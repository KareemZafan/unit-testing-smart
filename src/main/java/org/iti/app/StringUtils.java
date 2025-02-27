package org.iti.app;

public class StringUtils {

    public boolean isPalindrome(String text){
        return new StringBuilder(text).reverse().toString().equals(text);
    }
}
