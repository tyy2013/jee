package common.service;

import static org.junit.Assert.*;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class BaseServiceTest extends AbstractTransactionalJUnit4SpringContextTests{
	@Autowired
	private CommonService commonService;
	
	@Test
	public void testGetAllDbTableName() {
		assertNotNull(commonService.getAllDbTableName());
	}

	@Test
	public void testGetAllDbTableSize() {
		assertNotNull(commonService.getAllDbTableSize());
	}

}
