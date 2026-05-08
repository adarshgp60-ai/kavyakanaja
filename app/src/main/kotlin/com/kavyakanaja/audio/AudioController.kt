package com.kavyakanaja.audio

import android.content.Context
import androidx.media3.common.MediaItem
import androidx.media3.exoplayer.ExoPlayer
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AudioController @Inject constructor(
    @ApplicationContext context: Context
) {
    private val player = ExoPlayer.Builder(context).build()

    fun play(url: String) {
        player.setMediaItem(MediaItem.fromUri(url))
        player.prepare()
        player.play()
    }

    fun toggle() {
        if (player.isPlaying) player.pause() else player.play()
    }

    fun seekTo(positionMs: Long) {
        player.seekTo(positionMs)
    }

    fun setSpeed(speed: Float) {
        player.setPlaybackSpeed(speed)
    }

    fun release() {
        player.release()
    }
}
