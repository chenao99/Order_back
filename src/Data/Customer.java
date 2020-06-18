package Data;

public class Customer {
	private String c_id;
	private String c_name;
	private String c_psd;
	private String c_sex;
	private String c_hy;
	private String c_tel;
	
	public String getCid() {
		return this.c_id;
	}
	public String getCname() {
		return this.c_name;
	}
	public String getCpsd() {
		return this.c_psd;
	}
	public String getCsex() {
		return this.c_sex;
	}
	public String getChy() {
		return this.c_hy;
	}
	public String getCtel() {
		return this.c_tel;
	}
	public Customer(String c_id,String c_name,String c_psd,String c_sex,String c_hy,String c_tel)
	{
		this.c_id=c_id;
		this.c_name=c_name;
		this.c_psd=c_psd;
		this.c_sex=c_sex;
		this.c_hy=c_hy;
		this.c_tel=c_tel;
	}
	

}
