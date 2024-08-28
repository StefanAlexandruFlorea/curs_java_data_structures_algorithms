package datastructures.singlylinkedlist;


// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        LinkedList myLinkedList = new LinkedList(0);

        myLinkedList.append(1);
        myLinkedList.append(2);
        myLinkedList.append(3);

        myLinkedList.printList();
        System.out.println("--------------------");

        myLinkedList.reverse();
        myLinkedList.printList();


    }



}
