package com.yulei.demo.controller;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.yulei.demo.model.Item;
import com.yulei.demo.repository.ItemRepository;

@Controller
@RequestMapping("/items")
public class ItemController {
  @Autowired
  private ItemRepository itemRepository;

  @RequestMapping(value="findItems")
  public List<Item> findItems() {
    return itemRepository.findAll();
  }

  @RequestMapping(value="addItem")
  public Item addItem(@RequestBody Item item) {
    item.setId(null);
    return itemRepository.saveAndFlush(item);
  }

  @RequestMapping(value = "update/{id}")
  public Item updateItem(@RequestBody Item updatedItem, @PathVariable Integer id) {
    Item item = itemRepository.getOne(id);
    item.setChecked(updatedItem.isChecked());
    item.setDescription(updatedItem.getDescription());
    return itemRepository.saveAndFlush(item);
  }

  @RequestMapping(value = "deleteItem/{id}")
  @ResponseStatus(value = HttpStatus.NO_CONTENT)
  public void deleteItem(@PathVariable Integer id) {
    itemRepository.delete(id);
  }

  @ResponseStatus(HttpStatus.BAD_REQUEST)
  @ExceptionHandler(value = { EmptyResultDataAccessException.class, EntityNotFoundException.class })
  public void handleNotFound() { }
}