package com.example.kinozippy.service;

import com.example.kinozippy.model.Shop;
import com.example.kinozippy.repository.ShopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ShopService {

    @Autowired
    ShopRepository shopRepository;

    public ResponseEntity<Shop> postShop(Shop shop) {
        if (doesShopExist(shop)) {
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
        Shop postedShop = shopRepository.save(shop);
        return new ResponseEntity<>(postedShop, HttpStatus.OK);
    }

    public List<Shop> getShop() {
        return shopRepository.findAll();
    }

    public Optional<Shop> getShop(Long id) {
        return shopRepository.findById(id);
    }

    public ResponseEntity<Shop> putShop(Shop shop, long shopId) {
        if (doesShopExist(shopId)) {
            shop.setId(shopId);
            Shop updatedShop = shopRepository.save(shop);
            return new ResponseEntity<>(updatedShop, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    public ResponseEntity<Shop> deleteShop(long shopId) {
        Optional<Shop> optionalShop = shopRepository.findById(shopId);
        if (doesShopExist(shopId)) {
            Shop deletedShop = optionalShop.get();
            shopRepository.deleteById(shopId);
            return new ResponseEntity<>(deletedShop, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    public Shop saveShop(Shop shop) {
        return shopRepository.save(shop);
    }

    private boolean doesShopExist(Shop shop) {
        Long shopId = shop.getId();
        return doesShopExist(shopId);
    }

    private boolean doesShopExist(Long id) {
        boolean isIdSet = id != null;
        return isIdSet && shopRepository.existsById(id);
    }

    public ResponseEntity<Shop> putShops(List<Shop> shops) {
        for (Shop shop : shops) {
            if (doesShopExist(shop)) shopRepository.save(shop);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
