/**
 * 
 */
package com.upv.alalca3.metaIoT.operationmanager.model.dto;

import com.upv.alalca3.metaIoT.operationmanager.utils.enums.DeviceType;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Class to represent the data of a {@link OperationDTO}'s target devices
 */
@Data
@NoArgsConstructor
public class OperationTargetDeviceDataDTO {
    private String group;
    private DeviceType deviceType;
}
