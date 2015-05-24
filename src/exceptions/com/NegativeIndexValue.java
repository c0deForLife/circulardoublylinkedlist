package src.exceptions.com;

public class NegativeIndexValue extends Exception {
	public NegativeIndexValue() {
		super("The index value for the list cannot be zero or negative.");
	}
}
