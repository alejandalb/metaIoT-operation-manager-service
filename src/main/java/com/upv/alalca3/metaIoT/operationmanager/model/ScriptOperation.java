/**
 * 
 */
package com.upv.alalca3.metaIoT.operationmanager.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 */
@Entity
@PrimaryKeyJoinColumn(name = "id")
@Data
@NoArgsConstructor
public class ScriptOperation extends Operation {
    @OneToOne(mappedBy = "operation", optional = false, orphanRemoval = true, cascade = CascadeType.ALL)
    private Script script;
}
