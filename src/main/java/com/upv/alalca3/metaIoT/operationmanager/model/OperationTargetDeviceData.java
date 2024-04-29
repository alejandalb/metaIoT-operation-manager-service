/**
 * 
 */
package com.upv.alalca3.metaIoT.operationmanager.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Class to represent the data of a {@link Operation}'s target devices
 */
@Embeddable
@Data
@NoArgsConstructor
public class OperationTargetDeviceData {
    @Column(name = "device_group")
    private String group;
    private String deviceType;
}
