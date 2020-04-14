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
    @DeleteMapping("/deals/")  //DELETE
    public Object deleteDeals(){
        dealsService.deleteDeals();
        return dealsService.getEmptyMessage();
    }
    @PostMapping("/deals/reset")  //RESET LIST
    public List<Deals> resetDeals(){
        dealsService.resetDeals();
        return dealsService.getDeals();
    }
    @PutMapping("/deals/")  //PUT
    public String updateDeals(){
        return dealsService.getErrorMessage();
    }
}