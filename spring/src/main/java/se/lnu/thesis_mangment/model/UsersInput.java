package se.lnu.thesis_mangment.model;

import javax.validation.constraints.Size;

public class UsersInput
{

    @Size(max = 255)
    private String filterValue;

    private long roleId;

    private long id;

    @Size(max = 255)
    private String firstName;

    @Size(max = 255)
    private String username;


    @Size(max = 255)
    private String email;

    public String getFirstName()
    {
        return firstName;
    }

    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }


    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getFilterValue()
    {
        return filterValue;
    }

    public void setFilterValue(String filterValue)
    {
        this.filterValue = filterValue;
    }


    public long getRoleId()
    {
        return roleId;
    }

    public void setRoleId(long roleId)
    {
        this.roleId = roleId;
    }

    public long getId()
    {
        return id;
    }

    public void setId(long id)
    {
        this.id = id;
    }

    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }


}