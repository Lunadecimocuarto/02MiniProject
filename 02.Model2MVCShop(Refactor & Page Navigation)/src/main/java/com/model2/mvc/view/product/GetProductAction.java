package com.model2.mvc.view.product;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model2.mvc.framework.Action;
import com.model2.mvc.service.product.ProductService;
import com.model2.mvc.service.product.impl.ProductServiceImpl;
import com.model2.mvc.service.domain.Product;



public class GetProductAction extends Action{

	@Override
	public String execute(	HttpServletRequest request,
												HttpServletResponse response) throws Exception {
		System.out.println("=========================\n// GetProductAction execute start");
		
		int prodNo=Integer.parseInt(request.getParameter("prodNo"));
		
		ProductService service=new ProductServiceImpl();
		Product vo=service.getProduct(prodNo);
		
		
		request.setAttribute("vo", vo);
		
		System.out.println("vo : "+ vo);
		
		String history = null;
		Cookie[] cookies = request.getCookies();
		if (cookies!=null && cookies.length > 0) {
			for (int i = 0; i < cookies.length; i++) {
				Cookie cookie = cookies[i];
				if (cookie.getName().equals("history")) {
					history = cookie.getValue();
				}
			}
		}
		history += ","+vo.getProdNo();
		Cookie cookie=new Cookie("history", history);
		response.addCookie(cookie);
		
		
		String menu=(String)request.getParameter("menu");
		
		if(menu.equals("manage")) {
			return "forward:/product/updateProductView.jsp";
		}else {
			return "forward:/product/getProduct.jsp";
		}
	}
}