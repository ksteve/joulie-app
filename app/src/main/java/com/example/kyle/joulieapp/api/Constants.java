package com.example.kyle.joulieapp.Api;

/**
 * Created by Kyle on 2017-01-20.
 */

class Constants {
    final static String REFRESH_TOKEN = "AUTH0_REFRESH_TOKEN";
    final static String ACCESS_TOKEN = "AUTH0_ACCESS_TOKEN";
    final static String ID_TOKEN = "AUTH0_ID_TOKEN";
    final static String CREDENTIAL_TYPE = "AUTH0_CREDENTIAL_TYPE";

    //cylon server
    final static String CLOUD_URL = "https://joulie-core.herokuapp.com";

    final static String AUTH_TOKEN = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiIsImtpZCI6Ik9ERkZSakU1TURSRk1qSXlOVGd6UXpjME5qazBRVEpGTkRKQ1FVWXlSamcyTmpBd09ERTVOdyJ9.eyJpc3MiOiJodHRwczovL2pvdWxpZS5hdXRoMC5jb20vIiwic3ViIjoiZ3VNZFJBTmVOWUVvaVl4MmFlNmZNUXVlQTFCbENqQWxAY2xpZW50cyIsImF1ZCI6Imh0dHBzOi8vam91bGllLmF1dGgwLmNvbS9hcGkvdjIvIiwiZXhwIjoxNDkzNTA5NDkzLCJpYXQiOjE0OTMyNTAyOTMsInNjb3BlIjoicmVhZDpjbGllbnRfZ3JhbnRzIGNyZWF0ZTpjbGllbnRfZ3JhbnRzIGRlbGV0ZTpjbGllbnRfZ3JhbnRzIHVwZGF0ZTpjbGllbnRfZ3JhbnRzIHJlYWQ6dXNlcnMgdXBkYXRlOnVzZXJzIGRlbGV0ZTp1c2VycyBjcmVhdGU6dXNlcnMgcmVhZDp1c2Vyc19hcHBfbWV0YWRhdGEgdXBkYXRlOnVzZXJzX2FwcF9tZXRhZGF0YSBkZWxldGU6dXNlcnNfYXBwX21ldGFkYXRhIGNyZWF0ZTp1c2Vyc19hcHBfbWV0YWRhdGEgY3JlYXRlOnVzZXJfdGlja2V0cyByZWFkOmNsaWVudHMgdXBkYXRlOmNsaWVudHMgZGVsZXRlOmNsaWVudHMgY3JlYXRlOmNsaWVudHMgcmVhZDpjbGllbnRfa2V5cyB1cGRhdGU6Y2xpZW50X2tleXMgZGVsZXRlOmNsaWVudF9rZXlzIGNyZWF0ZTpjbGllbnRfa2V5cyByZWFkOmNvbm5lY3Rpb25zIHVwZGF0ZTpjb25uZWN0aW9ucyBkZWxldGU6Y29ubmVjdGlvbnMgY3JlYXRlOmNvbm5lY3Rpb25zIHJlYWQ6cmVzb3VyY2Vfc2VydmVycyB1cGRhdGU6cmVzb3VyY2Vfc2VydmVycyBkZWxldGU6cmVzb3VyY2Vfc2VydmVycyBjcmVhdGU6cmVzb3VyY2Vfc2VydmVycyByZWFkOmRldmljZV9jcmVkZW50aWFscyB1cGRhdGU6ZGV2aWNlX2NyZWRlbnRpYWxzIGRlbGV0ZTpkZXZpY2VfY3JlZGVudGlhbHMgY3JlYXRlOmRldmljZV9jcmVkZW50aWFscyByZWFkOnJ1bGVzIHVwZGF0ZTpydWxlcyBkZWxldGU6cnVsZXMgY3JlYXRlOnJ1bGVzIHJlYWQ6ZW1haWxfcHJvdmlkZXIgdXBkYXRlOmVtYWlsX3Byb3ZpZGVyIGRlbGV0ZTplbWFpbF9wcm92aWRlciBjcmVhdGU6ZW1haWxfcHJvdmlkZXIgYmxhY2tsaXN0OnRva2VucyByZWFkOnN0YXRzIHJlYWQ6dGVuYW50X3NldHRpbmdzIHVwZGF0ZTp0ZW5hbnRfc2V0dGluZ3MgcmVhZDpsb2dzIHJlYWQ6c2hpZWxkcyBjcmVhdGU6c2hpZWxkcyBkZWxldGU6c2hpZWxkcyB1cGRhdGU6dHJpZ2dlcnMgcmVhZDp0cmlnZ2VycyByZWFkOmdyYW50cyBkZWxldGU6Z3JhbnRzIHJlYWQ6Z3VhcmRpYW5fZmFjdG9ycyB1cGRhdGU6Z3VhcmRpYW5fZmFjdG9ycyByZWFkOmd1YXJkaWFuX2Vucm9sbG1lbnRzIGRlbGV0ZTpndWFyZGlhbl9lbnJvbGxtZW50cyBjcmVhdGU6Z3VhcmRpYW5fZW5yb2xsbWVudF90aWNrZXRzIHJlYWQ6dXNlcl9pZHBfdG9rZW5zIn0.d79PQByG3gjCw-T2sUIWDMfs280zo6nDS-SXa7a-OYr53osNOHGNtiqgBIJ1mmHzKKhx7ia4qWN-3wAWH-B4vdwSCjWgcti29c9ApiGzidVZkjXFOm4OeRb1G1b3YWTex67UHWVtFzTYsq_KfM_AI3k2aX6pTjsSxGiYR8ay49LBZ9GWdpIM7fq-7tMFwLBVb61WjwzlzKzt-SkxdPU1ZXU2cFel5rJSXAQ-EdXCFvBW9f567k2o3kvBBP-ZFGzn_uVDbUHACNy5426ataG2LlCB-NhA3AR04SEZjYfoiWS0EfK6iBIkrI45xTEWxuTfNi-0W4cfeOF8dQ4bx8KF4Q";


    final static String CREATE_DEVICE_ENDPOINT = "/api/robots/Test/commands/create_device";
    final static String REMOVE_DEVICE_ENDPOINT = "/api/robots/kyle/commands/remove_device";
    final static String DEVICE_COMMAND = "/api/robots/Test/devices/switch/commands/toggle_power";
      final static String UPDATE_TEMP = "api/robots/kyle/devices/thermostat/commands/target_temperature_c";



}
