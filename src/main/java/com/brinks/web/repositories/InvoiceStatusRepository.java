package com.brinks.web.repositories;


import com.brinks.web.models.InvoiceStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InvoiceStatusRepository extends PagingAndSortingRepository<InvoiceStatus,Integer> {

 List<InvoiceStatus> findByStatus(String status);

 Page<InvoiceStatus> findByStatus(String status, Pageable pageable);


 @Query(value="select * from invoice_status where invoice_name =:invoiceName ORDER BY ?#{#pageable}",
         countQuery = "select count(*) from invoice_status where invoice_name =:invoiceName",nativeQuery=true)
 Page<InvoiceStatus> findByInvoiceName(@Param("invoiceName")String invoiceName, Pageable pageable);




}
