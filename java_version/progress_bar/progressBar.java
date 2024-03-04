package progress_bar;

// You are writing a program using an image processing library. Calling methods of this library can 
// take quite a long time, so for the benefit of your users you want to let them know what percentage
// of the task is already done. The library you're using has a getProgress method to help you with this. 
// However, for some reason this method doesn't simply return a percentage of the task done. Instead it 
// returns a "progress bar" - a string which consists of parts. The left part of the bar is filled with 
// the same character and represents the part of the task which is completed. The right part of the bar is
// also filled with the same character (different from the character used for the left part of the bar) and 
// represents the part of the task which is yet to be done. Both parts of the bar have non-zero length.
//  Besides, the method uses different pairs of characters to generate the bar.

// Evidently, this way of representing progress is not usable, so you have to convert it to a more useful form.

// The input data consists of a single string. The length of the string is between 2 and 10 characters,
// inclusive. The string consists of two parts, each part filled with one character. The string doesn't
//  contain any whitespace characters.

// Output the percentage of the task which is already completed, as an integer (rounded down).

// Example

// input

// XX--

// output

// 50

// input

// 0.....

// output



public class progressBar {
    

    public static void main(String[] args) {
        String inputString = "XX--";

        System.out.println(getPercentage(inputString));
    }

    private static int getPercentage(String inputString){

        int count = 0;
        char startingChar = inputString.charAt(0);
        for(char c : inputString.toCharArray()){
            if(startingChar == c){
                count++;
            }
            else{
                break;
            }
        }

        return (int) ((count*100.00)/inputString.length());
    }


}
