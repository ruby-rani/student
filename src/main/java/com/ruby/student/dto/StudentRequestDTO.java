package com.ruby.student.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class StudentRequestDTO {
    @NotBlank(message = "name is required")
    @Size(min = 2, max=20 , message ="neme should be more than 2 and less than 20 chars")
    private String name;

    @Email(message = "email is not in formate")
    @NotBlank(message = "email formate is required")
    private String email;
    private Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
