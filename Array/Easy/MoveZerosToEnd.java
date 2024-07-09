package Easy;

import java.util.ArrayList;
import java.util.Arrays;

public class MoveZerosToEnd {

    //Bruteforce
    //TC: O(N) + O(X) + O(N-X) ~ O(2*N), where N = total no. of elements,X = no. of non-zero elements, and N-X = total no. of zeros.
    //SC: O(N)
    static int[] moveZeros(int[] arr, int n){
        ArrayList<Integer> temp = new ArrayList<>();

        for(int i=0; i<n; i++){
            if(arr[i] != 0) temp.add(arr[i]);
        }

        int nonZeroElements = temp.size();

        for(int i=0; i<nonZeroElements; i++){
            arr[i] = temp.get(i);
        }

        for(int i=nonZeroElements; i<n; i++){
            arr[i]=0;
        }
        return arr;
    }
    // Optimal
    o//TC: O(N) SC: O(1)
    static int[] moveZerosOptimal(int[] arr, int n) {

        int j = -1;

        for(int i=0; i<n; i++){
            if(arr[i] == 0){
                j = i;
                break;
            }
        }

        for(int i = j+1; i<n; i++){
            if(arr[i] != 0){
                int tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
                j++;
            }
        }
        return arr;
    }
    public static void main(String[] args) {
        int[] arr = {1, 0, 2, 3, 2, 0, 0, 4, 5, 1};
        int n = 10;
        int[] res = moveZeros(arr, n);
        for (int i = 0; i < n; i++) {
            System.out.print(res[i] + " ");
        }
        System.out.println("");

        int[] res1 = moveZerosOptimal(arr, n);
        Arrays.stream(res1).forEach(element -> System.out.print(element + " "));
        //System.out.println();
    }

    
}

