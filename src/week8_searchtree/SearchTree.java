/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package week8_searchtree;

/**
 *
 * @author Marc
 */
public class SearchTree {
    public Node root;
    
    public SearchTree() {        
    }
    
    public Node treeMinimum(Node x) {
        while (x.left != null) {
            x = x.left;
        }
        return x;
    }
    
    public Node treeMaximum(Node x) {
        while (x.right != null) {
            x = x.right;
        }
        return x;
    }
    
    public Node treeSuccessor(Node x) {
        if (x.right != null) {
            return treeMinimum(x.right);
        }
        Node y = x.p;
        while (y != null && x == y.right) {
            x = y;
            y = y.p;
        }
        return y;
    }
    
    public void treeInsert(Node z) {
        Node y = null;
        Node x = root;
        while (x != null) {
            y = x;
            if (z.key < x.key) {
                x = x.left;
            } else {
                x = x.right;
            }
        }
        z.p = y;
        if (y == null) {
            root = z;       //tree was empty
        } else if (z.key < y.key) {
            y.left = z;
        } else {
            y.right = z;
        }
    }
    
    public void transplant(Node u, Node v) {
        if (u.p == null) {
            root = v;
        } else if (u == u.p.left) {
            u.p.left = v;
        } else {
            u.p.right = v;
        }
        if (v != null) {
            v.p = u.p;
        }
    }
    
    public void treeDelete(Node z) {
        if (z.left == null) {
            transplant(z,z.right);
        } else if (z.right == null) {
            transplant(z,z.left);
        } else {
            Node y = treeMinimum(z.right);
            if (y.p != z) {
                transplant(y,y.right);
                y.right = z.right;
                y.right.p = y;
            }
            transplant(z,y);
            y.left = z.left;
            y.left.p = y;
        }
    }
}
