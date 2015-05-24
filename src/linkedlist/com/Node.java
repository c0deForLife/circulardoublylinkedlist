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
	public Account getAccountNode()
	{
		return accountNode;
	}
}