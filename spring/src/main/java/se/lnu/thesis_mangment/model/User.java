package se.lnu.thesis_mangment.model;

import javax.persistence.*;

/**
 * The type User.
 */
@Entity
@Table(name = "users")
public class User
{
    private long roleId;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    private String username = "";
    private String firstName = "";
    private String lastName = "";
    private String email = "";
    private String password = "";
    private Long deleted = 0L;
    private Long supervisorId = 0L;

    /**
     * Gets id.
     *
     * @return the id
     */
    public Long getId()
    {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(Long id)
    {
        this.id = id;
    }

    /**
     * Gets email.
     *
     * @return the email
     */
    public String getEmail()
    {
        return email;
    }

    /**
     * Sets email.
     *
     * @param email the email
     */
    public void setEmail(String email)
    {
        this.email = email;
    }

    /**
     * Gets password.
     *
     * @return the password
     */
    public String getPassword()
    {
        return password;
    }

    /**
     * Sets password.
     *
     * @param password the password
     */
    public void setPassword(String password)
    {
        this.password = password;
    }


    /**
     * Gets last name.
     *
     * @return the last name
     */
    public String getLastName()
    {
        return lastName;
    }

    /**
     * Sets last name.
     *
     * @param lastName the last name
     */
    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    /**
     * Gets deleted.
     *
     * @return the deleted
     */
    public Long getDeleted()
    {
        return deleted;
    }

    /**
     * Sets deleted.
     *
     * @param deleted the deleted
     */
    public void setDeleted(Long deleted)
    {
        this.deleted = deleted;
    }

    /**
     * Gets username.
     *
     * @return the username
     */
    public String getUsername()
    {
        return username;
    }

    /**
     * Sets username.
     *
     * @param username the username
     */
    public void setUsername(String username)
    {
        this.username = username;
    }

    /**
     * Gets first name.
     *
     * @return the first name
     */
    public String getFirstName()
    {
        return firstName;
    }

    /**
     * Sets first name.
     *
     * @param firstName the first name
     */
    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }


    /**
     * Gets role id.
     *
     * @return the role id
     */
    public long getRoleId()
    {
        return roleId;
    }

    /**
     * Sets role id.
     *
     * @param roleId the role id
     */
    public void setRoleId(long roleId)
    {
        this.roleId = roleId;
    }

    /**
     * Gets supervisor id.
     *
     * @return the supervisor id
     */
    public Long getSupervisorId()
    {
        return supervisorId;
    }

    /**
     * Sets supervisor id.
     *
     * @param supervisorId the supervisor id
     */
    public void setSupervisorId(Long supervisorId)
    {
        this.supervisorId = supervisorId;
    }
}