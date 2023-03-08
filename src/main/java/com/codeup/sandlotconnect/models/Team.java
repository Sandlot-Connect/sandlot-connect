package com.codeup.sandlotconnect.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "teams")
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private String city;

    @Column(nullable = false)
    private String state;

    @Column
    private String logoUrl;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "team")
    private List<User> users;

    @ManyToOne
    @JoinColumn(name = "captain_id")
    private User captain;

    @OneToMany(mappedBy = "team")
    private List<Request> requests;

    public Team() {
    }

    public Team(long id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public Team(long id, String name, String description, User captain) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.captain = captain;
    }

    public Team(long id, String name, String description, String city, String state) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.city = city;
        this.state = state;
    }

    public Team(long id, String name, String description, String city, String state, String logoUrl, List<User> users, User captain, List<Request> requests) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.city = city;
        this.state = state;
        this.logoUrl = logoUrl;
        this.users = users;
        this.captain = captain;
        this.requests = requests;
    }

    public Team(String name, String description, String city, String state, String logoUrl) {
        this.name = name;
        this.description = description;
        this.city = city;
        this.state = state;
        this.logoUrl = logoUrl;
    }

    public Team(String name, String description, String city, String state) {
        this.name = name;
        this.description = description;
        this.city = city;
        this.state = state;
    }

    public Team(String name, String description, String city, String state, String logoUrl, List<User> users, User captain, List<Request> requests) {
        this.name = name;
        this.description = description;
        this.city = city;
        this.state = state;
        this.logoUrl = logoUrl;
        this.users = users;
        this.captain = captain;
        this.requests = requests;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getLogoUrl() {
        return logoUrl;
    }

    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public User getCaptain() {
        return captain;
    }

    public void setCaptain(User captain) {
        this.captain = captain;
    }

    public List<Request> getRequests() {
        return requests;
    }

    public void setRequests(List<Request> requests) {
        this.requests = requests;
    }
}
