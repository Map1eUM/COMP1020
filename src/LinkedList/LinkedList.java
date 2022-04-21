package LinkedList;

import groovyjarjarantlr4.v4.runtime.misc.ObjectEqualityComparator;

import static processing.core.PApplet.println;

//deLinkedList

public class LinkedList {
    Node top;
    Node end;

    private int ListSize = 0;

    //use ListSize will be easier by consider ListSize=0 or not!(But I don't)
    //You can initiate the top and end and use as empty nodes, or just use as reference to first and last real element.

    public LinkedList() {
        this.top = new Node(0);
        this.end = new Node(0);
        this.top.nxt = this.end;
        this.end.pre = this.top;
    }


    //O(1)
    public void addBack(Object newData) {
        // four operations.
        Node newEndData = new Node(newData);
        Node oldEndData = this.end.pre;
        oldEndData.nxt = newEndData;
        newEndData.pre = oldEndData;
        newEndData.nxt = this.end;
        this.end.pre = newEndData;
        ++this.ListSize;
    }

    public void addFront(Object newData) {
        Node newTopData = new Node(newData);
        Node oldTopData = this.top.nxt;
        newTopData.nxt = oldTopData;
        oldTopData.pre = newTopData;
        this.top.nxt = newTopData;
        newTopData.pre = this.top;
        ++this.ListSize;
    }

    //O(n)

    public String toString() {
        String S = String.format("This LinkedList has %d elements:\n", this.ListSize);
        Node cur = this.end.pre;
        do {
            S += String.valueOf(cur.data) + ' ';
            cur = cur.pre;
//            println(cur.data);
        } while (cur != this.top);
        return S;
    }

}



