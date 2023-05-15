package com.brinks.web.services.impl;



import com.brinks.web.models.InvoiceStatus;
import com.brinks.web.repositories.InvoiceStatusRepository;
import com.brinks.web.services.InvoiceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;


@Service("InvoiceService")
public class InvoiceServiceImpl implements InvoiceService {

    @Autowired
    InvoiceStatusRepository invoiceStatusRepository;

    @Override
    public List<InvoiceStatus> getAllInvoiceByStatus(String status, Pageable pageable) {
        return invoiceStatusRepository.findByStatus(status,pageable).getContent();
    }
}
