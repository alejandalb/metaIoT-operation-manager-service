package com.upv.alalca3.metaIoT.operationmanager.model.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonTypeName;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@JsonTypeName("UPDATE")
public class UpdateOperationDTO extends OperationDTO {
    private List<PackageInfoDTO> packages;
}
