package com.musicseller.seller.sellerservice;

import com.musicseller.seller.entity.Instrument;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class SellerService {

    private RestTemplate restTemplate;

    public SellerService(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }

    private static final String RESOURCE_URL = "http://localhost:8080/musicstore";

    public Instrument getInstrument(Long id){
        return restTemplate.getForObject(RESOURCE_URL + "/findinstrument/" + id, Instrument.class);
    }

    public Instrument makeInstrumentAvailable(Long id){
        return restTemplate.getForObject(RESOURCE_URL + "/setavailable/" + id, Instrument.class);
    }

    HttpEntity<Instrument> request = new HttpEntity<>(new Instrument());

    ResponseEntity<Instrument> getInstrument = restTemplate
            .exchange(RESOURCE_URL, HttpMethod.GET, request, Instrument.class);

    ResponseEntity<Instrument> makeInstrumentAvailable = restTemplate
            .exchange(RESOURCE_URL,HttpMethod.POST, request, Instrument.class);



}
