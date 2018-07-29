import java.io.File;
import java.util.Scanner;

/*
 * General test class that tests Red-Black Tree by storing dictionary words into the tree
 * 
 * @author Naomi Campbell
 */
public class DictionaryTest {

	/*
	 * Method that stores text file values into the Red-Black Tree
	 * 
	 * @param tree Where words will be stored
	 * 
	 * @param filename Dictionary file
	 */
	public static void addDictionary(RedBlackTree tree, String filename) {
		File inputFile = new File(filename);
		Scanner in = null;
		try {
			in = new Scanner(inputFile);
			while (in.hasNextLine()) {
				String word = in.nextLine(); //temporarily store word in variable
				tree.addNode(word); // add that word to tree; create a new node
									// with data
			}
		} 
		catch(Exception exception){
			exception.printStackTrace();
			//System.out .print("An exception has occurred. Unable to load the dictionary in " + filename + "!");
		}
	}

	/*
	 * Main method for testing the Red-Black Tree class
	 */
	public static void main(String[] args) {
                long start = System.currentTimeMillis();
		RedBlackTree test = new RedBlackTree(); //create a new RBTree; root is initially null
		addDictionary(test, "dictionaryfile.txt"); //add all dictionary words into RBTree
                long end = System.currentTimeMillis();
                long elapsed = end - start;
		test.printPreOrder(test.getRoot());
                System.out.println("Total time to create Dictionary: " + elapsed + " milliseconds");
                //String key1 = "appreciatively";
                //String key1Color = RedBlackTree.getColor(test.search(key1));
                //System.out.println("Word: " + key1);
                //System.out.println("Color: " + key1Color);
                Scanner reader = new Scanner(System.in);
                System.out.print("Enter a word: ");
                String word = reader.next();
                start = System.currentTimeMillis();
                String wordColor = RedBlackTree.getColor(test.search(word));
                end = System.currentTimeMillis();
                elapsed = end - start;
                System.out.println("Color: " + wordColor);
                System.out.println("Total time to search word: " + elapsed + " milliseconds");
	}


}
