package com.tm.leaveManagement.employee.controller;

import com.tm.leaveManagement.employee.exception.NotEnoughLeaveException;
import com.tm.leaveManagement.employee.service.LeaveService;
import com.tm.leaveManagement.model.request.AddLeaveRequest;
import com.tm.leaveManagement.model.response.AddLeaveResponse;
import com.tm.leaveManagement.model.response.GetLeaveResponse;
import com.tm.leaveManagement.model.response.HistoryResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/leave")
@RequiredArgsConstructor
@CrossOrigin
public class LeaveController {
    private final LeaveService leaveService;

    @PostMapping
    public ResponseEntity<AddLeaveResponse> addLeave(@RequestBody AddLeaveRequest addLeaveRequest) throws NotEnoughLeaveException {
        return ResponseEntity.ok(leaveService.addLeave(addLeaveRequest));
    }

    @GetMapping("/{username}")
    public ResponseEntity<GetLeaveResponse> getTotalLeavesByUsername(@PathVariable String username){
        return ResponseEntity.ok(leaveService.getTotalLeavesByUsername(username));
    }

    @GetMapping("/history/{username}")
    public ResponseEntity<List<HistoryResponse>> getLeaveHistory(@PathVariable String username){
        return ResponseEntity.ok(leaveService.getHistoryByUser(username));
    }


}
