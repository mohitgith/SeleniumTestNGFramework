package listeners;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

public class TestNGListenerDemo {
	
	@Test
	public void test1() {
		System.out.println("This is test 1");
	}
	
	@Test
	public void test2() {
		System.out.println("This is test 2");
		Assert.fail();
	}
	
	@Test
	public void test3() {
		System.out.println("This is test 3");
		throw new SkipException("This test is skipped");
		
	}

}
