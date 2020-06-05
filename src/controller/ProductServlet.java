package controller;

import model.Product;
import service.ProductService;
import service.impl.ProductServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ProductServlet",urlPatterns = "/product")
public class ProductServlet extends HttpServlet {
    private ProductService productService = new ProductServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if(action==null) action="";
        switch (action){
            case "create":
                break;
            case "edit":
                break;
            case "delete":
                break;
            case "view":
                break;
            default:
                break;
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if(action==null) action="";
        switch (action){
            case "create":
                break;
            case "edit":
                break;
            case "delete":
                delete(request,response);
                break;
            case "view":
                break;
            default:
                listProduct(request,response);
                break;
        }
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        Product product = productService.findByID(id);
        RequestDispatcher dispatcher;
        if(product==null){
            dispatcher = request.getRequestDispatcher("error.jsp");
        }else{
            productService.remove(id);
            listProduct(request,response);
        }
    }

    private void listProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Product> products = this.productService.findAll();
        request.setAttribute("products",products);
        RequestDispatcher dispatcher = request.getRequestDispatcher("product/product.jsp");
        dispatcher.forward(request,response);
    }
}
