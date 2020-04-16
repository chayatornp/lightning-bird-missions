package com.example.mission3;

import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DealsRowMapper implements RowMapper<Deals> {
    @Override
    public Deals mapRow(ResultSet rs, int rowNum) throws SQLException{
        Deals deals = new Deals();
        deals.setId(rs.getString("deals_ref_id"));
        deals.setName(rs.getString("deals_name"));
        deals.setOriginalPrice(rs.getString("deals_original_price"));
        deals.setDiscountedPrice(rs.getString("deals_discounted_price"));
        return deals;
    }
}