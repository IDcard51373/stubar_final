package stubar.dbutils;


import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

/**
 * 通过数据库构建一个数据库连接池
 */
public class DBUtils {
	
	private static ComboPooledDataSource cpds = new ComboPooledDataSource("releaseDB");
	
	/**
	 * 指定数据库访问信息
	 */
	static {
		try {
			cpds.setDriverClass("com.mysql.jdbc.Driver");
			cpds.setJdbcUrl("jdbc:mysql://39.105.70.32/test2");
		cpds.setUser("stubar");
			cpds.setPassword("123456");
		} catch (PropertyVetoException e) {
			e.printStackTrace();
		}
	}
	
	public static DataSource getDataSource(){
		return cpds;
	}

}
