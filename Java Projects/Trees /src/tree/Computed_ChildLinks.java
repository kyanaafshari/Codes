package tree;

/* --- IMPORTANT: Do NOT change any code within this interface. ------------- */

public interface Computed_ChildLinks<T>
{
    //Return number indicating where (if at all) 'target' is located
    //within the array collection. Otherwise, it should return -1.
    public int indexOf(T target);

    //Returns the number of [non-null] children said 'node' has.
    public int numChildren(int node);
            
    //Returns the index of where the parent of said 'node' is at.
    public int getParentIndex(int node);
    
    //Returns the parent element of said 'node'.
    public T getParentNode(int node);
    
    //Replaces the element of given 'node's parent with 'obj'.
    public T setParentNode(int node, T obj);
    
    //Returns the index of where the left child of said 'node' is at.
    public int getLeftIndex(int node);
    
    //Returns the left child element of said 'node'.
    public T getLeftChild(int node);
    
    //Replaces the element of given 'node's left child with 'obj'.
    public T setLeftChild(int node, T obj);
    
    //Returns the index of where the right child of said 'node' is at.
    public int getRightIndex(int node);
    
    //Returns the right child element of said 'node'.
    public T getRightChild(int node);
    
    //Replaces the element of given 'node's right child with 'obj'.
    public T setRightChild(int node, T obj);
}

