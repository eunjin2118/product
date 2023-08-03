package kr.hs.study.product.dao;

import kr.hs.study.product.dto.productDTO;
import kr.hs.study.product.service.productService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class productDAOImpl implements productDAO{
    @Autowired
    private JdbcTemplate jdbc; // 실제로 데이터베이스에 접근하는 것

    @Override
    public void add(productDTO dto) {
        String sql="insert into product values(?,?)";
            jdbc.update(sql, dto.getProduct_id(), dto.getProduct_name());

    }

    @Override
    public List<productDTO> listAll() {
        String sql = "select * from product order by product_id desc";
        List<productDTO> dto = jdbc.query(sql, new BeanPropertyRowMapper<>(productDTO.class));
        // dto에 넣기->new BeanPropertyRowMapper<>(productDTO.class), 반드시 값을 가져오려면 이렇게 해야 함
        return dto;
    }

    @Override
    public void delete(String id) {
        String sql = "delete from product where product_id = (?)";
        jdbc.update(sql, id);
    }

    @Override
    public productDTO read(String id) {
        String sql = "select * from product where product_id = " + id;
        productDTO dto = jdbc.queryForObject(sql, new BeanPropertyRowMapper<>(productDTO.class));
        return dto;
    }

    @Override
    public void update(productDTO dto) {
        String sql = "update product set product_id = (?), product_name = (?)";
        jdbc.update(sql, dto.getProduct_id(), dto.getProduct_name());
    }


}
