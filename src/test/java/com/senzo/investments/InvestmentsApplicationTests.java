package com.senzo.investments;

import com.senzo.investments.enums.ProductEnum;
import com.senzo.investments.model.entity.InvestorDetails;
import com.senzo.investments.model.entity.InvestorProduct;
import com.senzo.investments.model.entity.Product;
import com.senzo.investments.model.entity.Withdrawal;
import com.senzo.investments.service.InvestorProductService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author user
 */
@SpringBootTest
public class InvestmentsApplicationTests {

    private InvestorDetails investorDetails;
    private InvestorProduct investorProduct;
    private Withdrawal withdrawal;
    private List<Product> products;

    @Autowired
    private InvestorProductService investorProductService;

    @BeforeAll
    public void setUpClass() {
        investorDetails = new InvestorDetails();
        investorDetails.setAddress("90 Dongei Rd, Umbilo, 4000");
        investorDetails.setDob(new Date(1945-1900,4,25));
        investorDetails.setInvestorName("Sibo");
        investorDetails.setSurname("Khumlo");
        investorDetails.setEmail("sib@dongei.com");
        investorDetails.setContactNumber("0824561235");

        Product product1 = new Product();
        product1.setProductName("pension");
        product1.setProductType("RETIREMENT");
        Product product2 = new Product();
        product2.setProductType("S");
    }

    @AfterAll
    public static void tearDownClass() {
    }

    @BeforeEach
    public void setUp() {
    }

    @AfterEach
    public void tearDown() {
    }

     @Test
     public void testRetrieveInvestorProduct() {
         InvestorProduct investorProduct = investorProductService.findByProductId(ProductEnum.RETIREMENT.getProduct(), 1);
         assert (investorProduct==null);
    }
}
