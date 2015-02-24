package camt.se331.shoppingcart.entity;

import camt.se331.shoppingcart.dao.NewProductDao;
import camt.se331.shoppingcart.dao.ProductDao;
import camt.se331.shoppingcart.entity.Product;
import camt.se331.shoppingcart.entity.SelectedProduct;
import camt.se331.shoppingcart.entity.VatEntity;
import camt.se331.shoppingcart.service.ProductService;
import junitparams.JUnitParamsRunner;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import static  junitparams.JUnitParamsRunner.$;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

/**
 * Created by CAMT on 2/24/2015.
 */
@RunWith(JUnitParamsRunner.class)
public class TestProduct {

    ProductDao productService;
    VatEntity vatEntity = new VatEntity();

    @Before
    public  void setUp(){
        productService = new NewProductDao();


    }

    @Test
    public void getProduct(){
        VatEntity.getInstance().setVat(0.07);
        assertThat(productService.getProduct(1l).getNetPrice(),is(929.9999999999999));
        VatEntity.getInstance().setVat(0.07);
        assertThat(productService.getProduct(2l).getNetPrice(),is(1859.9999999999998));
        VatEntity.getInstance().setVat(0.07);
        assertThat(productService.getProduct(3l).getNetPrice(),is(2325.00));
        VatEntity.getInstance().setVat(0.07);
        assertThat(productService.getProduct(4l).getNetPrice(),is(18600.0));
    }


}
