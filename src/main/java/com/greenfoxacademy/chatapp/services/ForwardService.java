package com.greenfoxacademy.chatapp.services;

import com.greenfoxacademy.chatapp.models.dtos.MessageDTO;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ForwardService {

    @POST("api/message/receive")
    Call<MessageDTO> forwardMessage(@Body MessageDTO message);

}
