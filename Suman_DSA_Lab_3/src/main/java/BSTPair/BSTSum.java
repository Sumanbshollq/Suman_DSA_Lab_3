package BSTPair;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BSTSum {

    public static List<Integer> nodelist = new ArrayList();

    public static Node newNode(int data) {
        Node temp = new Node();
        temp.data = data;
        temp.leftNode = null;
        temp.rightNode = null;
        return temp;
    }

    public static void insert(Node root, Node newNode) {
        if (root.data < newNode.data) {
            if (root.leftNode == null) {
                root.leftNode = newNode;
            } else {
                insert(root.leftNode, newNode);
            }
        } else {
            if (root.rightNode == null) {
                root.rightNode = newNode;
            } else {
                insert(root.rightNode, newNode);
            }
        }
    }

    public static void traverse(Node root) {
        if (root != null) {
            traverse(root.leftNode);
            nodelist.add(root.data);
            traverse(root.rightNode);
        }
    }

    public static void main(String[] args) {

        Node root = null;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of nodes : ");
        int k = sc.nextInt();
        for (int i = 0; i < k; i++) {
            System.out.println("Enter the data for the new node : ");
            int data = sc.nextInt();
            Node nn = newNode(data);
            if (root == null) {
                root = nn;
            } else {
                insert(root, nn);
            }
        }
        System.out.println("Enter the sum value : ");
        int sum = sc.nextInt();
        traverse(root);
        boolean flag = true;
        for (int i = 0; i < nodelist.size(); i++) {
            int val = sum - nodelist.get(i);
            if (nodelist.contains(val) && val != nodelist.get(i)) {
                System.out.println("Pair is =  " + val + " and " + nodelist.get(i));
                flag = false;
                break;
            }
        }
        if (flag) {
            System.out.println("Pair is not found");
        }
    }
}