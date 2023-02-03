package kozlov.cart;

import java.io.IOException;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import kozlov.business.Cart;
import kozlov.business.LineItem;
import kozlov.business.Product;
import kozlov.data.ProductIO;

public class CartServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        ServletContext sc = getServletContext();
        
        String action = request.getParameter("action");
        if (action == null) {
            action = "cart";
        }
        
        String url = "/index.jsp";
        if (action.equals("shop")) {
            url = "/index.jsp";
        } else if (action.equals("cart")) {
            String productCode = request.getParameter("productCode");
            String quantityString = request.getParameter("quantity");
            
            HttpSession session = request.getSession();
            Cart cart = (Cart) session.getAttribute("cart");
            if (cart == null) {
                cart = new Cart();
            }
            
            int quantity;
            try {
                quantity = Integer.parseInt(quantityString);
                if (quantity < 0) {
                    quantity = 1;
                }
            } catch (NumberFormatException ex) {
                quantity = 1;
            }
            
            String path = sc.getRealPath("/WEB-INF/product.txt");
            Product product = ProductIO.getProduct(productCode, path);
            LineItem lineItem = new LineItem();
            lineItem.setProduct(product);
            lineItem.setQuantity(quantity);
            if (quantity > 0) {
                cart.addItem(lineItem);
            } else if (quantity == 0) {
                cart.removeItem(lineItem);
            }
            
            session.setAttribute("cart", cart);
            url = "/cart.jsp";
            
        } else if (action.equals("checkout")) {
            url = "/checkout.jsp";
        }
        
        sc.getRequestDispatcher(url).forward(request, response);
        
    }
}

