package com.sejongunivclub.feature_schedule.presentation.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sejongunivclub.core.ResultState.MakeClubScheduleResult
import com.sejongunivclub.core.datasource.UserLocalDataSource
import com.sejongunivclub.core.model.ClubSchedule
import com.sejongunivclub.feature_schedule.domain.usecase.MakeScheduleUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ScheduleViewModel @Inject constructor(
    private val makeScheduleUseCase: MakeScheduleUseCase,
    private val userLocalDataSource: UserLocalDataSource
) : ViewModel() {
    fun makeClub(clubSchedule: ClubSchedule) = viewModelScope.launch {
        Log.e("123", "id: ${userLocalDataSource.getSelectedTeamId()}, schedule: $clubSchedule")
        val result = makeScheduleUseCase(userLocalDataSource.getSelectedTeamId(), clubSchedule)
        when (result) {
            is MakeClubScheduleResult.Success -> {
                Log.e("makeClub", "${result.code}")
            }

            is MakeClubScheduleResult.Error -> {
                Log.e("makeClub", result.errorMessage)
            }
        }
    }
}