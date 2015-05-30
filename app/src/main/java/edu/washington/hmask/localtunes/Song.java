package edu.washington.hmask.localtunes;

import android.support.annotation.Nullable;

/**
 * Created by huntermask on 5/30/15.
 */
public class Song {
    private User user;
    private String artist;
    private String album;
    private String title;
    private String albumArtUrl;


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Nullable
    public String getAlbumArtUrl() {
        return albumArtUrl;
    }

    public void setAlbumArtUrl(String albumArtUrl) {
        this.albumArtUrl = albumArtUrl;
    }
}
