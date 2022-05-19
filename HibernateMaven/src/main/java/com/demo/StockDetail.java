package com.demo;
import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name = "stockdetail", catalog="demo")
//@NamedQuery(name="StockDetail.findAll", query="SELECT o FROM StockDetail o")

public class StockDetail implements Serializable {
	
	private static final long serialVersionUID = 1L;



	private Integer stockId;
	
	
	
	private Stock stock;
	
	
	private String compName;
	
	
	private String compDesc;
	
	
	private String remark;
	
	
	private Date listedDate;
	
	public StockDetail() {
	}

	/*public StockDetail(Stock stock, String compName, String compDesc,
			String remark, Date listedDate) {
		this.stock = stock;
		//this.stockId=stock.getStockId();
		this.compName = compName;
		this.compDesc = compDesc;
		this.remark = remark;
		this.listedDate = listedDate;
	}*/

	@GenericGenerator(name = "generator", strategy = "foreign", parameters = @Parameter(name = "property", value = "stock"))
	@Id
	@Column(name = "STOCK_ID")
	public Integer getStockId() {
		return stockId;
	}

	public void setStockId(Integer stockId) {
		this.stockId = stockId;
	}

	@OneToOne(fetch = FetchType.LAZY,cascade=CascadeType.ALL)
	@PrimaryKeyJoinColumn
	public Stock getStock() {
		return stock;
	}

	public void setStock(Stock stock) {
		this.stock = stock;
	}

	@Column(name = "COMP_NAME")
	public String getCompName() {
		return compName;
	}

	public void setCompName(String compName) {
		this.compName = compName;
	}
	@Column(name = "COMP_DESC")
	public String getCompDesc() {
		return compDesc;
	}

	public void setCompDesc(String compDesc) {
		this.compDesc = compDesc;
	}
	@Column(name = "REMARK")
	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
	@Temporal(TemporalType.DATE)
	@Column(name = "LISTED_DATE")
	public Date getListedDate() {
		return listedDate;
	}

	public void setListedDate(Date listedDate) {
		this.listedDate = listedDate;
	}

}
