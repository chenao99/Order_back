package Data;

import java.util.ArrayList;
import java.util.List;

import Data.Dishes;

public class Menu {
	
	private int _id;
	private String title;
	public ArrayList<Dishes> dishes=new ArrayList<Dishes>();
	
	public int getid() {
		return this._id;
	}
	public String gettitle() {
		return this.title;
	}


	public Menu(int id,String title) {
		// TODO 自动生成的构造函数存根
		this._id=id;
		this.title=title;
	}

}
