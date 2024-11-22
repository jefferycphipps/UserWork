package com.jeffwork.UserWork.models;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.hibernate.annotations.JdbcTypeCode;
//import org.hibernate.type.SqlTypes;

@Entity
public class User extends AbstractEntity {



    @NotNull
    @Size(min=6)
    private String password;

    private static final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    @OneToOne(cascade = CascadeType.ALL)
    private Image userImage;

    public User() {}

    public User(String username, String password, Image image) {
        super();
        this.setName(username);
        this.password = password;
        this.userImage = image;
    }


    public @NotNull @Size(min = 6) String getPassword() {
        return password;
    }

    public void setPassword(@NotNull @Size(min = 6) String password) {
        this.password = password;
    }

    public Image getUserImage() {
        return userImage;
    }

    public void setUserImage(Image userImage) {
        this.userImage = userImage;
    }

    public boolean isMatchingPassword(String password) {
        return encoder.matches(password, password);
    }

}
