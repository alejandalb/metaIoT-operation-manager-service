/**
 * 
 */
package com.upv.alalca3.metaIoT.operationmanager.model;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Embedded;
import jakarta.persistence.Lob;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 */
@Embeddable
@Data
@NoArgsConstructor
public class Script {
    @Lob
    private String data;
    @Embedded
    private ScriptMetadata metadata;
}
