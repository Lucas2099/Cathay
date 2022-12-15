package com.example.imodel;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.model.*;
public interface ICurrency extends JpaRepository<Currency, Long>{ 

	List<Currency> findAll();
	
	Currency queryByCode(String code );
	
	int irtCurrency(); // iinsert
	
	int modCurrency(); //modify
	
	int delCurrency(); //delete
}
