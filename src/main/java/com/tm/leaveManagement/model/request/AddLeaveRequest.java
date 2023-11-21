package com.tm.leaveManagement.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddLeaveRequest {
    public String email;
    public Date startDate;
    public Date endDate;
    public float totalLeave;
    public String leaveType;
    public Boolean isFull;
}
