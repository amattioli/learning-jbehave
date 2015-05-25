package it.amattioli.learningjbehave;

import java.util.Stack;

import static junit.framework.Assert.*;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Pending;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

public class StackBehaviourSteps {
	private Stack<String> stack;

	@Given("I have an empty stack")
	public void givenIHaveAnEmptyStack()  {
		stack = new Stack<String>();
	}

	@When("I push an item $item")
	public void whenIPushAnItem(@Named("item") String item) {
		stack.push(item);
	}
	
	@When("I pop the stack")
	@Pending
	public void whenIPopTheStack() {
		stack.pop();
	}
	
	@Then("I should count $expected")
	public void thenIShouldCount(@Named("expected") int expected) {
		int actual = stack.size();
		assertEquals(expected, actual);
	}
	
	@Then("I should retrieve $expected")
	public void thenIShouldRetrieve(@Named("expected") String expected) {
		String actual = stack.pop();
		assertEquals(expected, actual);
	}
}
