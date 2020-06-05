package util;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.tomcat.dbcp.dbcp2.BasicDataSourceFactory;

/**
 * ���ݿ����ӹ�����
 * @author 22901
 *
 */
public class JDBCUtil {
	private static ThreadLocal<Connection> tl;
	private static DataSource ds;
	//��̬������ʼ��
	static {
		System.out.println("����Դ��̬������ʼ��");
		tl=new ThreadLocal<>();
		Properties p=new Properties();
		try {
			p.load(JDBCUtil.class.getClassLoader().getResourceAsStream("dbcp.properties"));
			ds=BasicDataSourceFactory.createDataSource(p);
			System.out.print(ds);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("����Դ��ʼ������");
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("����Դ��ʼ������");
			e.printStackTrace();
		}
	}
	public static Connection getLocalConnection() {
		Connection conn=tl.get();
		if(conn==null) {
			try {
				if(ds==null) {
					System.out.println("����ԴΪ��");
					return null;
				}
				conn=ds.getConnection();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			}
			tl.set(conn);//�������ǰ�̳߳�
		}
		return conn;
	}

}
