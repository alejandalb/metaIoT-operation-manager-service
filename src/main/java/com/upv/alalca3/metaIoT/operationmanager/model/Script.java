/**
 * 
 */
package com.upv.alalca3.metaIoT.operationmanager.model;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;

/**
 * 
 */
@Entity
public class Script {
	@Id
	private Long id;
	@Lob
	private String data;
	@Embedded
	private ScriptMetadata metadata;
	@OneToOne(optional = false)
	@JoinColumn(name = "id")
	@MapsId(value = "id")
	private ScriptOperation operation;

	/**
	 * Default constructor
	 */
	public Script() {
		super();
	}

}
