package com.abc.work.mvc;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Size;

@Entity
@Table(name="Customer")
public class Customer {

    @Id
    @Null(message = "Email can't be empty!")
    private String email;

    @Size(min = 3, message = "Minimum 3 chars reqd.")
    @Null(message = "First name can't be empty!")
    private String fname;

    @Size(min = 3, message = "Minimum 3 chars reqd.")
    @Null(message = "Last name can't be empty!")
    private String lname;

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
