package com.github.sergiooliveirabr.algostruct.service.recursion;

import org.springframework.stereotype.Service;

@Service
public class ReverseStringService {

    public String reverseString(String word) {

        int numOfLetters = word.length();

        //base
        if (word.isEmpty() || numOfLetters == 1) {
            return word;
        }

        //recursive steps
        char fisrtChar = word.charAt(0);
        String reversed = reverseString(word.substring(1, numOfLetters));
        return reversed + fisrtChar;
    }
}
