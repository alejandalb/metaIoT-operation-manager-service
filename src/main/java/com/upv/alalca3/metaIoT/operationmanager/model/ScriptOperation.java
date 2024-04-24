/**
 * 
 */
package com.upv.alalca3.metaIoT.operationmanager.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;

/**
 * 
 */
@Entity
@PrimaryKeyJoinColumn(name = "id")
@DiscriminatorValue(value = "SCRIPT")
public class ScriptOperation extends Operation {
	@OneToOne(mappedBy = "mission", optional = false, orphanRemoval = true, cascade = CascadeType.ALL)
	private Script script;
}
