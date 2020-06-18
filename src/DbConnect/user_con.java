package DbConnect;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Data.Customer;
import Data.Allorder;
import Data.order;
import Data.Dishes_num;

public class user_con extends DBcon{

	public user_con() {
		// TODO 自动生成的构造函数存根
	}
	//customer登陆
	public boolean login(int userID,String password) throws SQLException
	{
		String sql="SELECT * FROM  customer where c_Id=? and c_Psd=?";
		this.ps = dbConn.prepareStatement(sql);
	    ps.setLong(1, userID);
        ps.setString(2, password);
        rs = ps.executeQuery();
        if(rs.next())
        	return true;
		return false;
	}
	
	//注册
	public int Res(String userID,String password)throws SQLException
	{
		String sqlask="SELECT * FROM  customer where c_Id=?";
		ps = dbConn.prepareStatement(sqlask);
	    ps.setString(1, userID);
	    rs = ps.executeQuery();
        if(rs.next())
        	return 0;
        else {
        	String sql="insert into customer(c_Id,c_Psd,c_Hy) value(?,?,?)";
    		ps = dbConn.prepareStatement(sql);
    	    ps.setString(1, userID);
            ps.setString(2, password);
            ps.setString(3,"非会员");
            ps.execute();
            return 1;
        }
		
	}
	
	//查询客户信息
	public Customer Fphone(String userId) throws SQLException
	{
		String sql="SELECT * FROM  customer where c_Id=?";
		ps = dbConn.prepareStatement(sql);
	    ps.setString(1, userId);
        rs = ps.executeQuery();
        if(rs.next()) {
        	String id=rs.getString("c_Id");
            String name =rs.getString("c_Name");
            String psd =rs.getString("c_Psd");
            String sex =rs.getString("c_Sex");
            String hy=rs.getString("c_Hy");
            String tel=rs.getString("c_tel");
            Customer customer=new Customer(id,name,psd,sex,hy,tel);
            return customer;
        }
		return null;
	}
	
	//修改密码
	public boolean Mpsd(int userId,String password) throws SQLException
	{
		String sql="update customer set c_Psd=? where c_Id=?";
		ps = dbConn.prepareStatement(sql);
	    ps.setString(1, password);
        ps.setLong(2, userId);
        int t=ps.executeUpdate();
        if(t>0)
        {
        	return true;
        }
		return false;
	}
	
	//更改个人信息
	public boolean change(int id,String name,String psd,String sex,String tel)  throws SQLException{
		String sql="UPDATE customer\r\n" + 
				"SET c_Name=?, c_Psd=?,c_Sex=?,c_tel=?\r\n" + 
				"WHERE c_Id=?;";
		ps = dbConn.prepareStatement(sql);
	    ps.setString(1, name);
        ps.setString(2, psd);
        ps.setString(3, sex);
        ps.setString(4, tel);
        ps.setLong(5, id);
        int t=ps.executeUpdate();
        if(t>0)
        {
        	return true;
        }
		return false;

	}
	
	
	
	
	
	
}
