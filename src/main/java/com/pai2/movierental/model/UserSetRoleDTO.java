package com.pai2.movierental.model;

import com.pai2.movierental.persistence.model.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserSetRoleDTO {
    private String userName;
    private List<Role> roles;
}
