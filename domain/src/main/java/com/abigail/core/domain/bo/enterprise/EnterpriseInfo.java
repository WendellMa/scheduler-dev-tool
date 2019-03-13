package com.abigail.core.domain.bo.enterprise;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class EnterpriseInfo {
    private long entId;
    private String entName;
    private String entCode;
}
