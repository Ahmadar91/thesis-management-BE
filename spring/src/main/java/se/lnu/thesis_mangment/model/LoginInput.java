package se.lnu.thesis_mangment.model;

public class LoginInput
{


    //  @Size(max = 255)
    private String username;

    //   @NotNull
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

    public long getRoleId()
    {
        return roleId;
    }

    public void setRoleId(long roleId)
    {
        this.roleId = roleId;
    }
}
