package edu.washington.hmask.localtunes;

import android.support.annotation.Nullable;

import com.google.gson.annotations.SerializedName;

/**
 * Created by huntermask on 5/30/15.
 */
public class Song {
    @SerializedName("user")
    private String userId;

    private String artist;

    private String album;

    private String title;

    @SerializedName("album_art_url")
    private String albumArtUrl;


    public String getUserId() {
        return userId;
    }

    public void setUser(String userId) {
        this.userId = userId;
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
