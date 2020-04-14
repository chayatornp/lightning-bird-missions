package com.example.mission2;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
@Service

public class DealsService {
    private List<Deals> dealsList = new ArrayList<>(Arrays.asList(
            new Deals("1","Dead by Daylight","$19.99","$9.99"),
            new Deals("2","Red Dead Redemption 2","$59.99","$29.99"),
            new Deals("3","Battle Field V","$49.99","$19.99")
    ));

    public List<Deals> getDeals() {
        return dealsList;
    }
    public void createDeals(Deals deals){
        dealsList.add(deals);
    }
    public void deleteDeals() {
        dealsList.removeAll(dealsList);
    }
}
