package com.example.kinozippy.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import org.springframework.lang.NonNull;

@Entity
@Table(name = "shop")
public class Shop {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "shop_id")
  @JsonProperty("id")
  private Long id;

  @Column(name = "name")
  @NonNull
  @JsonProperty("name")
  private String name;

  @Column(name = "price")
  @NonNull
  @JsonProperty("price")
  private int price;

  @Column(name = "quantity")
  @NonNull
  @JsonProperty("quantity")
  private int quantity;

  public Shop(Long id, String name, int price, int quantity) {
    this.id = id;
    this.name = name;
    this.price = price;
    this.quantity = quantity;
  }

  public Shop(String name, int price, int quantity) {
    this.name = name;
    this.price = price;
    this.quantity = quantity;
  }

  public Shop() {

  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getPrice() {
    return price;
  }

  public void setPrice(int price) {
    this.price = price;
  }

  public int getQuantity() {
    return quantity;
  }

  public void setQuantity(int quantity) {
    this.quantity = quantity;
  }
}
