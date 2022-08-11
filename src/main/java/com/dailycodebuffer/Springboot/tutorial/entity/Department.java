package com.dailycodebuffer.Springboot.tutorial.entity;


import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.*;

@Entity
@Data
//@Getter
//@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message="Please Add Depatment name")
//    @Length(max=5,min=1)
//    @Size(max=10,min=0)
//    @Email
//    @Positive
//    @Negative
//    @FutureOrPresent
//    @PastOrPresent
    private String name;
    private String address;
    private String code;

}
