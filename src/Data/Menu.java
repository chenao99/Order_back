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
		// TODO �Զ����ɵĹ��캯�����
		this._id=id;
		this.title=title;
	}

}
