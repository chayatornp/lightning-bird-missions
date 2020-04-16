package com.example.mission2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.UUID;
@RestController
public class DealsController {
    @Autowired
    private DealsService dealsService;

    @GetMapping("/deals")       //GET
    public List<Deals> getDeals(){
        return dealsService.getDeals();
    }
    @PostMapping("/deals")  //POST
    public List<Deals> createDeals(@RequestBody Deals deals){
        dealsService.createDeals(deals);
        return dealsService.getDeals();
    }
    @PutMapping("/deals/{id}")  //PUT BY ID
    public List<Deals> updateDeals(@RequestBody Deals deals, @PathVariable UUID id){
        dealsService.updateDeals(deals, id);
        return dealsService.getDeals();
    }
    @DeleteMapping("/deals/{id}") //DELETE BY ID
    public Object deleteDealsById(@PathVariable UUID id){
        dealsService.deleteDealsById(id);
        return dealsService.getDeals();
    }
    @DeleteMapping("/deals/")  //DELETE ALL
    public Object deleteDeals(){
        dealsService.deleteDeals();
        return dealsService.getEmptyMessage();
    }
    @PostMapping("/deals/reset")  //RESET LIST
    public List<Deals> resetDeals(){
        dealsService.resetDeals();
        return dealsService.getDeals();
    }
}