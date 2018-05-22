package com.jaken.sp.config;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

@Configuration
public class RepoConfig {

	@Bean(name="dataSource")
	public DataSource getDefaultDataSource(){
		BasicDataSource bds=new BasicDataSource();
		bds.setDriverClassName("com.mysql.jdbc.Driver");
		bds.setUrl("jdbc:mysql://localhost:3333/springprictise");
		bds.setUsername("root");
		bds.setPassword("jaken123");
		return bds;
	}
	
	@Bean(name="sqlSessionFactory")
	@Autowired
	public SqlSessionFactoryBean getSqlSessionFactoryBean(DataSource dataSource){
		SqlSessionFactoryBean sfb=new SqlSessionFactoryBean();
		sfb.setDataSource(dataSource);
		PathMatchingResourcePatternResolver resourceLoader=new PathMatchingResourcePatternResolver();
		try {
			sfb.setConfigLocation(resourceLoader.getResource("classpath:mybatisconfig.xml"));
			sfb.setMapperLocations(resourceLoader.getResources("classpath:com/jaken/sp/entity/*.xml"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sfb;
	}
	
	@Bean(name="mapperScannerConfigurer")
	public MapperScannerConfigurer getMapperScannerConfigurer(){
		MapperScannerConfigurer msc=new MapperScannerConfigurer();
		msc.setSqlSessionFactoryBeanName("sqlSessionFactory");
		msc.setBasePackage("com.jaken.sp.dao");
		return msc;
	}
}
