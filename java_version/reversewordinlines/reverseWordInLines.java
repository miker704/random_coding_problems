package reversewordinlines;

import java.util.Arrays;
import java.util.Collections;

// You are given an integer N, 
// followed by N lines of input (1 <= N <= 100). Each line of input contains one 
// or several words separated with single spaces. Each word is a sequence of letters of English alphabet
//  containing between 1 and 10 characters, inclusive. The total number of words in the input is between 1 and 100, 
//  inclusive.

// Your task is to reverse the order of words in each line of input, while preserving the words themselves. 
// The lines of your output should not have any trailing or leading spaces.

// input
// 3
// Hello World
// Bye World
// Useless World

// output
// World Hello
// World Bye
// World Useless

class ReverseWordsInLines {

    public static void main(String[] args) {

        String[] lines = { "Hello World", "Bye World", "Useless World" };

        ReverseWordsInLines.reverseWordsInLines(3, lines);
        /*
         * output
         * World Hello
         * World Bye
         * World Useless
         * 
         * 
         */
    }

    private static void reverseWordsInLines(int n, String[] lines) {
            for(String line : lines){
                String [] words = line.split(" ");
                Collections.reverse(Arrays.asList(words));
                String finalWords = String.join(" ",words);
                System.out.println(finalWords);
            }
    }

}