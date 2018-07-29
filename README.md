# RedBlackTree
Red-black tree project in Java

Unzipped folder contains entire project (folder) exported from NetBeans. This includes the dictionaryfile.txt, src package, 
test package, and a folder titled "nbproject". User can create a new project, then create a main source package (for main classes) 
and a test package (for the JUnit test), and then import the corresponding java files. The main source package has files: RedBlackTree 
(the main red-black tree class) and DictionaryTest (the general tester that prints results and prompts user). The test package is 
for the JUnit test and the class is called JUnitRBTest. My NetBeans uses JUnit test library version 4.10.

RED BLACK TREE SPEC:
“Since a Red Black Tree is a binary search tree, the following property must be true: the value in every node is larger than the value of the left child (or any value in the left subtree) and smaller than the value of the right child (or any value in the right subtree). Additionally, a Red Black Tree has these properties:
1. Every node is either red or black
2. Every leaf (NULL pointer) is black
3. If a node is red, both children are black
4. Every path from node to descendent leaf contains the same number of black nodes
5. The root is always black
Red-black trees consist of nodes which are instances of the class that is given in RBNode.h

TO DO: Create a Red Black Tree (RBtree) class. First you will have to give the RBtree all the functionality of a binary search tree.”


REPORT & REFLECTION:
My red-black tree project includes 3 classes: DictionaryTest, RedBlack Tree, and JUnitRBTest. The DictionaryClass is the main tester in which a dictionary text file is scanned, and each word in the dictionary is stored in a red-black tree. It also prompts the user to input a word and returns the color and time it took to search for the word, or key. In my tester, I scanned a dictionary text file and stored all of the words into a redBlackTree. It took 1.55 seconds to create the dictionary in total, and 0 seconds to search for a word which makes sense since red-black trees are self-balancing and are very efficient.

RedBlackTree class includes methods getSibling, getUncle, getGrandparent, getRoot, getColor, fixTree (for adding new nodes), rotateRight, rotateLeft, printPreOrder, and search. I used int values to keep track of the color of the nodes, and the term "data" in place of "key" in the nested node class to store the String values. I had difficulty figuring out where to start when I first began the project. One of the problems was that I was initializing too many variables that did not need to be initialized. I was also making things more complicated for myself by creating a separate Node class outside of the RedBlackTree class when all I had to do was create a nested class to make things simpler. The get methods were simple to implement, as well as the search, toString, and printPreOrder methods. However, my fixTree method continued to give me errors for hours. I later realized that it was because I did not include in my several if statements: "y!=null". I was not checking to make sure whether or not there was an existing node, so that continued to give me problems. I almost ended up changing my entire code because of that one mistake. The addNode method was fairly simple to implement. Overall, this project took me several hours to complete, but I am glad that I was able to catch my mistakes and write and understand the code. I will also implement the delete operation on my own, outside of this project.
