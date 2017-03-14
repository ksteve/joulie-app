package com.example.kyle.joulieapp.api;

/**
 * Created by Kyle on 2017-01-20.
 */

class Constants {
    final static String REFRESH_TOKEN = "AUTH0_REFRESH_TOKEN";
    final static String ACCESS_TOKEN = "AUTH0_ACCESS_TOKEN";
    final static String ID_TOKEN = "AUTH0_ID_TOKEN";
    final static String CREDENTIAL_TYPE = "AUTH0_CREDENTIAL_TYPE";

    //cylon server
    final static String BASE_URL = "https://joulie-cylon.herokuapp.com";
    final static String CREATE_DEVICE_ENDPOINT = "/api/robots/Test/commands/create_device";
    final static String REMOVE_DEVICE_ENDPOINT = "/api/robots/kyle/commands/remove_device";
    final static String DEVICE_COMMAND = "/api/robots/Test/devices/switch/commands/toggle_power";
      final static String UPDATE_TEMP = "api/robots/kyle/devices/thermostat/commands/target_temperature_c";



}