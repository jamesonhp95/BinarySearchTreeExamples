/**
    Author: Jameson Price
    This file contains a tester for the BinarySearchTree class for inorder and postorder traversals.
 */

public class Tester {
    public static void main(String args[])
    {
        BinarySearchTree myBST = new BinarySearchTree();
        myBST.insert(8);
        myBST.insert(3);
        myBST.insert(10);
        myBST.insert(14);
        myBST.insert(13);
        myBST.insert(1);
        myBST.insert(6);
        myBST.insert(4);
        myBST.insert(7);
        myBST.inorderTraversal();
        myBST.postorderTraversal();

        boolean success = false;
        success = myBST.delete(8);
        if(success)
            System.out.println("Success!");
        else
            System.out.println("Failure!");
        myBST.inorderTraversal();
        myBST.postorderTraversal();

        success = myBST.delete(10);
        if(success)
            System.out.println("Success!");
        else
            System.out.println("Failure!");
        myBST.inorderTraversal();
        myBST.postorderTraversal();
    }
}