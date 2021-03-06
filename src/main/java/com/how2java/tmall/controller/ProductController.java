package com.how2java.tmall.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.how2java.tmall.pojo.Category;
import com.how2java.tmall.pojo.Product;
import com.how2java.tmall.service.CategoryService;
import com.how2java.tmall.service.ProductService;
import com.how2java.tmall.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("")
public class ProductController {
    @Autowired
    ProductService productService;
    @Autowired
    CategoryService categoryService;

    @RequestMapping("admin_product_list")
    public String list(Model model, Page page, int cid) {
        List<Product> ps = productService.list(cid);
        Category c = categoryService.get(cid);
        PageHelper.offsetPage(page.getStart(), page.getCount());
        int total = (int) new PageInfo<>(ps).getTotal();
        page.setTotal(total);
        page.setParam("&cid=" + c.getId());
        model.addAttribute("ps", ps);
        model.addAttribute("c", c);
        model.addAttribute("page", page);
        return "admin/listProduct";
    }

    @RequestMapping("admin_product_add")
    public String add(Product p) {
        productService.add(p);
        return "redirect:admin_product_list?cid=" + p.getCid();
    }

    @RequestMapping("admin_product_delete")
    public String delete(int id) {
        Product p = productService.get(id);
        productService.delete(id);
        return "redirect:admin_product_list?cid=" + p.getCid();
    }

    @RequestMapping("admin_product_edit")
    public String edit(int id, Model model) {
        Product p = productService.get(id);
        Category c = categoryService.get(p.getCid());
        p.setCategory(c);
        model.addAttribute("p", p);
        return "admin/editProduct";
    }

    @RequestMapping("admin_product_update")
    public String update(Product p) {
        productService.update(p);
        return "redirect:admin_product_list?cid=" + p.getCid();
    }
}
