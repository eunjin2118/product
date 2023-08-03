package kr.hs.study.product.controller;

import kr.hs.study.product.dto.productDTO;
import kr.hs.study.product.service.productService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class productController {
    @Autowired
    private productService service;

    @GetMapping("/add")
    public String write_form(){
        return "add_form";
    }

    @PostMapping("/add")
    public String add(productDTO dto) {
       service.add(dto);
        return "result";
    }

    @GetMapping("/list")
    public String list(Model model) {
        List<productDTO> list = service.listAll();
        model.addAttribute("list", list);
        System.out.println("list : " + list);
        return "list";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable String id) {
        service.delete(id);
        return "redirect:/list"; // 다시 리스트로 돌아가기
    }

    @GetMapping("/update/{id}")
    public String read(@PathVariable String id, Model model) {
        productDTO dto = service.read(id);
        model.addAttribute("dto",dto);
        System.out.println(dto);
        return "read"; // 다시 리스트로 돌아가기
    }

    @PostMapping("/update")
    public String update(productDTO dto) {
        service.update(dto);
        return "redirect:/list";
    }
}
