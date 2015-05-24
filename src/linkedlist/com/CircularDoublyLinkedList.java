package src.linkedlist.com;

import java.util.Date;

import src.entity.com.Account;
import src.exceptions.com.InvalidIndexValue;
/* Circular Doubly Linked List */
import src.exceptions.com.InvalidNodeValue;
import src.exceptions.com.NegativeIndexValue;



public class CircularDoublyLinkedList 
{
	Node head;
	Node tail;
	private int sizeOfList = 0;
	public CircularDoublyLinkedList()
	{
		head = tail = null;
	}
	CircularDoublyLinkedList(CircularDoublyLinkedList dll)
	{
		/* Code to perform deep copy such that this = dll */
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
