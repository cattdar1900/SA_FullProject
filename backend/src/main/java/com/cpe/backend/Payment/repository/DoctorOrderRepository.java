package com.cpe.backend.Payment.repository;



import com.cpe.backend.Payment.entity.DoctorOrder;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;  
  
@RepositoryRestResource
public interface DoctorOrderRepository extends JpaRepository<DoctorOrder, Long> {
    DoctorOrder findById(long id);
}