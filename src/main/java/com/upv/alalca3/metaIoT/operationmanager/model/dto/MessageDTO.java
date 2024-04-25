/**
 * 
 */
package com.upv.alalca3.metaIoT.operationmanager.model.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 *
 */
@Data
@NoArgsConstructor
public class MessageDTO {
    private Long id;

    private DeviceDTO device;

    private String content;
    private String type;
}
