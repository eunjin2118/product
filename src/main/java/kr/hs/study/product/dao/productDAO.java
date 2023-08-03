package kr.hs.study.product.dao;

import kr.hs.study.product.dto.productDTO;
import kr.hs.study.product.service.productService;

import java.util.List;

public interface productDAO {
    //insert, delete, update, select  메서드
    public void add(productDTO dto);

    public List<productDTO> listAll();

    public void delete(String id);

    public productDTO read(String id);

    public void update(productDTO dto);
}
