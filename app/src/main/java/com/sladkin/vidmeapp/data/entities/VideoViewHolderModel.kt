package com.sladkin.vidmeapp.data.entities

import android.graphics.Bitmap
import com.sladkin.vidmeapp.data.rest.model.Video

/**
 * Created by dima on 05.11.2017.
 */
data class VideoViewHolderModel(var videoModel: VideoModel, var thumb: Bitmap)