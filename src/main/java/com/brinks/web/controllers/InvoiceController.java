package com.brinks.web.controllers;

import com.brinks.web.models.InvoiceStatus;
import com.brinks.web.services.InvoiceService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class InvoiceController {

    @Autowired
    InvoiceService invoiceService;

    @ApiOperation(value="This API is used to get all invoice by provided status")
    @GetMapping("/getAllInvoiceByStatus/{status}")
    @ResponseBody public List<InvoiceStatus> index(@PathVariable("status") String status, @RequestParam("page") int page,@RequestParam("size")int size) {
        Pageable pageable = PageRequest.of(page,size);
              return invoiceService.getAllInvoiceByStatus(status,pageable);
    }

}
