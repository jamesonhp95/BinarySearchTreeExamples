/*
    Author: Jameson Price
    This file contains the class for BinarySearchTree, which contains methods for insertion, as well printAllPath() which
    prints all of the paths in the BST using recursion, and printAllPath2() which prints all of the paths using the stack.
 */

import java.util.ArrayList;
import java.util.Stack;

public class BinarySearchTree {

    private Node root;
    private Integer size = 0;

    private class Node {
        Node left;
        Node right;
        boolean leftv;
        boolean rightv;
        Comparable data;

        Node(Comparable newData)
        {
            left = null;
            right = null;
            leftv = false;
            rightv = false;
            data = newData;
        }
    }

    public BinarySearchTree()
    {
        this.root = null;
    }

    public void insert(Comparable data)
    {
        this.size++;
        root = insert(root, data);
    }

    /**
        This method looks at the current node data and compares it to the passed in Comparable data,
        then it recursively calls insert with the left or right pointers respectively along with data until
        it reaches a null pointer and then constructs a new node to be the last nodes left or right node.
     */
    private Node insert(Node node, Comparable data)
    {
        if(node == null)
            node = new Node(data);
        else
        {
            if(data.compareTo(node.data) < 0)
                node.left = insert(node.left, data);
            else
                node.right = insert(node.right, data);
        }
        return node;
    }

    /**
        This method creates the arrayList that will be used for printing paths and sends it to the printAllPathHelper.
     */
    public void printAllPath()
    {
        ArrayList<Comparable> toPrint = new ArrayList<>();
        printAllPathHelper(root, toPrint, 0);
    }

    /**
        This method has the base case of checking if root is null, otherwise it adds the data of the current node at the index signifying its depth.
        Then if the current root node is a leaf node, it prints the path from index 0 up until its depths i.
        Otherwise if the node is not a root node, i is incremented and then we recursively call printAllPathHelper for
        both the left and right subtrees of the root node, passing the path as well as i.
     */
    private void printAllPathHelper(Node root, ArrayList<Comparable> path, int i)
    {
        if(root == null) { return; }
        path.add(i, root.data);
        if(root.left == null && root.right == null)
        {
            System.out.print("Path: ");
            int x;
            for(x=0; x < i; x++)
            {
                System.out.print(path.get(x) + " -> ");
            }
            System.out.print(path.get(x));
            System.out.println();
        }
        else
        {
            i++;
            printAllPathHelper(root.left, path, i);
            printAllPathHelper(root.right, path, i);
        }
    }

    /**
        This method checks if root is null, if not it creates a stack and pushes a string that consists of the current path
        onto the stack as well as the root node. Then while the stack is not empty, both the node at the top of the stack and
        the current path at the top of the stack are popped off the stack. Then if it is a leaf node, I print the entire current path.
        If the right subtree is not null, I manipulate the path to include the right subtrees roots data and push the newPath as well as
        the right subtree root onto the stack. I then duplicate this for the left subtree if it is not null.
     */
    public void printAllPath2()
    {
        if (root == null) {
            return;
        }
        Stack myStack = new Stack();
        myStack.push(root.data + "");
        myStack.push(root);
        Node cur;
        String path = "";
        String newPath = "";
        while (!myStack.empty()) {
            cur = (Node) myStack.pop();
            path = (String) myStack.pop();
            if (cur.left == null && cur.right == null) {
                System.out.print("Path: ");
                System.out.println(path);
            }
            if (cur.right != null) {
                newPath = path + " -> " + cur.right.data;
                myStack.push(newPath);
                myStack.push(cur.right);
            }
            if (cur.left != null) {
                newPath = path + " -> " + cur.left.data;
                myStack.push(newPath);
                myStack.push(cur.left);
            }
        }
    }
}
