package com.model2.mvc.view.product;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model2.mvc.framework.Action;
import com.model2.mvc.service.product.ProductService;
//import com.model2.mvc.service.product.dao.ProductDAO;
import com.model2.mvc.service.product.impl.ProductServiceImpl;
import com.model2.mvc.service.product.vo.ProductVO;

public class UpdateProductAction extends Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		ProductService service = new ProductServiceImpl();
		
		int prodNo = Integer.parseInt(request.getParameter("prodNo"));

		// ProductVO productVO=new ProductVO();

		ProductVO productVO = service.getProduct(prodNo);
		
		System.out.println("productVO : " + productVO);
		System.out.println("prodNo : " + prodNo);

		
		// ProductDAO productDAO = new ProductDAO();

		// productDAO.findProduct(prodNo);

		
		  productVO.setProdNo(prodNo);
		  productVO.setProdName(request.getParameter("prodName"));
		  productVO.setProdDetail(request.getParameter("prodDetail"));
		  productVO.setManuDate(request.getParameter("manuDate"));
		 productVO.setPrice(Integer.parseInt(request.getParameter("price")));
		 productVO.setFileName(request.getParameter("fileName"));
		 
		System.out.println("update :" +productVO.toString()); 
		service.updateProduct(productVO);
		

		/*
		 * HttpSession session=request.getSession(); String
		 * sessionId=((ProductVO)session.getAttribute("prodNo")).getProdNo();
		 * 
		 * if(sessionId.equals(prodNo)){ session.setAttribute("prodNo", productVO); }
		 */

		return "redirect:/getProduct.do?prodNo=" + prodNo;
	}
}