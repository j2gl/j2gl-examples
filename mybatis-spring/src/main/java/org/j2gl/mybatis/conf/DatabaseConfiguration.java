package org.j2gl.mybatis.conf;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@MapperScan(basePackages = "org.j2gl.mybatis.mapper")
@EnableTransactionManagement
public class DatabaseConfiguration {

    @Bean(destroyMethod = "close")
    public DataSource dataSource(@Value("${db.host:127.0.0.1}") final String host,
                                 @Value("${db.port:3307}") final String port,
                                 @Value("${db.schema:mybatis}") final String schema,
                                 @Value("${db.username:mybatisusr}") final String userName,
                                 @Value("${db.password:mybatispwd}") final String password) {


        final HikariConfig hikariConfig = new HikariConfig();

        final Properties properties = new Properties();
        properties.put("serverName", host);
        properties.put("portNumber", port);
        properties.put("zeroDateTimeBehavior", "convertToNull");
        properties.put("characterEncoding", "UTF-8");
        properties.put("useServerPrepStmts", "true");
        properties.put("prepStmtCacheSize", "512");
        properties.put("prepStmtCacheSqlLimit", "2048");

        hikariConfig.setDataSourceClassName("com.mysql.jdbc.jdbc2.optional.MysqlDataSource");
        hikariConfig.setDataSourceProperties(properties);
        hikariConfig.setUsername(userName);
        hikariConfig.setPassword(password);
        hikariConfig.setCatalog(schema);
        hikariConfig.setMaximumPoolSize(5);

        return new HikariDataSource(hikariConfig);
    }

    @Bean
    public SqlSessionFactoryBean sqlSessionFactory(final DataSource dataSource) throws Exception {
        final SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        sqlSessionFactoryBean.setTypeAliasesPackage("org.j2gl.mybatis.domain");
        return sqlSessionFactoryBean;
    }

    @Bean
    public SqlSessionTemplate sqlSessionTemplate(final SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

    @Bean
    public PlatformTransactionManager transactionManager(final DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

}
