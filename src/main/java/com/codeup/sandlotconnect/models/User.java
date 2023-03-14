package com.codeup.sandlotconnect.models;

import com.codeup.sandlotconnect.validators.StrongPassword;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Email(regexp = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$", message = "Please enter valid email address.")
    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private String password;

    @Transient
    @StrongPassword(message = "Password must be at least 8 characters and must contain at least 1 lower case, 1 upper case, 1 digit and 1 special character")
    private String passwordForm;

    @Transient
    @NotBlank(message = "Confirm password is required.")
    private String confirmPassword;

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

    @OneToOne(mappedBy = "captain")
    private Team captainOfTeam;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private List<Post> posts;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private List<Comment> comments;

    @OneToMany(mappedBy = "user")
    private List<Request> requests;

    public User() {
    }

    public User(User copy) {
        id = copy.id;
        username = copy.username;
        password = copy.password;
        firstName = copy.firstName;
        lastName = copy.lastName;
        isCaptain = copy.isCaptain;
        profilePictureUrl = copy.profilePictureUrl;
        description = copy.description;
        team = copy.team;
    }

    public User(long id, String username, String description, String password, String firstName, String lastName, boolean isCaptain, String profilePictureUrl, Team team, Team captainOfTeam, List<Post> posts, List<Comment> comments, List<Request> requests) {
        this.id = id;
        this.username = username;
        this.description = description;
        this.password = password;
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

    public User(long id, String username, String password, String firstName, String lastName, boolean isCaptain, String profilePictureUrl, Team team, Team captainOfTeam, List<Post> posts, List<Comment> comments, List<Request> requests) {
        this.id = id;
        this.username = username;
        this.password = password;
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

    public User(long id, String username, String description, String password, String passwordForm, String confirmPassword, String firstName, String lastName, boolean isCaptain, String profilePictureUrl, Team team, Team captainOfTeam, List<Post> posts, List<Comment> comments, List<Request> requests) {
        this.id = id;
        this.username = username;
        this.description = description;
        this.password = password;
        this.passwordForm = passwordForm;
        this.confirmPassword = confirmPassword;
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

    public User(String username, String description, String password, String passwordForm, String confirmPassword, String firstName, String lastName, boolean isCaptain, String profilePictureUrl, Team team, Team captainOfTeam, List<Post> posts, List<Comment> comments, List<Request> requests) {
        this.username = username;
        this.description = description;
        this.password = password;
        this.passwordForm = passwordForm;
        this.confirmPassword = confirmPassword;
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

    public User(String username, String password, String firstName, String lastName, boolean isCaptain, String profilePictureUrl, Team team, Team captainOfTeam, List<Post> posts, List<Comment> comments, List<Request> requests) {
        this.username = username;
        this.password = password;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public Team getCaptainOfTeam() {
        return captainOfTeam;
    }

    public void setCaptainOfTeam(Team captainOfTeam) {
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

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public String getPasswordForm() {
        return passwordForm;
    }

    public void setPasswordForm(String passwordForm) {
        this.passwordForm = passwordForm;
    }
}
