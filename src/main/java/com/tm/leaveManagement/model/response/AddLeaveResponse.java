package com.tm.leaveManagement.model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AddLeaveResponse {
    public Date startDate;
    public Date endDate;
    public float totalLeaves;
}
