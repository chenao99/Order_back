package Data;

public class Dishes {
	
	private String ID;     //id
	private String foodName;   //����
	private double foodPrice;   //�۸�
	private String note;    //��ע
	private String evaluate;    //����
	private int kindid;    //����
	private int salesCount;     //��Ʒ����
	private String url;
	
	public String getid() {
		return this.ID;
	}
	public String getname() {
		return this.foodName;
	}
	public double getprice() {
		return this.foodPrice;
	}
	public String getnote() {
		return this.note;
	}
	public String getevaluate() {
		return this.evaluate;
	}
	public int getkind() {
		return this.kindid;
	}
	public int getsum() {
		return this.salesCount;
	}
	public String geturl() {
		return this.url;
	}
	
	public Dishes(String id,String name,double price,String note,String evaluate,int kind,int sum,String url) {
		// TODO �Զ����ɵĹ��캯�����
		this.ID=id;
		this.foodName=name;
		this.foodPrice=price;
		this.note=note;
		this.evaluate=evaluate;
		this.kindid=kind;
		this.salesCount=sum;
		this.url=url;
	}
	
}
