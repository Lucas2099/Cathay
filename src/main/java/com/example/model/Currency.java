package com.example.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

@Entity
@Table(name = "Currency")
public class Currency {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@Column(name="code")
	private String code;
	
	@Column(name="symbol")
	private String symbol;
	
	@Column(name="rate")
	private String rate;
	
	@Column(name="description")
	private String description;
	
	@Column(name="ratefloat")
	private double rate_float;
	
	@Column(name = "creatdate")
    @CreatedDate()
    private Date createDt;
	
	@Column(name = "modifydate")
    private Date modifyDt;

	public Currency(String code, String symbol, String rate, String description, double ratefloat) {
		this.code = code;
		this.symbol = symbol;
		this.rate = rate;
		this.description = description;
		this.rate_float = ratefloat;
	}
	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getCode() {
		return code;
	}


	public void setCode(String code) {
		this.code = code;
	}


	public String getSymbol() {
		return symbol;
	}


	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}


	public String getRate() {
		return rate;
	}


	public void setRate(String rate) {
		this.rate = rate;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public double getRate_float() {
		return rate_float;
	}


	public void setRate_float(double rate_float) {
		this.rate_float = rate_float;
	}


	public Date getCreateDt() {
		return createDt;
	}


	public void setCreateDt(Date createDt) {
		this.createDt = createDt;
	}


	public Date getModifyDt() {
		return modifyDt;
	}


	public void setModifyDt(Date modifyDt) {
		this.modifyDt = modifyDt;
	}
	
	
}
