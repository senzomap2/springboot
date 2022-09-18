//package com.senzo.investments;
//
//import com.senzo.investments.enums.ProductEnum;
//import com.senzo.investments.model.WithdrawalRequest;
//import com.senzo.investments.model.WithdrawalResponse;
//import com.senzo.investments.model.entity.InvestorDetails;
//import com.senzo.investments.model.entity.InvestorProduct;
//import com.senzo.investments.model.entity.Product;
//import com.senzo.investments.model.entity.Withdrawal;
//import com.senzo.investments.service.InvestorProductService;
//import com.senzo.investments.service.InvestorService;
//import com.senzo.investments.service.ProductService;
//import com.senzo.investments.service.WithdrawalService;
//import org.junit.Test;
//import org.junit.jupiter.api.AfterAll;
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.BeforeAll;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import java.math.BigDecimal;
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;
//@RunWith(SpringRunner.class)
//@SpringBootTest
//public class WithdrawalTests {
//    private InvestorDetails investorDetails;
//
//    private Withdrawal withdrawal;
//    private List<Product> products;
//    private List<InvestorProduct> investorProducts;
//    @Autowired
//    private WithdrawalService withdrawalService;
//    @Autowired
//    InvestorService investorService;
//    @Autowired
//    InvestorProductService investorProductService;
//    @Autowired
//    ProductService productService;
//    private WithdrawalRequest withdrawalRequest;
//
//
//    @BeforeAll
//    public static void setUpClass() {
//
//    }
//
//    @AfterAll
//    public static void tearDownClass() {
//    }
//    @BeforeEach
//    public void setUp() {
//        products = new ArrayList<>();
//        investorProducts=new ArrayList<>();
//        investorDetails = new InvestorDetails();
//        investorDetails.setAddress("90 Dongei Rd, Umbilo, 4000");
//        investorDetails.setDob(new Date(1945-1900,4,25));
//        investorDetails.setInvestorName("Sibo");
//        investorDetails.setSurname("Khumlo");
//        investorDetails.setEmail("sib@dongei.com");
//        investorDetails.setContactNumber("0824561235");
//        investorDetails.setIdnumber("8705054412");
//
//        Product product1 = new Product();
//        product1.setProductId(1);
//        product1.setProductName("pension");
//        product1.setProductType("RETIREMENT");
//        Product product2 = new Product();
//        product2.setProductId(2);
//        product2.setProductType("SAVINGS");
//        product2.setProductName("MzansiSave");
//        products.add(product1);
//        products.add(product2);
//        withdrawalRequest = new WithdrawalRequest();
//        withdrawalRequest.setAccountNumber("0077445214");
//        withdrawalRequest.setBankName("Absa");
//        withdrawalRequest.setAmount(new BigDecimal(245_785_421.52));
//        withdrawalRequest.setEmailAddress(investorDetails.getEmail());
//        withdrawalRequest.setIdNumber(investorDetails.getIdnumber());
//        withdrawalRequest.setContactNumber(investorDetails.getContactNumber());
//        withdrawalRequest.setProductType("SAVINGS");
//        InvestorProduct investorProduct1 = new InvestorProduct();
//        investorProduct1.setInvestorDetails(investorDetails);
//        investorProduct1.setCurrentbalance(new BigDecimal(1452024552123.24));
//        investorProduct1.setProduct(product1);
//        InvestorProduct investorProduct2 = new InvestorProduct();
//        investorProduct2.setProduct(product2);
//        investorProduct2.setInvestorDetails(investorDetails);
//        investorProduct2.setCurrentbalance(new BigDecimal(250_500.50));
//        investorProducts.add(investorProduct1);
//        investorProducts.add(investorProduct2);
//
//        investorService.save(investorDetails);
//        productService.save(products.get(0));
//        productService.save(products.get(1));
//        investorProductService.save(investorProducts.get(0));
//        investorProductService.save(investorProducts.get(1));
//    }
//    @AfterEach
//    public void tearDown() {
//    }
//
//    @Test
//    public void testProcessWithdrawal() {
//        setUp();
//        WithdrawalResponse withdrawalResponse = withdrawalService.processWithdrawal(withdrawalRequest);
//        System.out.println(withdrawalResponse);
//    }
//
//    @Test
//    public void testEnum(){
//        setUp();
//        System.out.println(investorDetails.getInvestorId());
//        ProductEnum productEnum = ProductEnum.valueOf(withdrawalRequest.getProductType());
//        System.out.println(productEnum+" : "+productEnum.getProduct());
//
//    }
//
//    @Test
//    public void testSaveInvestorProduct(){
//        setUp();
//        InvestorProduct investorProduct = investorProductService.findByProductId(ProductEnum.SAVINGS.getProduct(),
//                investorDetails.getInvestorId());
//
//        System.out.println(investorProducts.get(1).getProduct().getProductType());
//    }
//}