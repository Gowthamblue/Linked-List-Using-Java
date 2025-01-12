import java.util.Scanner;

class Node {
    int data;
    Node next;
    Node prev;

    public Node(int val) {
        data = val;
        next = null;
        prev = null;
    }
}

public class Main {
    public static Node InsertAtEnd(Node head, int value) {
        Node m = new Node(value);
        if (head == null) {
            head = m;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = m;
            m.prev = temp;
        }
        return head;
    }

    public static Node InsertAtBegin(Node head, int value) {
        Node m = new Node(value);
        if (head == null) {
            head = m;
        } else {
            head.prev = m;
            m.next = head;
            head = m;
        }
        return head;
    }

    public static Node InsertAtSpecific(Node head, int value, int pos) {
        Node m = new Node(value);
        int count = 1;
        if (head == null) {
            head = m;
        }
        if (pos == 1) {
            head = InsertAtBegin(head, value);
        } else {
            Node temp = head;
            while (temp.next != null) {
                count++;
                if (count == pos) {
                    m.next = temp.next;
                    temp.next.prev = m;
                    temp.next = m;
                    m.prev = temp;
                    break;
                }
                temp = temp.next;
            }

        }
        if (pos == (getSize(head) + 1)) {
            head = InsertAtEnd(head, value);
        } else if (pos > (getSize(head) + 1)) {
            System.out.println("Index is too high");
        }
        return head;
    }

    public static int getSize(Node head) {
        int count = 1;
        if (head == null) {
            count = 0;
        } else {

            Node temp = head;
            while (temp.next != null) {
                count++;
                temp = temp.next;
            }
        }
        return count;

    }

    public static Node DeleteAtBegin(Node head) {
        if (head == null) {
            System.out.println("List is Empty");
        } else {
            Node temp = head;
            head = head.next;
            head.prev = null;
            temp.next = null;
        }
        return head;
    }

    public static Node DeleteAtEnd(Node head) {
        if (head == null) {
            System.out.println("List is Empty");
        } else {

            if (head.next == null) {
                head = null;
            } else {
                Node temp = head;
                while (temp.next.next != null) {
                    temp = temp.next;
                }

                temp.next.prev = null;
                temp.next = null;

            }
        }
        return head;
    }

    public static Node DeleteAtSpecificpos(Node head, int pos) {
        Node temp = head;
        int count = 1;
        if (head == null) {
            System.out.println("List is Empty");
        }
        if (pos == 1) {
            head = DeleteAtBegin(head);
        } else if (pos > (getSize(head))) {
            System.out.println("Index is too high");
        } else {
            while (temp.next != null) {
                Node temp1 = temp.next;
                count++;
                if (count == pos) {
                    if (temp1.next != null) {
                        temp1.next.prev = temp;
                    }
                    temp.next = temp1.next;
                    temp1.next = null;
                    temp1.prev = null;
                    break;

                }
                temp = temp.next;
            }
        }
        if ((pos == count + 1) && temp.next == null) {
            head = DeleteAtEnd(head);
        }

        return head;

    }

    public static Node DeletebyValue(Node head, int value) {
        if (head == null) {
            System.out.println("List is Empty");
        } else if (head.data == value) {
            head = DeleteAtBegin(head);
        } else {
            Node temp = head;
            while (temp.next != null && temp.data != value) {
                temp = temp.next;
            }
            if (temp.next == null && temp.data != value) {
                System.out.println("The Data " + value + " is Not Found ");
            } else if (temp.next == null && temp.data == value) {
                head = DeleteAtEnd(head);
            } else if (temp.data == value) {
                temp.next.prev = temp.prev;
                temp.prev.next = temp.next;
                temp.prev = null;
                temp.next = null;
            }

        }
        return head;
    }

    public static Node ReverseList(Node head) {
        if (head == null) {
            System.out.println("List is Empty");
        } else {
            Node temp = head;
            Node temp1 = null;
            while (temp != null) {
                temp1 = temp.prev;
                temp.prev = temp.next;
                temp.next = temp1;
                temp = temp.prev;
            }
            head = temp1.prev;

        }
        return head;
    }

    public static void ReverseDisplay(Node head) {
        if (head == null) {
            System.out.println("Null");
        } else {

            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            while (temp != null) {
                System.out.print(temp.data + " -> ");
                temp = temp.prev;
            }
            System.out.print("Null");
            System.out.println();
        }

    }

    public static void Display(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.print("Null");
        System.out.println();
    }

    public static boolean Search(Node head, int value) {
        boolean h = false;
        Node temp = head;
        while (temp != null) {
            if (temp.data == value) {
                h = true;
                break;
            }
            temp = temp.next;
        }
        return h;
    }

    public static void main(String[] args) {
        Node head = null;
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("==========Operations Of Doubly Linked List==============");
            System.out.println("1-> Insert an Element to the Linked List");
            System.out.println("2-> Delete Elements From the List");
            System.out.println("3-> Display the Linked List");
            System.out.println("4-> Diplay the Linked List in Reverse Order");
            System.out.println("5-> Reverse the Linked List");
            System.out.println("6-> Get the Size Of the List");
            System.out.println("7-> Search the Element from the List");
            System.out.println("8-> Quit");
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
                            head = InsertAtBegin(head, k);
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
                                head = InsertAtBegin(head, sc.nextInt());
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
                            head = DeleteAtSpecificpos(head, g);
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
                    Display(head);
                    break;
                }
                case 4: {
                    System.out.print("The List in Reverse order: ");
                    ReverseDisplay(head);
                    break;
                }
                case 5: {
                    head = ReverseList(head);
                    System.out.println("List Reversed Successfully");
                    break;
                }
                case 6: {
                    System.out.println("The Size of the List is : " + getSize(head));
                    break;
                }
                case 7: {
                    System.out.print("Enter the Value to Search on the List: ");
                    int g = sc.nextInt();
                    if (Search(head, g)) {
                        System.out.println("The Element " + g + " is Exist on the List.");
                    } else {
                        System.out.println("The Element " + g + " Does not Exist on the List");
                    }
                    break;
                }
                case 8: {
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
