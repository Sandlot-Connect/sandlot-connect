package com.codeup.sandlotconnect.models;

import jakarta.persistence.*;

@Entity
@Table(name = "requests")
public class Request {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String status;

    @Column
    private boolean cancelled = false;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false, unique = true)
    private User user;

    @ManyToOne
    @JoinColumn(name = "team_id")
    private Team team;

    public Request() {
    }

    public Request(long id, String status, User user, Team team) {
        this.id = id;
        this.status = status;
        this.user = user;
        this.team = team;
    }

    public Request(String status, User user, Team team) {
        this.status = status;
        this.user = user;
        this.team = team;
    }

    public Request(long id, String status, boolean cancelled, User user, Team team) {
        this.id = id;
        this.status = status;
        this.cancelled = cancelled;
        this.user = user;
        this.team = team;
    }

    public Request(String status, boolean cancelled, User user, Team team) {
        this.status = status;
        this.cancelled = cancelled;
        this.user = user;
        this.team = team;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public boolean isCancelled() {
        return cancelled;
    }

    public void setCancelled(boolean cancelled) {
        this.cancelled = cancelled;
    }
}
