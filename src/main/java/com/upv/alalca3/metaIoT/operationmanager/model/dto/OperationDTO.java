/**
 * 
 */
package com.upv.alalca3.metaIoT.operationmanager.model.dto;

import java.time.Instant;
import java.util.List;

import com.upv.alalca3.metaIoT.operationmanager.model.Message;
import com.upv.alalca3.metaIoT.operationmanager.model.OperationSchedule;
import com.upv.alalca3.metaIoT.operationmanager.model.OperationSchedulingData;
import com.upv.alalca3.metaIoT.operationmanager.model.OperationTargetDeviceData;
import com.upv.alalca3.metaIoT.operationmanager.utils.enums.OperationStatus;
import com.upv.alalca3.metaIoT.operationmanager.utils.enums.OperationType;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * DTO for {@link Operation}
 */
@Data
@NoArgsConstructor
public abstract class OperationDTO {
    private Long id;
    private OperationType type;
    private OperationStatus status;
    private OperationTargetDeviceData targetDevice;
    private OperationSchedulingData schedulingData;
    private List<Message> messages;
    private OperationSchedule schedule;
    private Instant creationDate;
    private Instant modificationDate;
}
