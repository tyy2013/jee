/**
 * 
 */
package common.dao;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

/**
 * @author tyy 
 * @since 2013-4-9
 */
public class SampleTest {

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("BeforeClass");
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("@AfterClass");
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		System.out.println("@@Before");
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		System.out.println("@@@After");
	}

	/**
	 * Test method for {@link common.dao.impl.BaseCommonDao#getAllDbTableName()}.
	 */
	@Test
	public void testGetAllDbTableName() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link common.dao.impl.BaseCommonDao#getAllDbTableSize()}.
	 */
	@Ignore
	public void testGetAllDbTableSize() {
		fail("Not yet implemented"); // TODO
	}

}
