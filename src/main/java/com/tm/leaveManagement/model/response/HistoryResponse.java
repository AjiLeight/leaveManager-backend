package com.tm.leaveManagement.model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class HistoryResponse {
    private Date start;
    private Date end;
    private Boolean full;
    private String type;
}
