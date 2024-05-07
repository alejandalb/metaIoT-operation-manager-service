/**
 * 
 */
package com.upv.alalca3.metaIoT.operationmanager.model;

import java.util.List;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 */
@Entity
@PrimaryKeyJoinColumn(name = "id")
@Data
@NoArgsConstructor
public class UpdateOperation extends Operation {
    @ElementCollection
    private List<PackageInfo> packages;
}
