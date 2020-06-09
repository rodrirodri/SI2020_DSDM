package br.edu.unisep.videoalbum

import android.content.Intent
import android.media.MediaMetadataRetriever
import android.net.Uri
import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.FileProvider
import kotlinx.android.synthetic.main.activity_main.*
import java.io.File

class MainActivity : AppCompatActivity() {

    private lateinit var videoUri: Uri

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonRecord.setOnClickListener { recordVideo() }
    }

    private fun recordVideo() {
        val intentCamera = Intent(MediaStore.ACTION_VIDEO_CAPTURE)

        // Verifica se a ação de acesso à câmera está disponível no dispositivo
        // e acessível a partir do app
        if (intentCamera.resolveActivity(packageManager) != null) {
            buildVideoPath()

            intentCamera.putExtra(MediaStore.EXTRA_OUTPUT, videoUri)

            // 0 - baixa qualidade / 1 - alta qualidade
            intentCamera.putExtra(MediaStore.EXTRA_VIDEO_QUALITY, 1)
            startActivityForResult(intentCamera, REQUEST_CODE_VIDEO)
        }
    }

    private fun buildVideoPath() {
        val videoDir = getExternalFilesDir(Environment.DIRECTORY_MOVIES)
        val videoFile = File.createTempFile("video_", ".avi", videoDir)

        this.videoUri = FileProvider.getUriForFile(
            this,
            "${packageName}.fileprovider", videoFile
        )
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == REQUEST_CODE_VIDEO && resultCode == RESULT_OK) {
            val metadataRetriever = MediaMetadataRetriever()
            metadataRetriever.setDataSource(this, videoUri)

            val thumb = metadataRetriever.getFrameAtTime(1)
            imageViewThumb.setImageBitmap(thumb)
        }
    }

    companion object {
        private const val REQUEST_CODE_VIDEO = 1
    }
}
