package se.lnu.thesis_mangment.model;

import javax.management.relation.Role;
import javax.persistence.Entity;
import java.util.UUID;

public class User
{

    private Long id;
    private String email;
    private String password;
    private Role role;
    private String name;

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public Role getRole()
    {
        return role;
    }

    public void setRole(Role role)
    {
        this.role = role;
    }

    public void setRole(String role)
    {
        this.role.setRoleName(role);
    }

    public boolean isSignedIn()
    {
        return false;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }
}
