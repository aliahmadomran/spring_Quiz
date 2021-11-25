package com.example.quiz.controllers;


import com.example.quiz.dto.requests.SaleAddRequest;
import com.example.quiz.dto.requests.UpdateSaleRequest;
import com.example.quiz.dto.resposes.GetAllSalesResponse;
import com.example.quiz.models.Sale;
import com.example.quiz.services.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("salesSystem/api/sales")
public class SaleController {

    private final SaleService saleService;

    @Autowired
    public SaleController(SaleService saleService) {
        this.saleService = saleService;
    }

    @GetMapping ("/getAllSales")
    public List<GetAllSalesResponse> getAllSales(){

        return saleService.getAllSales();
    }

    @PostMapping("/addSale")
    public void addNewSale(@RequestBody SaleAddRequest saleAddRequest){

        saleService.addNewSale(saleAddRequest);
    }


    @PutMapping("/updateSale/{saleId}")
    public void updateSale(@PathVariable("saleId") Long saleId, @RequestBody UpdateSaleRequest updateSaleRequest){
        saleService.updateSale(saleId,updateSaleRequest);
    }
}
