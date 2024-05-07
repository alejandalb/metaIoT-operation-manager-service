/**
 * 
 */
package com.upv.alalca3.metaIoT.operationmanager.model;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
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
    @Embedded
    private Script script;
}
