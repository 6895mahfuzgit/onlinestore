package com.onlinestore.controller.admin;

import com.onlinestore.model.Product;
import com.onlinestore.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by MahfuzCSE'11 on 25-Jun-16.
 */

@Controller
@RequestMapping("/admin")
public class AdminProduct {

    private Path path;

    @Autowired

    private ProductService productService;


    @RequestMapping("/product/addProduct")
    public String addProduct(Model model) {


        Product product = new Product();

        product.setProductCategory("instrument");
        product.setProductCondition("new");
        product.setProductStatus("Active");

        model.addAttribute("product", product);

        return "addProduct";
    }


    /**********************
     * Ading product using @ModelAttribute
     *****************************/

    @RequestMapping(value = "/product/addProduct", method = RequestMethod.POST)
    public String addProductActive(@Valid @ModelAttribute("product") Product product, BindingResult result, HttpServletRequest request) {


        if (result.hasErrors()) {

            return "addProduct";
        }

        productService.addProduct(product);


        MultipartFile productImage = product.getProductImage();

        String rootDirectory = request.getSession().getServletContext().getRealPath("/");


        path = Paths.get(rootDirectory + "\\WEB-INF\\resources\\images\\" + product.getProductId() + ".jpg");


        if (productImage != null && !productImage.equals(null)) {


            try {


                productImage.transferTo(new File(path.toString()));

            } catch (Exception ex) {


                ex.printStackTrace();

                throw new RuntimeException("Image is not uploaded??");
            }


        }


        return "redirect:/admin/productInventory";
    }


    @RequestMapping("/product/editProduct/{productId}")
    public String editProduct(@PathVariable int productId, Model model) {

        Product product = productService.getProductById(productId);

        model.addAttribute(product);


        return "editProduct";
    }


    @RequestMapping(value = "/product/editProduct", method = RequestMethod.POST)
    public String editProductActive(@Valid @ModelAttribute("product") Product product, BindingResult result, HttpServletRequest request) {


        if (result.hasErrors()) {

            return "editProduct";
        }


        MultipartFile productImage = product.getProductImage();

        String rootDirectory = request.getSession().getServletContext().getRealPath("/");


        path = Paths.get(rootDirectory + "\\WEB-INF\\resources\\images\\" + product.getProductId() + ".jpg");


        if (productImage != null && !productImage.equals(null)) {


            try {


                productImage.transferTo(new File(path.toString()));

            } catch (Exception ex) {


                ex.printStackTrace();

                throw new RuntimeException("Image is not uploaded??");
            }


        }

        productService.editProduct(product);

        return "redirect:/admin/productInventory";
    }


    @RequestMapping("/product/deleteProduct/{productId}")
    public String deleteProduct(@PathVariable int productId, HttpServletRequest request) {


        String rootDirectory = request.getSession().getServletContext().getRealPath("/");


        path = Paths.get(rootDirectory + "\\WEB-INF\\resources\\images\\" + productId + ".jpg");

        if (Files.exists(path)) {
            try {

                Files.delete(path);

            } catch (IOException ec) {

                ec.printStackTrace();
            }

        }


        Product product = productService.getProductById(productId);
        productService.deleteProduct(product);

        return "redirect:/admin/productInventory";
    }


}
