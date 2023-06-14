package task2;
import task1.Student;

public class Node<Key extends Comparable<Key>, Value> {

    public Key key; //main antribute and based on it we construct the tree, place the node in correct place
    public Value value;  //related to Student object
    public Node<Key,Value> left; //reference to left node
    public Node<Key,Value> right; //reference to right node
    public int size = 1; //size of the node is 1 because it represents itself and will be updated when new nodes are inserted
    public boolean color;  //color of the link/edge

    public Node (Key key, Value value, boolean color){
        this.key = key;
        this.value = value;
        this.color = color;
    }
}
