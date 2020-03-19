package com.hx;

import com.hx.config.AccessConfig;
import com.hx.config.LoginConfig;
import com.hx.dao.AccessDao;
import com.hx.dao.CementLastcountMapper;
import com.hx.dao.CementStrengthMapper;
import com.hx.entity.CementLastcount;
import com.hx.entity.CementStrength;
import com.hx.model.MainDataModel;
import com.hx.utils.DateUtil;
import com.hx.utils.StringUtil;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.Properties;

@RunWith(SpringRunner.class)
@SpringBootTest
@Ignore
public class CementstrengthApplicationTests {

	@Autowired
	private CementLastcount cementLastcount;
	@Autowired
	private CementLastcountMapper cementLastcountMapper;
	@Autowired
	private AccessConfig accessConfig;
	@Autowired
	private AccessDao accessDao;
	@Autowired
	private LoginConfig loginConfig;
	@Autowired
	private CementStrength cementStrength;
	@Autowired
	private CementStrengthMapper cementStrengthMapper;


	@Test
	public void contextLoads() {
	}

	@Test
	public void test1() {
		//cementLastcount.setCementcount(6);
		//cementLastcount.setId(1);
		//cementLastcountMapper.insert(cementLastcount);
		//cementLastcountMapper.updateByPrimaryKeySelective(cementLastcount);
		cementStrength.setID(1);
		cementStrength.setSampleNo("66");
		//cementStrengthMapper.updateByPrimaryKeySelective(cementStrength);
		cementStrengthMapper.updateByPrimaryKey(cementStrength);
	}

	@Test
	public void test2() throws Exception{
		Properties prop = new Properties();
		prop.load(new FileInputStream("src/main/resources/application.properties"));
		prop.getProperty("access.driver");
		prop.getProperty("access.charSet");
		prop.getProperty("access.password");
		prop.getProperty("access.path");
		String sql = prop.getProperty("access.sql");
		System.out.println(sql);
	}

	@Test
	public void test3(){
		String charSet = accessConfig.getCharSet();
		System.out.println(charSet);
	}

	@Test
	public void test4(){
		CementLastcount lastCount = cementLastcountMapper.getLastCount();

		System.out.println(lastCount.getCementcount());
	}

	@Test
	public void test5() throws Exception{
		Connection conn = null;
		Class.forName(accessConfig.getDriver());
		Properties properties = new Properties();
		properties.put("charSet",accessConfig.getCharSet());
		properties.put("password",accessConfig.getPassword());
		conn = DriverManager.getConnection("jdbc:Access:///" + accessConfig.getPath(), properties);
		//logger.debug("connection: " + conn);
		PreparedStatement statement = conn.prepareStatement(accessConfig.getSql());
		statement.setInt(1,(int)cementLastcountMapper.getLastCount().getCementcount());
		ResultSet result = statement.executeQuery();
	}

	@Test
	public void test6() throws Exception{
		List<CementStrength> cementStrengths = accessDao.resolverMdb();
		for (CementStrength data:cementStrengths){
			System.out.println(data.getKind());
			System.out.println(data.getSampleTime());
		}
	}

	@Test
	public void test7(){
		String username = loginConfig.getUsername();
		System.out.println(username);
		System.out.println(loginConfig.getPassword());
	}

	@Test
	public void test8()throws Exception{
		List<CementStrength> lists = null;
		CementLastcount lastCount = cementLastcountMapper.getLastCount();
		System.out.println(lastCount.getCementcount());
		lists = accessDao.resolverMdb();
		String keyNo = null;
		String duration = null;
		for (CementStrength data:lists) {
			keyNo = data.getSampleNo();
			System.out.println(keyNo);
			int count = cementStrengthMapper.selectCountBySampleNo(keyNo,duration);
			System.out.println(count);
			// cementStrengthMapper.updateBySampleNoSelective(keyNo,data);
			data.setCreateTime(DateUtil.StrToDate(data.getSampleTime()));
			data.getCreateTime();
			cementStrengthMapper.insertSelective(data);
		}
	}

	@Test
	public void test9(){
		MainDataModel model = new MainDataModel();
		model.setPageNum(5);
		Integer pageNum1 = model.getPageNum();
		Integer pageSize = model.getPageSize();

		int pageNum=(pageNum1==null)?1:pageNum1;
		//System.out.println(equals);
		System.out.println(pageNum);
		System.out.println(pageSize);

	}

	@Test
	public void test10(){
		String c1 = null;
		String c2 = null;
		String [] str ={"Dr:Drags","Mar","Mad","Vad","Aad","Had"};
		for (int i = 0; i < str.length; i++) {
			c1 = str[i].contains(":") ? (str[i].split(":"))[0]:str[i];
			c2 = str[i].contains(":") ? (str[i].split(":"))[1]:str[i];
			System.out.println(c1);
			System.out.println(c2);

		}
	}


	@Test
	public void test11(){
		String str="a";
		String s = accessDao.formatStr(str,3);
		System.out.println(s);
		String s1 = accessDao.rightFormatStr(str, 3);
		System.out.println(s1);
	}

	@Test
	public void test12(){
		String str= "2020-01-20 11:09:37";
		String string = StringUtil.formatString(str);
		System.out.println(string);
	}

	@Test
	public void test13(){
		String duration = "28";
		//System.out.println(!duration.equals("18"));
		//System.out.println(!duration.equals("1"));
		boolean flag1 = !duration.equals("1") && !duration.equals("3") && !duration.equals("7") && !duration.equals("28") && !duration.equals("90") && !duration.equals("180");
		System.out.println(flag1);
	}
}
