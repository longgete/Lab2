package sql;
import java.sql.*;
public class Sql {
	Connection con =null;
	Statement stat=null;
	ResultSet rs=null;
	
	public Sql()
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");//��������
			con=DriverManager.getConnection("jdbc:mysql://w.rdc.sae.sina.com.cn:3307/app_commombookdb","3mjx3l3xz1","33xmw4z0ki3kl1wi3y2izklii00l54w4w0x4h3xm");//�������ݿ�
            stat=con.createStatement();
		}
		
		catch(Exception e)
		{
			con=null;
		}
	
	}
	
	public ResultSet executeQuery(String sql)
	{
		try
		{
			
			rs=stat.executeQuery(sql);
		}
		
		catch(Exception e)
		{
			rs=null;
		}
		return rs;
	}
	
	public int executeUpdate(String sql)
	{
		try
		{
			stat.executeUpdate(sql);
			return 0;
		}
		catch(Exception e)
		{
			return -1;
		}
	}
}
