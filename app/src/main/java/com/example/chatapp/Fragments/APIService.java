package com.example.chatapp.Fragments;

import com.example.chatapp.Notifications.MyResponse;
import com.example.chatapp.Notifications.Sender;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface APIService {
    @Headers(
            {
                    "Content-Type:application/json",
                    "Authorization: key=AAAAFxqhx7c:APA91bEcpRTdi6FnCmWu68vRGNi9_Afrm1VzoBzggVTI2KdmG2eedDxPgopHEWANQ9nZ4cebeGiq0nqhnkLt27CvLb-Uy-eebvBXsAYeFCFczJ_rrs-HQkyNGSY7dtRKTZfNg9St2-As"
            }
    )

    @POST("fcm/send")
    Call<MyResponse> sendNotification(@Body Sender body);
}
