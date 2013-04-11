package common.dao;

import static org.junit.Assert.*;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.AbstractTransactionalSpringContextTests;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import common.dao.impl.CommonDao;
import common.mode.DBTable;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-dao.xml")
public class BaseDaoTest extends AbstractTransactionalJUnit4SpringContextTests {

	//private static final Logger logger = Logger.getLogger(BaseDaoTest.class);
	
	@Autowired
	private ICommonDao commonDao;
	
	@Before
	public void setup(){
		System.out.println("Before");
	}
	
	@Test
	public void test() {
		List<DBTable> list = commonDao.getAllDbTableName();
		for(DBTable dt : list){
			System.out.println(dt.getTableName());
		}
		assertNotNull(commonDao.getAllDbTableSize()>0); // TODO
	}

}
