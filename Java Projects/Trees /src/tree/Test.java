package tree;


public class Test 
{
    /*
     *  Feel free to change the code here to test out various things.
     *  Remember, only the code written in 'ArrayBinaryTree.java' is relevant towards your grade.
     */
    public static void main(String[] args) 
    {
        ArrayBinaryTree<String> tree = new ArrayBinaryTree("A", 3);
        
        tree.setLeftChild(0, "B");
        tree.setRightChild(0, "C");
        
        tree.setLeftChild(2, "D");
        tree.setRightChild(2, "E");
        
        System.out.println(tree + "\n");
        
        String value = tree.getElement(2);
        System.out.println("Index of " + value + "'s left child: " + tree.getLeftIndex(2));
        System.out.println("Index of " + value + "'s right child: " + tree.getRightIndex(2) + "\n");
        
        System.out.println("Replacing node at index " + tree.getParentIndex(1));
        tree.setParentNode(1, "F");
        System.out.println(tree + "\n");
        
        System.out.println("Replacing node at index " + tree.getParentIndex(5));
        tree.setParentNode(5, "G");
        System.out.println(tree);
        
        System.out.println("\nRoot has " + tree.numChildren(0) + " children");
        System.out.println("Left Child of Root has " + tree.numChildren(1) + " children");
        System.out.println("Right Child of Root has " + tree.numChildren(2) + " children");
    }
}
