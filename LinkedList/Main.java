class Node{
    int data;
    Node next;
    Node(int val)
    {
        data = val;
        next = null;
    }
}
public class Main {

    public static void Display(Node headNode)
    {
        if(headNode==null)
        {
            System.out.print("Null");
            return;
        }
        System.out.print(headNode.data+" -> ");
        Display(headNode.next);
    }


    public static void main(String args[])
    {
        Node head = new Node(10);
        head.next = new Node(20);
        head.next.next = new Node(43);
        head.next.next.next = new Node(327);
        Display(head);
    }    
}
