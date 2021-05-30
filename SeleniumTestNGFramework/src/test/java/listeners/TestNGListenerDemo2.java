package listeners;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

public class TestNGListenerDemo2 {
	
	@Test
	public void test4() {
		System.out.println("This is test 4");
	}
	
	@Test
	public void test5() {
		System.out.println("This is test 5");
		Assert.fail();
	}
	
	@Test
	public void test6() {
		System.out.println("This is test 6");
		throw new SkipException("This test is skipped");
		
	}

}
