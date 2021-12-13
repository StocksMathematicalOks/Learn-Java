import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'plusMinus' function below.
     *
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static void plusMinus(List<Integer> arr) {
        double NumZero = 0, NumPos = 0, NumNeg = 0, Sum = 0;
        for(int i=0; i < arr.size(); i++){
            if( Sum+arr.get(i) > Sum ){
                NumPos++;
            }
            else if( Sum+arr.get(i) < Sum ){
                NumNeg++;
            }
            else{
                NumZero++;
            }
        }
        System.out.println(NumPos/arr.size());
        System.out.println(NumNeg/arr.size());
        System.out.println(NumZero/arr.size());
    }

}

import java.io.*;
        import java.math.*;
        import java.security.*;
        import java.util.HashMap;
        import java.text.*;
        import java.util.*;
        import java.util.concurrent.*;
        import java.util.function.*;
        import java.util.regex.*;
        import java.util.stream.*;
        import static java.util.stream.Collectors.joining;
        import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'matchingStrings' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. STRING_ARRAY strings
     *  2. STRING_ARRAY queries
     */

    public static List<Integer> matchingStrings(List<String> strings, List<String> queries) {
        List<Integer> Arr = new ArrayList<Integer>();
        HashMap<String, Integer> Frequency = new HashMap<String, Integer>();
        for(int i=0; i < strings.size(); i++){
            if( Frequency.containsKey(strings.get(i)) ){
                Frequency.put(strings.get(i), Frequency.get(strings.get(i))+1);
            }
            else{
                Frequency.put(strings.get(i), 1);
            }
        }
        for(int i=0; i < queries.size(); i++){
            if( Frequency.containsKey(queries.get(i)) ){
                Arr.add(Frequency.get(queries.get(i)));
            }
            else {
                Arr.add(0);
            }
        }
        return Arr;
    }

}



import java.io.*;
        import java.math.*;
        import java.security.*;
        import java.text.*;
        import java.util.*;
        import java.util.concurrent.*;
        import java.util.function.*;
        import java.util.regex.*;
        import java.util.stream.*;
        import static java.util.stream.Collectors.joining;
        import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'diagonalDifference' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts 2D_INTEGER_ARRAY arr as parameter.
     */

    public static int diagonalDifference(List<List<Integer>> arr) {
        // Write your code here
        int DiagOne = 0;
        int DiagTwo = 0;
        int IncrementerOne = 0;
        int Length = arr.get(0).size();
        for(int i=0; i < Length; i++){
            DiagOne+=arr.get(IncrementerOne).get(IncrementerOne);
            DiagTwo+=arr.get(IncrementerOne).get(Length-1-IncrementerOne);
            IncrementerOne++;
        }
        return Math.abs(DiagOne-DiagTwo);
    }

}



import java.io.*;
        import java.math.*;
        import java.security.*;
        import java.text.*;
        import java.util.*;
        import java.util.concurrent.*;
        import java.util.function.*;
        import java.util.regex.*;
        import java.util.stream.*;
        import static java.util.stream.Collectors.joining;
        import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'birthday' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY s
     *  2. INTEGER d
     *  3. INTEGER m
     */

    public static int birthday(List<Integer> s, int d, int m) {
        // Write your code here
        int NumberOfArrays = 0, CurrentSum = 0, WindowStart = 0;
        for(int WindowEnd = 0; WindowEnd < s.size(); WindowEnd++){
            CurrentSum+=s.get(WindowEnd);
            if( WindowEnd-WindowStart+1 >= m ){
                if( CurrentSum == d ){
                    NumberOfArrays++;
                }
                CurrentSum -= s.get(WindowStart);
                WindowStart++;
            }
        }
        return NumberOfArrays;
    }
}


import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while( scan.hasNextInt() ){
            System.out.println(scan.nextInt());
        }
        scan.close();
    }
}

import java.io.*;
        import java.util.Arrays;
        import java.util.HashSet;
        import java.math.*;
        import java.security.*;
        import java.text.*;
        import java.util.*;
        import java.util.concurrent.*;
        import java.util.function.*;
        import java.util.regex.*;
        import java.util.stream.*;
        import static java.util.stream.Collectors.joining;
        import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'pangrams' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    public static String pangrams(String s) {
        int NumChars = 0;
        String alpha_char = "acdefghijklmnopqrstuvwxyz";
        HashSet<Character> Alphabet = new HashSet<Character>();
        for(int i=0; i < alpha_char.length(); i++){
            Alphabet.add(alpha_char.charAt(i));
        }
        for(int i=0; i < s.length(); i++){
            if( Alphabet.contains(Character.toLowerCase(s.charAt(i))) ){
                NumChars++;
                System.out.println(s.charAt(i));
                Alphabet.remove(Character.toLowerCase(s.charAt(i)));
            }
        }
        System.out.println(NumChars);
        if( NumChars+1 == 26 ){
            return "pangram";
        }
        else{
            return "not pangram";
        }
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        String result = Result.pangrams(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
