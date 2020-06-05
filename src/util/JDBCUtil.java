package util;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.tomcat.dbcp.dbcp2.BasicDataSourceFactory;

/**
 * 数据库连接工具类
 * @author 22901
 *
 */
public class JDBCUtil {
	private static ThreadLocal<Connection> tl;
	private static DataSource ds;
	//静态代码块初始化
	static {
		System.out.println("数据源静态代码块初始化");
		tl=new ThreadLocal<>();
		Properties p=new Properties();
		try {
			p.load(JDBCUtil.class.getClassLoader().getResourceAsStream("dbcp.properties"));
			ds=BasicDataSourceFactory.createDataSource(p);
			System.out.print(ds);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("数据源初始化出错");
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("数据源初始化出错");
			e.printStackTrace();
		}
	}
	public static Connection getLocalConnection() {
		Connection conn=tl.get();
		if(conn==null) {
			try {
				if(ds==null) {
					System.out.println("数据源为空");
					return null;
				}
				conn=ds.getConnection();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			}
			tl.set(conn);//保存进当前线程池
		}
		return conn;
	}

}
