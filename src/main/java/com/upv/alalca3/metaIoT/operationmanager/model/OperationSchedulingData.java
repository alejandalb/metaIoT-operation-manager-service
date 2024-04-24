/**
 * 
 */
package com.upv.alalca3.metaIoT.operationmanager.model;

import java.time.Instant;

import com.upv.alalca3.metaIoT.operationmanager.utils.types.Frequency;

import jakarta.persistence.Embeddable;

/**
 * 
 */
@Embeddable
public class OperationSchedulingData {
	private Instant scheduledDate;
	private Frequency frequency;

	/**
	 * Default constructor
	 */
	public OperationSchedulingData() {
		super();
	}

	/**
	 * @return the scheduledDate
	 */
	public Instant getScheduledDate() {
		return this.scheduledDate;
	}

	/**
	 * @param scheduledDate the scheduledDate to set
	 */
	public void setScheduledDate(Instant scheduledDate) {
		this.scheduledDate = scheduledDate;
	}

	/**
	 * @return the frequency
	 */
	public Frequency getFrequency() {
		return this.frequency;
	}

	/**
	 * @param frequency the frequency to set
	 */
	public void setFrequency(Frequency frequency) {
		this.frequency = frequency;
	}

}
