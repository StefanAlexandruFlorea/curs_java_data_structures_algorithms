package datastructures.hashtable;

import org.w3c.dom.Node;

import java.util.ArrayList;

public class HashTable {
    private int size = 7;
    private Node[] dataMap;

    class Node {
        String key;
        int value;
        Node next;

        public Node(String key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    public HashTable() {
        dataMap = new Node[size];
    }

    public Node[] getDataMap() {
        return dataMap;
    }

    public void printTable() {
        for (int i = 0; i < dataMap.length; i++) {
            System.out.println(i + ":");
            if (dataMap[i] != null) {
                Node temp = dataMap[i];
                while (temp != null) {
                    System.out.println("   {" + temp.key + ", " + temp.value + "}");
                    temp = temp.next;
                }
            }
        }
    }

    public void set(String key, int value) {
        Node newNode = new Node(key, value);
        int index = hash(key);

        if (dataMap[index] == null) {
            dataMap[index] = newNode;
        } else {
            Node current = dataMap[index];
            if (current.key.equals(key)) {
                current.value = value;
                return;
            }

            while (current.next != null) {
                if (current.key.equals(key)) {
                    current.value = value;
                    return;
                }
                current = current.next;
            }
            current.next = newNode;
        }
    }

    private int hash(String key) {
        int hash = 0;
        for (char c : key.toCharArray()) {
            hash = (hash + c * 23) % dataMap.length;
        }
        return hash;
    }

    public int get(String key) {
        int index = hash(key);

        if (dataMap[index] == null) return 0;
        Node current = dataMap[index];
        while (current != null) {
            if (current.key.equals(key)) {
                return current.value;
            }
            current = current.next;
        }
        return 0;
    }

    public ArrayList keys(){
        ArrayList<String> keys = new ArrayList<>();

        for(int i = 0; i< dataMap.length; i++){
            Node current = dataMap[i];
            while(current!=null){
                keys.add(current.key);
                current=current.next;
            }
        }
        return keys;
    }



}
