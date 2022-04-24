package Assignment4;

public class TestPhase2
{
	public static void main (String[] args)
	{
		DoublyLinkedList myList = DoublyLinkedList.createList("C:\\Users\\chenr5-INS\\IdeaProjects\\COMP1020\\src\\Assignment4\\testData.txt");

		System.out.println(myList);
		System.out.println(myList.toStringReversed());

		System.out.println("The list has a size of: " + myList.size());
	}
}