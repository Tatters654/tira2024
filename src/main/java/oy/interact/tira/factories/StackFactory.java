package oy.interact.tira.factories;

import oy.interact.tira.NotYetImplementedException;
import oy.interact.tira.student.StackImplementation;
import oy.interact.tira.util.StackInterface;

public class StackFactory {
	private StackFactory() {
		// Empty
	}

	public static StackInterface<Integer> createIntegerStack() {
		StackImplementation<Integer> stackImplementation = new StackImplementation();
		return stackImplementation;
	}

	public static StackInterface<Integer> createIntegerStack(int capacity) {
		StackImplementation<Integer> stackImplementation = new StackImplementation(capacity);
		return stackImplementation;	}

	public static StackInterface<Character> createCharacterStack() {
		StackImplementation<Character> stackImplementation = new StackImplementation();
		return stackImplementation;
	}

	public static StackInterface<Character> createCharacterStack(int capacity) {
		StackImplementation<Character> stackImplementation = new StackImplementation(capacity);
		return stackImplementation;	}

}
