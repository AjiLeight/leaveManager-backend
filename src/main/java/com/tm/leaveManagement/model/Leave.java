package com.tm.leaveManagement.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "t_leave")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Leave {
    @Id
    private String email;
    private float casual;
    private float medical;
}
