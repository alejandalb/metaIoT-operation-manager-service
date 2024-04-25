/**
 * 
 */
package com.upv.alalca3.metaIoT.operationmanager.model.dto;

import java.time.Instant;

import com.upv.alalca3.metaIoT.operationmanager.utils.enums.Frequency;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class OperationSchedulingDataDTO {
    private Instant scheduledDate;
    private Frequency frequency;
    private Integer maxIterations;
}
