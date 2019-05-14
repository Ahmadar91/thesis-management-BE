package se.lnu.thesis_mangment.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class LoginInput extends UsersInput
{



    @Size(max = 255)
    private String username;

    @NotNull
    private String password;


    private long roleId;


    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }


    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    @Override
    public long getRoleId()
    {
        return roleId;
    }

    @Override
    public void setRoleId(long roleId)
    {
        this.roleId = roleId;
    }
}
