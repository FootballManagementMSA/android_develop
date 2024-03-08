package com.example.network_api.api

import com.example.network_api.response.MakeClubResponse
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Response
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part

interface ClubApi {
    @Multipart
    @POST("/api/team-service/teams")
    suspend fun sendClubInfo(
        @Part("name") name: RequestBody,
        @Part emblem: MultipartBody.Part
    ): Response<MakeClubResponse>
}