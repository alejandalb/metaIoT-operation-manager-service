/**
 * 
 */
package com.upv.alalca3.metaIoT.operationmanager.model;

import jakarta.persistence.Embeddable;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Embeddable class that contains the {@link Script} metadata
 */
@Embeddable
@Data
@NoArgsConstructor
public class ScriptMetadata {
    // The name of the script
    private String name;
    // The version of the script
    private String version;
    // The author of the script
    private String author;
    // The type of the script (e.g., "update", "configuration", "diagnostic")
    private String scriptType;
    // The intended device type for the script (e.g., "sensor", "actuator")
    private String deviceType;
    // The minimum firmware version required to run the script
    private String minFirmwareVersion;
    // The maximum firmware version that can run the script
    private String maxFirmwareVersion;
    // The programming language of the script
    private String language;

}
