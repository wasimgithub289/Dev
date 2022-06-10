package com.ng.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ng.spring.entities.Invoice;

public interface InvoiceRepository extends JpaRepository<Invoice, Long> 
{

}