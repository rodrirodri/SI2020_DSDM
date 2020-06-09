package br.edu.unisep.videoalbum

import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.MediaController
import kotlinx.android.synthetic.main.activity_video_player.*

class VideoPlayerActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_video_player)

        setupPlayer()
    }

    private fun setupPlayer() {
        // Obtém a URI do vídeo a ser exibido
        val videoUri = intent.getStringExtra(EXTRA_VIDEO_URI)

        // Atribuir a URI do vídeo ao componente video view
        videoView.setVideoURI(Uri.parse(videoUri))

        val controller = MediaController(this)
        controller.setAnchorView(videoView)

        videoView.setMediaController(controller)
        videoView.start()
    }

    companion object {
        private const val EXTRA_VIDEO_URI = "video-uri"

        fun newIntent(context: Context, videoUri: String) =
            Intent(context, VideoPlayerActivity::class.java)
                .putExtra(EXTRA_VIDEO_URI, videoUri)
    }

}
