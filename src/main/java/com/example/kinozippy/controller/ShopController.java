package com.example.kinozippy.controller;

import com.example.kinozippy.exception.ResourceNotFoundException;
import com.example.kinozippy.model.Shop;
import com.example.kinozippy.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(value = "*")
public class ShopController {

  @Autowired
  ShopService shopService;


  @PostMapping("/Shop")
  @ResponseStatus(HttpStatus.CREATED)
  public ResponseEntity<Shop> postShop(@RequestBody Shop shop) {
    return shopService.postShop(shop);
  }

  @GetMapping("/Shops")
  public List<Shop> getMovies() {
    return shopService.getShop();
  }

  @GetMapping("/shop/{id}")
  public Shop getShop(@PathVariable long id) {
    return shopService.getShop(id).orElseThrow( ()-> new ResourceNotFoundException("Shop with id: " + id));
  }

  @PutMapping("/shop/{id}")
  public ResponseEntity<Shop> putMovie(@PathVariable long id, @RequestBody Shop shop) {
    return shopService.putShop(shop, id);
  }

  @DeleteMapping("/shop/{id}")
  public ResponseEntity<Shop> deleteShop(@PathVariable long id) {
    return shopService.deleteShop(id);
  }



}
