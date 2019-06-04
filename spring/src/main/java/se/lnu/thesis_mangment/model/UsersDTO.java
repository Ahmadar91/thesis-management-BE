package se.lnu.thesis_mangment.model;

import javax.validation.constraints.Size;

/**
 * The type Users dto.
 */
public class UsersDTO
{
    private long id;

    @Size(max = 255)
    private String filterValue;
    // student as default
    private long roleId;

    private Long supervisorId;

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


    private long deleted;

    private String password;


    @Size(max = 255)
    private String firstName;


    @Size(max = 255)
    private String lastName;
    @Size(max = 255)
    private String username;


    @Size(max = 255)
    private String email;

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
     * Gets filter value.
     *
     * @return the filter value
     */
    public String getFilterValue()
    {
        return filterValue;
    }

    /**
     * Sets filter value.
     *
     * @param filterValue the filter value
     */
    public void setFilterValue(String filterValue)
    {
        this.filterValue = filterValue;
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
     * Gets id.
     *
     * @return the id
     */
    public long getId()
    {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(long id)
    {
        this.id = id;
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
     * Validate password boolean.
     *
     * @return the boolean
     */
    public boolean validatePassword()
    {
        return password != null;
    }

    /**
     * Gets deleted.
     *
     * @return the deleted
     */
    public long getDeleted()
    {
        return deleted;
    }

    /**
     * Sets deleted.
     *
     * @param deleted the deleted
     */
    public void setDeleted(long deleted)
    {
        this.deleted = deleted;
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
}
