package tree;


/* --- IMPORTANT: Do NOT change any code within this interface. ------------- */

public interface TreeADT<T>
{
    public T getRootElement();
    
    public boolean isEmpty();
    
    public int size();
    
    //Returns true if the tree contains an element that matches 
    //the specified 'target', otherwise it'll return false. 
    public boolean contains(T target);
    
    //Returns a reference to the specified 'target' element if it is 
    //found within this tree, otherwise it'll throw an exception.
    public T find(T target);
}
