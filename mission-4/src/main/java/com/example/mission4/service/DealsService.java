package com.example.mission4.service;

import com.example.mission4.configuration.DealsRowMapper;
import com.example.mission4.configuration.JdbcConfig;
import com.example.mission4.model.Deals;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import javax.sql.DataSource;
import java.util.List;

@Service
public class DealsService {

    DataSource dataSource = new JdbcConfig().mysqlDataSource();
    JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
    private String emptyMessage = "The table is empty";
    private String queryAll = "SELECT * FROM tbl_deals";
    private String queryById ="SELECT * FROM tbl_deals WHERE deals_ref_id=?";
    private String addList = "INSERT tbl_deals(deals_ref_id,deals_name, deals_original_price, deals_discounted_price) VALUES (MID(UUID(),1,36),?,?,?)";
    private String updateListById ="UPDATE tbl_deals SET deals_name=?,deals_original_price=?,deals_discounted_price=? WHERE deals_ref_id=?";
    private String deleteListById ="DELETE FROM tbl_deals WHERE deals_ref_id=?";
    private String deleteAll = "TRUNCATE TABLE tbl_deals";

    public Object getEmptyMessage() {
        return emptyMessage;
    }
    public List<Deals> getDeals() {
        return jdbcTemplate.query(queryAll, new DealsRowMapper());
    }
    public List<Deals> getDealById(String id) {
        return jdbcTemplate.query(queryById, new DealsRowMapper(), id);
    }
    public void createDeals(Deals deals) {
        jdbcTemplate.update(addList, deals.getName(),deals.getOriginalPrice(),deals.getDiscountedPrice());
    }
    public void updateDeals(Deals deals, String id ) {
        jdbcTemplate.update(updateListById, deals.getName(),deals.getOriginalPrice(),deals.getDiscountedPrice(),id);
    }
    public void deleteDealsById(String id) {
        jdbcTemplate.update(deleteListById, id);
    }
    public void deleteDeals() {
        jdbcTemplate.execute(deleteAll);
    }
}