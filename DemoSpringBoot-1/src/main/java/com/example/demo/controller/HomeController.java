package com.example.demo.controller;


import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.model.Account;
import com.example.demo.model.Product;
import com.example.demo.service.AccountService;
import com.example.demo.service.ProductService;

@Controller
public class HomeController {
	// 
	@Autowired
	private ProductService productService;
	private AccountService accountService;
	
	
	// lấy ra toàn bộ product
	@RequestMapping("/")
    public String personList(Model model) {
        model.addAttribute("products", productService.findAll());
        return "Home";
    }
	
	// tạo product
	@RequestMapping("/product/create")
    public String create(Model model) {
        model.addAttribute("product", new Product());
        return "Form";
    }
	
	// sửa
	@RequestMapping("/product/edit/{id}")
    public String edit(@PathVariable int id, Model model) {	
        model.addAttribute("product", productService.findOne(id));
        return "Form";        
    }
	
	
	
	// tạo mới hoặc sửa lưu vào trong db
	@PostMapping("product/save")
	public String save(Model model, @ModelAttribute("product") Product p,RedirectAttributes redirect) {	
		productService.save(p);
		return "redirect:/";		
	}
	
	// tạo mới
	@RequestMapping("/create")
	public String add(Model model) {			
		model.addAttribute("product", new Product());
		return "Form";		
	}
	
	// xóa
	@GetMapping("product/delete/{id}")
	public String delete(@PathVariable int id,RedirectAttributes redirect) {				
		productService.delete(id);
		return "redirect:/";	
	}
	
	//chueyenr trang login
	@GetMapping("login")
	public String login(Model model) {				
		return "Login";	
	}
	
	@RequestMapping("/login/{userName}/{password}")
    public String checkLogin(@PathVariable String userName,@PathVariable String password, Model model,RedirectAttributes redirect) {
		Optional<Account> acc = accountService.findUser(userName,password);
		if(acc.isEmpty()) {
			return "redirect:/login";	
		}else {
			model.addAttribute("user", acc);
	        return "redirect:/home";     
		}        
    }

	
}
