package com.example.kinozippy.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import org.springframework.lang.NonNull;

@Entity
@Table(name = "shop")
public class Shop {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "Shop_id")
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

  public Shop(Long id, @NonNull String name, int price, int quantity) {
    this.id = id;
    this.name = name;
    this.price = price;
    this.quantity = quantity;
  }

  public Shop() {

  }

  public void setId(Long id) {
    this.id = id;
  }

  @Id
  public Long getId() {
    return id;
  }

  @NonNull
  public String getName() {
    return name;
  }

  public void setName(@NonNull String name) {
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
