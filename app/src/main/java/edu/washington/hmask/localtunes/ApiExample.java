package edu.washington.hmask.localtunes;

import android.app.Activity;
import android.util.Log;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by huntermask on 5/30/15.
 */
public class ApiExample extends Activity {

    public static final String API_BASE_URL = "http://ec2-52-11-139-181.us-west-2.compute.amazonaws.com";
    RequestQueue queue = Volley.newRequestQueue(this);

    public void getSongsExample() {
        final GsonRequest gsonRequest = new GsonRequest(API_BASE_URL + "/nearby/lat/47.655335/lon/-122.303520", Songs.class, null, new Response.Listener<Songs>() {

            @Override
            public void onResponse(Songs songs) {
                // Do something with songs.getSongs() here
                Log.i("ApiExample", "Got " + songs.getSongs().size() + " song(s) back");
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                if(volleyError != null) Log.e("MainActivity", volleyError.getMessage());
            }
        });
        queue.add(gsonRequest);
    }

    public void getUserExample() {
        final GsonRequest gsonRequest = new GsonRequest(API_BASE_URL + "/user/1", User.class, null, new Response.Listener<User>() {

            @Override
            public void onResponse(User user) {
                // Do something with your User object here
                Log.i("ApiExample", "Got user" + user.getScreenName() + " back");
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                if(volleyError != null) Log.e("MainActivity", volleyError.getMessage());
            }
        });
        queue.add(gsonRequest);
    }

    public void createUserExample() {
        User user = new User();
        user.setId("12345");
        user.setScreenName("test_user");
        user.setFirstName("Test");
        user.setLastName("User");
        try {

            JsonObjectRequest request = new JsonObjectRequest(Request.Method.POST, API_BASE_URL + "/user/create",
                    new JSONObject(new Gson().toJson(user)),
                    null,
                    new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {

                        }
                    }
            );
            queue.add(request);
        } catch (JSONException ex) {
            Log.e("ApiExample", ex.getMessage());
        }
    }

    public void logSongExample() {
        Song song = new Song();
        song.setArtist("Tycho");
        song.setAlbum("Awake");
        song.setTitle("Awake");
        song.setUser("1");
        try {
            JsonObjectRequest request = new JsonObjectRequest(Request.Method.POST, API_BASE_URL + "/nearby/lat/47.655335/lon/-122.303520",
                    new JSONObject(new Gson().toJson(song)),
                    null,
                    new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {

                        }
                    }
            );
            queue.add(request);
        } catch (JSONException ex) {
            Log.e("ApiExample", ex.getMessage());
        }
    }
}
