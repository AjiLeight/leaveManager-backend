package com.tm.leaveManagement.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "user")
@NoArgsConstructor
@Data
public class User {
    private String empId;
    @Id
    private String email;
    private String password;
    private String name;

}
