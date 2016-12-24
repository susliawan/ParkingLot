import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CarTest {
	
	private Car car;
	
	@Before
	public void runBeforeEachTest(){
		car = new Car("KA-01-HH-123", "White");
	}
	
	@Test
	public void testCreate() {
		String registrationNo = car.registrationNo();
		String colour = car.colour();
		
		assertEquals(registrationNo, "KA-01-HH-123");
		assertEquals(colour, "White");
	}

}
