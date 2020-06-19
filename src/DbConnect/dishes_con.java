package DbConnect;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Data.Dishes;
import Data.ALLMenu;
import Data.Menu;

public class dishes_con extends DBcon {

	public dishes_con() {
		// TODO 自动生成的构造函数存根
	}
	
	//通过菜系查询
	public List<Dishes> getDisherBykind(int kind) throws SQLException
	{
		String sql="SELECT * FROM  dishes where kindid=?";
		this.ps = dbConn.prepareStatement(sql);
	    ps.setLong(1, kind);
	    rs = ps.executeQuery();
	    List<Dishes> list=new ArrayList<Dishes>();
        while(rs.next()) {
        	String id=rs.getString("id");
            String name =rs.getString("name");
            double price =Double.valueOf(rs.getString("price")).doubleValue();
            String note =rs.getString("note");
            String evaluate=rs.getString("evaluate");
            int kinds=Integer.valueOf(rs.getString("kindid")).intValue();
            int sum=Integer.valueOf(rs.getString("sum")).intValue();
            String url=rs.getString("url");
            Dishes dishes=new Dishes(id,name,price,note,evaluate,kinds,sum,url);
            list.add(dishes);
        }
        return list;

	}
	
	//通过菜名查询
	public Dishes getDisherByid(int id) throws SQLException
	{
		String sql="SELECT * FROM  dishes where id=?";
		this.ps = dbConn.prepareStatement(sql);
	    ps.setLong(1, id);
	    rs = ps.executeQuery();
        if(rs.next()) {
        	String ids=rs.getString("id");
            String names =rs.getString("name");
            double price =Double.valueOf(rs.getString("price")).doubleValue();
            String note =rs.getString("note");
            String evaluate=rs.getString("evaluate");
            int kinds=Integer.valueOf(rs.getString("kindid")).intValue();
            int sum=Integer.valueOf(rs.getString("sum")).intValue();
            String url=rs.getString("url");
            Dishes dishes=new Dishes(ids,names,price,note,evaluate,kinds,sum,url);
            return dishes;
        }
		return null;
	}
	
	
	//添加菜品
	public int addDisher(Dishes dishes) throws SQLException
	{
		String sqlask="SELECT * FROM  dishes where id=?";
		ps = dbConn.prepareStatement(sqlask);
	    ps.setString(1, dishes.getid());
	    rs = ps.executeQuery();
        if(rs.next())
        	return 0;         //主键菜品id已存在
        else {
        	String sql="insert into dishes(id,name,price,note,evaluate,sum,kindid) value(?,?,?,?,?,?,?)";
    		this.ps = dbConn.prepareStatement(sql);
    	    ps.setString(1, dishes.getid());
    	    ps.setString(2, dishes.getname());
    	    ps.setDouble(3, dishes.getprice());
    	    ps.setString(4, dishes.getnote());
    	    ps.setString(5, dishes.getevaluate());
    	    ps.setLong(6, dishes.getsum());
    	    ps.setLong(7, dishes.getkind());
    	    ps.execute();
            return 1;    //插入成功
        }
	}
	
	
	//修改菜品
	public int changeDisher(Dishes dishes) throws SQLException
	{
		String sqlask="SELECT * FROM  dishes where id=?";
		ps = dbConn.prepareStatement(sqlask);
	    ps.setString(1, dishes.getid());
	    rs = ps.executeQuery();
        if(rs.next()) {
        	String sql="UPDATE dishes SET name = ?,price = ?,note=? ,evaluate=?,sum=?,kindid=? WHERE id = ? ";
    		this.ps = dbConn.prepareStatement(sql);
    	    ps.setString(7, dishes.getid());
    	    ps.setString(1, dishes.getname()==null?rs.getString("name"):dishes.getname());
    	    ps.setDouble(2, dishes.getprice()==-100?Double.valueOf(rs.getString("price")).doubleValue():dishes.getprice());
    	    ps.setString(3, dishes.getnote()==null?rs.getString("note"):dishes.getnote());
    	    ps.setString(4, dishes.getevaluate()==null?rs.getString("evaluate"):dishes.getevaluate());
    	    ps.setLong(5, dishes.getsum()==-100?Integer.valueOf(rs.getString("sum")).longValue():dishes.getsum());
    	    ps.setLong(6, dishes.getkind()==-100?Integer.valueOf(rs.getString("kindid")).longValue():dishes.getsum());
    	    ps.executeUpdate();
    	    return 1;    //修改成功
        }
        	
        else {
        	return 0;         //主键菜品id不存在
        }	
	}
	
	
	//获取全部显示的菜单
	public ALLMenu getMenu() throws SQLException{
		String sqlask="SELECT * FROM  kind";
		ps = dbConn.prepareStatement(sqlask);
	    rs = ps.executeQuery();
	    ALLMenu allmenu=new ALLMenu("无");
	    while(rs.next()) {
	    	int id=Integer.valueOf(rs.getString("id")).intValue();
	    	String name=rs.getString("name");
	    	String sql="SELECT * FROM  dishes WHERE kindid=?";
	    	ResultSet rs1;
	    	ps = dbConn.prepareStatement(sql);
	    	ps.setLong(1, id);
	    	rs1 = ps.executeQuery();
	    	Menu menu=new Menu(id,name);
	    	while(rs1.next()) {
	    		String ids=rs1.getString("id");
	            String names =rs1.getString("name");
	            double price =Double.valueOf(rs1.getString("price")).doubleValue();
	            String note =rs1.getString("note");
	            String evaluate=rs1.getString("evaluate");
	            int kinds=Integer.valueOf(rs1.getString("kindid")).intValue();
	            int sum=Integer.valueOf(rs1.getString("sum")).intValue();
	            String url=rs1.getString("url");
	            Dishes dishes=new Dishes(ids,names,price,note,evaluate,kinds,sum,url);
	            menu.dishes.add(dishes);
	    	}
	    	allmenu.results.add(menu);
	    }
	    return allmenu;
	}
	
	public int changedishesnum(ALLMenu allmenu) throws SQLException{
		ArrayList<Menu> menulist=allmenu.results;
		for(int i=0;i<menulist.size();i++) {
			ArrayList<Dishes> disheslist=menulist.get(i).dishes;
			for(int j=0;j<disheslist.size();j++) {
				String sql="UPDATE dishes set sum=? WHERE id=?";
				ps = dbConn.prepareStatement(sql);
				ps.setLong(1,disheslist.get(j).getsum() );
	    	    ps.setString(2,disheslist.get(j).getid() );
	    	    ps.executeUpdate();
			}
		}
		return 1;
	}
	
	//添加新菜系
	public int addkind(int id,String name) throws SQLException
	{
		String sqlask="SELECT * FROM  kind WHERE id=?";
		ps = dbConn.prepareStatement(sqlask);
	    ps.setLong(1, id);
	    rs = ps.executeQuery();
	    if(rs.next()) {
	    	return 1;    //插入失败
	    }
	    else {
	    	String sql="insert into kind(id,name) value(?,?)";
			ps = dbConn.prepareStatement(sql);
		    ps.setLong(1, id);
		    ps.setString(2, name);
		    ps.execute();
		    return 0;
	    }
		
		

	}
	
	
	
	
}
