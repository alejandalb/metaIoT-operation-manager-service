/**
 * 
 */
package com.upv.alalca3.metaIoT.operationmanager.model.dto;

import com.upv.alalca3.metaIoT.operationmanager.utils.enums.DeviceType;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class DeviceDTO {
    private String name;
    private String group;
    private DeviceType deviceType;
}
