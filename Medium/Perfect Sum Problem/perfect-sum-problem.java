//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    int n = sc.nextInt();
                    int sum = sc.nextInt();
                    int arr[] = new int[n];
                    for(int i = 0;i<n;i++)
                    arr[i] = sc.nextInt();
                    
                    Solution ob = new Solution();
                    System.out.println(ob.perfectSum(arr,n,sum));
                }
        }
}    
// } Driver Code Ends


class Solution{


	    static final int MOD = 1000000007;
 
    public int numberOfWays(int i, int sum, int[] arr, int n, int[][] dp) {
        if (sum == 0 && i == n) return 1;
 
        if (i >= n || sum < 0) return 0;
 
        if (dp[i][sum] != -1) return dp[i][sum];
 
        int pick = numberOfWays(i + 1, sum - arr[i], arr, n, dp);
        int notPick = numberOfWays(i + 1, sum, arr, n, dp);
        return dp[i][sum] = (pick % MOD + notPick % MOD) % MOD;
    }
 
    public int perfectSum(int[] arr, int n, int sum) {
        int totalSum = 0;
        for (int i = 0; i < n; i++) {
            totalSum += arr[i];
        }
        if (totalSum < sum) return 0;
 
        int[][] dp = new int[n + 1][totalSum + 1];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], -1);
        }
 
        int ans = numberOfWays(0, sum, arr, n, dp);
        return ans;
    }
	
}