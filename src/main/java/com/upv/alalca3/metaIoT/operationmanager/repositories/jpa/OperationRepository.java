/**
 * 
 */
package com.upv.alalca3.metaIoT.operationmanager.repositories.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.upv.alalca3.metaIoT.operationmanager.model.Operation;

/**
 * 
 */
public interface OperationRepository extends CrudRepository<Operation, Long> {
    @Query("SELECT o FROM Operation o WHERE o.schedule IS NOT NULL")
    List<Operation> findScheduledOperations();
}
