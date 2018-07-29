/*
 * This class provides implementation of Red-Black Trees.
 * Properties:
 * 1. Every node is either red or  black
 * 2. Every leaf (NULL pointer) is black
 * 3. If a node is red, both children are black
 * 4. Every path from node to descendent leaf contains same # of black nodes
 * 5. Root is always black
 * 
 * @author Naomi Campbell
 */

public class RedBlackTree {
	private RBNode root;
	private final int BLACK = 1; //static final?
	private final int RED = 0; //static final?
	
	public class RBNode { //static?
		public RBNode parent;
		public RBNode left;
		public RBNode right;
		public String data;
		public int color;
		
		public RBNode()
		{
		}
		
		//@Override
		public String toString()
		{
			return this.data;
		}
	}
	/*
	 * Red-Black Tree Constructor
	 */
	public RedBlackTree() {
		root = null;
	}
	
	/*
	 * Find sibling node
	 * @param node	finding the sibling of this node
	 */
	public RBNode getSibling(RBNode node)
	{
		if(node==node.parent.left){ //if node is left of parent, sibling is right
			return node.parent.right;
		}
		else
		{
			return node.parent.left;
		}
	}
	
	/*
	 * Find uncle node
	 * @param node	finding the uncle of this node
	 */
	public RBNode getUncle(RBNode node)
	{
		RBNode gp = getGrandparent(node); //get the grandp. of the node
		if(gp == null){
			return null;
		}
		else if(node.parent == gp.left){ //if the parent is left of grandp., uncle would be right of grandp.
			return gp.right;
		}
		else{
			return gp.left; //if parent is right of grandp. print left
		}
	}
	
	/*
	 * Find grandparent node
	 * @param node	finding the grandparent of this node
	 */
	public RBNode getGrandparent(RBNode node)
	{
		if ((node != null) && (node.parent!= null)) //make sure there are existing nodes
		{
			return node.parent.parent;
		}
		else{
			return null;
		}
	}
	
	/*
	 * Returns root (for printing preorder in tester)
	 */
	public RBNode getRoot(){
		if(root == null){
			return null;
		}
		else{
			return root;
		}
	}
	
        public static String getColor(RBNode node){
            if(node != null){
                if(node.color == 1){
                    return "black";
                } else{
                return "red";
                }
            }
            else{
                return "Node does not exist";
            }
        }
        
/*
 * Fixes cases/violations of Red-Black Tree properties (insert follow-up)
 * Not the recursive version
 * @param current	the node that was inserted
 */
	public void fixTree(RBNode current)
	{
		RBNode y = null;
		while ((current != root) && (current.parent.color == RED))
		{	//if current is left child of its parent
			if(current.parent == current.parent.parent.left){
				y = getUncle(current); //initialize y as current's uncle ****
				//case 1, uncle is red:
				if((y != null) && (y.color == RED)){
					current.parent.color = BLACK;
					y.color = BLACK;
					getGrandparent(current).color = RED;
					current = getGrandparent(current); //current.p.p --> grandparent
				}
				//case 2, y black, current is right child:
				else{
					if(current == current.parent.right){
					current = current.parent;
					rotateLeft(current);
					}
				//case 3, y black, current is left child:
					current.parent.color = BLACK;
					getGrandparent(current).color = RED;
					rotateRight(getGrandparent(current)); //rotate right about grandparent
				}
			}
			//if current is right child of its parent; switch left & right
			else{
				y = getUncle(current); //initialize y as current's uncle
				//case 1, uncle is red:
				if((y != null) && (y.color == RED)){
					current.parent.color = BLACK;
					y.color = BLACK;
					getGrandparent(current).color = RED;
					current = getGrandparent(current); //current.p.p --> grandparent
				}
				//case 2, y black, current is left child:
				else{
					if(current == current.parent.left){
					current = current.parent;
					rotateRight(current);
					}
				//case 3, y black, current is left child:
					current.parent.color = BLACK;
					getGrandparent(current).color = RED;
					rotateLeft(getGrandparent(current)); //rotate left about grandparent
				}
			}
		}
		root.color=BLACK;
	}
	
	/*
	 * Inserting/adding a new node to the Red-Black Tree
	 * @param word	the key for the new node; construct a new node
	 * 				storing this word as it's "data"
	 */
	public void addNode(String word){
		RBNode newNode = new RBNode(); //create new node
		newNode.data = word; //store key
		newNode.left = null; //initialize
		newNode.right = null; //initialize
		RBNode y = null;
		RBNode x = root;
		while(x != null){
			y = x;
			if(newNode.data.compareTo(root.data)<=0) // <0?
			{
				x = x.left;
			}else{
				x = x.right;
			}
		}
		newNode.parent = y;
		if(y == null){
			root = newNode;
		}
		else if(newNode.data.compareTo(y.data)<=0){ // <0?
			y.left = newNode;
		}
		else{
			y.right = newNode;
		}
		newNode.left = null;
		newNode.right = null;
		newNode.color = RED;
		fixTree(newNode); //restore RBT properties after adding
	}

	/*
	 * Rotate right about input node
	 * @param node	we're rotating about this node
	 */
	public void rotateRight(RBNode node) { //imagine "node" is y
		RBNode x = node.left;

		node.left = x.right;

    	if (x.right != null)
    	    x.right.parent = node;

    	x.parent = node.parent;

    	if (node.parent == null)
    	    root = x;
    	else {
    	    if (node == node.parent.left)
    	    	node.parent.left = x;
    	    else
    	    	node.parent.right = x;
    	}

    	x.right = node;
    	node.parent = x;
    }
	
	/*
	 * Rotate left about input node
	 * @param node	we're rotating about this node
	 */
	 public void rotateLeft(RBNode node) { //imagine "node" is x
	    	RBNode y = node.right;

	    	node.right = y.left;
	    	if (y.left != null)
	    	    y.left.parent = node;

	    	y.parent = node.parent;
	    	if (node.parent == null)
	    		root = y;
	    	else {
	    	    if (node == node.parent.left)
	    	    	node.parent.left = y;
	      	    else
	      	    	node.parent.right = y;
	    	}
	    	y.left = node;
	    	node.parent = y;
	    }
	
	
	/*
	 * Print tree in preorder; recursive
	 * @param node	root
	 */
	public void printPreOrder(RBNode node) {
		if (node == null) {
			return;
		}
		System.out.println(node.toString().trim());
		printPreOrder(node.left);
		printPreOrder(node.right);
	}
        
        /*
         * Search for a node using a key
         * @param key  trying to find the node for this key
        */
        public RBNode search(String key)
        {
            RBNode current = root;
            while(current != null){
                if(current.data.equals(key)){
                    return current;
                }
                else if(current.data.compareTo(key) <= 0){
                    current = current.right;
                }
                else{
                    current = current.left;
                }
            }
            return null;
        }

}

/*
 * References:
 * CLRS pseudocode
 * http://en.literateprograms.org/Red-black_tree_(Java)
 * http://www-scf.usc.edu/~csci455/curr/bigJava/ch17/worked_example_2/RedBlackTree.java
 */
