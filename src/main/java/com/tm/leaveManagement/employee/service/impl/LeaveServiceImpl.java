package com.tm.leaveManagement.employee.service.impl;

import com.tm.leaveManagement.constants.ApplicationConstants;
import com.tm.leaveManagement.employee.exception.NotEnoughLeaveException;
import com.tm.leaveManagement.employee.repository.LeaveHistoryRepository;
import com.tm.leaveManagement.employee.repository.LeaveRepository;
import com.tm.leaveManagement.employee.service.LeaveService;
import com.tm.leaveManagement.model.Leave;
import com.tm.leaveManagement.model.LeaveHistory;
import com.tm.leaveManagement.model.request.AddLeaveRequest;
import com.tm.leaveManagement.model.response.AddLeaveResponse;
import com.tm.leaveManagement.model.response.GetLeaveResponse;
import com.tm.leaveManagement.model.response.HistoryResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class LeaveServiceImpl implements LeaveService {
    private final LeaveRepository leaveRepository;
    private final LeaveHistoryRepository leaveHistoryRepository;
    @Override
    public AddLeaveResponse addLeave(AddLeaveRequest request) throws NotEnoughLeaveException {
        String user = request.getEmail();
        updateLeaveData(user,request.getTotalLeave(),request.getLeaveType());
        LeaveHistory leaveHistory = updateLeaveHistory(user,request);
        return AddLeaveResponse.builder()
                .startDate(leaveHistory.getStartDate())
                .endDate(leaveHistory.getEndDate())
                .totalLeaves(request.getTotalLeave())
                .build();
    }

    @Override
    public GetLeaveResponse getTotalLeavesByUsername(String username) {
        Leave leave = leaveRepository.getLeaveByEmail(username);
        return GetLeaveResponse.builder()
                .medical(leave.getMedical())
                .casual(leave.getCasual())
                .build();
    }

    @Override
    public List<HistoryResponse> getHistoryByUser(String username) {
        List<LeaveHistory> leaveHistories = leaveHistoryRepository.findLeaveHistoriesByEmail(username);
        List<HistoryResponse> historyResponses = new ArrayList<>();
        for(LeaveHistory leaveHistory : leaveHistories){
            HistoryResponse historyResponse = HistoryResponse.builder()
                    .end(leaveHistory.getEndDate())
                    .start(leaveHistory.getStartDate())
                    .type(leaveHistory.getType())
                    .full(leaveHistory.getFull())
                    .build();
            historyResponses.add(historyResponse);
        }
        return historyResponses;
    }

    private void updateLeaveData(String user, float totalLeaves, String type) throws NotEnoughLeaveException {
        Leave leave = leaveRepository.getLeaveByEmail(user);
        if(Objects.equals(type, ApplicationConstants.TYPE_CASUAL)){
            if(leave.getCasual()< totalLeaves){
                throw new NotEnoughLeaveException("not enough leaves");
            }
            leave.setCasual(leave.getCasual()-totalLeaves);
            leaveRepository.save(leave);
        }else if(Objects.equals(type, ApplicationConstants.TYPE_MEDICAL)){
            if(leave.getMedical()< totalLeaves){
                throw new NotEnoughLeaveException("not enough leaves");
            }
            leave.setMedical(leave.getMedical()-totalLeaves);
            leaveRepository.save(leave);
        }else {
            throw new InvalidParameterException("invalid parameter for leave type");
        }
    }

    private LeaveHistory updateLeaveHistory(String user, AddLeaveRequest request){
        LeaveHistory leaveHistory = LeaveHistory.builder()
                .email(user)
                .startDate(request.getStartDate())
                .endDate(request.getEndDate())
                .full(request.getIsFull())
                .type(request.leaveType)
                .build();
        return leaveHistoryRepository.save(leaveHistory);
    }
}
