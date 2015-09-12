package src.linkedlist.com;

import src.entity.com.Account;

public class Node
{
	private Account accountNode;
	Node next;
	Node prev;
	public Node(Account accNode)
	{
		accountNode = accNode;
		next = null;
		prev = null;
	}
	/* Constructor to perform deep copy*/
	public Node(Node newNode)
	{
		accountNode = new Account(newNode.accountNode);
		this.next = null;
		this.prev = null;
	}
	public Account getAccountNode()
	{
		return accountNode;
	}
}