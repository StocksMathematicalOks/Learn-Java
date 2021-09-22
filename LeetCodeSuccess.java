// 1619. Mean of Array After Removing Some Elements:
import java.util.Arrays;
import java.util.Stack;
class Solution {
    public double trimMean(int[] arr) {
        double sum = 0;
        double median;
        ArrayList<Integer> ArrayL = new ArrayList<Integer>();
        Arrays.sort(arr);
        double percent = 0.05*arr.length;
        for(int i=0; i<arr.length; i++){
            ArrayL.add(arr[i]);
        }
        for(int i=0; i<percent; i++){
            ArrayL.remove(0);
        }
        for(int i=0; i<percent; i++){
            ArrayL.remove(ArrayL.size()-1);
        }
        for(int i=0; i<ArrayL.size(); i++){
            sum += ArrayL.get(i);
        }
        return sum/ArrayL.size();
    }
}

// Reverse a String:
import java.util.Arrays;
import java.util.stream.Collectors;
class Solution {
    public void reverseString(char[] s) {
        Stack<Character> Stack_array = new Stack<Character>();
        for(int i=s.length-1; i >= 0; i--){
            Stack_array.push((Character)s[i]);
        }
        /*Since the reversed string and the normal string have the same length, 
        we can run only one loop.*/
        for(int i=0; i<Stack_array.size(); i++){
            s[i] = Stack_array.get(i);
        }
    }
}

// Divide Two Integers (Java):
class Solution {
    public int divide(int dividend, int divisor) {
        double Divisor = Math.pow(divisor, -1);
        double result = Divisor*dividend;
        int Result = (int)result;
        return Result;
    }
}
