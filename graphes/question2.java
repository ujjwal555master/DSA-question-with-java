// Questions is [7, 1, 9, 2, 11, 1, 9, 2] = maximum profit (10)

import java.util.*;

class question2{
    public static void main(String args[]){
        Scanner scc = new Scanner(System.in);
        int n = scc.nextInt();

        int arr[] = new int[n];

        for(int i=0; i<n; i++){
            arr[i] = scc.nextInt();
        }

        int buy = Integer.MAX_VALUE;
        int max_profit = 0;

        for(int i=0; i<n; i++){
            if(buy<arr[i]){
                int profit = arr[i] - buy;
                max_profit = Math.max(profit, max_profit);
            }else{
                buy = arr[i];
            }
        }
        System.out.println(max_profit);

    }
}