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
		// TODO �Զ����ɵĹ��캯�����
		this.error=error;
	}

}
