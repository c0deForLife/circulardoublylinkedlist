package src.exceptions.com;

public class InvalidNodeValue extends Exception {
	public InvalidNodeValue() {
		super("The node is not instantiated properly. Please re-create the node and try again");
	}

}
