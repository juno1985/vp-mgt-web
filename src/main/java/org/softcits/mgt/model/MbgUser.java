package org.softcits.mgt.model;

import java.util.Date;

public class MbgUser {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column users.id
     *
     * @mbg.generated Sun May 27 13:51:09 CST 2018
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column users.username
     *
     * @mbg.generated Sun May 27 13:51:09 CST 2018
     */
    private String username;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column users.passwd
     *
     * @mbg.generated Sun May 27 13:51:09 CST 2018
     */
    private String passwd;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column users.create_time
     *
     * @mbg.generated Sun May 27 13:51:09 CST 2018
     */
    private Date createTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column users.state
     *
     * @mbg.generated Sun May 27 13:51:09 CST 2018
     */
    private String state;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column users.role_id
     *
     * @mbg.generated Sun May 27 13:51:09 CST 2018
     */
    private Integer roleId;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column users.id
     *
     * @return the value of users.id
     *
     * @mbg.generated Sun May 27 13:51:09 CST 2018
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column users.id
     *
     * @param id the value for users.id
     *
     * @mbg.generated Sun May 27 13:51:09 CST 2018
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column users.username
     *
     * @return the value of users.username
     *
     * @mbg.generated Sun May 27 13:51:09 CST 2018
     */
    public String getUsername() {
        return username;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column users.username
     *
     * @param username the value for users.username
     *
     * @mbg.generated Sun May 27 13:51:09 CST 2018
     */
    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column users.passwd
     *
     * @return the value of users.passwd
     *
     * @mbg.generated Sun May 27 13:51:09 CST 2018
     */
    public String getPasswd() {
        return passwd;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column users.passwd
     *
     * @param passwd the value for users.passwd
     *
     * @mbg.generated Sun May 27 13:51:09 CST 2018
     */
    public void setPasswd(String passwd) {
        this.passwd = passwd == null ? null : passwd.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column users.create_time
     *
     * @return the value of users.create_time
     *
     * @mbg.generated Sun May 27 13:51:09 CST 2018
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column users.create_time
     *
     * @param createTime the value for users.create_time
     *
     * @mbg.generated Sun May 27 13:51:09 CST 2018
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column users.state
     *
     * @return the value of users.state
     *
     * @mbg.generated Sun May 27 13:51:09 CST 2018
     */
    public String getState() {
        return state;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column users.state
     *
     * @param state the value for users.state
     *
     * @mbg.generated Sun May 27 13:51:09 CST 2018
     */
    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column users.role_id
     *
     * @return the value of users.role_id
     *
     * @mbg.generated Sun May 27 13:51:09 CST 2018
     */
    public Integer getRoleId() {
        return roleId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column users.role_id
     *
     * @param roleId the value for users.role_id
     *
     * @mbg.generated Sun May 27 13:51:09 CST 2018
     */
    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }
}