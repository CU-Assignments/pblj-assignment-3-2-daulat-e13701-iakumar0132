@Configuration
@ComponentScan("your.package")
@EnableTransactionManagement
public class AppConfig {

    @Bean
    public DataSource dataSource() {
        return new DriverManagerDataSource("jdbc:mysql://localhost:3306/testdb", "root", "password");
    }

    @Bean
    public LocalSessionFactoryBean sessionFactory() {
        LocalSessionFactoryBean sf = new LocalSessionFactoryBean();
        sf.setDataSource(dataSource());
        sf.setPackagesToScan("your.package");
        sf.setHibernateProperties(new Properties() {{
            put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
            put("hibernate.hbm2ddl.auto", "update");
            put("show_sql", "true");
        }});
        return sf;
    }

    @Bean
    public HibernateTransactionManager txManager(SessionFactory sf) {
        return new HibernateTransactionManager(sf);
    }
}
