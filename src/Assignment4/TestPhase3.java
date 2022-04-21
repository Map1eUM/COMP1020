package Assignment4;

public class TestPhase3
{
	public static void main (String[] args)
	{
		DoublyLinkedList myList = DoublyLinkedList.createList("C:\\Users\\chenr5-INS\\IdeaProjects\\COMP1020\\src\\Assignment4\\list.txt");

		System.out.println(myList);
		System.out.println("The list has a size of: " + myList.size());

		for (int i = 0; i < 8; i++) //remove 5 items at position 2
		{
			Node removed = myList.remove(2);
			System.out.println("The removed LinkedList.Node contained: " + removed.getData());

			System.out.println("The list has a size of: " + myList.size());
		}

		System.out.println("List (forward): " + myList);
		System.out.println("List (backward): " + myList.toStringReversed());

		//Testing the IndexOutOfBoundsException
		try
		{
			myList.remove(75);
		}
		catch(IndexOutOfBoundsException e)
		{
			System.err.println("Seems like we have an invalid index!");
		}
	}
}