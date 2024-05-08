/**
 * 
 */
package com.upv.alalca3.metaIoT.operationmanager.model;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.upv.alalca3.metaIoT.operationmanager.utils.enums.OperationStatus;
import com.upv.alalca3.metaIoT.operationmanager.utils.enums.OperationType;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Base class for all operations
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@EntityListeners(AuditingEntityListener.class)
@Data
@NoArgsConstructor
public class Operation {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "operation_seq")
    @SequenceGenerator(name = "operation_seq", sequenceName = "operation_seq", allocationSize = 50)
    private Long id;

    @Enumerated(EnumType.STRING)
    private OperationType type;

    @Enumerated(EnumType.ORDINAL)
    private OperationStatus status;
    @Embedded
    private OperationTargetDeviceData targetDevice;
    @Embedded
    private OperationSchedulingData schedulingData;

    @OneToMany(mappedBy = "operation", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Message> messages;
    @OneToOne(mappedBy = "operation", optional = true, orphanRemoval = true, cascade = CascadeType.ALL)
    private OperationSchedule schedule;

    // Auditing attributes
    @CreatedDate
    private Instant creationDate;
    @LastModifiedDate
    private Instant modificationDate;

    public void addMessage(Message message) {
	if (this.messages == null) {
	    this.messages = new ArrayList<>();
	}
	this.messages.add(message);
    }
}
