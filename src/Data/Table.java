package Data;

public class Table {
	
	private int id;
	private int num;
	private int state;
	
	public int getnum() {
		return this.num;
	}
	public int getid() {
		return this.id;
	}
	public int getstate() {
		return this.state;
	}
	
	public Table(int id,int num,int state) {
		// TODO 自动生成的构造函数存根
		this.id=id;
		this.num=num;
		this.state=state;
	}

}
