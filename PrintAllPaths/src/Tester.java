/*
    Author: Jameson Price
    This file contains a tester for the BinarySearchTree class and the printAllPath(), printAllPath2() methods.
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
        myBST.printAllPath();
        System.out.println();
        myBST.printAllPath2();
    }
}