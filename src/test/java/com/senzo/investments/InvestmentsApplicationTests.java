package com.senzo.investments;

import com.senzo.investments.enums.ProductEnum;
import com.senzo.investments.model.WithdrawalRequest;
import com.senzo.investments.model.WithdrawalResponse;
import com.senzo.investments.model.entity.InvestorDetails;
import com.senzo.investments.model.entity.InvestorProduct;
import com.senzo.investments.model.entity.Product;
import com.senzo.investments.model.entity.Withdrawal;
import com.senzo.investments.repository.BankDetailsRepo;
import com.senzo.investments.repository.InvestorDetailsRepo;
import com.senzo.investments.service.InvestorProductService;
import com.senzo.investments.service.ProductService;
import com.senzo.investments.service.WithdrawalService;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Senzo
 */
@SpringBootTest
public class InvestmentsApplicationTests {

    private InvestorDetails investorDetails;
    private Withdrawal withdrawal;
    private List<Product> products;
    private List<InvestorProduct> investorProducts;
    private WithdrawalRequest withdrawalRequest;
    @Autowired
    private   InvestorDetailsRepo investorDetailsRepo;
    @Autowired
    private   InvestorProductService investorProductService;
    @Autowired
    private   ProductService productService;
    @Autowired
    BankDetailsRepo bankDetailsRepo;
    @Autowired
    private   WithdrawalService withdrawalService;
    private InvestorDetails dbInvestorDetails;
    private Product dbProduct;
    private Product dbProduct2;
    private InvestorProduct dbInvestorProduct1;
    private InvestorProduct dbInvestorProduct2;

    @BeforeAll
    public static void setUpClass() {

    }

    @AfterAll
    public static void tearDownClass() {

    }

    @BeforeEach
    public void setUp() {

        products = new ArrayList<>();
        investorProducts = new ArrayList<>();
        investorDetails = new InvestorDetails();
        investorDetails.setAddress("90 Dongei Rd, Umbilo, 4000");
        investorDetails.setDob(LocalDate.of(1945,4,25));
        investorDetails.setInvestorName("Sibo");
        investorDetails.setSurname("Khumlo");
        investorDetails.setEmail("sib@dongei.com");
        investorDetails.setContactNumber("0824561235");
        investorDetails.setIdnumber("8705054412");

        Product product1 = new Product();
        product1.setProductId(1);
        product1.setProductName("pension");
        product1.setProductType("RETIREMENT");

        Product product2 = new Product();
        product2.setProductType("SAVINGS");
        product2.setProductName("MzansiSave");
        product2.setProductId(2);

        products.add(product1);
        products.add(product2);

        withdrawalRequest = new WithdrawalRequest();
        withdrawalRequest.setAccountNumber("0077445214");
        withdrawalRequest.setBankName("Absa");
        withdrawalRequest.setAmount(new BigDecimal(5_421.52));
        withdrawalRequest.setEmailAddress(investorDetails.getEmail());
        withdrawalRequest.setIdNumber(investorDetails.getIdnumber());
        withdrawalRequest.setContactNumber(investorDetails.getContactNumber());
        withdrawalRequest.setProductType(ProductEnum.SAVINGS);

        InvestorProduct investorProduct1 = new InvestorProduct();
        investorProduct1.setInvestorDetails(investorDetails);
        investorProduct1.setCurrentbalance(new BigDecimal(1452123.24));
        investorProduct1.setProduct(product1);
        InvestorProduct investorProduct2 = new InvestorProduct();
        investorProduct2.setProduct(product2);
        investorProduct2.setInvestorDetails(investorDetails);
        investorProduct2.setCurrentbalance(new BigDecimal(250_500.50));
        investorProducts.add(investorProduct1);
        investorProducts.add(investorProduct2);
         dbInvestorDetails = investorDetailsRepo.save(investorDetails);
         dbProduct = productService.save(products.get(0));
         dbProduct2 = productService.save(products.get(1));
         investorProduct1.setInvestorDetails(dbInvestorDetails);
         investorProduct1.setProduct(dbProduct);
         investorProduct2.setProduct(dbProduct2);
         investorProduct2.setInvestorDetails(dbInvestorDetails);
         dbInvestorProduct1 = investorProductService.save(investorProducts.get(0));
         dbInvestorProduct2 = investorProductService.save(investorProducts.get(1));
    }

    @AfterEach
    public void tearDown() {
        clear();
    }


    private void clear(){

        withdrawalService.deleteAll();
        bankDetailsRepo.deleteAll();
        investorProductService.deleteAll();
        investorDetailsRepo.deleteAll();
        productService.deleteAll();
    }
    @Test
    public void testRetrieveInvestorProduct(){
        InvestorProduct investorProduct = investorProducts.get(1);
        InvestorProduct byProductId = investorProductService.findByProductId(withdrawalRequest.getProductType().getProduct(), dbInvestorDetails.getInvestorId());
        assert byProductId.getInvestorDetails().getInvestorId()==byProductId.getInvestorDetails().getInvestorId();
    }

    @Test
    public void testProcessWithdrawal() {
        BigDecimal currentBalance = investorProducts.get(1).getCurrentbalance();
        WithdrawalResponse withdrawalResponse = withdrawalService.processWithdrawal(withdrawalRequest);
        BigDecimal amount = withdrawalRequest.getAmount();
        InvestorProduct updatedIP = investorProductService.findByProductId(dbProduct2.getProductId(), dbInvestorDetails.getInvestorId());
        assert updatedIP.getCurrentbalance().doubleValue()==currentBalance.subtract(amount).doubleValue();
        assert withdrawalResponse.getWithdrawal().getClosingBalance().doubleValue()==updatedIP.getCurrentbalance().doubleValue();
    }
}
