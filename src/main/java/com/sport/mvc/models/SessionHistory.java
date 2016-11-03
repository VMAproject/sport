package com.sport.mvc.models;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "session_history")
public class SessionHistory extends Model {

    private static final long serialVersionUID = -3832085403808589327L;

    @Column(name = "session_date")
    private Date sessionDate;

    @Column(name = "session_ip")
    private String ip;

    @Column(name = "browser")
    private String browser;

    @OneToMany(mappedBy = "sessionHistory" , cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<User> users = new HashSet<>();

    public SessionHistory() {
        super();
    }

    public String getBrowser() {
        return browser;
    }

    public void setBrowser(String browser) {
        this.browser = browser;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Date getSessionDate() {
        return sessionDate;
    }

    public void setSessionDate(Date sessionDate) {
        this.sessionDate = sessionDate;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }
}
