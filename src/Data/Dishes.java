package Data;

public class Dishes {
	
	private String ID;     //id
	private String foodName;   //菜名
	private double foodPrice;   //价格
	private String note;    //备注
	private String evaluate;    //评价
	private int kindid;    //种类
	private int salesCount;     //菜品数量
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
		// TODO 自动生成的构造函数存根
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
