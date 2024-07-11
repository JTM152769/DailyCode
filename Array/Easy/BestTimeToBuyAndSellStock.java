package Easy;

public class BestTimeToBuyAndSellStock_LC121 {

    //Bruteforce
    //TC: O(n2) SC:O(1)
    static int maxProfit(int[] arr, int n){
        int maxProfit = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(arr[j] > arr[i]){
                    maxProfit = Math.max(arr[j]-arr[i], maxProfit);
                }
            }
        }
        return maxProfit;
    }

    //Optimal approach
    //TC: O(n) SC: O(1)
    static int maxProfitOptimal(int[] arr, int n){
        int maxProfit = 0;
        int minPrice = Integer.MAX_VALUE;
        for(int i=0; i<n; i++){
            minPrice = Math.min(arr[i], minPrice);
            maxProfit = Math.max(arr[i] - minPrice, maxProfit);
        }
        return maxProfit;
    }
    
    public static void main(String[] args) {
        int arr[] = {7,1,5,3,6,4};
        int n = arr.length;
        int maxPro = maxProfit(arr,n);
        System.out.println("Max profit is: " + maxPro);
    
    }
}

