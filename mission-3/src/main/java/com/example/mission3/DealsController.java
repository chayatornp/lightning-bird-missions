package com.example.mission3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.UUID;
@RestController
public class DealsController {
    @Autowired
    private DealsService dealsService;
    @GetMapping("/deals/")       //GET ALL DEALS
    public List<Deals> getDeals() {
        return dealsService.getDeals();
    }
    @GetMapping("/deals/{id}")       //GET DEAL BY ID
    public List<Deals> getDealById(@PathVariable String id) {
        return dealsService.getDealById(id);
    }
    @PostMapping("/deals/")  //POST TO INSERT NEW DEAL
    public List<Deals> createDeals(@RequestBody Deals deals) {
        dealsService.createDeals(deals);
        return dealsService.getDeals();
    }
    @PutMapping("/deals/{id}")  //PUT DEAL BY ID
    public List<Deals> updateDeals(@RequestBody Deals deals, @PathVariable String id) {
        dealsService.updateDeals(deals, id);
        return dealsService.getDeals();
    }
    @DeleteMapping("/deals/{id}") //DELETE DEAL BY ID
    public Object deleteDealsById(@PathVariable String id) {
        dealsService.deleteDealsById(id);
        return dealsService.getDeals();
    }
    @DeleteMapping("/deals/")  //DELETE ALL DEALS
    public Object deleteDeals() {
        dealsService.deleteDeals();
        return dealsService.getEmptyMessage();
    }
}