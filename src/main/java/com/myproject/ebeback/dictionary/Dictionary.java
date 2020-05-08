package com.myproject.ebeback.dictionary;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name="items")
public class Dictionary {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="seqNo")
	int seqNo;
	
	@Column(name="custId")
	String custId;
	
	@Column(name="key")
	int key;
	
	@Column(name="value")
	String value;

	@Column(name="modDt")
	String modDt;

	@Column(name="modTm")
	String modTm;

	@Column(name="regDt")
	String regDt;

	@Column(name="regTm")
	String regTm;

	@Builder
	public Dictionary(int id, String name, int price, String imgPath) {
		super();
		this.seqNo = seqNo;
		this.custId = custId;
		this.key = key;
		this.value = value;
		this.modDt = modDt;
		this.modTm = modTm;
		this.regDt = regDt;
		this.regTm = regTm;
	}
}
