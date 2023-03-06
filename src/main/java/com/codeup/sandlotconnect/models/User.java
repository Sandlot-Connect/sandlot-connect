package com.codeup.sandlotconnect.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column
    private boolean isCaptain;

    @Column
    private String profilePictureUrl;

    @ManyToOne
    @JoinColumn(name = "team_id")
    private Team team;

    @OneToMany(mappedBy = "captain")
    private List<Team> captainOfTeam;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private List<Post> posts;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private List<Comment> comments;

    @OneToMany(mappedBy = "user")
    private List<Request> requests;

    public User() {
    }

    public User(String email, String firstName, String lastName, boolean isCaptain, String profilePictureUrl, Team team, List<Team> captainOfTeam, List<Post> posts, List<Comment> comments, List<Request> requests) {
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.isCaptain = isCaptain;
        this.profilePictureUrl = profilePictureUrl;
        this.team = team;
        this.captainOfTeam = captainOfTeam;
        this.posts = posts;
        this.comments = comments;
        this.requests = requests;
    }

    public User(long id, String email, String firstName, String lastName, boolean isCaptain, String profilePictureUrl, Team team, List<Team> captainOfTeam, List<Post> posts, List<Comment> comments, List<Request> requests) {
        this.id = id;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.isCaptain = isCaptain;
        this.profilePictureUrl = profilePictureUrl;
        this.team = team;
        this.captainOfTeam = captainOfTeam;
        this.posts = posts;
        this.comments = comments;
        this.requests = requests;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public boolean isCaptain() {
        return isCaptain;
    }

    public void setCaptain(boolean captain) {
        isCaptain = captain;
    }

    public String getProfilePictureUrl() {
        return profilePictureUrl;
    }

    public void setProfilePictureUrl(String profilePictureUrl) {
        this.profilePictureUrl = profilePictureUrl;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public List<Team> getCaptainOfTeam() {
        return captainOfTeam;
    }

    public void setCaptainOfTeam(List<Team> captainOfTeam) {
        this.captainOfTeam = captainOfTeam;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public List<Request> getRequests() {
        return requests;
    }

    public void setRequests(List<Request> requests) {
        this.requests = requests;
    }
}
