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
            new Deals("Red Dead Redemption 2","59.99","$29.99"),
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
                new Deals("Red Dead Redemption 2","59.99","$29.99"),
                new Deals("Battle Field V","$49.99","$19.99")
        ));
    }
    public List<Deals> updateDeals(Deals deals, UUID id) {
        int counter = 0;
        for(Deals deals1: dealsList){
            if(deals1.getId().equals(id)){
                dealsList.set(counter,deals);
            }
            counter++;

        }
        return null;
    }
}