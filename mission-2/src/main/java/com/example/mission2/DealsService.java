package com.example.mission2;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Service
public class DealsService {
    private List<Deals> dealsList = new ArrayList<>(Arrays.asList(
            new Deals("Dead by Daylight","$19.99","$9.99"),
            new Deals("Red Dead Redemption 2","$59.99","$29.99"),
            new Deals("Battle Field V","$49.99","$19.99")
    ));
    public List<Deals> getDeals() {
        return dealsList;
    }

    public String getEmptyMessage(){
        String emptyMessage = "The list has been cleared";
        return emptyMessage;
    }
    public void createDeals(Deals deals){
        dealsList.add(deals);
    }
    public void deleteDeals() {
        dealsList.removeAll(dealsList);
    }
    public void resetDeals() {
                dealsList = new ArrayList<>(Arrays.asList(
                new Deals("Dead by Daylight","$19.99","$9.99"),
                new Deals("Red Dead Redemption 2","$59.99","$29.99"),
                new Deals("Battle Field V","$49.99","$19.99")
        ));
    }
    public void updateDeals(Deals deals, UUID id) {
        for(Deals deals1: dealsList){
            if(deals1.getId().equals(id))
            {
                deals1.name = deals.name;
                deals1.originalPrice = deals.originalPrice;
                deals1.discountedPrice = deals.discountedPrice;
            }
        }
    }
    public void deleteDealsById(UUID id) {
        for(Deals deals1: dealsList){
            if(deals1.getId().equals(id))
            {
                dealsList.remove(deals1);
            }
        }
    }

}