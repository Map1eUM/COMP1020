package Assignment4;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class DoublyLinkedList {
	/*
	The following code is provided. You are not allowed to modify it.
	*/

    //
    //Instance variables
    //
    private Node first;  //the first LinkedList.Node (or the top LinkedList.Node) of the list
    private Node last;  //the last LinkedList.Node of the list

    //
    //Instance methods
    //

    //accessor for the first LinkedList.Node
    public Node getFirst() {
        return first;
    }

    //accessor for the last LinkedList.Node
    public Node getLast() {
        return last;
    }

	/*
	End of the provided code.
	*/

    //Add your code below.

    //Constant time complexity to add an element to the beginning of the list
    public void addFront(Number data) {
        Node oldFront = this.first;
        this.first = new Node(data, null, this.first);
        if (oldFront != null) oldFront.setPrevious(this.first);
        //important special case!
        if (last == null) this.last = this.first;
    }

    //Constant time complexity to add an element to the end of the list
    public void addEnd(Number data) {
        Node oldEnd = this.last;
        this.last = new Node(data, this.last, null);
        //this is equivalent to: size > 0 setnext, size == 0, first = last!
        if (oldEnd != null) oldEnd.setNext(this.last);
        //important special case!
        if (this.first == null) this.first = this.last;
    }

    //public interface to return the size of this linkedlist
    public int size() {
        return sizeRec(this.first);
    }

    //recursively calculate the size of the LinkedList
    private int sizeRec(Node node) {
        if (node == null) return 0;
        return sizeRec(node.getNext()) + 1;
    }

    //use recursive calls to move through the list and build a String representation of itself
    private String toStringRec(Node node) {
        if (node == null) return ">>";
        return String.valueOf(node.getData()) + " " + toStringRec(node.getNext());
    }

    // This method is the public interface to the toStringRec method described above
    public String toString() {
        return "<< " + toStringRec(this.first);
    }

    //use recursive calls to move through the list and build a reversed String representation of itself
    private String toStringReversedRec(Node node) {
        if (node == null) return ">>";
        return node.getData() + " " + toStringReversedRec(node.getPrevious());
    }

    // This method is the public interface to the toStringReversedRec method described above
    public String toStringReversed() {
        return "<< " + toStringReversedRec(this.last);
    }

    //to create and return a new DoublyLinkedList based on the parsing of a file
    public static DoublyLinkedList createList(String filename) {
        try {
            Scanner reader = new Scanner(new FileReader(filename));
            DoublyLinkedList newList = new DoublyLinkedList();
            parseScanner(reader, newList);
            return newList;
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        //return never reach here!
    }

    // use recursive calls to add elements to the end of given DoublyLinkedList
    private static void parseScanner(Scanner reader, DoublyLinkedList newList) {
        if (!reader.hasNext()) return;
        else {
            if (reader.hasNextInt()) newList.addEnd(reader.nextInt());
            else if (reader.hasNextLong()) newList.addEnd(reader.nextLong());
            else if (reader.hasNextDouble()) newList.addEnd(reader.nextDouble());
            else {
                //simply filtered the non-number data
                if (reader.hasNext()) reader.next();
            }
            parseScanner(reader, newList);
        }
    }

    //remove the given node
    private void removeNode(Node node) {
        Node pre = node.getPrevious();
        Node nxt = node.getNext();

        if (pre != null && nxt != null) {
            //cannot just node = null cuz it will break the link.
            pre.setNext(nxt);
            nxt.setPrevious(pre);
            //no need to set node = null because java should auto collect it.
        } else {
            if (pre == null) {
                node.getNext().setPrevious(null);
                //Finally debugged this::!!
                this.first = node.getNext();
            }
            if (nxt == null) {
                node.getPrevious().setNext(null);
                this.last = node.getPrevious();
            }
        }
    }

    //recursively find the removing node
    private Node removeRec(int index, Node node) {
        if (index == 0) {
            //save the reference to the deleted node in the heap!
            Node ansNode = node;
            removeNode(node);
            return ansNode;
        }
        return removeRec(index - 1, node.getNext());
    }

    //This method is the public interface to the removeRec method
    public Node remove(int index) {
        if (index >= this.size()) {
            throw new IndexOutOfBoundsException("Seems like we have an invalid index!\n");
        } else return removeRec(index, this.first);
    }

    //use recursive calls to move through the list and return the largest Node in the list (by using the compareTo method of the
    //Node class)
    private Node findMaxRec(Node node, Node maxNode) {
        if (node.compareTo(maxNode) > 0) maxNode = node;
        if (node.getNext() == null) return maxNode;
        else return findMaxRec(node.getNext(), maxNode);
    }
    //This method is the public interface to the findMaxRec method
    public Node findMax() {
        if (this.size() == 0) return null;
        return findMaxRec(this.first, this.first);
    }

    //make an ordered insertion of the toInsert Node recursively
    public void orderedInsertRec(Node toInsert, Node current) {
        if (current == null) {
            //Assume this list is empty. special case
            this.first = this.last = toInsert;
            return;
        }
        if (toInsert.compareTo(current) < 0) {
            if (current.getPrevious() != null) orderedInsertRec(toInsert, current.getPrevious());
            else {
                if (toInsert.getNext() != null)
                    toInsert.getNext().setPrevious(toInsert.getPrevious());
                if (toInsert.getPrevious() != null)
                    toInsert.getPrevious().setNext(toInsert.getNext());
                current.setPrevious(toInsert);
                toInsert.setNext(current);
                //??
                toInsert.setPrevious(null);
                this.first = toInsert;
                return;
            }
        } else {
            if (current.getNext() == toInsert) {
                this.last = toInsert;
                return;
            }
            //Six possible links to update!
            if (toInsert.getNext() != null) toInsert.getNext().setPrevious(toInsert.getPrevious());
            if (toInsert.getPrevious() != null) toInsert.getPrevious().setNext(toInsert.getNext());
            if (current.getNext() != null) current.getNext().setPrevious(toInsert);
            toInsert.setNext(current.getNext());
            current.setNext(toInsert);
            toInsert.setPrevious(current);
            //remember to update the last element!
            if (toInsert.getNext() == null) this.last = toInsert;
            return;
        }
    }
    //use recursive calls to move through the list, take the current Node and
    //insert it in the right spot inside the sorted part
    //of the list
    private void insertionSortRec(Node curNode) {
        //start from the second one! if only one or no element this method shouldn't be called!
        if (curNode == null) return;
//        println(String.format("This is %d element",++x));
//        println(curNode);
        //??
        Node nxtCurNode = curNode.getNext();
        orderedInsertRec(curNode, curNode.getPrevious());
        insertionSortRec(nxtCurNode);
    }
    // This method is the public interface to the insertionSortRec method
    public void insertionSort() {
        //already sorted.
        if (this.size() == 1 || this.size() == 0) return;
        else insertionSortRec(this.first.getNext());
    }
}