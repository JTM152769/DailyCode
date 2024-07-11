
package Easy;

import java.util.HashMap;
import java.util.Map;

public class MajorityElement_LC169 {
    
    //Brute force
    //TC: O(n2) SC: O(1)
    static int majorityElement(int[] arr, int n){

        for(int i=0; i<n; i++){
            int cnt = 0;
            for(int j = 0; j<n; j++){
                if(arr[j] == arr[i]){
                    cnt++;
                }
            }
            if(cnt > n/2){
                return arr[i];
            }
        }
        return -1;
    }

    //Better Solution
    //TC: O(NlogN)  SC: O(N)
    static int majorityElementBetter(int[] arr, int n){
        HashMap<Integer, Integer> freqMap = new HashMap<>();

        for(int i=0; i<n; i++){
            freqMap.put(arr[i], freqMap.getOrDefault(arr[i], 0)+1);  
        }
        
        for(Map.Entry<Integer, Integer> entry : freqMap.entrySet()){
            if(entry.getValue() > n/2){
                return entry.getKey();
            }
        }
        return -1;
    }

    //Optimal Approach
    //TC: O(N) SC: O(1)
    static int majorityElementOptimal(int[] arr, int n){
        int cnt = 0;
        int element = 0;

        for (int i = 0; i < n; i++) {
            if (cnt == 0) {
                cnt = 1;
                element = arr[i];
            } else if (element == arr[i]) cnt++;
            else cnt--;
        }

        //checking if the stored element is the majority element:
         
        int cnt1 = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] == element) cnt1++;
        }

        if (cnt1 > (n / 2)) return element;
        return -1;

    }

    public static void main(String args[]) {
        int[] arr = {2, 2, 1, 1, 1, 2, 2};
        int n = arr.length;
        int res = majorityElement(arr, n);
        System.out.println("The majority element is: " + res);

        int res1 = majorityElementBetter(arr, n);
        System.out.println("The majority element is: " + res1);

        int res2 = majorityElementOptimal(arr, n);
        System.out.println("The majority element is: " + res2);


    }
}
