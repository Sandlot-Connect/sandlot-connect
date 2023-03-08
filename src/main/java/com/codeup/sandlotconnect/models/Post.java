package com.codeup.sandlotconnect.models;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "posts")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String content;

    @Column(nullable = false)
    private Date timestamp;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "post")
    private List<Comment> comments;

    public Post() {
    }

    public Post(String title, String content, Date timestamp, User user) {
        this.title = title;
        this.content = content;
        this.timestamp = timestamp;
        this.user = user;
    }

    public Post(long id, String title, String content, Date timestamp, User user, List<Comment> comments) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.timestamp = timestamp;
        this.user = user;
        this.comments = comments;
    }

    public Post(String title, String content, Date timestamp, User user, List<Comment> comments) {
        this.title = title;
        this.content = content;
        this.timestamp = timestamp;
        this.user = user;
        this.comments = comments;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }
}
