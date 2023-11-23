/**
 * 
 */
package com.upv.alalca3.metaIoT.operationmanager.model.jpa;

import org.springframework.data.repository.CrudRepository;

import com.upv.alalca3.metaIoT.operationmanager.model.Message;

public interface MessageRepository extends CrudRepository<Message, Long> {
}
