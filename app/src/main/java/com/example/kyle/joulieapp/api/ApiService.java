package com.example.kyle.joulieapp.Api;

import com.example.kyle.joulieapp.Models.Device;
import com.example.kyle.joulieapp.Models.Rule;
import com.example.kyle.joulieapp.Models.Usage;
import com.example.kyle.joulieapp.Models.UsageResponse;
import com.google.gson.JsonObject;

import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by Kyle on 2017-02-24.
 */

public interface ApiService {

    //test connection to url
    @GET(".")
    Call<Void> ping();

    @GET("ngrok")
    Call<String> getNgrokUrl();

    @POST("robots/reset")
    Call<String> resetRobot();

    @POST("user/{user_token}/devices/reset")
    Call<String> resetDevices(@Path("user_token") String userToken);

    //Create a new device for the specified robot
    @POST("device")
    Call<Device> createDevice(@Body Device device);

    //delete a device from the specified robot
    @DELETE("device/{device_id}")
    Call<String> deleteDevice(@Path("device_id") String deviceID);

    //Create a new device for the specified robot
    @POST("device/{device_id}/rule")
    Call<String> createRule(@Path("device_id") String deviceID, @Body Rule rule);

    //delete a device from the specified robot
    @DELETE("rule/{rule_id}")
    Call<String> deleteRule(@Path("rule_id") String ruleID);

    //send a command to a specific device
    @POST("device/{device_id}/{command_name}")
    Call<String> sendCommand(@Path("device_id") String deviceName, @Path("command_name") String commandName, @Body HashMap<String, String> body);

    @POST("newuser")
    Call<String> newUser(@Body HashMap<String, String> body);

    @POST("updateuser")
    Call<String> updateUser(@Body HashMap<String, String> body);

    @GET("devices")
    Call<List<Device>> getDevices();

    @GET("rules")
    Call<List<Rule>> getRules();

    @GET("user/current/data")
    Call<List<UsageResponse>> getUsages();

    @GET("finduser/{user_email}")
    Call<String> userSearch(@Path("user_email") String userEmail);

    @POST("device/{device_id}/share/{user_id}")
    Call<String> shareDevice(@Path("device_id") String deviceId, @Path("user_id") String userId);

    // TODO: 2017-03-17 get usage data endpoint
    // TODO: 2017-03-17 create new rule endpoint

}
