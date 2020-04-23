package com.example.mission3;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;
import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Service
public class DealsService {
    @Autowired
    JdbcTemplate jdbcTemplate;

    class DealsRowMapper implements RowMapper<Deals> {
        @Override
        public Deals mapRow(ResultSet rs, int rowNum) throws SQLException {
            Deals deals = new Deals();
            deals.setId(rs.getString("deals_ref_id"));
            deals.setName(rs.getString("deals_name"));
            deals.setOriginalPrice(rs.getString("deals_original_price"));
            deals.setDiscountedPrice(rs.getString("deals_discounted_price"));
            return deals;
        }
    }

    private String queryAll = "SELECT * FROM tbl_deals";
    private String queryById ="SELECT * FROM tbl_deals WHERE deals_ref_id=?";
    private String addList = "INSERT tbl_deals(deals_ref_id,deals_name, deals_original_price, deals_discounted_price) VALUES (MID(UUID(),1,36),?,?,?)";
    private String updateListById ="UPDATE tbl_deals SET deals_name=?,deals_original_price=?,deals_discounted_price=? WHERE deals_ref_id=?";
    private String deleteListById ="DELETE FROM tbl_deals WHERE deals_ref_id=?";


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
