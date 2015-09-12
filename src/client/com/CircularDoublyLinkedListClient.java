package src.client.com;

import java.util.Date;

import src.entity.com.Account;
import src.exceptions.com.InvalidIndexValue;
/* Circular Doubly Linked List */
import src.exceptions.com.InvalidNodeValue;
import src.exceptions.com.NegativeIndexValue;
import src.linkedlist.com.CircularDoublyLinkedList;
import src.linkedlist.com.Node;



public class CircularDoublyLinkedListClient {

	public static void main(String[] args) throws InvalidNodeValue, InvalidIndexValue, NegativeIndexValue {

		Account acc = new Account("Abc",new Date(),1234,30000D);
		Account acc1 = new Account("Bcd",new Date(),2345,40000d);
		Account acc2 = new Account("Cde",new Date(),1235,30000D);
		Account acc3 = new Account("Def",new Date(),4444,30000D);
		Account acc4 = new Account("Efg",new Date(),5555,30000D);
		Account acc5 = new Account("Fgh",new Date(),6666,30000D);
		Account acc6 = new Account("Ghi",new Date(),7777,30000D);
		Account acc7 = new Account("Hij",new Date(),8888,30000D);

		Node n1 = new Node(acc);
		Node n2 = new Node(acc1);
		Node n3 = new Node(acc2);
		Node n4 = new Node(acc3);
		Node n5 = new Node(acc4);
		Node n6 = new Node(acc5);
		Node n7 = new Node(acc6);
		Node n8 = new Node(acc7);
		/*
		CircularDoublyLinkedList dll = new CircularDoublyLinkedList();
		dll.display();
		//dll.displayReverse();
		dll.insertAtLast(n1);
		//dll.display();
		//dll.displayReverse();
		dll.insertAtLast(n2);
		//dll.displayReverse();
		//dll.display();
		dll.insertAtLast(n3);
		//dll.display();
		dll.insertAtLast(n4);
	//	dll.display();
		dll.insertAtLast(n5);
		//dll.display();
		//dll.displayReverse();
		//System.out.println("Index = "+dll.getIndexOf(n4));
		//System.out.println("Holder name at 3 = "+dll.getNodeAtIndex(3).getAccountNode().getHolderName());
		dll.insertAtIndex(n6,3);
		//dll.display();
		dll.insertAtIndex(n7,1);
		//dll.display();
		dll.insertAtIndex(n8,1);
		dll.display();
		System.out.println("Size = "+dll.size());
		dll.deleteAtIndex(5);
		dll.display();
		System.out.println("Size = "+dll.size());*/
		Node n = new Node(n1);
		Account accN = new Account(acc);		
		accN.setBalance(85236d);
		
		System.out.println("Acc = "+n1.getAccountNode().getBalance());
		System.out.println("Acc = "+accN.getBalance());
	}
	

}
