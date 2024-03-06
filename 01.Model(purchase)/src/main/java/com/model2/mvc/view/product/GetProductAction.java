package com.model2.mvc.view.product;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Cookie;
import com.model2.mvc.framework.Action;
import com.model2.mvc.service.product.ProductService;
import com.model2.mvc.service.product.impl.ProductServiceImpl;
import com.model2.mvc.service.product.vo.ProductVO;

public class GetProductAction extends Action{

   @Override
   public String execute(   HttpServletRequest request,
                                    HttpServletResponse response) throws Exception {
      
      int prodNo=Integer.parseInt(request.getParameter("prodNo"));
      
      ProductService service=new ProductServiceImpl();
      ProductVO vo=service.getProduct(prodNo);
      
       Cookie[] cookies = request.getCookies();
        String cookieValue = "";

           if (cookies != null) {
               for (Cookie cookie : cookies) {
                   if (cookie.getName().equals("history")) {
                      cookieValue = cookie.getValue();
                   System.out.println(cookieValue.toString());
                       break;
                   }
               }
           }

           if (cookieValue.isEmpty()) {
               cookieValue = String.valueOf(prodNo);
           } else {
               cookieValue = cookieValue + "/" + prodNo;
           }

           Cookie Cookies = new Cookie("history", cookieValue);
           response.addCookie(Cookies);
      
      request.setAttribute("vo", vo);

      return "forward:/product/getProduct.jsp";
   }
}