package datastructures.binarysearchtree;

import java.sql.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree {
    private Node root;

    class Node {
        Node left;
        Node right;
        int value;

        public Node(int value) {
            this.value = value;
        }
    }

    public Node getRoot() {
        return root;
    }

    public boolean insert(int value) {
        Node newNode = new Node(value);
        if (root == null) {
            root = newNode;
            return true;
        }
        Node current = root;

        while (true) {
            if (value == current.value) return false;

            if (value < current.value) {
                if (current.left == null) {
                    current.left = newNode;
                    return true;
                }
                current = current.left;

            } else {
                if (current.right == null) {
                    current.right = newNode;
                    return true;
                }
                current = current.right;

            }
        }

    }

    public boolean contains(int value) {
        Node current = root;

        while (current != null) {
            if (value > current.value) {
                current = current.right;
            } else if (value < current.value) {
                current = current.left;
            } else {
                return true;
            }
        }
        return false;
    }

    private boolean rContains(Node current, int value) {
        if (current == null) return false;
        if (current.value == value) return true;
        if (value < current.value) {
            return rContains(current.left, value);
        } else {
            return rContains(current.right, value);
        }
    }

    public boolean rContains(int value) {
        return rContains(root, value);
    }

    private Node rInsert(Node current, int value) {
        if (current == null) return new Node(value);
        if (value < current.value) {
            current.left = rInsert(current.left, value);
        }
        if (value > current.value) {
            current.right = rInsert(current.right, value);
        }
        return current;
    }

    public void rInsert(int value) {
        root = rInsert(root, value);
    }

    public int minValue(Node current) {
        while (current.left != null) {
            current = current.left;
        }
        return current.value;
    }

    private Node deleteNode(Node current, int value) {
        if (current == null) return null;

        if (value < current.value) {
            current.left = deleteNode(current.left, value);
        } else if (value > current.value) {
            current.right = deleteNode(current.right, value);
        } else {
            if (current.left == null && current.right == null) {
                return null;
            } else if (current.left == null) {
                current = current.right;
            } else if (current.right == null) {
                current = current.left;
            } else {
                current.value = minValue(current.right);
                current.right = deleteNode(current.right, current.value);
            }
        }
        return current;
    }

    public void deleteNode(int value) {
        root = deleteNode(root, value);
    }

    private Node sortedArrayToBST(int[] nums, int left, int right) {
        if (left > right) return null;

        int mid = left + (left - right) / 2;

        Node root = new Node(nums[mid]);
        root.left = sortedArrayToBST(nums, left, mid - 1);
        root.right = sortedArrayToBST(nums, mid + 1, right);

        return root;

    }

    public Node sortedArrayToBST(int[] nums) {
        return sortedArrayToBST(nums, 0, nums.length - 1);
    }

    public void invert() {
        root = invertTree(root);
    }

    private Node invertTree(Node node) {
        if (node == null) return null;

        Node temp = node.left;
        node.left = invertTree(node.right);
        node.right = invertTree(temp);

        return node;
    }

    public ArrayList<Integer> breadthFirstSearch(){
        Queue<Node> queue = new LinkedList<>();
        ArrayList<Integer> result = new ArrayList<>();
        Node currentNode = root;
        queue.add(currentNode);

        while(!queue.isEmpty()){
            currentNode = queue.remove();
            result.add(currentNode.value);

            if(currentNode.left != null) queue.add(currentNode.left);

            if(currentNode.right != null) queue.add(currentNode.right);
        }
        return result;
    }
}
