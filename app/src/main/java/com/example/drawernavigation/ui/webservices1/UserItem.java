package com.example.drawernavigation.ui.webservices1;

public class UserItem {
    private String no_pendaftaran, username;

    public UserItem(String no_pendaftaran, String username ) {
        this.no_pendaftaran = no_pendaftaran;
        this.username = username;
    }

    public String getNo() {
        return no_pendaftaran;
    }

    public String getName() {
        return username;
    }
}
