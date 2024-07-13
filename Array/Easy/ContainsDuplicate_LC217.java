/*Given an integer array nums, return true if any value appears at least twice in the array, and 
return false if every element is distinct. 

Example 1:

Input: nums = [1,2,3,1]
Output: true
Example 2:

Input: nums = [1,2,3,4]
Output: false
Example 3:

Input: nums = [1,1,1,3,3,4,3,2,4,2]
Output: true
*/
package Easy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate_LC217{
    
    //Bruteforce
    //TC: O(n2) SC:O(1)
    public static boolean containsDuplicate(int[] arr, int n) {
        
        for(int i=0; i<n; i++){
            for(int j=0; j<i; j++){
                if(arr[j] == arr[i]){
                    return true;
                }
            }
        }
        return false;
    }

    /*Time complexity : O(nlogn)
    Sorting is O(nlogn) and the sweeping is O(n)
    The entire algorithm is dominated by the sorting step, which is O(nlogn)

    Space complexity : O(1)
    Space depends on the sorting implementation which, usually, costs O(1)
    auxiliary space if heapsort is used.*/
    public static boolean containsDuplicateBetter(int[] arr, int n){
        Arrays.sort(arr);
        for(int i=0; i<n; i++){
            if(arr[i] == arr[i+1]){
                return true;
            }
        }
        return false;
    }

    //TC: O(n) SC:O(n)
    public static boolean containsDuplicateOptimal(int[] arr, int n) { 
        Set<Integer> set = new HashSet<>(arr.length); 
        for (int x: arr) { 
            if (set.contains(x)) return true; 
            set.add(x); 
        } 
        return false; 
    }


    public static void main(String[] args) {
        int arr[] = {1,1,1,3,3,4,3,2,4,2};
        int arr1[] = {1,2,3,4};
        int n = arr.length;
        System.out.println(containsDuplicate(arr, n));
        System.out.println(containsDuplicateBetter(arr, n));
        System.out.println(containsDuplicateOptimal(arr1, n));
    }
}
