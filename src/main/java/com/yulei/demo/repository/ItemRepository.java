package com.yulei.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.yulei.demo.model.Item;

public interface ItemRepository extends JpaRepository<Item, Integer> {

	  @Query("SELECT i FROM Item i WHERE i.checked=true")
	  List<Item> findChecked();
	}