/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shop;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author son
 */
public class Controller extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            HttpSession session = request.getSession(true);
            Cart mCart = (Cart) (session.getAttribute("cart"));
            if (mCart == null) {
                mCart = new Cart();
            }
            String pro = request.getParameter("cbohang");
            String number = request.getParameter("tfSoluong");
            int quantity = Integer.parseInt(number);
            if (quantity > 0) {
                double price = Pricing(pro);
                Product product = new Product(pro, price, quantity);
                mCart.AddProduct(product);
                session.setAttribute("cart", mCart);
            }
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("EShop");
            requestDispatcher.forward(request, response);
        } finally {
            out.close();
        }
    }

    private double Pricing(String product) {
        switch (product) {
            case "banana":
                return 10000d;
            case "cherry":
                return 15000d;
            case "apple":
                return 20000d;
            case "mango":
                return 14000d;
        }
        return 0;
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
