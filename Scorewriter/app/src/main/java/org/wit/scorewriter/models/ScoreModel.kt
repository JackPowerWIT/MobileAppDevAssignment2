package org.wit.scorewriter.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ScoreModel(
        var id: Long = 0,
        var title: String = "",
        var artist: String = "Unknown"
) : Parcelable