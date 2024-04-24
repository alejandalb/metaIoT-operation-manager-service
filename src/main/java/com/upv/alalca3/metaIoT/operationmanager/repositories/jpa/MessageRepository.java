/**
 * 
 */
package com.upv.alalca3.metaIoT.operationmanager.repositories.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.upv.alalca3.metaIoT.operationmanager.model.Message;

public interface MessageRepository extends JpaRepository<Message, Long> {
	@Query("SELECT m FROM Message m WHERE m.operation.id = :operationId AND m.type = :type")
	List<Message> findByOperationIdAndType(@Param("operationId") Long operationId, @Param("type") String type);
}
