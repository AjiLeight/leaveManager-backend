package com.tm.leaveManagement.employee.service;

import com.tm.leaveManagement.employee.exception.NotEnoughLeaveException;
import com.tm.leaveManagement.model.request.AddLeaveRequest;
import com.tm.leaveManagement.model.response.AddLeaveResponse;
import com.tm.leaveManagement.model.response.GetLeaveResponse;
import com.tm.leaveManagement.model.response.HistoryResponse;
import org.springframework.stereotype.Service;

import java.util.List;

public interface LeaveService {
    AddLeaveResponse addLeave(AddLeaveRequest request) throws NotEnoughLeaveException;

    GetLeaveResponse getTotalLeavesByUsername(String username);

    List<HistoryResponse> getHistoryByUser(String username);
}
