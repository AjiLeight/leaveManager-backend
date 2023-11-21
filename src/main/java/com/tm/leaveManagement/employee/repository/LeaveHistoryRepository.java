package com.tm.leaveManagement.employee.repository;

import com.tm.leaveManagement.model.LeaveHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LeaveHistoryRepository extends JpaRepository<LeaveHistory, String> {
    LeaveHistory getLeaveHistoriesByEmail(String email);
    List<LeaveHistory> findLeaveHistoriesByEmail(String email);
}
