/*
    Author: Jameson Price
    This file contains the class for BinarySearchTree, which contains methods for insertion, deletion,
    and for inorder and postorder traversal as well as helper methods to accomplish these tasks.
 */

import java.util.ArrayList;

public class BinarySearchTree {

    private Node root;
    private Integer size = 0;

    private class Node {
        Node left;
        Node right;
        Comparable data;

        Node(Comparable newData)
        {
            left = null;
            right = null;
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

    public boolean delete(Comparable data)
    {
        Integer sizeBefore = this.size;
        removeItem(root, data);
        Integer sizeAfter = this.size;
        if(sizeBefore > sizeAfter)
            return true;
        else
            return false;
    }

    /**
        This method recursively moves through the tree until the current node data is equal to the data
        that needs to be removed, upon finding this data it moves to the removeFromRoot method to
        remove the node.
     */
    private Node removeItem(Node root, Comparable toRem)
    {
        if(root == null) { return null; }
        Comparable rootData = root.data;
        if(toRem.compareTo(rootData) == 0)
            root = removeFromRoot(root);
        else if(toRem.compareTo(rootData) < 0)
            root.left = removeItem(root.left, toRem);
        else
            root.right = removeItem(root.right, toRem);
        return root;
    }

    /**
        This method checks three cases;
        If the node to remove has both a left and right subtree, it will set the current root.data to be the largest data
        in the left subtree by calling removeLargest, which will simultaneously remove the largest node.
        If the node only has a right subtree, it sets the root to be root.right.
        If the node only has a left subtree, it sets the root to be root.left.
     */
    private Node removeFromRoot(Node root)
    {
        this.size--;
        if(root.right != null && root.left != null)
            root.data = removeLargest(root.left);
        else if(root.right != null)
            root = root.right;
        else if(root.left != null)
            root = root.left;
        else
            root = null;
        return root;
    }

    /**
        This method finds the largest data within its tree by traversing to root.right until the next node would be null.
        Then it grabs the data and removes the node by setting prev.right to equal root.left so as to keep the tree integrity.
        The data is then returned.
     */
    private Comparable removeLargest(Node root)
    {
        Node prev = null;
        while(root.right != null)
        {
            prev = root;
            root = root.right;
        }

        Comparable lData = root.data;
        prev.right = root.left;
        return lData;
    }

    /**
        postorderTraversal sets up an arraylist for the printPostorder to use and set up the proper
        order of what should be printed.
     */
    public void postorderTraversal()
    {
        ArrayList<Comparable> toPrint = new ArrayList<>();
        printPostorder(root, toPrint);
        System.out.println(toPrint);
    }

    /**
        printPostorder has the base case where if the node is null, it returns, otherwise it recursively
        sends node.left to printPostorder, and node.right to printPostoder. After these have finished, the node
        data is added to the arraylist that will print the postorder of the tree.
     */
    private void printPostorder(Node node, ArrayList<Comparable> aList)
    {
        if(node == null) { return; }
        printPostorder(node.left, aList);
        printPostorder(node.right, aList);
        aList.add(node.data);
    }

    /**
        inorderTraversal sets up the arraylist for printing, and passes the root node as well as the arraylist
        to the printInorderTraversal method.
     */
    public void inorderTraversal()
    {
        ArrayList<Comparable> toPrint = new ArrayList<>();
        printInorderTraversal(root, toPrint);
        System.out.println(toPrint);
    }

    /**
        printInorderTraversal has the base case where if the node is null it returns, otherwise it visits the left subtree
        and then after completely visiting the left subtree, the current nodes data is added to the arraylist. Afterwards,
        the right subtree is sent to printInorderTraversal.
     */
    private void printInorderTraversal(Node node ,ArrayList<Comparable> aList)
    {
        if(node == null) { return; }
        printInorderTraversal(node.left, aList);
        aList.add(node.data);
        printInorderTraversal(node.right, aList);
    }
}
