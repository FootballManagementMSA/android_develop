package com.example.feature_mypage.presentation.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeightIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.core.model.MyPageUserInfoUiModel
import com.example.feature_mypage.presentation.UserInfoState
import com.example.feature_mypage.presentation.ui_component.MyPageCardView
import com.example.feature_mypage.presentation.ui_component.MyPageInfoView
import com.example.feature_mypage.presentation.ui_component.MyPageTopView
import com.example.feature_mypage.presentation.viewmodel.MyPageViewModel
import com.example.ui_component.values.gradientColorsList
import com.example.ui_component.values.mainTheme

@Composable
fun MyPageScreen(
    navHostController: NavHostController,
    viewModel: MyPageViewModel = hiltViewModel()
) {
    val state by viewModel.uiState.collectAsState()
    var userInfo: MyPageUserInfoUiModel? = null

    when (state) {
        is UserInfoState.Loading -> {
            CircularProgressIndicator()
        }

        is UserInfoState.Success -> {
            userInfo = (state as UserInfoState.Success).data
        }
    }
    Column {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    brush = Brush.horizontalGradient(colors = gradientColorsList),
                )
        ) {
            Row {
                MyPageTopView(Modifier.weight(1f), title = "마이페이지", onBack = {}) {
                }
            }
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(
                        mainTheme,
                        shape = RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp)
                    )
                    .align(Alignment.BottomCenter)
                    .fillMaxHeight(0.75f)
            ) {
                Column {
                    userInfo?.let {
                        MyPageInfoView(
                            modifier = Modifier
                                .fillMaxHeight()
                                .requiredHeightIn(180.dp)
                                .weight(2f)
                                .align(Alignment.CenterHorizontally),
                            profileImage = it.image,
                            name = it.name,
                            studentId = it.studentId
                        )
                    }
                    MyPageCardView(
                        modifier = Modifier
                            .fillMaxWidth()
                            .requiredHeightIn(180.dp)
                            .weight(7f)
                            .padding(30.dp)
                    ) {
                        navHostController.navigate("MYPAGE_MODIFY")
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun MyPageScreenPreview() {
    MyPageScreen(navHostController = rememberNavController())
}

