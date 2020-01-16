package com.abc.work.mvc;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Customer {
    @NotNull(message = "First name can't be empty!")
    private String fname;

    @NotNull(message = "Last name can't be empty!")
    @Size(min = 3, message = "Minimum 3 chars reqd.")
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
}
