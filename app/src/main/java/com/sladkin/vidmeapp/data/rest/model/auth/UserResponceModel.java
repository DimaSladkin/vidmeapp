
package com.sladkin.vidmeapp.data.rest.model.auth;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UserResponceModel {

    @SerializedName("status")
    @Expose
    private Boolean status;
    @SerializedName("auth")
    @Expose
    private Auth auth;
    @SerializedName("user")
    @Expose
    private User user;

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Auth getAuth() {
        return auth;
    }

    public void setAuth(Auth auth) {
        this.auth = auth;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "status: " + status;
    }
}
