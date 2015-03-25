 package com.mybatis.test;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.exception.InvalidConfigurationException;
import org.mybatis.generator.exception.XMLParserException;
import org.mybatis.generator.internal.DefaultShellCallback;
 /** 
* @ClassName: GenMain 
* @Description: 自动生成Mybatis类的main函数
* @author qiugui 
* @date 2015年3月4日 下午5:19:28 
*  
*/ 
public class GenMain {

	public static void main(String[] args) {
		List<String> warnings = new ArrayList<String>();
		boolean overwrite = true;
		String genCfg="/mbgConfiguration.xml";
		
		File configFile = new File(GenMain.class.getResource(genCfg).getFile());
		
		ConfigurationParser cp = new ConfigurationParser(warnings);
		DefaultShellCallback callback = new DefaultShellCallback(overwrite);
		
		MyBatisGenerator myBatisGenerator = null;
		Configuration config = null;
		
		try {
			config=cp.parseConfiguration(configFile);
			myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
			myBatisGenerator.generate(null);
		} catch (IOException e) {
			 e.printStackTrace();
		} catch (XMLParserException e) {
			 e.printStackTrace();
		} catch (SQLException e) {
			 e.printStackTrace();
		} catch (InterruptedException e) {
			 e.printStackTrace();
		} catch (InvalidConfigurationException e) {
			 e.printStackTrace();
		}

	}

}

 