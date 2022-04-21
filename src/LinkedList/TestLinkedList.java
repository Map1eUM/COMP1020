package LinkedList;

import static processing.core.PApplet.print;

public class TestLinkedList {
    public static void test() {
        try {
            String S = "a12";
            int x = Integer.parseInt(S);
        } catch (Exception e) {
            print("AA");
        }
        print("BB");
    }
    public static void main(String[] args) {

//        Node x1=new Node(12);
//        Node x2= x1;
//        print(x1==x2);

//        LinkedList lst = new LinkedList();
//        lst.addFront(32);
//        lst.addBack(180);
//        lst.addFront(27);
//        lst.addBack(10);
//        print(lst);
        test();
    }
}

