    package com.example.Assessment.Model;

    import jakarta.persistence.*;
    import lombok.AllArgsConstructor;
    import lombok.Data;
    import lombok.NoArgsConstructor;

    @AllArgsConstructor //generates constructors for all fields
    @NoArgsConstructor //default constructor with no parameters
    @Entity // treats this as a table
    @Data // getters and setters
    @Table(name="Assessment_User")
    public class User {
        @Id // primary key
        @GeneratedValue //auto generated value
        @Column(name="user_id")
        private int id;
        @Column(name="username")
        private String username;
        @Column(name="password1")
        private String password1;
        @Column(name="email")
        private String email;
    }