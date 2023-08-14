//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            String s = br.readLine();
            String[] S = s.split(" ");
            int[] v = new int[2 * n + 2];
            for(int i = 0; i < 2 * n + 2; i++)
            {
                v[i] = Integer.parseInt(S[i]);
            }
            Solution ob = new Solution();
            int[] ans = ob.singleNumber(v);
            for(int i = 0; i < ans.length; i++)
                System.out.print(ans[i] + " ");
            System.out.println();
        }
    }
}


// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int[] singleNumber(int[] nums)
    {
        // Code here
        int x = 0,setBit=0;
        for(int y:nums)x^=y;
        for(int i=0;i<=32;i++){
            int num = 1<<i;
            if((num&x)!=0){
                setBit=num;
                break;
            }
        }
        int first=0,second=0;
        for(int y:nums){
            if((y&setBit)!=0)first^=y;
            else second^=y;
        }
        int ans[] = new int[2];
        if(first<=second){
            ans[0]=first;
            ans[1]=second;
        }
        else{
            ans[0]=second;
            ans[1]=first;
        }
        return ans;
    }
}