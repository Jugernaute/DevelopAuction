package ua.com.method;

import java.util.Random;

public class RandomStr {

    public static String randomKey() {
        String randomNum = String.valueOf((long) (Math.random() * 1000000000000000000L));

        int randomLength = randomNum.length()-1;

        Random randomOfLength = new Random();
        int numOfLength = randomOfLength.nextInt(19);

        Random chars = new Random();
        int x2 = chars.nextInt(26) + 97;
        char newChar = (char) x2;

        char oldChar = randomNum.charAt(randomLength - numOfLength);
        String key = randomNum.replace(oldChar, newChar);
        return key;
    }
}
