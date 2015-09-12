package src.linkedlist.com;

import src.exceptions.com.InvalidIndexValue;
import src.exceptions.com.InvalidNodeValue;
import src.exceptions.com.NegativeIndexValue;


/* Circular Doubly Linked List */

public class CircularDoublyLinkedList 
{
	Node head;
	Node tail;
	private int sizeOfList;
	public CircularDoublyLinkedList()
	{
		head = tail = null;
		sizeOfList = 0;
	}
	CircularDoublyLinkedList(CircularDoublyLinkedList dll)
	{
		if(head != null && tail != null)
		{
			Node newHead = new Node(head);
			Node currNode = head;
			Node currNewNode = newHead;
			System.out.println("Following are elements in the doubly linked list");
			while(currNode != null)
			{
				currNewNode.next = new Node(currNode.next);
				currNewNode.prev = new Node(currNode.prev);
				currNode d= currNode.next;
				currNewNode = currNewNode.next;
				if(currNode == head)
					break;
			}
		}
	}
	public boolean insertAtLast(Node newNode) throws InvalidNodeValue
	{
		if(newNode == null)
			throw new InvalidNodeValue();
		if(head == null && tail == null) /*first node*/
		{
			newNode.next = newNode;
			newNode.prev = newNode;
			head = newNode;
			tail = newNode;
		}
		else if (head == tail) /* There is only one node currently in the list*/
		{
			
			Node nodeInList = tail;
			nodeInList.next = newNode;
			nodeInList.prev = newNode;
			newNode.next = nodeInList;
			newNode.prev = nodeInList;
			tail = newNode;
			head.prev = tail;
		}
		else
		{
			Node lastNode = tail;
			lastNode.next = newNode;
			newNode.prev = lastNode;
			newNode.next = head;
			tail = newNode;
			head.prev = tail;
		}
		sizeOfList += 1;
		return true;
	}
	public boolean insertAtFirst(Node newNode) throws InvalidNodeValue
	{
		if(newNode == null)
			throw new InvalidNodeValue();
		if(head == null && tail == null) /*first node*/
		{
			newNode.next = newNode;
			newNode.prev = newNode;
			head = newNode;
			tail = newNode;
		}
		else if (head == tail) /* There is only one node currently in the list*/
		{	
			Node nodeInList = head;
			nodeInList.next = newNode;
			nodeInList.prev = newNode;
			newNode.next = nodeInList;
			newNode.prev = nodeInList;
			head = newNode;
			
		}
		else
		{
			Node nodeInList = head;
			nodeInList.prev = newNode;
			newNode.next = nodeInList;
			newNode.prev = tail;
			head = newNode;
			tail.next = newNode;
		}
		sizeOfList += 1;
		return true;
	}
	public Node deleteAtFirst() throws NegativeIndexValue, InvalidIndexValue
	{
		Node nodeDeleted = deleteAtIndex(1);
		return nodeDeleted;	
	}
	public Node deleteAtLast() throws NegativeIndexValue, InvalidIndexValue
	{
		Node nodeDeleted = deleteAtIndex(this.sizeOfList);
		return nodeDeleted;
	}
	public Node deleteAtIndex(int index) throws NegativeIndexValue, InvalidIndexValue
	{
		Node nodeToDel = null;
		if(head != null && tail != null)
		{
			if(index <= 0)
				throw new NegativeIndexValue();
			else if(index > sizeOfList )
				throw new InvalidIndexValue(sizeOfList);
			nodeToDel = getNodeAtIndex(index);
			Node nextNode = nodeToDel.next;
			Node prevNode = nodeToDel.prev;
			prevNode.next = nextNode;
			nextNode.prev = prevNode;
			if(index == 1)
				head = nextNode;
			else if(index == sizeOfList)
				tail = prevNode;
			/* So that the client is unable to access any of the next or previous nodes using this node*/
			nodeToDel.next = null;
			nodeToDel.prev = null;
			sizeOfList -= 1;
		}
		return nodeToDel;
	}
	public Node getNodeAtIndex(int index)
	{
		Node currNode = null;
		if(head != null && tail != null)
		{
			currNode = head;
			int currIndex = 1;
			System.out.println("getNodeAtIndex");
			while(currNode != null)
			{
				if(currIndex == index)
					break;
				currNode = currNode.next;
				currIndex += 1;
			}
		}
		return currNode;
	}
	public boolean insertAtIndex(Node newNode,int index) throws InvalidNodeValue, InvalidIndexValue, NegativeIndexValue
	{
		if(newNode == null)
			throw new InvalidNodeValue();
		else if(index <= 0)
			throw new NegativeIndexValue();
		else if(index > sizeOfList + 1 )
			throw new InvalidIndexValue(sizeOfList);		
		else if(index == 1)
			return(insertAtFirst(newNode));
		else if(index == sizeOfList + 1)
			return(insertAtLast(newNode));
		else
		{
			Node prevNode = getNodeAtIndex(index-1);
			Node nextNode = getNodeAtIndex(index);
			newNode.next = nextNode;
			newNode.prev = prevNode;
			prevNode.next = newNode;
			nextNode.prev = newNode;
			sizeOfList +=1;
			return true;
		}		
	}
	public int size()
	{
		return sizeOfList;
	}
	public int getIndexOf(Node thisNode)
	{
		int index = -1;
		if(head != null && tail != null)
		{
			Node currNode = head;
			index = 0;
			System.out.println("Find");
			int accountNumToFound = thisNode.getAccountNode().getAccountNumber();
			while(currNode != null)
			{
				if(currNode.getAccountNode().getAccountNumber() == accountNumToFound)
				{
					return (index + 1);
				}
				currNode = currNode.next;
				index += 1;
				if(currNode == head)
					break;
			}
		}
		return index;
	}
	public void display()
	{
		if(head != null && tail != null)
		{
			Node currNode = head;
			System.out.println("Following are elements in the doubly linked list");
			while(currNode != null)
			{
				System.out.println(currNode.getAccountNode().getHolderName());
				currNode = currNode.next;
				if(currNode == head)
					break;
			}
		}
		else
		{
			System.out.println("There are no elements in the doubly linked list");
		}
	}
	public void displayReverse()
	{
		if(head != null && tail != null)
		{
			Node currNode = tail;
			System.out.println("Following are elements in the doubly linked list in reverse order");
			while(currNode != null)
			{
				System.out.println(currNode.getAccountNode().getHolderName());
				currNode = currNode.prev;
				if(currNode == tail)
					break;
			}
		}
		else
		{
			System.out.println("There are no elements in the doubly linked list");
		}
	}
}
