package kr.hs.study.product.service;

import kr.hs.study.product.dto.productDTO;

import java.util.List;

public interface productService {
    public void add(productDTO dto);

    // select
    public List<productDTO> listAll();

    public void delete(String id);

    public productDTO read(String id);

    public void update(productDTO dto); // dto안에 값이 들어있으니까
}
