package com.example.mission4.controller;

import com.example.mission4.model.Deals;
import com.example.mission4.view.DealsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class DealsController {
    @Autowired
    private DealsService dealsService;
    @GetMapping("/deals/")       //GET ALL DEALS
    public List<Deals> getDeals() {
        return dealsService.getDeals();
    }
    @GetMapping("/deals/{id}")       //GET DEAL BY ID
    @ResponseStatus(HttpStatus.OK)
    public List<Deals> getDealById(@PathVariable String id) {
        return dealsService.getDealById(id);
    }
    @PostMapping("/deals/")  //POST TO INSERT NEW DEAL
    @ResponseStatus(HttpStatus.CREATED)
    public void createDeals(@RequestBody Deals deals) {
        dealsService.createDeals(deals);
    }

    @PutMapping("/deals/{id}")  //PUT DEAL BY ID
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void updateDeals(@RequestBody Deals deals, @PathVariable String id) {
        dealsService.updateDeals(deals, id);
    }
    @DeleteMapping("/deals/{id}") //DELETE DEAL BY ID
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteDealsById(@PathVariable String id) {
        dealsService.deleteDealsById(id);
    }
}