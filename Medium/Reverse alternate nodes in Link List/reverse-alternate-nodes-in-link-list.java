//{ Driver Code Starts
import java.util.*;
import java.lang.*;

class Node
{
    int data;
    Node next;
    Node(int key)
    {
        data = key;
        next = null;
    }
}

class Rearr
{
    static Node head;
    
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t  =sc.nextInt();
        
        while(t-- > 0)
        {
            int n = sc.nextInt();
            int a1 = sc.nextInt();
            Node head = new Node(a1);
            Node temp = head;
            for(int i = 1; i < n; i++)
            {
                int a = sc.nextInt();
                temp.next = new Node(a);
                temp = temp.next;
            }
            
            Solution ob = new Solution();
            ob.rearrange(head);
            printLast(head);
            System.out.println();
        }
    }
    
    public static void printLast(Node node)
    {
        while(node != null)
        {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }
}
// } Driver Code Ends


/*node class of the linked list
class Node
{
    int data;
    Node next;
    Node(int key)
    {
        data = key;
        next = null;
    }
}*/
class Solution {
    public Node reverse(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node smallHead = reverse(head.next);
        Node temp = head;
        temp.next.next = head;
        temp.next = null;
        return smallHead;
    }

    public void rearrange(Node odd) {
        Node first = odd;
        Node second = odd.next;
        Node temp = odd.next;
        while (first.next != null && second.next != null) {
            first.next = first.next.next;
            first = first.next;
            second.next = second.next.next;
            second = second.next;
        }

        first.next = reverse(temp);
    }
}

