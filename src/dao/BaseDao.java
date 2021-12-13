package dao;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;


/**
 * 数据库操作基类
 */
public class BaseDao {
	public static String DRIVER="com.mysql.cj.jdbc.Driver"; // 数据库驱动

	public static String URL="jdbc:mysql://localhost:3306/MySQL?serverTimezone=UTC";//url
	public static String DBNAME="root"; // 数据库用户名

	public static String DBPASS="root"; // 数据库密码	
	Connection conn = null;// 数据连接对象
	
	/*static{//静态代码块,在类加载的时候执行
		init();
	}*/
	
	/**
	 * 初始化连接参数,从配置文件里获得
	 */
		/*public static void init(){
			Properties params=new Properties();
			String configFile = "database.properties";//配置文件路径
			//加载配置文件到输入流中
			InputStream is=BaseDao.class.getClassLoader().getResourceAsStream(configFile);
			
			try {
				//从输入流中读取属性列表
				params.load(is);
			} catch (IOException e) {
				e.printStackTrace();
			}
			//根据指定的获取对应的值
			DRIVER=params.getProperty("driver");
			URL=params.getProperty("url");
			DBNAME=params.getProperty("user");
			DBPASS=params.getProperty("password");
		}   */

	/**
	 * 得到数据库连接
	 * 
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @return 数据库连接
	 */
	public Connection getConn() throws ClassNotFoundException, SQLException {
		Connection conn = null;
		try {
			Class.forName(DRIVER); // 注册驱动
			conn = DriverManager.getConnection(URL, DBNAME, DBPASS); // 获得数据库连接
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn; // 返回连接
	}

	/**
	 * 释放资源
	 * 
	 * @param conn
	 *            数据库连接
	 * @param pstmt
	 *            PreparedStatement对象
	 * @param rs
	 *            结果集
	 */
	public void closeAll(Connection conn, PreparedStatement pstmt, ResultSet rs) {

		/* 如果rs不空，关闭rs */
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		/* 如果pstmt不空，关闭pstmt */
		if (pstmt != null) {
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		/* 如果conn不空，关闭conn */
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}


	/**
	 * 执行SQL语句，可以进行增、删、改的操作，不能执行查询
	 * 
	 * @param sql
	 *            预编译的 SQL 语句
	 * @param param
	 *            预编译的 SQL 语句中的‘？’参数的字符串数组
	 * @return 影响的条数
	 */
	public int executeSQL(String preparedSql, Object[] param) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int num = 0;

		/* 处理SQL,执行SQL */
		try {
			conn = getConn(); // 得到数据库连接
			pstmt = conn.prepareStatement(preparedSql); // 得到PreparedStatement对象
			if (param != null) {
				for (int i = 0; i < param.length; i++) {
					pstmt.setObject(i + 1, param[i]); // 为预编译sql设置参数
				}
			}
		
			num = pstmt.executeUpdate(); // 执行SQL语句
		} catch (ClassNotFoundException e) {
			e.printStackTrace(); // 处理ClassNotFoundException异常
		} catch (SQLException e) {
			e.printStackTrace(); // 处理SQLException异常
		} finally {
			this.closeAll(conn, pstmt, null);
		}
		return num;
	}
	/**
	 * 查询数据库
	 * @param sql    SQL语句
	 * @param param    SQL语句中的‘？’参数的字符串数组  
	 * @return
	 */
	public List executeQuery(String sql,Object[] param) {
		List table=new ArrayList();
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			conn=getConn();
			pstmt=conn.prepareStatement(sql);
			if(param!=null) {
				for(int i=0;i<param.length;i++) {
					pstmt.setObject(i+1, param[i]);
				}
			}
			rs=pstmt.executeQuery();
			ResultSetMetaData meta=rs.getMetaData();  //包括了rs表格所必须具备的信息
			int column=meta.getColumnCount();  //记录一行共有几列
			while(rs.next()) {
				List row=new ArrayList();
				for(int i=0;i<column;i++) {
					row.add(i, rs.getObject(i+1));
				}
				table.add(row);
			}
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			this.closeAll(conn, pstmt, rs);
		}
		return table;
	}

}
