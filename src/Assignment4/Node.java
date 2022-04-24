package Assignment4;

import static java.lang.Math.abs;

public class Node {
	/*
	The following code is provided. You are not allowed to modify it.
	*/

    //
    //Instance variables
    //
    private Number data; //the data stored in the node must be a subclass of Number (in our assignment, it could be either an Integer, Double or Long)

    private Node previous;  //a link to the previous LinkedList.Node
    private Node next;  //a link to the next LinkedList.Node


    //
    //Constructor
    //
    public Node(Number data, Node previous, Node next) {
        this.data = data;
        this.previous = previous;
        this.next = next;
    }


    //
    //Instance methods
    //

    //accessor for the data
    public Number getData() {
        return data;
    }

    //accessor for the previous LinkedList.Node
    public Node getPrevious() {
        return previous;
    }

    //accessor for the next LinkedList.Node
    public Node getNext() {
        return next;
    }

    //mutator for the previous LinkedList.Node
    public void setPrevious(Node newPrev) {
        previous = newPrev;
    }

    //mutator for the next LinkedList.Node
    public void setNext(Node newNext) {
        next = newNext;
    }

	/*
	End of the provided code.
	*/

    //Add your code below.

    public int compareTo(Node node) {
        int type1 = 0, type2 = 0;
        if (this.data instanceof Double) type1 = 3;
        if (this.data instanceof Long) type1 = 2;
        if (this.data instanceof Integer) type1 = 1;
        if (node.data instanceof Double) type2 = 3;
        if (node.data instanceof Long) type2 = 2;
        if (node.data instanceof Integer) type2 = 1;
        if (type1 > type2) return 1;
        else if (type1 < type2) return -1;
        else {
            double data1 = this.data.doubleValue();
            double data2 = node.data.doubleValue();
            if (data1 < data2) return -1;
            else if (data1 == data2) return 0;
            else return 1;

        }

    }



}