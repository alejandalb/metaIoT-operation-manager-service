/**
 * 
 */
package com.upv.alalca3.metaIoT.operationmanager.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author amna
 *
 */
@Embeddable
@Data
@NoArgsConstructor
public class Device {
    private String name;
    @Column(name = "device_group")
    private String group;
    private String deviceType;
}
