/**
 * 
 */
package com.upv.alalca3.metaIoT.operationmanager.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 */
@Entity
@Data
@NoArgsConstructor
public class OperationSchedule {
    @Id
    private Long id;
    @OneToOne(optional = false)
    @JoinColumn(name = "id")
    @MapsId(value = "id")
    private Operation operation;
    private String cronExpression;
    private Integer iterations;

    /**
     * Constructor with essential fields
     * 
     * @param operation      operation that is scheduled
     * @param cronExpression schedule details expression
     */
    public OperationSchedule(Operation operation, String cronExpression) {
	super();
	this.operation = operation;
	this.cronExpression = cronExpression;
	this.iterations = 0;
    }

}
