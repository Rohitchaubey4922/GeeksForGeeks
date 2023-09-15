//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine());
            String input_line[] = in.readLine().trim().split("\\s+");
            int arr[] = new int[N];
            for(int i = 0;i < N;i++)
                arr[i] = Integer.parseInt(input_line[i]);
            
            Solution ob = new Solution();
            int x = ob.equalPartition(N, arr);
            if(x == 1)
                System.out.println("YES");
            else
                System.out.println("NO");
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution{
    static int equalPartition(int n, int arr[])
    {
        // code here
          int totalSum = 0;
        for (int i = 0; i < n; i++)
            totalSum += arr[i];

        if (totalSum % 2 != 0)
            return 0;

        int targetSum = totalSum / 2;

        boolean[][] dp = new boolean[n + 1][targetSum + 1];// all marked as false now
         dp[0][0] = true;
	   // for(int i=1; i<=sum; i++)
	   // dp[0][i]=0;//first row from 2nd cell
	     
	    for(int i=1; i<=n; i++)
	    {
	        for(int j=0; j<=targetSum; j++)
	        {
	            if(j<arr[i-1]) //nt
	            dp[i][j] = dp[i-1][j];
	            
	            else 
	            dp[i][j] = dp[i-1][j] || dp[i-1][j-arr[i-1]];
	            
	        }
	    }
	    return dp[n][targetSum]==true? 1:0;   
    }
}