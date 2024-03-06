package com.model2.mvc.view.product;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model2.mvc.framework.Action;
import com.model2.mvc.service.product.ProductService;
import com.model2.mvc.service.product.impl.ProductServiceImpl;
import com.model2.mvc.service.product.vo.ProductVO;


public class AddProductAction extends Action {

	@Override
	public String execute(	HttpServletRequest request,
												HttpServletResponse response) throws Exception {
		
		ProductVO productVO=new ProductVO();
		
		String[] date = request.getParameter("manuDate").split("-");
		
		productVO.setFileName(request.getParameter("fileName"));
		productVO.setManuDate(date[0] + date[1] + date[2]);
		//productVO.setManuDate(request.getParameter("manuDate"));
		productVO.setPrice(Integer.parseInt((request.getParameter("price"))));
		productVO.setProdDetail(request.getParameter("prodDetail"));
		productVO.setProdName(request.getParameter("prodName"));
		
		System.out.println(productVO);
		
		ProductService service=new ProductServiceImpl();
		service.addProduct(productVO);
		
		return "forward:/product/addProduct.jsp";
	}
}