package Assignment4;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.LinkedList;
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

    public void addFront(Number data) {
        Node oldFront = this.first;
        this.first = new Node(data, null, this.first);
        if (oldFront != null) oldFront.setPrevious(this.first);
        //important special case!
        if (last == null) this.last = this.first;
    }

    public void addEnd(Number data) {
        Node oldEnd = this.last;
        this.last = new Node(data, this.last, null);
        //this is equivalent to: size > 0 setnext, size == 0, first = last!
        if (oldEnd != null) oldEnd.setNext(this.last);
        //important special case!
        if (this.first == null) this.first = this.last;
    }

    public int size() {
        return sizeRec(this.first);
    }

    private int sizeRec(Node node) {
        if (node == null) return 0;
        return sizeRec(node.getNext()) + 1;
    }

    private String toStringRec(Node node) {
        if (node == null) return ">>";
        return String.valueOf(node.getData()) + " " + toStringRec(node.getNext());
    }

    public String toString() {
        return "<< " + toStringRec(this.first);
    }

    private String toStringReversedRec(Node node) {
        if (node == null) return ">>";
        return String.valueOf(node.getData()) + " " + toStringReversedRec(node.getPrevious());
    }

    public String toStringReversed() {
        return "<< " + toStringReversedRec(this.last);
    }

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

    private static void parseScanner(Scanner reader, DoublyLinkedList newList) {
        if (!reader.hasNext()) return;
        try {
            newList.addEnd(NumberFormat.getInstance().parse(reader.next()));
            parseScanner(reader, newList);
        } catch (ParseException e) {
            //This should never happen, unless you pass something is not even a number.
//            throw new RuntimeException(e);
            parseScanner(reader, newList);
        }
    }

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

    private Node removeRec(int index, Node node) {
        if (index == 0) {
            //save the reference to the deleted node in the heap!
            Node ansNode = node;
            removeNode(node);
            return ansNode;
        }
        return removeRec(index - 1, node.getNext());
    }

    public Node remove(int index) {
        if (index >= this.size()) {
            throw new IndexOutOfBoundsException("Seems like we have an invalid index!\n");
        } else return removeRec(index, this.first);
    }

    private Node findMaxRec(Node node, Node maxNode) {
        if (node.compareTo(maxNode) > 0) maxNode = node;
        if (node.getNext() == null) return maxNode;
        else return findMaxRec(node.getNext(), maxNode);
    }

    public Node findMax() {
        if (this.size() == 0) return null;
        return findMaxRec(this.first, this.first);
    }

    public void orderedInsertRec(Node toInsert, Node current) {
        if (toInsert == null) return;
        if (current == null) {
            this.first = this.last = toInsert;
            return;
        }
        Node preToIns = toInsert.getPrevious();
        Node nxtToIns = toInsert.getNext();
        Node preCurrent = current.getPrevious();
        Node nxtCurrent = current.getNext();

        if (toInsert.compareTo(current) > 0) {
            if (nxtCurrent == null) {
                current.setNext(toInsert);
                toInsert.setPrevious(current);
                this.last = toInsert;
                return;
            }
            if (nxtCurrent != toInsert) {
                current.setNext(toInsert);
                toInsert.setPrevious(current);
                nxtCurrent.setPrevious(toInsert);
                toInsert.setNext(nxtCurrent);
                if(preToIns!=null)preToIns.setNext(nxtToIns);
                if(nxtToIns!=null) nxtToIns.setPrevious(preToIns);
                return;
            } else return;

        } else {
            if (current.getPrevious() != null)
                orderedInsertRec(toInsert, current.getPrevious());
            else {
                //put toInsert to first one
                this.first = toInsert;
                toInsert.setPrevious(null);
                current.setPrevious(toInsert);
                toInsert.setNext(current);
                if (nxtToIns == null) preToIns.setNext(null);
                else {
                    nxtToIns.setPrevious(preToIns);
                    preToIns.setNext(nxtToIns);
                }
            }


        }
    }

    private void insertionSortRec(Node curNode) {
        //start from the second one! if only one or no element this method shouldn't be called!
//        System.out.println("STACK!");

        orderedInsertRec(curNode,curNode.getPrevious());
    }

    public void insertionSort() {
        //already sorted.
        DoublyLinkedList newlst = new DoublyLinkedList();
        if(this.size()<=1) return;


        insertionSortRec(this.last);
    }

}