package com.shop.controller;

import java.io.IOException;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



import com.shop.model.*;
import com.shop.service.OrderService;
import com.shop.service.ProductService;

import com.shop.dto.*;
import com.shop.entity.Product;
import com.shop.entity.User;

@WebServlet(urlPatterns={"/login","/auth","/auth/profile","/auth/profile/admin/*","/auth/profile/customer/*","/auth/profile/admin/product/save"})
public class ShopController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	@Inject
	ProductService service;
	
	@Inject
	OrderService service2;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String path = request.getServletPath();
		String contextPath = request.getContextPath();
		String info = request.getPathInfo();
		String url = request.getRequestURI();
		String fullPath = contextPath+path+info;

		String getNumber = url.replaceAll(".*?(\\d+)$", "$1"); //view/101 -> 101

		
		if("/login".equals(path)) {
			RequestDispatcher dispatch = request.getRequestDispatcher("/login.jsp");
            dispatch.forward(request, response);
		}else if("/auth/profile".equals(path)){
			HttpSession session = request.getSession();
			User user = (User)session.getAttribute("user_data");
			String role = user.getRole();
			
			if("admin".equals(role)) {
				System.out.println("executed admin");
				RequestDispatcher dispatch = request.getRequestDispatcher("/WEB-INF/jsp/admin/admin.jsp");
				dispatch.forward(request, response);
			}else if("customer".equals(role)){
				System.out.println("executed customer");
				RequestDispatcher dispatch = request.getRequestDispatcher("/WEB-INF/jsp/customer/customer.jsp");
				dispatch.forward(request, response);
			}
		}else if (("/auth/profile/admin").equals(path)) {
			if("/register".equals(info)) {
				RequestDispatcher dispatch = request.getRequestDispatcher("/WEB-INF/jsp/admin/product_register.jsp");
				dispatch.forward(request, response);
			}else if("/catalog".equals(info)) {
				
				List<ProductDto> products = service.findAll();
            	request.setAttribute("product_list", products);
				RequestDispatcher dispatch = request.getRequestDispatcher("/WEB-INF/jsp/admin/product_catalog.jsp");
				dispatch.forward(request, response);
			}else if(("/view/"+getNumber).equals(info)) {
				
                ProductDto productById = service.findById(String.valueOf(getNumber));
                request.setAttribute("product_by_id", productById);
				
				RequestDispatcher dispatch = request.getRequestDispatcher("/WEB-INF/jsp/admin/product_view.jsp");
				dispatch.forward(request, response);
			}
		}else if (("/auth/profile/customer").equals(path)) {
			if("/list".equals(info)) {
				System.out.println("executed list");
				List<ProductDto> products = service.findAll();
            	request.setAttribute("product_list", products);
            	
				RequestDispatcher dispatch = request.getRequestDispatcher("/WEB-INF/jsp/customer/product_list.jsp");
				dispatch.forward(request, response);
			}else if ("/cart".equals(info)) {
				System.out.println("executed cart");
				RequestDispatcher dispatch = request.getRequestDispatcher("/WEB-INF/jsp/customer/order_cart.jsp");
				dispatch.forward(request, response);
			}else if ("/submit".equals(info)) {
				System.out.println("executed submit");
				RequestDispatcher dispatch = request.getRequestDispatcher("/WEB-INF/jsp/customer/order_submit.jsp");
				dispatch.forward(request, response);
			}
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String path = request.getServletPath();
		String url = request.getRequestURI();
		String info = request.getPathInfo();
		String getNumber = url.replaceAll(".*?(\\d+)$", "$1");
		System.out.println(("/auth/profile/admin/view/save/"+getNumber).equals(path+info));
		
		if("/auth".equals(path)) {
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			String contextPath = request.getContextPath();
		
			HttpSession session = request.getSession();
			UserRepo userRepo = new UserRepo();
			User users = userRepo.getUser(username, password);
			
			boolean isEmpty = (users == null);
			if(isEmpty) {
				response.sendRedirect(contextPath+"/login");
			}else {
				session.setAttribute("user_data", users);
				response.sendRedirect(contextPath+"/auth/profile");
			}
		}else if("/auth/profile/admin/product/save".equals(path)) {
			String id = request.getParameter("product_id");
			String name = request.getParameter("product_name");
			String type = request.getParameter("product_type");
			String price = request.getParameter("product_price");

			Product product = new Product(id,name,type,Double.parseDouble(price));
			service.addProduct(product);
			response.sendRedirect(request.getContextPath()+"/auth/profile/admin/catalog");
			
		}else if (("/auth/profile/customer/cart").equals(path+info)) {
			System.out.println("executed cart post");
			String customerName = request.getParameter("customer_name");
			String id = request.getParameter("product_id");
			String name = request.getParameter("product_name");
			String type = request.getParameter("product_type");
			String price = request.getParameter("product_price");
			String quantity = request.getParameter("product_quantity");

			UserRepo repo = new UserRepo();
			int userId = repo.getUserId(customerName);
			System.out.println("user id "+ userId);
			System.out.println(id + " " + " "+ type + " " + quantity);
			OrderItemDto item = new OrderItemDto(id,name,type,Double.parseDouble(price),Integer.parseInt(quantity));
			//OrderItem item = new OrderItem(id,name,type,Double.parseDouble(price),Integer.parseInt(quantity));
			OrderDto order = new OrderDto(userId,customerName);
			order.addOrder(item);
			
			HttpSession session = request.getSession();
			session.setAttribute("order_cart", order);
			
			response.sendRedirect(request.getContextPath()+"/auth/profile/customer/cart");
			
		}else if (("/auth/profile/customer/submit").equals(path+info)) {
			System.out.println("executed submit");
			HttpSession session = request.getSession();
			OrderDto order = (OrderDto) session.getAttribute("order_cart");
			User user = (User) session.getAttribute("user_data");
			UserRepo repo = new UserRepo();
			int userId = repo.getUserId(user.getName());
			order.setCustomerId(userId);
			order.setCustomerName(user.getName());
			System.out.println("customer id ,"+ order.getCustomerId());
			int result = service2.submitOrder(order);
			if(result == 1) {
			response.sendRedirect(request.getContextPath()+"/auth/profile/customer/submit");
			}
		}
	}
}

