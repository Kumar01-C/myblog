package com.redbus.Operator.Payloads;

import lombok.*;

import java.util.List;

@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PageResponse {

    private List<BusOperatorDto> dto;
    private int pageNo;
    private int pageSize;
    private int totalPages;
    private Boolean lastpage;
}
