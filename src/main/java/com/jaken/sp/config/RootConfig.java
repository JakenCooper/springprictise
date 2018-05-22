package com.jaken.sp.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@Import(RepoConfig.class)
@EnableTransactionManagement(proxyTargetClass=false)
@ComponentScan(basePackages={"com.jaken.sp.service"})
public class RootConfig {

	@Bean(name="transactionManager")
	@Qualifier("mybatisTransactionManager")
	public DataSourceTransactionManager getDefaultTransactionManager(DataSource dataSource){
		DataSourceTransactionManager dtm=new DataSourceTransactionManager();
		dtm.setDataSource(dataSource);
		return dtm;
	}
}
