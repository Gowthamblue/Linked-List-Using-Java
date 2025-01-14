import java.util.*;
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
    public static Node InsertatBegin (Node head,int val) {
        Node temp = new Node(val);
        if(head==null)
        {
            head = temp;
    
        }
        else
        {
            temp.next = head;
            head = temp;
        }
        return head;
    }
    public static Node InsertAtEnd(Node head,int value)
    {
        Node m = new Node(value);
        if(head==null)
        {
            head = m;
        }
        else
        {
            Node temp = head;
            while(temp.next!=null)
            {
                temp = temp.next;
            }
            temp.next = m;
        }
        return head;
    }
    public static Node InsertAtSpecific(Node head,int val,int pos)
    {
        Node value = new Node(val);
        Node temp = head;
        int count = 1;
        if(pos==1)
        {
            head=InsertatBegin(head, val);
        }
        else
        {
            while(temp.next!=null)
            {
                count++;
                if(count==pos)
                {
                    break;
                }
                temp=temp.next;

            }
        }
        if(count==pos)
        {
            value.next=temp.next;
            temp.next=value;
        }
        else
        {
            System.out.println("Invalid position");
        }
        return head;
    }
    public static int  getSize(Node head)
    {
        if(head==null)
        {
            return 0;
        }
        Node temp = head;
        int count=1;
        while(temp.next!=null)
        {
            count++;
            temp=temp.next;    
        }
        return count;
    }

    public static Node reverseList(Node head)
    {
        if(head==null)
        {
            System.out.println("List is Empty");
        }
        else
        {
            Node temp = null;
            Node temp1 = head;
            Node temp2 = null;
            while(temp1!=null)
            {
                temp2 = temp1.next;
                temp1.next = temp;
                temp = temp1;
                temp1 = temp2;
            }
            head = temp;
        }
        return head;
    }
    public static Node DeleteAtBegin(Node head)
    {
        if(head == null)
        {
            System.out.println("List is Empty");
        }
        else
        {
            Node temp =head;
            head=head.next;
            temp.next=null;
        }
        return head;
    }
    public static Node DeleteAtEnd(Node head)
    {
        if(head==null)
        {
            System.out.println("List is Empty");
        }
        else
        {
            Node temp=head;
            while(temp.next.next!=null)
            {
                temp=temp.next;
            }
            temp.next=null;
        }
        return head;
    }
    public static Node DeletebyValue(Node head,int value)
    {
        if(head==null)
        {
            System.out.println("List is Empty");
        }
        else
        {
            Node temp = head;
            boolean t = false;
            while(temp.next!=null)
            {
                if(temp.next.data==value)
                {
                    temp.next=temp.next.next;
                    t = true;
                    break;
                }
                temp=temp.next;
            }
            if(!t)
            {
                System.out.println("Element Does not Exist");
            }


        }
        return head;
    }
    public static Node DeleteBySpecificPos(Node head,int pos)
    {
        if(head==null)
        {
            System.out.println("List is Empty");
        }
        if(pos==1)
        {
            head=DeleteAtBegin(head);
        }
        else
        {
            Node temp = head;
            int count =1;
            while(temp.next!=null)
            {
                count++;
                if(count==pos)
                {
                    break;
                }
                temp=temp.next;
            }
            if(count==pos)
            {
                temp.next=temp.next.next;
            }
            else
            {
                System.out.println("Index out of Range");
            }
        }
        return head;
    }
    public  static boolean Found(Node head,int value)
    {
        boolean t = false;
        Node temp = head;
        while(temp!=null)
        {
            if(temp.data==value)
            {
                t=true;
                break;
            }
            temp = temp.next;
        }
       return t;
    }
    public static void DisplayRec(Node headNode)
    {
        if(headNode==null)
        {
            System.out.print("Null");
            System.out.println();
            return;
        }       
        System.out.print(headNode.data+" -> ");
        DisplayRec(headNode.next);
    }
    public static void DisplayManual(Node headNode) {
            Node temp = headNode;
            
            while(temp!=null)
            {
                System.out.print(temp.data+" -> ");
                temp=temp.next;
            }
            System.out.print("Null");
            System.out.println();
        
    }
    public static void main(String args[])
    {
        Node head = null;
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("==========Operations Of Doubly Linked List==============");
            System.out.println("1-> Insert an Element to the Linked List");
            System.out.println("2-> Delete Elements From the List");
            System.out.println("3-> Display the Linked List");
            System.out.println("4-> Reverse the Linked List");
            System.out.println("5-> Get the Size Of the List");
            System.out.println("6-> Search the Element from the List");
            System.out.println("7-> Quit");
            System.out.print("Enter Your Choice : ");
            int t = sc.nextInt();
            switch (t) {
                case 1: {
                    System.out.println("1-> Insert Single Element at the First");
                    System.out.println("2-> Insert Single Element at the Last");
                    System.out.println("3-> Insert Multiple Element at First");
                    System.out.println("4-> Insert Multiple Element at Last");
                    System.out.println("5-> Insert Single Element at the Specific Position");
                    System.out.println("6-> Exit to Main Menu");
                    System.out.print("Enter Your Choice: ");
                    int n = sc.nextInt();
                    switch (n) {
                        case 1: {
                            System.out.print("Enter the Element to Insert: ");
                            int k = sc.nextInt();
                            head = InsertatBegin(head, k);
                            break;
                        }
                        case 2: {
                            System.out.print("Enter the Element to Insert: ");
                            int k = sc.nextInt();
                            head = InsertAtEnd(head, k);
                            break;
                        }
                        case 3: {
                            System.out.print("Enter the Number of the Elements to Insert: ");
                            int g = sc.nextInt();
                            for (int i = 0; i < g; i++) {
                                System.out.print("Enter the Element: ");
                                head = InsertatBegin(head, sc.nextInt());
                            }
                            break;
                        }
                        case 4: {
                            System.out.print("Enter the Number of the Elements to Insert: ");
                            int g = sc.nextInt();
                            for (int i = 0; i < g; i++) {
                                System.out.print("Enter the Element: ");
                                head = InsertAtEnd(head, sc.nextInt());
                            }
                            break;
                        }
                        case 5: {
                            System.out.print("Enter the Element to Insert: ");
                            int k = sc.nextInt();
                            System.out.print("Enter the postion: ");
                            int pos = sc.nextInt();
                            head = InsertAtSpecific(head, k, pos);
                            break;
                        }
                        case 6: {
                            break;
                        }

                        default: {
                            System.out.println("Invalid Choice. ");
                            break;
                        }
                    }
                    break;

                }
                case 2: {
                    System.out.println("1-> Delete First Element from the Linked List");
                    System.out.println("2-> Delete Last Element from the Linked List");
                    System.out.println("3-> Delete Multiple Element From the Beginning");
                    System.out.println("4-> Delete Multiple Element From the Ending");
                    System.out.println("5-> Delete Elements By th Value");
                    System.out.println("6-> Delete Elements by the Position");
                    System.out.println("7-> Exit to Main Menu");
                    System.out.print("Enter your Choice: ");
                    int h = sc.nextInt();
                    switch (h) {
                        case 1: {
                            head = DeleteAtBegin(head);
                            break;

                        }
                        case 2: {
                            head = DeleteAtEnd(head);
                            break;
                        }
                        case 3: {
                            System.out.print("Enter the Number of Element to Delete from First: ");
                            int g = sc.nextInt();
                            for (int i = 0; i < g; i++) {
                                head = DeleteAtBegin(head);
                            }
                            break;
                        }
                        case 4: {
                            System.out.print("Enter the Number of Element to Delete from Last: ");
                            int g = sc.nextInt();
                            for (int i = 0; i < g; i++) {
                                head = DeleteAtEnd(head);
                            }
                            break;
                        }
                        case 5: {
                            System.out.print("Enter the Element to Delete: ");
                            int g = sc.nextInt();
                            head = DeletebyValue(head, g);
                            break;
                        }
                        case 6: {
                            System.out.print("Enter the Index to Delete: ");
                            int g = sc.nextInt();
                            head = DeleteBySpecificPos(head, g);
                            break;
                        }
                        default: {
                            System.out.println("Invalid Option");
                            break;
                        }
                    }
                    break;
                }
                case 3: {
                    DisplayRec(head);
                    break;
                }
                case 4: {
                    head = reverseList(head);
                    System.out.println("List Reversed Successfully");
                    break;
                }
                case 5: {
                    System.out.println("The Size of the List is : " + getSize(head));
                    break;
                }
                case 6: {
                    System.out.print("Enter the Value to Search on the List: ");
                    int g = sc.nextInt();
                    if (Found(head, g)) {
                        System.out.println("The Element " + g + " is Exist on the List.");
                    } else {
                        System.out.println("The Element " + g + " Does not Exist on the List");
                    }
                    break;
                }
                case 7: {
                    System.out.println("Program Quited Successfully....");
                    return;
                }
                default: {
                    System.out.println("Invalid Operation.");
                    break;
                }
            }
        }
    }    
}

