package br.com.universal.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	private static final SessionFactory sessionFactory;
	
	static
	{
		Configuration configuration = new Configuration();
		configuration.setProperty("hibernate.dialect","org.hibernate.dialect.PostgreSQLDialect");
		configuration.setProperty("hibernate.connection.driver_class","org.postgresql.Driver");
		configuration.setProperty("hibernate.connection.url","jdbc:postgresql://localhost:5432/universal");
		configuration.setProperty("hibernate.connection.username","postgres");
		configuration.setProperty("hibernate.connection.password","postgres");
		configuration.setProperty("hibernate.c3p0.min_size","1");
		configuration.setProperty("hibernate.c3p0.max_size","5");
		configuration.setProperty("hibernate.c3p0.timeout","3600");
		configuration.setProperty("hibernate.c3p0.max_statements","50");
		configuration.setProperty("hibernate.c3p0.idle_test_period","3600");
		configuration.setProperty("hibernate.current_session_context_class.min_size","thread");
		configuration.setProperty("hibernate.show_sql","true");
		configuration.setProperty("hibernate.format_sql","true");
		sessionFactory = configuration.buildSessionFactory();
		
	}

	public static SessionFactory getSessionfactory() {
		return sessionFactory;
	}

}
