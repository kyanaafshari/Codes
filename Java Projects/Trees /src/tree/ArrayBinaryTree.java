package tree;

/*
 * Author: Kyana Afshari
 * Date: 4/27/19
 * Program: ArrayBinaryTree
 */
/*
 *  NOTE For this assignment (and for simplicity's sake), once the array's 
 *  [starting] capacity is set, it CANNOT be expanded upon (or shrunken).
 *
 *  For more info on how this class' methods are supposed to behave, 
 *  read the code / commentary found in the following interfaces.
 */
public class ArrayBinaryTree<T> implements TreeADT<T>, Computed_ChildLinks<T> {
	/* --- IMPORTANT: Do NOT change either of these [2] attributes. --------- */
	private T[] data;

	/* --- IMPORTANT: Do NOT change either of these [2] constructors. ------- */
	public ArrayBinaryTree(T obj) {
		this(obj, 5);
	}

	/*
	 * IE. A binary tree with a [max] height of 2 needs (2^(2+1) - 1) => 7 nodes.
	 * data[0] / \ data[1] data[2] / \ / \ data[3] data[4] data[5] data[6]
	 */
	public ArrayBinaryTree(T obj, int maxHeight) {
		if (maxHeight < 0)
			throw new IllegalArgumentException("Height of tree can't be negative.");

		int capacity = (int) Math.pow(2, maxHeight + 1) - 1;

		data = (T[]) new Object[capacity];

		data[0] = obj;
	}

	public T getRootElement() {
		return data[0];
	}

	// NOTE: Assumes that 'index' is valid.
	public T getElement(int index) {
		return data[index];
	}

	public boolean isEmpty() {
		return (data[0] == null);
	}

	public int size() {
		int count = 0;

		for (T value : data) {
			if (value != null)
				count++;
		}

		return count;
	}

	/*
	 * TODO: Implement method "contains"
	 *
	 * Important: Throw an 'IllegalArgumentException' if argument is null.
	 */
	// Returns true if the tree contains an element that matches
	// the specified 'target', otherwise it'll return false.
	public boolean contains(T target) {
		if (target == null)
			throw new IllegalArgumentException("Error can't have a null value");
		for (int value = 0; value < size(); value++) {
			if (getElement(value).equals(target)) {
				return true;
			}
		}
		return false;
	}

	/*
	 * TODO: Implement method "find"
	 *
	 * Important: Throw an 'IllegalArgumentException' if argument is null. Also,
	 * throw a 'RuntimeException' if argument is not found [anywhere] in the array
	 * tree.
	 */
	// Returns a reference to the specified 'target' element if it is
	// found within this tree, otherwise it'll throw an exception.
	public T find(T target) {
		if (target == null)
			throw new IllegalArgumentException("Error can't have a null value");
		for (int value = 0; value < size(); value++) {
			if (getElement(value).equals(target)) {
				return getElement(value);
			}
		}
		throw new RuntimeException("Not found in array tree");

	}

	/*
	 * TODO: Implement method "indexOf" Important: Throw an
	 * 'IllegalArgumentException' if argument is null.
	 */
	// Return number indicating where (if at all) 'target' is located
	// within the array collection. Otherwise, it should return -1.
	public int indexOf(T target) {
		if (target == null)
			throw new IllegalArgumentException("Error can't have a null value");
		for (int value = 0; value < size(); value++) {
			if (getElement(value).equals(target)) {
				return value;
			}
		}
		return -1;
	}

	/*
	 * TODO: Implement method "numChildren"
	 *
	 * This should work identically to how it does in 'BinaryTreeNode', only now,
	 * the argument will determine where the starting point of the counting should
	 * be. If it were zero, then it starts at the root; if it were one, then it
	 * starts at the left child of the root (and would exclude the root parent and
	 * said root's right subtree); if it were two, then it starts at the right child
	 * of the root, (and would exclude the root parent and said root's left
	 * subtree), etc. - Tip: Use a [similar] recursive-based solution. Important:
	 * Out-of-bound indices and null values have ZERO children. - Do not let the
	 * program crash nor return -1 for these special cases. Tip: Be sure to double
	 * check the validity of your indexes before you use them
	 * 
	 * 
	 * as arguments for function calls / array accesses. do same thing except put in
	 * accessor methods in left/right child or left/right child nodes so i could be
	 * like if left index is right do recursive number of function thing for those
	 * one do my recursion where we get int node so like we get int 1 and we count
	 * root nodes so add results of left child and right child index
	 */
	public int numChildren(int node) {
		if(getRightChild(node) == null && getLeftChild(node) == null) {
		
		return 0;
		}
		
		else if(getRightChild(node) == null) {
			return 1 + numChildren(getLeftIndex(node));
		}
		else if(getLeftChild(node) == null) {
			return 1 + numChildren(getLeftIndex(node));
		}
		else {
			return (2 + numChildren(getLeftIndex(node)) + numChildren(getRightIndex(node)));
		}
	}

	/*
	 * TODO: Implement method "getParentIndex"
	 *
	 * Important: Return -1 if 'node' is an invalid index or it's the root index.
	 */
	public int getParentIndex(int node) {
		if (node <= 0) {
			return -1;
		}
		return (node - 1) / 2;
	}

	/*
	 * TODO: Implement method "getParentNode"
	 *
	 * Important: Return 'null' if computed [parent] index is invalid.
	 */
	// Returns the parent element of said 'node'.
	public T getParentNode(int node) {
		return getElement(getParentIndex(node));
	}

	/*
	 * TODO: Implement method "setParentNode"
	 *
	 * Important: Return 'null' if computed [parent] index is invalid. Otherwise,
	 * return the value of the [old] overwritten element.
	 */
	// Replaces the element of given 'node's parent with 'obj'.
	public T setParentNode(int node, T obj) {
		if (node <= 0)
			return null;
		T temp = getParentNode(node);
		data[getParentIndex(node)] = obj;
		return temp;
	}

	/*
	 * TODO: Implement method "getLeftIndex"
	 *
	 * Important: Return -1 if 'node' is an invalid index.
	 */
	// Returns the index of where the left child of said 'node' is at.
	public int getLeftIndex(int node) {
		if (node <= 0)
			return -1;
		return node * 2 + 1;
	}

	/*
	 * TODO: Implement method "getLeftChild"
	 *
	 * Important: Return 'null' if computed [left child] index is invalid.
	 */
	// Returns the left child element of said 'node'.
	public T getLeftChild(int node) {
		if (node <= 0)
			return null;
		return getElement(getLeftIndex(node));
	}

	/*
	 * TODO: Implement method "setLeftChild"
	 *
	 * Important: Return 'null' if computed [left child] index is invalid.
	 * Otherwise, return the value of the [old] overwritten element.
	 */
	// Replaces the element of given 'node's left child with 'obj'.
	public T setLeftChild(int node, T obj) {
		if (node <= 0)
			return null;
		T temp = getLeftChild(node);
		data[getLeftIndex(node)] = obj;
		return temp;
	}

	/*
	 * TODO: Implement method "getRightIndex"
	 *
	 * Important: Return -1 if 'node' is an invalid index.
	 */
	// Returns the index of where the right child of said 'node' is at.
	public int getRightIndex(int node) {
		if (node <= 0)
			return -1;
		return node * 2 + 2;
	}

	/*
	 * TODO: Implement method "getRightChild"
	 *
	 * Important: Return 'null' if computed [right child] index is invalid.
	 */
	// Returns the right child element of said 'node'.

	public T getRightChild(int node) {
		if (node <= 0)
			return null;
		return getElement(getRightIndex(node));
	}

	/*
	 * TODO: Implement method "setRightChild"
	 *
	 * Important: Return 'null' if computed [right child] index is invalid.
	 * Otherwise, return the value of the [old] overwritten element.
	 */
	public T setRightChild(int node, T obj) {
		if (node <= 0)
			return null;
		T temp = getRightChild(node);
		data[getRightIndex(node)] = obj;
		return temp;
	}

	private boolean isValidIndex(int index) {
		return (index >= 0 && index < data.length);
	}

	// Returns a string with content of 'data' in the following format
	// (where 'n' is equal to said array's length, minus one):
	// "Nodes: <d[0]> <d[1]> <d[2]> ... <d[n]>"
	// "Index: 0 1 2 ... n "
	public String toString() {
		String firstRow = "Nodes: ";
		String secondRow = "Index: ";

		for (int index = 0; index < data.length; index++) {
			T value = data[index];

			// Note to Reader: Uncomment this bit of code if you only want non-null elements
			// to be printed.
			// if(value == null)
			// continue;

			String text = "null";
			int tabLength = 2;

			if (value != null) {
				text = value.toString();
				tabLength = text.length() / 2;
			}

			for (int i = 0; i < tabLength; i++)
				secondRow += " ";

			firstRow += value + " ";
			secondRow += index + " ";

			if (text.length() % 2 == 0)
				tabLength--;

			for (int i = 0; i < tabLength; i++)
				secondRow += " ";
		}

		return firstRow + "\n" + secondRow;
	}
}
