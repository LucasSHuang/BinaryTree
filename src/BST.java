import java.util.ArrayList;

/**
 * An Integer Binary Search Tree
 * @author: Lucas
 * @version: 12/9/24
 */

public class BST {
    private BSTNode root;

    public BSTNode getRoot() {
        return this.root;
    }

    public void setRoot(BSTNode root) {
        this.root = root;
    }

    /**
     * Sets up a binary search tree
     * with some default values
     */
    public void setupTestData() {
        this.root = new BSTNode(10);
        this.root.setLeft(new BSTNode(5));
        this.root.setRight(new BSTNode((15)));
        this.root.getLeft().setLeft(new BSTNode(3));
        this.root.getLeft().setRight(new BSTNode(9));
    }

    /**
     * Prints the provided ArrayList of nodes
     * in the form node1-node2-node3
     * @param nodes ArrayList of BSTNodes
     */
    public static void printNodes(ArrayList<BSTNode> nodes) {
        for(int i=0; i<nodes.size()-1; i++) {
            System.out.print(nodes.get(i) + "-");
        }
        System.out.println(nodes.get(nodes.size()-1));
    }

    /**
     * A function that searches for a value in the tree
     * @param val integer value to search for
     * @return true if val is in the tree, false otherwise
     */
    public boolean search(int val) {
        // TODO: Complete the search function
        // Uses the search help function to find if the root is in there or not
        return (searchHelp(val, root));
    }

    public boolean searchHelp(int val, BSTNode node) {
        // Makes it so that if you get to the end it says that it returns false
        if (node == null) {
            return false;
        }
        // Makes it so that if the node equals the value it returns true
        else if (node.getVal() == val) {
            return true;
        }

        // Uses recursion to check if either side contains the value
        return searchHelp(val, node.getRight()) || searchHelp(val, node.getLeft());
    }

    /**
     * @return ArrayList of BSTNodes in inorder
     */
    public ArrayList<BSTNode> getInorder() {
        // TODO: Complete inorder traversal
        // Creates an ArrayList to keep order of the values
        ArrayList<BSTNode> results = new ArrayList<BSTNode>();
        // Uses a helper to find the order of nodes
        getInorderHelp(root, results);
        return results;
    }

    public void getInorderHelp(BSTNode node, ArrayList<BSTNode> results) {
        // Uses recursion in order of Inorder to get right order until you reach the end of the tree at that spot
        if (node != null) {
            getInorderHelp(node.getLeft(), results);
            results.add(node);
            getInorderHelp(node.getRight(), results);
        }
    }

    /**
     * @return ArrayList of BSTNodes in preorder
     */
    public ArrayList<BSTNode> getPreorder() {
        // TODO: Complete preorder traversal
        // Same thing as Inorder
        ArrayList<BSTNode> results = new ArrayList<BSTNode>();
        getPreorderHelp(root, results);
        return results;
    }

    public void getPreorderHelp(BSTNode node, ArrayList<BSTNode> results) {
        // Same as InorderHelp but recursion in Preorder order (root, left, right)
        if (node != null) {
            results.add(node);
            getPreorderHelp(node.getLeft(), results);
            getPreorderHelp(node.getRight(), results);
        }
    }

    /**
     * @return ArrayList of BSTNodes in postorder
     */
    public ArrayList<BSTNode> getPostorder() {
        // TODO: Complete postorder traversal
        // Same as previous two
        ArrayList<BSTNode> results = new ArrayList<BSTNode>();
        getPostorderHelp(root, results);
        return results;
    }

    public void getPostorderHelp(BSTNode node, ArrayList<BSTNode> results) {
        // Same as previous two but in Postorder order (left, right, root)
        if (node != null) {
            getPostorderHelp(node.getLeft(), results);
            getPostorderHelp(node.getRight(), results);
            results.add(node);
        }
    }

    /**
     * Inserts the given integer value to the tree
     * if it does not already exist. Modifies the
     * root instance variable to be the root of the new modified tree.
     * @param val The value ot insert
     */
    public void insert(int val) {
        // TODO: Complete insert
        // Makes it so that if there is no root then this value becomes the root
        if (root == null) {
            root = new BSTNode(val);
        }
        // Checks to see if value is in the tree already
        else {
            if(!search(val)) {
                insertHelp(root, val);
            }
        }
    }

    public void insertHelp(BSTNode node, int val) {
        // Makes it so that if the value is less than the node it goes left and if there is nothing left
        // It adds the value
        if (val < node.getVal()) {
            if (node.getLeft() == null) {
                node.setLeft(new BSTNode(val));
            }
            else {
                insertHelp(node.getLeft(), val);
            }
        }
        // Does the same thing except for the right
        else {
            if (node.getRight() == null) {
                node.setRight(new BSTNode(val));
            }
            else {
                insertHelp(node.getRight(), val);
            }
        }

    }

    /**
     * Determines if the current BST is
     * a valid BST.
     * @return true if valid false otherwise
     */
    public boolean isValidBST() {
        // TODO: Optional Challenge!
        return false;
    }

    public static void main(String[] args) {
        // Tree to help you test your code
        BST tree = new BST();
        tree.setupTestData();

        System.out.println("\nSearching for 15 in the tree");
        System.out.println(tree.search(15));

        System.out.println("\nSearching for 22 in the tree");
        System.out.println(tree.search(22));

        System.out.println("\nPreorder traversal of binary tree is");
        ArrayList<BSTNode> sol = tree.getPreorder();
        printNodes(sol);

        System.out.println("\nInorder traversal of binary tree is");
        sol = tree.getInorder();
        printNodes(sol);

        System.out.println("\nPostorder traversal of binary tree is");
        sol = tree.getPostorder();
        printNodes(sol);

        tree.insert(8);
        System.out.println("\nInorder traversal of binary tree is");
        sol = tree.getInorder();
        printNodes(sol);
    }
}
