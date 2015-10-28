/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shop;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author son
 */
public class EShop extends HttpServlet {

    private Cart cart = null;

    public EShop() {
        super();
        cart = new Cart();
    }

    public void init(ServletConfig config) throws ServletException {

    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        double pricing = 0d;
        try {
            HttpSession session = request.getSession(true);
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Shopping Cart demo with servlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1 align=\"center\">CHÀO MỪNG ĐẾN VỚI GIAN HÀNG TRÁI CÂY</h1>");
            out.println("<form action=\"Controller\" method=\"post\">");
            out.println("<p>Chọn mặt hàng:<select name=\"cbohang\">");
            out.println("<option>banana</option>"
                    + "<option>mango</option>"
                    + "<option>apple</option>"
                    + "<option>organe</option>"
                    + "<option>cherry</option>");
            out.println("</select>Số lượng<input type=\"text\" name=\"tfSoluong\" value=\"1\">");
            out.println("</p>");
            out.println("<input type=\"submit\" value=\"Mua Hàng\">");

            out.println("<h2 align=\"center\">THÔNG TIN GIỎ HÀNG</h2>");
            out.println("<table width=\"80%\" border=\"1\"><tr>"
                    + "<td>STT</td><td>Tên Sản phẩm</td><td>Số lượng</td>"
                    + "<td>Đơn giá</td><td>Thành tiền</td>"
                    + "</tr>");
            Cart mCart = (Cart) (session.getAttribute("cart"));
            if (mCart != null) {
                pricing = mCart.totalPricing();
                for (int i = 0; i <= mCart.numberProduct() - 1; i++) {
                    Product mProduct = mCart.getProduct(i);
                    out.println("<tr><td>" + i + "</td><td>" + mProduct.getName() + "</td><td>"
                            + mProduct.getQuantity() + "</td><td>" + mProduct.getPrice() + "</td>"
                            + "<td>" + mProduct.getPrice() * mProduct.getQuantity() + "</td>"
                            + "</tr>");
                }
                out.println("");
                out.println("");
            }
            out.println("</table>");
            out.println("<h2>Tổng tiền:" + pricing + " đồng</h2>");
            out.println("");
            out.println("</form>");
            out.println("</body>");
            out.println("</html>");
        } finally {
            out.println("</html>");
            out.close();
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
}
