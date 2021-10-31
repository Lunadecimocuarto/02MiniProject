package com.model2.mvc.view.product;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model2.mvc.framework.Action;
import com.model2.mvc.service.product.ProductService;
import com.model2.mvc.service.product.dao.ProductDAO;
import com.model2.mvc.service.product.impl.ProductServiceImpl;
import com.model2.mvc.service.domain.Product;


public class UpdateProductAction extends Action {

	@Override
	public String execute(	HttpServletRequest request,
												HttpServletResponse response) throws Exception {
		
		
		System.out.println("==UpdateProductAction Ω√¿€==");
			
		int prodNo=Integer.parseInt(request.getParameter("prodNo"));
				
		Product product=new Product();
		product.setProdNo(prodNo);
		product.setFileName(request.getParameter("fileName"));
		product.setManuDate((request.getParameter("manuDate")).replace("-",""));
		//System.out.println((request.getParameter("manuDate")).replace("-",""));
		product.setPrice(Integer.parseInt(request.getParameter("price")));
		product.setProdDetail(request.getParameter("prodDetail"));
		product.setProdName(request.getParameter("prodName"));
		System.out.println(product);
		
		ProductService service=new ProductServiceImpl();
		service.updateProduct(product);
		
		HttpSession session=request.getSession(true);
		
	//	int sessionNo=((Product)session.getAttribute("vo")).getProdNo();
	//	int sessionNo=((Product)request.getAttribute("vo")).getProdNo();
		
		ProductDAO productDao=new ProductDAO();
		product.setRegDate(productDao.findProduct(prodNo).getRegDate());

	//	if(sessionNo==prodNo) {
			session.setAttribute("vo", product);
	//		request.setAttribute("vo", product);
	//	}
		
		System.out.println("==UpdateProductAction ≥°==");
		
		return "redirect:/product/updateProduct.jsp";
		
		
	}
}