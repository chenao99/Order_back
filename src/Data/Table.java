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
		// TODO �Զ����ɵĹ��캯�����
		this.id=id;
		this.num=num;
		this.state=state;
	}

}
