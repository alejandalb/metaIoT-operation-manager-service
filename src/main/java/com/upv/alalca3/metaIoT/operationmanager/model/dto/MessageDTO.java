/**
 * 
 */
package com.upv.alalca3.metaIoT.operationmanager.model.dto;

import java.time.Instant;

import com.upv.alalca3.metaIoT.operationmanager.utils.enums.MessageType;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 *
 */
@Data
@NoArgsConstructor
public class MessageDTO {
    private DeviceDTO device;
    private String content;
    private MessageType type;
    private Instant date;
}
