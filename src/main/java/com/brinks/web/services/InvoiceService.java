package com.brinks.web.services;


import com.brinks.web.models.InvoiceStatus;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface InvoiceService {

List<InvoiceStatus> getAllInvoiceByStatus(String status, Pageable pageable);

}
