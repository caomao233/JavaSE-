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
 * ���ݿ��������
 */
public class BaseDao {
	public static String DRIVER="com.mysql.cj.jdbc.Driver"; // ���ݿ�����

	public static String URL="jdbc:mysql://localhost:3306/MySQL?serverTimezone=UTC";//url
	public static String DBNAME="root"; // ���ݿ��û���

	public static String DBPASS="root"; // ���ݿ�����	
	Connection conn = null;// �������Ӷ���
	
	/*static{//��̬�����,������ص�ʱ��ִ��
		init();
	}*/
	
	/**
	 * ��ʼ�����Ӳ���,�������ļ�����
	 */
		/*public static void init(){
			Properties params=new Properties();
			String configFile = "database.properties";//�����ļ�·��
			//���������ļ�����������
			InputStream is=BaseDao.class.getClassLoader().getResourceAsStream(configFile);
			
			try {
				//���������ж�ȡ�����б�
				params.load(is);
			} catch (IOException e) {
				e.printStackTrace();
			}
			//����ָ���Ļ�ȡ��Ӧ��ֵ
			DRIVER=params.getProperty("driver");
			URL=params.getProperty("url");
			DBNAME=params.getProperty("user");
			DBPASS=params.getProperty("password");
		}   */

	/**
	 * �õ����ݿ�����
	 * 
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @return ���ݿ�����
	 */
	public Connection getConn() throws ClassNotFoundException, SQLException {
		Connection conn = null;
		try {
			Class.forName(DRIVER); // ע������
			conn = DriverManager.getConnection(URL, DBNAME, DBPASS); // ������ݿ�����
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn; // ��������
	}

	/**
	 * �ͷ���Դ
	 * 
	 * @param conn
	 *            ���ݿ�����
	 * @param pstmt
	 *            PreparedStatement����
	 * @param rs
	 *            �����
	 */
	public void closeAll(Connection conn, PreparedStatement pstmt, ResultSet rs) {

		/* ���rs���գ��ر�rs */
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		/* ���pstmt���գ��ر�pstmt */
		if (pstmt != null) {
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		/* ���conn���գ��ر�conn */
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}


	/**
	 * ִ��SQL��䣬���Խ�������ɾ���ĵĲ���������ִ�в�ѯ
	 * 
	 * @param sql
	 *            Ԥ����� SQL ���
	 * @param param
	 *            Ԥ����� SQL ����еġ������������ַ�������
	 * @return Ӱ�������
	 */
	public int executeSQL(String preparedSql, Object[] param) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int num = 0;

		/* ����SQL,ִ��SQL */
		try {
			conn = getConn(); // �õ����ݿ�����
			pstmt = conn.prepareStatement(preparedSql); // �õ�PreparedStatement����
			if (param != null) {
				for (int i = 0; i < param.length; i++) {
					pstmt.setObject(i + 1, param[i]); // ΪԤ����sql���ò���
				}
			}
		
			num = pstmt.executeUpdate(); // ִ��SQL���
		} catch (ClassNotFoundException e) {
			e.printStackTrace(); // ����ClassNotFoundException�쳣
		} catch (SQLException e) {
			e.printStackTrace(); // ����SQLException�쳣
		} finally {
			this.closeAll(conn, pstmt, null);
		}
		return num;
	}
	/**
	 * ��ѯ���ݿ�
	 * @param sql    SQL���
	 * @param param    SQL����еġ������������ַ�������  
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
			ResultSetMetaData meta=rs.getMetaData();  //������rs���������߱�����Ϣ
			int column=meta.getColumnCount();  //��¼һ�й��м���
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
