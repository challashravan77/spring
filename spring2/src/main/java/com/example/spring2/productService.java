package com.example.spring2;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
	public class productService
	{
		@Autowired
		myrepo myrepo;
		public  List<product> displayData()
		{
			 return myrepo.findAll();
		}
		public void saveProduct(product product)
		{
			myrepo.save(product);
		}
		public product getProd(long id)
		{
			return myrepo.findById(id).get();
		}
		public void delete(long id)
		{
			myrepo.deleteById(id);;
		}
	}


