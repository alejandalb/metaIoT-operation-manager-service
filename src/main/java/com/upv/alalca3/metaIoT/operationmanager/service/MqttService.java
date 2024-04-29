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
     * @param <D>       operation type
     * @param operation operation data
     */
    <D extends OperationDTO> void publishOperation(D operation);
}
