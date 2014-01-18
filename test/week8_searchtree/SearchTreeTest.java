/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package week8_searchtree;

import java.util.Random;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Marc
 */
public class SearchTreeTest {    
    SearchTree tree;
    Node node17, node72;
    
    @Before
    public void setUp() {
        Random random = new Random();
        node17 = new Node(17);
        node72 = new Node(72);
        tree = new SearchTree();
        tree.treeInsert(new Node(50));
        tree.treeInsert(node17);
        tree.treeInsert(new Node(12));
        tree.treeInsert(new Node(9));
        tree.treeInsert(new Node(14));
        tree.treeInsert(new Node(23));
        tree.treeInsert(new Node(19));
        tree.treeInsert(node72);
        tree.treeInsert(new Node(54));
        tree.treeInsert(new Node(67));
        tree.treeInsert(new Node(76));
    }

    @Test
    public void testTreeMinimum() {
        int result = tree.treeMinimum(tree.root).key;
        assertEquals(9,result);
    }

    @Test
    public void testTreeMaximum() {
        int result = tree.treeMaximum(tree.root).key;
        assertEquals(76,result);
    }

    @Test
    public void testTreeSuccessor() {
        int result = tree.treeSuccessor(node17).key;
        assertEquals(19,result);
    }

    @Test
    public void testTreeInsert() {
        tree.treeInsert(new Node(33));
    }

    @Test
    public void testTreeDelete() {
        int result = tree.root.right.key;
        assertEquals(72,result);        
        tree.treeDelete(node72);
        result = tree.root.right.key;
        assertEquals(76,result);
    }
}