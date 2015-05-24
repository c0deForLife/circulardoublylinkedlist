package src.exceptions.com;

public class InvalidIndexValue extends Exception {
 public InvalidIndexValue(int size) {
	super("The index provided exceeds the current limit of the list. The current size of the list is "+size);
}
}
