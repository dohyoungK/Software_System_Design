package CharacterStack;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.EmptyStackException;

import org.junit.Test;

public class CharacterStackTest {
	private static final int MAX_SIZE = 20;
	
	@Test
	public void testConstructor() {
		String str = "string";
		String nullStr = null;
		String emptyStr = "";
		CharacterStack characterStack = new CharacterStack();
		CharacterStack characterStackWithString1 = new CharacterStack(str);
		CharacterStack characterStackWithString2 = new CharacterStack(nullStr);
		CharacterStack characterStackWithString3 = new CharacterStack(emptyStr);
		CharacterStack characterStackWithCharacter = new CharacterStack('a');
		
		assertEquals(characterStack.getSize(), 0);
		assertEquals(characterStackWithString1.getSize(), str.length());
		assertEquals(characterStackWithCharacter.getSize(), 1);
	}
	
	@Test(expected = StackOverflowError.class)
	public void testConstructorOverflow() {	
		String str = "abcdefghijklmnopqrstuvwxyzabcdefghi";
		CharacterStack characterStackWithString = new CharacterStack(str);
	}
	
	@Test
	public void testPushChar() {
		CharacterStack characterStack = new CharacterStack();
		characterStack.push('a');
		assertNotNull(characterStack.pop());
	}
	
	@Test
	public void testPushString() {
		String str = "push";
		String nullStr = null;
		String emptyStr = "";
		CharacterStack characterStack = new CharacterStack();
		CharacterStack characterNullStack = new CharacterStack();
		CharacterStack characterEmptyStack = new CharacterStack();
		characterStack.push(str);
		characterNullStack.push(nullStr);
		characterEmptyStack.push(emptyStr);
		assertNotNull(characterStack.pop());
		assertEquals(characterNullStack.getSize(), 0);
		assertEquals(characterEmptyStack.getSize(), 0);
	}	
	@Test(expected = StackOverflowError.class)
	public void testPushCharOverflow() {	
		CharacterStack characterStack = new CharacterStack();
		for(int i=0; i<MAX_SIZE; i++)	characterStack.push('a');
		characterStack.push('a');
	}
	@Test(expected = StackOverflowError.class)
	public void testPushStringOverflow() {	
		String str = "abcdefghijklmnopqrstuvwxyzabcdefghi";
		CharacterStack characterStack = new CharacterStack();
		characterStack.push(str);
	}
	
	@Test
	public void testPop() {
		CharacterStack characterStack = new CharacterStack('a');
		assertNotNull(characterStack.pop());
	}
	@Test(expected = EmptyStackException.class)
	public void testEmptyStackException() {	
		CharacterStack characterStack = new CharacterStack();
		characterStack.pop();
	}
	
	@Test
	public void testGetMaxSize() {
		CharacterStack characterStack = new CharacterStack();
		assertEquals(characterStack.getMaxSize(), MAX_SIZE);
	}
}
