 // Using traditional approach
import java.util.*;
class node
{
    int data;
    node next;
    public node(int val)
    {
        data = val;
        next = null;
    }
}

class LinkedList
{
    node head,temp;
    public LinkedList()
    {
        head = temp = null;
    }
    public void insertatend(int val)
    {
        node newnode = new node(val);
            if(head==null)
                head = temp = newnode;
            else
            {
                // temp = head;
                // while(temp.next!=null)
                //     temp = temp.next;
                   
                temp.next = newnode;
                temp = newnode;
            }
    }
    public void insertatbegin(int val)
    {
        node newnode = new node(val);
        newnode.next = head;
        head = newnode;
    }
    public void display()
    {
        temp = head;
        while(temp!=null)
        {
            System.out.print(temp.data+" ");
            temp =temp.next;
        }
    }
   
}
public class Main
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int val = sc.nextInt();
        LinkedList ll = new LinkedList();
        LinkedList ll2 = new LinkedList();
        int count =0;
        while(val!=-1)
        {
            ll.insertatend(val);
            count++;
            ll2.insertatbegin(val);
            val = sc.nextInt();
        }
        int check =1;
       
        node temp1 = ll.head;
        node temp2 = ll2.head;
       
        int i=0;
        while(temp1!=null && i<=count/2 && temp2!=null)
        {
            if(temp1.data!=temp2.data)
            {
                check =0;
                break;
            }
            i++;
            temp1= temp1.next;
            temp2 = temp2.next;
        }
       
        if(check==1)
            System.out.println("Palindrome");
        else
            System.out.println("Not a Palindrome");
    }
}

