package com.tm.leaveManagement.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "leave_history")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LeaveHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    private Date startDate;
    private Date endDate;
    private Boolean full;
    private String type;
}
