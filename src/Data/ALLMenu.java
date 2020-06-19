package Data;

import java.util.ArrayList;

import Data.Menu;

public class ALLMenu {
	
	private String error;
	public ArrayList<Menu> results=new ArrayList<Menu>();;
	
	public String geterror() {
		return this.error;
	}
	
	public void seterror(String error) {
		this.error=error;
	}
	public ArrayList<Menu> getresult() {
		return this.results;
	}

	public ALLMenu(String error) {
		// TODO 自动生成的构造函数存根
		this.error=error;
	}

}
