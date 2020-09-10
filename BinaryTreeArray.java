import java.util.ArrayList;

/* Java implementation of a Binary tree using an array.
 */

/* To do:
 * - shift children nodes if deleting a parent
 * - convert to binary heap
 */

class Children {
	public String leftChild;
	public String rightChild;
	
	public Children(String left, String right) {
		leftChild = left;
		rightChild = right;
	}
}

public class BinaryTreeArray {
	private ArrayList<String> tree;
	private String root;
	
	public BinaryTreeArray() {
		tree = new ArrayList<String>();
		root = null;
	}
	
	public BinaryTreeArray(String str) {
		tree = new ArrayList<String>();
		root = str;
		tree.add(root);
	}
	
	public BinaryTreeArray(ArrayList<String> nodes) {
		tree = nodes;
		root = tree.get(0);
	}
	
	public String getRoot() {
		return root;
	}
	
	public void addNode(String str) {
		tree.add(str);
	}
	
	// Iterate through arraylist and removes inputed string
	public void deleteNode(String str) {
		for (int i = 0; i < tree.size(); i++) {
			if (str.equals(tree.get(i))) {
				tree.remove(i);
				return;
			}
		}
		System.out.println("Could not find string " + str + " in tree.");
 	}
	
	// parent, left, right
	public void preorderTraversal(int index) {
		if (index > tree.size() - 1) {
			return;
		}
		
		printNode(index);
		preorderTraversal(2 * index + 1);
		preorderTraversal(2 * index + 2);
	}
	
	// left, parent, right
	public void inorderTraversal(int index) {
		if (index > tree.size() - 1) {
			return; 
		}
		
		inorderTraversal(2 * index + 1);
		printNode(index);
		inorderTraversal(2 * index + 2);
	}
	
	// left, right, parent
	public void postorderTraversal(int index) {
		if (index > tree.size() - 1) {
			return; 
		}
		
		postorderTraversal(2 * index + 1);
		postorderTraversal(2 * index + 2);
		printNode(index);
	}
	
	private void printNode(int index) {
		String node = tree.get(index);
		if (node == null) {
			return;
		}
		System.out.print(node + " ");
	}
	
	private Children getChildren(int index) {
		String left = tree.get(2 * index + 1);
		String right = tree.get(2 * index + 2);
		return new Children(left, right);
	}
	
	
	public static void main(String[] args) {
		ArrayList<String> nodes = new ArrayList<String>();
		nodes.add("F");
		nodes.add("B");
		nodes.add("G");
		nodes.add("A");
		nodes.add("D");
		nodes.add("O");
		nodes.add("C");
		
		/*					F
		 * 			B				G
		 * 		A		D		O		C
		 */
		
		BinaryTreeArray tree = new BinaryTreeArray(nodes);
		
		tree.preorderTraversal(0); // F B A D G O C
		System.out.println();
		tree.inorderTraversal(0); // A B D F O G C
		System.out.println();
		tree.postorderTraversal(0); // A D B O C G F
		System.out.println();
	}
	
}

