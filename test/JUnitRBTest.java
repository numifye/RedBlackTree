import junit.framework.Assert;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Numi
 */
public class JUnitRBTest{

    /*
    Tests adding/rotating/fixing and makes sure colors are correct
    */
    @Test
    public void testAddNode(){
        RedBlackTree tree = new RedBlackTree();
        tree.addNode("c"); //b is black
        tree.addNode("f"); //f is left; red
        tree.addNode("j"); //j is left of f; red
        //NOTE: 1 = black, 0 = red
        //case 1; after fix: root=f (black), root.left=b (red), root.right=j (red)
        Assert.assertEquals(1, tree.getRoot().color);
        Assert.assertEquals(1, tree.search("f").color);
        Assert.assertEquals(0, tree.search("c").color);
        Assert.assertEquals(0, tree.search("j").color);
        tree.addNode("a"); //a is left of b; red, red parent, red uncle
        Assert.assertEquals(1, tree.getRoot().color); //1 = black, 0 = red
        Assert.assertEquals(1, tree.search("f").color);
        Assert.assertEquals(1, tree.search("c").color);
        Assert.assertEquals(1, tree.search("j").color);
        Assert.assertEquals(0, tree.search("a").color);
        tree.addNode("b"); //black uncle; b is red (child of red); case 2+3
        Assert.assertEquals(1, tree.getRoot().color); //1 = black, 0 = red
        Assert.assertEquals(1, tree.search("f").color);
        Assert.assertEquals(0, tree.search("c").color);
        Assert.assertEquals(1, tree.search("j").color);
        Assert.assertEquals(0, tree.search("a").color);
        Assert.assertEquals(1, tree.search("b").color);
    }
    
    /*
    Test to make sure basic tree properties are being maintained. TREE WOULD LOOK LIKE:
        
                f
            b       j
          a   c   *   *
    
    */
    @Test
    public void testProperties(){
        RedBlackTree tree = new RedBlackTree();
        tree.addNode("c");
        tree.addNode("f");
        tree.addNode("j");
        tree.addNode("a");
        tree.addNode("b");
        //make sure left elements smaller than root
        int compared = (tree.getRoot().left.data).compareTo(tree.getRoot().data);
        Assert.assertTrue(compared <= 0);
        //make sure right elements larger than root
        int compared2 = (tree.getRoot().right.data).compareTo(tree.getRoot().data);
        Assert.assertTrue(compared2 >= 0);
        //make sure root's left grandchild is smaller than root's left child
        int compared3 = (tree.getRoot().left.left.data).compareTo(tree.getRoot().left.data);
        Assert.assertTrue(compared3 <= 0);
    }
    
}



