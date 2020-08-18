package assignment2;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.jupiter.api.Test;

class Test2 {
	DefaultMessage m1;
	@Before
	void setUp() throws Exception {
		
	}

	@Test
	void testGetMessage() {
		DefaultMessage m1=new DefaultMessage();
		DefaultMessage m2=new DefaultMessage("Hii");
		assertEquals("Spring",m1.getMessage());
		assertEquals("Hii",m2.getMessage());
		
	}


	

}
