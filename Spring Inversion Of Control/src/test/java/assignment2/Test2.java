package assignment2;

import static org.junit.Assert.*;

import org.junit.Test;

public class Test2 {

	@Test
	public void testGetMessage() {
		ConstructorMessage m=new ConstructorMessage();
		assertEquals(null,m.getMessage());
		ConstructorMessage m2=new ConstructorMessage("hello");
		assertEquals("hello",m2.getMessage());
	}

}
