
import java.util.Scanner;

class Node {

    int key;
    Node next;

    public Node(int key) {
        this.key = key;
        next = null;
    }
}

public class MergeLinkedLists {

    public static Node mergeSortedLists(Node list1, Node list2) {
        Node dummy = new Node(-1); // Dummy node to simplify merging

        Node current = dummy;
        while (list1 != null && list2 != null) {
            if (list1.key < list2.key) {
                current.next = list1;
                list1 = list1.next;
            } else {
                current.next = list2;
                list2 = list2.next;
            }

            current = current.next;
        }

        // Append remaining elements, if any
        if (list1 != null) {
            current.next = list1;
        } else {
            current.next = list2;
        }

        return dummy.next;
    }

    public static void printList(Node head) {
        Node current = head;
        while (current != null) {
            System.out.print(current.key + " ");
            current = current.next;
        }

        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Node list1 = null;
        Node list2 = null;
        Node tail1 = null;
        Node tail2 = null;

        System.out.print("Enter the number of elements in the first linked list: ");
        int n = scanner.nextInt();
        System.out.println("Enter the elements of the first linked list in sorted order:");
        for (int i = 0; i < n; i++) {
            int key = scanner.nextInt();
            if (list1 == null) {
                list1 = new Node(key);
                tail1 = list1;
            } else {
                tail1.next = new Node(key);
                tail1 = tail1.next;
            }
        }

        System.out.print("Enter the number of elements in the second linked list: ");
        int m = scanner.nextInt();
        System.out.println("Enter the elements of the second linked list in sorted order:");
        for (int i = 0; i < m; i++) {
            int key = scanner.nextInt();
            if (list2 == null) {
                list2 = new Node(key);
                tail2 = list2;
            } else {
                tail2.next = new Node(key);
                tail2 = tail2.next;
            }
        }

        Node mergedList = mergeSortedLists(list1, list2);
        System.out.print("Resultant Merge Linked List is: ");
        printList(mergedList);

        scanner.close();
    }
}
