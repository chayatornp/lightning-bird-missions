package com.example.mission2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
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
    @DeleteMapping("/deals")  //DELETE
    public List<Deals> deleteDeals(){
        dealsService.deleteDeals();
        return dealsService.getDeals();
    }
}