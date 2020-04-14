package com.example.mission2;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
@Service
public class DealsService {
    private List<Deals> dealsList = new ArrayList<>(Arrays.asList(
            new Deals("Dead by Daylight","$19.99","$9.99"),
            new Deals("Red Dead Redemption 2","59.99","$29.99"),
            new Deals("Battle Field V","$49.99","$19.99")
    ));
    private String emptyMessage = "The list has been cleared";
    private String errorMessage = "ERROR Inserting Game Deals";
    public List<Deals> getDeals() {
        return dealsList;
    }
    public String getEmptyMessage(){
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
    public String getErrorMessage() {
        return errorMessage;
    }
}