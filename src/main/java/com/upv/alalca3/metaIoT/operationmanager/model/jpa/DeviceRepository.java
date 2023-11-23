/**
 * 
 */
package com.upv.alalca3.metaIoT.operationmanager.model.jpa;

import org.springframework.data.repository.CrudRepository;

import com.upv.alalca3.metaIoT.operationmanager.model.Device;

/**
 * 
 */
public interface DeviceRepository extends CrudRepository<Device, Long> {
}
