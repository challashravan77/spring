package com.example.spring2;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class mycontroller {

		@Autowired
		productService service;
		@RequestMapping("/")
		public String showHomePage(Model model)
		{
			
			System.out.println("Display is called");
			List<product> list= service.displayData();
			for(product product : list)
			{
				System.out.println(product.getId()+ " "+product.getName());
			}
			model.addAttribute("abc", list);
			return "show";
		}
		@RequestMapping("/addData")
		public String newData(Model model)
		{
			product product= new product();
			model.addAttribute("product", product);
			return "addpro";
		}
		@RequestMapping(value =  "/save" , method = RequestMethod.POST)
		public String saveData(@ModelAttribute("product") product product)
		{
			service.saveProduct(product);
			return "redirect:/";
		}
		@RequestMapping("/edit/{id}")
		public ModelAndView editData(@PathVariable(name = "id") int id)
		{
			ModelAndView view = new ModelAndView("edit_");
			product product = service.getProd(id);
			view.addObject("product", product);
			return view;
		}
		
		@RequestMapping("/delete/{id}")
		public String deleteData(@PathVariable(name = "id") int id)
		{
			service.delete(id);
			return "redirect:/";
		}
	}


