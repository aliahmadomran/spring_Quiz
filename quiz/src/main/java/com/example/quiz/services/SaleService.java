package com.example.quiz.services;
import com.example.quiz.dto.requests.SaleAddRequest;
import com.example.quiz.dto.requests.UpdateSaleRequest;
import com.example.quiz.dto.resposes.GetAllSalesResponse;
import com.example.quiz.helper.ProductQuantity;
import com.example.quiz.models.Bill;
import com.example.quiz.models.Client;
import com.example.quiz.models.Product;
import com.example.quiz.models.Sale;
import com.example.quiz.repository.BillRepo;
import com.example.quiz.repository.ClientRepo;
import com.example.quiz.repository.ProductRepo;
import com.example.quiz.repository.SaleRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class SaleService {
    Logger logger = LoggerFactory.getLogger(SaleService.class);
    private final ClientRepo clientRepo;
    private final ProductRepo productRepo;
    private final  SaleRepo saleRepo;

    @Autowired
    public SaleService(ClientRepo clientRepo, ProductRepo productRepo, SaleRepo saleRepo) {
        this.clientRepo = clientRepo;
        this.productRepo = productRepo;
        this.saleRepo = saleRepo;
    }

    public List<GetAllSalesResponse> getAllSales(){

        List<Sale> sales =   saleRepo.findAll();
        List<GetAllSalesResponse> response = new ArrayList<GetAllSalesResponse>();
        for( Sale sale : sales){
            GetAllSalesResponse  saleResponse = new  GetAllSalesResponse();
            saleResponse.setSaleId(sale.getSaleId());
            saleResponse.setClient(sale.getClient());
            saleResponse.setTotal(sale.getTotal());
            saleResponse.setSellerName(sale.getSellerName());
            saleResponse.setSaleCreationDate(sale.getSaleCreationDate());
            response.add(saleResponse);
        }
        return response;
    }

    Double findTotal(List<Double> price,List<Double> quantity){
        logger.info("Calculate total price");
        double total = 0.0;
        for (int index = 0 ; index < price.size(); index++){
                total += price.get(index)*quantity.get(index);
    }
       return total;
    }
    public void addNewSale(SaleAddRequest saleAddRequest) {
        try{
            logger.info("try to add new Sale");
        List<ProductQuantity> productQuantities =  saleAddRequest.getProductQuantity();
        List<Double> prices = new ArrayList<>() ;
        List<Double> quantity = new ArrayList<>() ;
        List<Bill> bills = new ArrayList<>() ;
        for( ProductQuantity obj : productQuantities){
            prices.add(obj.getPrice());
            quantity.add(obj.getQuantity());
            Bill bill = new Bill();
            bill.setPrice(obj.getPrice());
            bill.setQuantity(obj.getQuantity());
            bill.setProduct(productRepo.getById(obj.getpId()));
            bills.add(bill);
        }
        Sale sale = new Sale();
        sale.setSellerName(saleAddRequest.getSellerName());
        Client client = clientRepo.getById(saleAddRequest.getClientId());
        sale.setClient(client);
        sale.setSaleCreationDate(LocalDateTime.now());
        sale.setBill(bills);
        sale.setTotal(findTotal(prices,quantity));
        saleRepo.save(sale);
        logger.info("Sale add successfully");}catch (Exception e){
            logger.error("Fail to add Sale ..",e);
        }

    }

    @Transactional
    public void updateSale(Long sId , UpdateSaleRequest productQuantities){
        try{
            logger.info("try to update Sale with sale id : "+sId);
        Sale sale = saleRepo.findById(sId)
                .orElseThrow(()->new IllegalStateException(
                        "sale with id :"+sId+" does not exist"));
        List<Double> prices = new ArrayList<>();
        List<Double> quantity = new ArrayList<>();
        for(ProductQuantity productQuantity :productQuantities.getProductQuantity()) {

            List<Bill> bills = sale.getBill();
            for (Bill bill : bills) {
                Product product = bill.getProduct();
                if (product.getProductId().equals(productQuantity.getpId())) {
                    bill.setQuantity(productQuantity.getQuantity());
                    bill.setPrice(productQuantity.getPrice());
                }
            }
            prices.add(productQuantity.getPrice());
            quantity.add(productQuantity.getQuantity());
        }
        sale.setTotal(findTotal(prices, quantity));
        logger.info("Sale updated successfully ");
        }catch (Exception e){
            logger.error("Failed to update Sale with id "+sId+"..",e);
        }
    }


}
