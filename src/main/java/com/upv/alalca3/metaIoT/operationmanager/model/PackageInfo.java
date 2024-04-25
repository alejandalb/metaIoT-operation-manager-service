/**
 * 
 */
package com.upv.alalca3.metaIoT.operationmanager.model;

import jakarta.persistence.Embeddable;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 */
@Embeddable
@Data
@NoArgsConstructor
public class PackageInfo {
    private String name;
    private String version;
}
