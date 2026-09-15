package linkedList;
class Solution {
    // Node definition
    static class Node {
        int data;
        Node next;
    }

    // Add node to empty list
    static Node addToEmpty(Node last, int data) {
        if (last != null)
            return last;

        Node newNode = new Node();
        newNode.data = data;
        last = newNode;
        last.next = last; // circular link
        return last;
    }

    // Add node to front (head position)
    static Node addFront(Node last, int data) {
        if (last == null)
            return addToEmpty(last, data);

        Node newNode = new Node();
        newNode.data = data;
        newNode.next = last.next;
        last.next = newNode;
        return last;
    }

    // Add node at the end (after last)
    static Node addEnd(Node last, int data) {
        if (last == null)
            return addToEmpty(last, data);

        Node newNode = new Node();
        newNode.data = data;
        newNode.next = last.next;
        last.next = newNode;
        last = newNode;
        return last;
    }

    // Add node after a specific item
    static Node addAfter(Node last, int data, int item) {
        if (last == null)
            return null;

        Node p = last.next;
        do {
            if (p.data == item) {
                Node newNode = new Node();
                newNode.data = data;
                newNode.next = p.next;
                p.next = newNode;

                if (p == last)
                    last = newNode; // update last if inserted after last
                return last;
            }
            p = p.next;
        } while (p != last.next);

        System.out.println(item + " not found in the list");
        return last;
    }

    // Delete node with given key
    static Node deleteNode(Node last, int key) {
        if (last == null)
            return null;

        // Case 1: Only one node
        if (last.data == key && last.next == last) {
            return null;
        }

        Node temp = last;

        // Case 2: If last itself is to be deleted
        if (last.data == key) {
            while (temp.next != last) {
                temp = temp.next;
            }
            temp.next = last.next;
            last = temp; // update last correctly
            return last;
        }

        // Case 3: Search for node to delete
        while (temp.next != last && temp.next.data != key) {
            temp = temp.next;
        }

        if (temp.next.data == key) {
            temp.next = temp.next.next;
        } else {
            System.out.println(key + " not found in the list");
        }

        return last;
    }

    // Traverse and print list
    static void traverse(Node last) {
        if (last == null) {
            System.out.println("List is empty.");
            return;
        }

        Node p = last.next;
        do {
            System.out.print(p.data + " ");
            p = p.next;
        } while (p != last.next);
        System.out.println();
    }

    // Driver function
    public static void main(String[] args) {
        Node last = null;

        last = addToEmpty(last, 6);
        last = addEnd(last, 8);
        last = addFront(last, 2);
        last = addAfter(last, 10, 2);

        System.out.println("List after insertions:");
        traverse(last);

        last = deleteNode(last, 8);

        System.out.println("List after deleting 8:");
        traverse(last);
    }
}