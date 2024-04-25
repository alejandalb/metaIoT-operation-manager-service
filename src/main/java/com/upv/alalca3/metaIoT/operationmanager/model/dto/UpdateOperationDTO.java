package com.upv.alalca3.metaIoT.operationmanager.model.dto;

import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UpdateOperationDTO extends OperationDTO {
    private List<PackageInfoDTO> packages;
}
