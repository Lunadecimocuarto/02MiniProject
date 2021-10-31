package com.model2.mvc.view.product;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model2.mvc.framework.Action;
import com.model2.mvc.service.product.ProductService;
import com.model2.mvc.service.product.impl.ProductServiceImpl;
import com.model2.mvc.service.domain.Product;

public class AddProductAction extends Action {

	@Override
	public String execute(	HttpServletRequest request,
												HttpServletResponse response) throws Exception {
		Product product=new Product();
		product.setFileName(request.getParameter("fileName"));
		product.setManuDate((request.getParameter("manuDate")).replace("-",""));
		//System.out.println((request.getParameter("manuDate")).replace("-",""));
		product.setPrice(Integer.parseInt(request.getParameter("price")));
		product.setProdDetail(request.getParameter("prodDetail"));
		product.setProdName(request.getParameter("prodName"));
		System.out.println(product);
			
		ProductService service=new ProductServiceImpl();
		service.addProduct(product);
		
		HttpSession session=request.getSession(true);
		session.setAttribute("vo", product);
		
		return "redirect:/product/addProduct.jsp";
	}
}