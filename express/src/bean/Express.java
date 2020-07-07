package bean;

import java.sql.Date;

public class Express {
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getEno() {
		return eno;
	}
	public void setEno(String eno) {
		this.eno = eno;
	}
	public String getCarno() {
		return carno;
	}
	public void setCarno(String carno) {
		this.carno = carno;
	}
	public String getGoods() {
		return goods;
	}
	public void setGoods(String goods) {
		this.goods = goods;
	}
	public String getIsStartLocation() {
		return isStartLocation;
	}
	public void setIsStartLocation(String isStartLocation) {
		this.isStartLocation = isStartLocation;
	}
	public String getIsEndLocation() {
		return isEndLocation;
	}
	public void setIsEndLocation(String isEndLocation) {
		this.isEndLocation = isEndLocation;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public String getExpresser() {
		return expresser;
	}
	public void setExpresser(String expresser) {
		this.expresser = expresser;
	}
	private Integer id;
	
	private String eno;
	private String carno;
	private String goods;
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	private double price;
	
	private String isStartLocation;
	private String isEndLocation;
	private Date createTime;
	private String expresser;

}
