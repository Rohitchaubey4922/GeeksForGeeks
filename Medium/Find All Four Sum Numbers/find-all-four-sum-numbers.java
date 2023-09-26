//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());

        while (tc-- > 0) {
            String[] nk = br.readLine().trim().split(" ");
            int n = Integer.parseInt(nk[0]);
            int k = Integer.parseInt(nk[1]);

            String[] str = br.readLine().trim().split(" ");
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(str[i]);
            }

            Solution sln = new Solution();
            ArrayList<ArrayList<Integer>> ans = sln.fourSum(a, k);
            for (ArrayList<Integer> v : ans) {
                for (int u : v) {
                    System.out.print(u + " ");
                }
                System.out.print("$");
            }
            if (ans.isEmpty()) {
                System.out.print(-1);
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


// User function Template for Java

// arr[] : int input array of integers
// k : the quadruple sum required

class Solution {
    public ArrayList<ArrayList<Integer>> fourSum(int[] arr, int k) {
        int n=arr.length;
        ArrayList<ArrayList<Integer>> ans=new ArrayList<>();
        
        Arrays.sort(arr);
        
        for(int i=0;i<n;i++)
        {
            if(i>0 && arr[i]==arr[i-1]) continue;
            for(int j=i+1;j<n;j++)
            {
                if(j>i+1 && arr[j]==arr[j-1]) continue;
                
                int low=j+1,high=n-1;
                
                while(low<high){
                    if(arr[i]+arr[j]+arr[low]+arr[high]==k)
                    {
                        ArrayList<Integer> list=new ArrayList(Arrays.asList(arr[i],arr[j],arr[low],arr[high]));
                        ans.add(list);
                        
                        int a=arr[low],b=arr[high];
                        while(low<high && a==arr[low]) low++;
                        while(low<high &&  b==arr[high]) high--;
                        
                    }
                    else if(arr[i]+arr[j]+arr[low]+arr[high]<k) low++;
                    else high--;
                }
                
            }
        }
        
        return ans;
    }
}