package Data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;
import Data.Dishes_num;

public class order {

	private String order_id;     //����id
	private String cus_id;        //�ͻ�id
	private int table_id;   //����
	private String state;         //����״̬
	private double priceall;    //�ܼ�
	private String evaluate;          //����
	private String overdate;
	public ArrayList<Dishes_num> dishes=new ArrayList<Dishes_num>();  //�����б�

	
	public String getorder_id() {
		return this.order_id;

	}
	public String getcus_id() {
		return this.cus_id;
	}
	public int gettable_id() {
		return this.table_id;
	}
	public String getstate() {
		return this.state;
	}
	public double getpriceall() {
		return this.priceall;
	}
	public String getevaluat() {
		return this.evaluate;
	}
	public String getoverdate() {
		return this.evaluate;
	}
	
	
	
	public order(String order_id,String cus_id,int table_id,String state,double priceall,String evaluate) {
		// TODO �Զ����ɵĹ��캯�����
		this.order_id=order_id;
		this.cus_id=cus_id;
		this.table_id=table_id;
		this.state=state;
		this.priceall=priceall;
		this.evaluate=evaluate;
	}
	
	public order(String order_id,double priceall,int dishes_num,int table,String overdate) {
		this.order_id=order_id;
		this.priceall=priceall;
		this.table_id=table;
		this.overdate=overdate;
	}

}
