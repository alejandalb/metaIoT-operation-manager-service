/**
 * 
 */
package com.upv.alalca3.metaIoT.operationmanager.model;

import com.upv.alalca3.metaIoT.operationmanager.utils.enums.DeviceType;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
    @Enumerated(EnumType.STRING)
    private DeviceType deviceType;
}
