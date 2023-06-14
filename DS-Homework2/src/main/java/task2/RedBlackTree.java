package task2;
import task1.Student;

public class RedBlackTree <Key extends Comparable<Key>, Value> {

    private Node<Key, Value> rootNode; //defining the root node from which the traversing of the tree will start
    private static final boolean Red = true;  //Two conctant variables that will define the color of the link
    private static final boolean Black = false;

    // track the number of iterations needed for the get() operation to complete
    public int numSteps = 0;

    public Value get(Key key) {

        Node<Key, Value> currentKey = rootNode; //Creating a root node

        while (currentKey != null) {  //Go trought the tree as long as there is nodes in the tree
            int comparisonResult = key.compareTo(currentKey.key);  //It compares the key (StudentId) of the current node and the provided key
            numSteps++; //For every iteration it increases the number of steps
            if (comparisonResult < 0) {
                currentKey = currentKey.left;  //if the comaprison gives -1 it means that the provided key is less than the current, so it goes to the left subtree
            } else if (comparisonResult > 0) {
                currentKey = currentKey.right; //if the comaprison gives other value it means that the provided key is greater than the current, so it goes to the right subtree
            } else {
                return currentKey.value; //if it is 0 -> key found
            }
        }
        return null;
    }

    /* Because there can be some violations when putting or inserting new nodes into the red-black tree,it is also
       important to have methods that can help to resolve those issues. That's why I added additional methods:
       rotateLeft() -> rotates the right-leaning red link to left.
       rotateRight() -> rotates the left-leaning red link  to right.
       colorFlip() -> changes the color of children links to black, and changes the parent black link to red.
       idRead() -> returns the information if the link is red. */

    private Node<Key,Value> rotateLeft(Node<Key, Value> node) {

        Node <Key,Value> rNode = node.right; //defined the rNode which is the right child of node
        node.right = rNode.left; //left child of rNode becomes right child of node
        rNode.left = node; //node becomes new left child of rNode
        rNode.color = node.color; //update node colors. rNode got in position of node, so it gets the color of it.
        node.color = Red; // node has been changed to red.
        //node.size = 1 + node.left.size + node.right.size;
        return rNode;
    }

    private Node<Key,Value> rotateRight(Node<Key, Value> node) {

        Node<Key,Value> lNode = node.left;
        node.left = lNode.right;
        lNode.right = node;
        lNode.color = node.color;
        node.color = Red;
       // node.size = 1 + node.left.size + node.right.size;

        return lNode;
    }

    public void colorFlip (Node<Key,Value> node){

        //If both children links have red color, the parent link becomes red and the children nodes links get the black color
        node.color = Red;
        node.left.color = Black;
        node.right.color = Black;
    }

    public boolean isRed (Node <Key,Value> node){

        if(node == null){
            return false; //This will treat all null links as black links.
        }

        return node.color == Red;  //If node exists , it compares its link to red.
    }


    public void put (Key key, Value value){ //Add value based on the given key

        rootNode = put(rootNode, key, value);  //insertion strats from the root node, invoking private put() method

    }
    private Node<Key,Value> put(Node<Key,Value> root, Key key, Value value){

        if (root == null){
            return new Node<Key,Value>(key,value,Red); //New node will be inserted at first null position, and its link will be red.
        }

        int comparisonResult = key.compareTo(root.key); //comparison between the provided key and current rootNode key
        if (comparisonResult < 0){
            root.left = put(root.left, key, value);  //if the provided key is less than the rootNode key, we insert the node on its left side, invoking on that inserted node again the put metod in order to keep inserting the nodes
        }
        else if (comparisonResult > 0){
            root.right = put(root.right, key, value); //Same but since the key is greater -> input on right side
        }
        else{
            root.value = value;  //If the keys are equal, that means that the node with that key already exists -> update value
        }

        /*Code below shows the situations when to use the method if there are some violences*/
        if (isRed(root.right) && !isRed(root.left)){
            root = rotateLeft(root);      //if the right link is red and left link is black -> perform the left rotation
        }

        if (isRed(root.left) && isRed(root.left.left)){
            root = rotateRight(root); //if there are two red links on th eleft tree side -> perform the right rotataion
        }

        if (isRed(root.left) && isRed(root.right)){
            colorFlip(root); //if both links from paren node are red, flib their color
        }

        return root;

    }

    //RedLinks counter

    public int countRedLinks() {

        return countRedLinks(rootNode); // Start counting from the root node
    }

    private int countRedLinks(Node<Key, Value> node) {
        if (node == null) {
            return 0; //if node is null, return 0
        }

        int redLinks = 0;
        if (isRed(node)) {
            redLinks = 1; // If the current node is red, increment redLinks by 1
        }

        // Recursively count red links in the left and right subtrees
        redLinks += countRedLinks(node.left);
        redLinks += countRedLinks(node.right);

        return redLinks;
    }
}