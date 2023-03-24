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


  @PostMapping("/shop")
  @ResponseStatus(HttpStatus.CREATED)
  public ResponseEntity<Shop> postShop(@RequestBody Shop shop) {
    return shopService.postShop(shop);
  }

  @GetMapping("/shops")
  public List<Shop> getItems() {
    return shopService.getShop();
  }

  @GetMapping("/shop/{id}")
  public Shop getShop(@PathVariable long id) {
    return shopService.getShop(id).orElseThrow( ()-> new ResourceNotFoundException("Shop with id: " + id));
  }

  @PutMapping("/shop/{id}")
  public ResponseEntity<Shop> putItem(@PathVariable long id, @RequestBody Shop shop) {
    return shopService.putShop(shop, id);
  }

  // put multiple items
    @PutMapping("/shop")
    public ResponseEntity<Shop> putItems(@RequestBody List<Shop> shops) {
        return shopService.putShops(shops);
    }



  @DeleteMapping("/shop/{id}")
  public ResponseEntity<Shop> deleteShop(@PathVariable long id) {
    return shopService.deleteShop(id);
  }



}
