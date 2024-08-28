package datastructures.singlylinkedlist;

import datastructures.doublylinkedlist.DoublyLinkedList;

import java.util.HashSet;
import java.util.Set;

public class LinkedList {

    private Node head;
    private Node tail;
    private int length;

    class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
        }
    }

    public LinkedList(int value) {
        Node newNode = new Node(value);
        head = newNode;
        tail = newNode;
        length = 1;
    }

    public Node getHead() {
        return head;
    }

    public Node getTail() {
        return tail;
    }

    public int getLength() {
        return length;
    }

    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.value + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public void printAll() {
        if (length == 0) {
            System.out.println("Head: null");
            System.out.println("Tail: null");
        } else {
            System.out.println("Head: " + head.value);
            System.out.println("Tail: " + tail.value);
        }
        System.out.println("Length:" + length);
        System.out.println("\nLinked List:");
        if (length == 0) {
            System.out.println("empty");
        } else {
            printList();
        }
    }

    public void makeEmpty() {
        head = null;
        tail = null;
        length = 0;
    }

    public void append(int value) {
        Node newNode = new Node(value);
        if (length == 0) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        length++;
    }

    public Node removeLast() {
        if (length == 0) {
            return null;
        }

        Node pre = head;
        Node temp = head;

        while (temp.next != null) {
            pre = temp;
            temp = temp.next;
        }
        tail = pre;
        tail.next = null;
        length--;
        if (length == 0) {
            head = null;
            tail = null;
        }

        return temp;
    }

    public void prepend(int value) {
        Node newNode = new Node(value);
        if (length == 0) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
        length++;
    }

    public Node removeFirst() {
        if (length == 0) return null;
        Node temp = head;
        head = head.next;
        temp.next = null;
        length--;
        if (length == 0) {
            tail = null;
        }
        return temp;
    }

    public Node get(int index) {
        if (index < 0 || index >= length) {
            return null;
        }
        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp;
    }

    public boolean set(int index, int value) {
        Node toUpdate = get(index);

        if (toUpdate != null) {
            toUpdate.value = value;
            return true;
        }
        return false;
    }

    public boolean insert(int index, int value) {
        if (index < 0 || index > length) {
            return false;
        }
        if (index == 0) {
            prepend(value);
            return true;
        }
        if (index == length) {
            append(value);
            return true;
        }

        Node newNode = new Node(value);
        Node nodeBeforeIndex = get(index - 1);

        newNode.next = nodeBeforeIndex.next;
        nodeBeforeIndex.next = newNode;
        length++;
        return true;
    }

    public Node remove(int index) {
        if (index < 0 || index >= length) return null;
        if (index == 0) return removeFirst();

        Node prev = get(index - 1);
        Node temp = prev.next;
        prev.next = temp.next;
        temp.next = null;
        length--;
        return temp;
    }

        public void reverse() {
        // swap head and tail
        Node current = head;
        head = tail;
        tail = current;

        Node before = null;
        Node after;

        while (current != null) {
            after = current.next;// store current next in after
            current.next = before;// change current next to before

            before = current;     //move before to current
            current = after;      //move current to after
        }

    }
    public void reverse2() {
        Node before = null;
        Node current = head;
        Node after = null;

        while (current != null) { // 1 2 4 ->null
            after = current.next;
            current.next = before;
            before = current;
            current = after;
        }
        head = before;
    }


    // Interview Questions
    public Node findMiddleNode() {
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    public boolean hasLoop() {
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) return true;
        }

        return false;
    }

    public Node findKthFromEnd(int k) {
        Node slow = head;
        Node fast = head;

        for (int i = 0; i < k; i++) {
            if (fast == null) return null;
            fast = fast.next;
        }

        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }


    public void partitionList(int x) {
        if (head == null) return;

        Node dummy1 = new Node(0);
        Node dummy2 = new Node(0);
        Node prev1 = dummy1;
        Node prev2 = dummy2;

        Node current = head;

        while (current != null) {
            if (current.value < x) {
                prev1.next = current;
                prev1 = prev1.next;
            } else {
                prev2.next = current;
                prev2 = prev2.next;
            }
            current = current.next;
        }

        prev2.next = null;
        prev1.next = dummy2.next;
        head = dummy1.next;
    }

    public void removeDuplicates1() {
        Set<Integer> set = new HashSet<>();
        Node prev = head;
        Node temp = head;

        while (temp.next != null) {

            prev = temp;
            temp = prev.next;
            set.add(prev.value);

            if (set.contains(temp.value)) {
                prev.next = temp.next;
            }

        }
    }

    public void removeDuplicates() {
        Set<Integer> values = new HashSet<>();
        Node previous = null;
        Node current = head;

        while (current != null) {
            if (values.contains(current.value)) {
                previous.next = current.next;
                length--;
            } else {
                values.add(current.value);
                previous = current;
            }
            current = current.next;

        }
    }

    public void removeDuplicates2() {
        Node current = head;

        while (current != null) {
            Node runner = current;

            while (runner.next != null) {
                if (runner.next.value == current.value) {
                    runner.next = runner.next.next;
                    length--;
                } else {
                    runner = runner.next;
                }

            }
            current = current.next;
        }
    }

    public int binaryToDecimal() {
        //reverse list
        Node temp = head;

        Node before = null;
        Node after;

        while (temp != null) {
            after = temp.next;
            temp.next = before;
            before = temp;
            temp = after;
            if (temp != null && temp.next == null) {
                head = temp;
            }
        }

        temp = head;
        int powOfTwo = 1;
        int sum = 0;

        while (temp != null) {
            int value = temp.value;
            sum = sum + (powOfTwo * value);
            powOfTwo *= 2;
            temp = temp.next;
        }
        return sum;
    }

    public int binaryToDecimal2() {
        int num = 0;
        Node current = head;

        while (current != null) {
            num = num * 2 + current.value;
            current = current.next;
        }
        return num;
    }

    public void reverseBetween(int m, int n) {

        Node tail1 = head;
        Node head2 = null;
        Node tail2 = null;
        Node head3 = null;

        Node before = null;
        Node current = null;
        Node after = null;
        // reverse between
        if (m > 0 && n < length - 1) {   // head....tail1   head2...tail2   head3....


            //find tail1 and head2
            for (int i = 0; i < m - 1; i++) {
                tail1 = tail1.next;
            }
            head2 = tail1.next;

            //find tail2 and head3
            tail2 = head2;
            for (int i = m; i < n; i++) {
                tail2 = tail2.next;
            }
            head3 = tail2.next;
            tail2.next = null;

            current = head2;
            while (current != null) {
                after = current.next;
                current.next = before;
                before = current;
                current = after;
            }
            tail1.next = tail2;
            head2.next = head3;


        }

        //reverse first part of the list
        if (m == 0 && n < length - 1) {
            tail1 = head;
            for (int i = 0; i < n; i++) {
                tail1 = tail1.next;
            }
            head2 = tail1.next;
            tail1.next = null;

            current = head;
            while (current != null) {
                after = current.next;
                current.next = before;
                before = current;
                current = after;
            }
            head.next = head2;
            head = tail1;

        }

        //reverse the last part of the list
        if (m > 0 && n == length - 1) {
            tail1 = head;
            for (int i = 0; i < m - 1; i++) {
                tail1 = tail1.next;
            }
            head2 = tail1.next;

            current = head2;
            while (current != null) {
                after = current.next;
                current.next = before;
                before = current;
                current = after;
            }
            tail1.next = before;
        }

        // reverse the entire list
        if (m == 0 && n == length - 1) {
            current = head;
            while (current != null) {
                after = current.next;
                current.next = before;
                before = current;
                current = after;
            }
            head = before;
        }

    }

    public void reverseBetween2(int startIndex, int endIndex) {
        Node dummy = new Node(0);
        dummy.next = head;
        Node before = dummy; // node before start index

        for (int i = 0; i < startIndex; i++) { //  dummy 0 1 2 3 4
            before = before.next;
        }

        Node current = before.next; // before = 1     current = 2

        for (int i = 0; i < endIndex - startIndex; i++) {// 1  2 3
            Node nodeToMove = current.next;
            current.next = nodeToMove.next;
            nodeToMove.next = before.next;
            before.next = nodeToMove;
        }

        head = dummy.next;
    }


}



