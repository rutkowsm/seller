package com.musicseller.seller.controller;

import com.musicseller.seller.entity.Instrument;
import com.musicseller.seller.sellerservice.SellerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/instrumentseller")
public class SellerController {

    private SellerService sellerService;

    public SellerController(SellerService sellerService) {
        this.sellerService = sellerService;
    }

    @GetMapping("getinstrument/{id}")
    public ResponseEntity<Instrument> getInstrument(@PathVariable Long id){
        return ResponseEntity.ok(this.sellerService.getInstrument(id));
    }
}
