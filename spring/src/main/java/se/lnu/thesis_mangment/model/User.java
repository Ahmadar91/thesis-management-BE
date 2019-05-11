package se.lnu.thesis_mangment.model;

import javax.management.relation.Role;
import javax.persistence.*;

@Entity
@Table(name = "users")
public class User
{
    //  @ManyToOne(fetch = FetchType.LAZY, targetEntity = se.lnu.thesis_mangment.model.Role.class)
    //  @JoinColumn(name = "role_id")
    //   private Role role;
    private long roleId;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    @Column
    private String firstName;


    @Column
    private String email;
    @Column
    private String password;
    private Long deleted;

    public User()
    {

    }


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

    public boolean isSignedIn()
    {
        return false;
    }

    public Long getDeleted()
    {
        return deleted;
    }

    public void setDeleted(Long deleted)
    {
        this.deleted = deleted;
    }

    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }


    public long getRoleId()
    {
        return roleId;
    }

    public void setRoleId(long roleId)
    {
        this.roleId = roleId;
    }
//    public Role getRole()
//    {
//        return role;
//    }
//
//    public void setRole(Role role)
//    {
//        this.role = role;
//    }
//
//    public void setRole(String role)
//    {
//        this.role.setRoleName(role);
//    }
}