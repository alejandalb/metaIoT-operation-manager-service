/**
 * 
 */
package com.upv.alalca3.metaIoT.operationmanager.model;

import java.time.Instant;

import com.upv.alalca3.metaIoT.operationmanager.utils.enums.Frequency;

import jakarta.persistence.Embeddable;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 */
@Embeddable
@Data
@NoArgsConstructor
public class OperationSchedulingData {
    private Instant scheduledDate;
    private Frequency frequency;
    private Integer maxIterations;
}
