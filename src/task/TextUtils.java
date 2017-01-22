package task;

import java.util.Arrays;

/**
 * Created by Vorobiei on 18.05.2016.
 */
public class TextUtils {
    /**
     * Method contains inside of its body three another methods.
     * Each of this method defined below.
     *
     * @param text
     * @return sorted by natural order array of unique words
     */
    public static String[] getUniqueSortedWords(String text) {
        String[] sortWords = {};
        if (text == null || "".equals(text)) sortWords = new String[0];
        else {
            String[] words = getWords(text);
            String[] uniqueWords = getUniqueWords(words);
            sortWords = sortWords(uniqueWords);
        }
        return sortWords;
    }

    /**
     * @param text
     * @return array with words, get from receive text
     * if received argument is null
     * or text length is zero
     * return array with zero length
     */
    public static String[] getWords(String text) {
        String[] arrayWords = {};
        if (text == null || "".equals(text)) arrayWords = new String[0];
        else arrayWords = text.split("; ");
        return arrayWords;
    }

    /**
     * @param words array with words
     * @return array with unique words
     */
    public static String[] getUniqueWords(String[] words) {
        int len = words.length;
        int count = 1;
        String[] uniqueWords = new String[len];
        uniqueWords[0] = words[0];
        for (int i = 1; i < len - 1; i++)
            if (!(hasDuplicates(uniqueWords, words[i]))) {
                add(uniqueWords, words[i]);
                count++;
            }
        return cutArray(uniqueWords, count);
    }

    public static String[] cutArray(String[] str, int num) {
        String[] result = new String[num];
        for (int i = 0; i < num; i++)
            result[i] = str[i];
        return result;
    }

    public static boolean hasDuplicates(String[] str, String target) {
        boolean result = false;
        int i = 0;
        while (str[i] != null) {
            if (str[i].equals(target)) result = true;
            i++;
        }
        return result;
    }

    public static void add(String[] words, String str) {
        int len = words.length;
        for (int i = 0; i < len; i++)
            if (words[i] == null) {
                words[i] = str;
                i = len;
            }
    }

    /**
     * @param uniqueWords array with unique words
     * @return sorted by natural order array of unique words
     */
    public static String[] sortWords(String[] uniqueWords) {
        int len = uniqueWords.length;
        String temp;
        for (int i = len - 1; i > 0; i--)
            for (int j = 0; j < i; j++) {
                if (getMinWord(uniqueWords[j], uniqueWords[j + 1]).equals(uniqueWords[j + 1])) {
                    temp = uniqueWords[j + 1];
                    uniqueWords[j + 1] = uniqueWords[j];
                    uniqueWords[j] = temp;
                }
            }
        return uniqueWords;
    }

    public static String getMinWord(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();
        int len = len1;
        if (len2 < len1) {
            String temp;
            temp = word1;
            word1 = word2;
            word2 = temp;
            len = len2;
        }
        String result = word2;
        for (int i = 0; i < len; i++)
            if (word1.charAt(i) < word2.charAt(i)) {
                result = word1;
                i = len;
            } else if (word1.charAt(i) > word2.charAt(i)) {
                result = word2;
                i = len;
            } else if (word1.charAt(i) == word2.charAt(i)) result = word1;
        return result;
    }

}
