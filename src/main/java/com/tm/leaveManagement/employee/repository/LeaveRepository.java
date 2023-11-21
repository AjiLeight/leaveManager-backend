package com.tm.leaveManagement.employee.repository;

import com.tm.leaveManagement.model.Leave;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LeaveRepository extends JpaRepository<Leave, String> {
    Leave getLeaveByEmail(String email);
}
