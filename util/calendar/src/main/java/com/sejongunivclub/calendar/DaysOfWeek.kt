package com.sejongunivclub.calendar

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.sejongunivclub.calendar.values.calendarDateSize
import com.sejongunivclub.calendar.values.dayOfWeekList

@Composable
fun DaysOfWeek(modifier: Modifier = Modifier) {
    val dayOfWeekList = remember { dayOfWeekList }
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        dayOfWeekList.forEachIndexed { index, dayOfWeek ->
            Box(modifier = Modifier.size(calendarDateSize)) {
                Text(
                    modifier = Modifier.align(Alignment.Center),
                    text = dayOfWeek,
                    color = when (index) {
                        0 -> Color.Red
                        dayOfWeekList.size - 1 -> Color.Blue
                        else -> Color.Black
                    }
                )
            }
        }
    }
    Spacer(modifier = modifier)
}

@Preview
@Composable
fun DaysOfWeekPreview(){
    DaysOfWeek()
}