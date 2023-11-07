package day15;

public class MyLinkedList {

	Node head;

	public Node getByValue(int value) {

		Node currentNode = head;

		while (currentNode != null) {
			if (currentNode.data == value) {
				return currentNode;
			}

			currentNode = currentNode.next;
		}

		return null;
	}

	public Node getByIndex(int index) {

		Node currentNode = head;
		int currentIndex = 0;

		while (currentNode != null) {
			if (currentIndex == index) {
				return currentNode;

			}

			currentNode = currentNode.next;
			currentIndex++;
		}
		return null;

	}

	public void addNoteAtIndex(Node newNode, int index) {

		if (index == 0) {
			newNode.next = head;
			head = newNode;

		}
		
		Node currentNode = head;
		int currentIndex = 0;

		while (currentIndex < index - 1) {
			currentNode = currentNode.next;
			currentIndex++;

		}
		if (currentNode.next == null && currentIndex == index - 1) {
			currentNode.next = newNode;
			newNode.next = null;
		} else {
			newNode.next = currentNode.next;
			currentNode.next = newNode;
		}

	}

}
