package Assignment4;

import java.io.FileWriter;
import java.io.IOException;

import static processing.core.PApplet.println;

public class TestPhase5
{
	public static void main (String[] args) throws IOException {
//		FileWriter fw=new FileWriter("output.txt");
//		System.out.println("FUCK COMP");
//		fw.close();
		//Testing the orderedInsertRec
		DoublyLinkedList myList = new DoublyLinkedList();

		myList.orderedInsertRec(new Node(22.1, null, null), myList.getLast());
		System.out.println(myList);

		myList.orderedInsertRec(new Node(5.55, null, null), myList.getLast());
		System.out.println(myList);

		myList.orderedInsertRec(new Node(1, null, null), myList.getLast());
		System.out.println(myList);

		myList.orderedInsertRec(new Node(111121212121212l, null, null), myList.getLast());
		System.out.println(myList);

		myList.orderedInsertRec(new Node(600, null, null), myList.getLast());
		System.out.println(myList);

		myList.orderedInsertRec(new Node(0.5, null, null), myList.getLast());
		System.out.println(myList);

		myList.orderedInsertRec(new Node(77.789, null, null), myList.getLast());
		System.out.println(myList);
		System.out.println(myList.toStringReversed());
//		println(myList.getLast().getNext().getPrevious());
		println(myList.getFirst());

		System.out.println();  //spacing

//		Testing the insertionSort
		DoublyLinkedList toSort = DoublyLinkedList.createList("C:\\Users\\chenr5-INS\\IdeaProjects\\COMP1020\\src\\Assignment4\\list.txt");
		System.out.println("Before sorting:\n" + toSort);

		toSort.insertionSort();
		System.out.println("After sorting:\n" + toSort);
//		fw.close();
		System.out.println("");  //spacing

		//2nd test for insertionSort
		DoublyLinkedList toSort2 = DoublyLinkedList.createList("C:\\Users\\chenr5-INS\\IdeaProjects\\COMP1020\\src\\Assignment4\\list2.txt");
		System.out.println("Before sorting:\n" + toSort2);
		toSort2.insertionSort();
		System.out.println("After sorting:\n" + toSort2);
//		fw.close();
	}
}