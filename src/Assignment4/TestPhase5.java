package Assignment4;

import java.io.FileWriter;
import java.io.IOException;

public class TestPhase5
{
	public static void main (String[] args) throws IOException {
		FileWriter fw=new FileWriter("output.txt");
		fw.write("FUCK COMP");
//		fw.close();
//		//Testing the orderedInsertRec
//		DoublyLinkedList myList = new DoublyLinkedList();
//
//		myList.orderedInsertRec(new Node(22.1, null, null), myList.getLast());
//		fw.write(myList);
//
//		myList.orderedInsertRec(new Node(5.55, null, null), myList.getLast());
//		fw.write(myList);
//
//		myList.orderedInsertRec(new Node(1, null, null), myList.getLast());
//		fw.write(myList);
//
//		myList.orderedInsertRec(new Node(111121212121212l, null, null), myList.getLast());
//		fw.write(myList);
//
//		myList.orderedInsertRec(new Node(600, null, null), myList.getLast());
//		fw.write(myList);
//
//		myList.orderedInsertRec(new Node(0.5, null, null), myList.getLast());
//		fw.write(myList);
//
//		myList.orderedInsertRec(new Node(77.789, null, null), myList.getLast());
//		fw.write(myList);
//		fw.write(myList.toStringReversed());
//
//		fw.write();  //spacing

		//Testing the insertionSort
//		DoublyLinkedList toSort = DoublyLinkedList.createList("C:\\Users\\chenr5-INS\\IdeaProjects\\COMP1020\\src\\Assignment4\\list.txt");
//		fw.write("Before sorting:\n" + toSort);
//
//		toSort.insertionSort();
//		fw.write("After sorting:\n" + toSort);
//		fw.close();
//		fw.write("");  //spacing

		//2nd test for insertionSort
		DoublyLinkedList toSort2 = DoublyLinkedList.createList("C:\\Users\\chenr5-INS\\IdeaProjects\\COMP1020\\src\\Assignment4\\list2.txt");
		fw.write("Before sorting:\n" + toSort2);
		toSort2.insertionSort();
		fw.write("After sorting:\n" + toSort2);
		fw.close();
	}
}