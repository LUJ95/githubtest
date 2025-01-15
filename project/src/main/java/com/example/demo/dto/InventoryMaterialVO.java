package com.example.demo.dto;

import org.apache.ibatis.type.Alias;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Alias("InventoryMaterialVO")
public class InventoryMaterialVO {
	private int invenmat_num;
	private String invenmat_name;
	private int invenmat_price;
	private int invenmat_amount;
	private int invenmat_regdate;
}
