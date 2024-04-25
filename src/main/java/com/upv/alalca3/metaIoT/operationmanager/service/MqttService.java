/**
 * 
 */
package com.upv.alalca3.metaIoT.operationmanager.service;

import com.upv.alalca3.metaIoT.operationmanager.model.dto.OperationDTO;

/**
 * 
 */
public interface MqttService {

	/**
	 * Publishes a Mqtt message that contains a {@link OperationDTO}
	 * 
	 * @param <E>       operation type
	 * @param operation operation data
	 */
	<E extends OperationDTO> void publishOperation(E operation);
}
