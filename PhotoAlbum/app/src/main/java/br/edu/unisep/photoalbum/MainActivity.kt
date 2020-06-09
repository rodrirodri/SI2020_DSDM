package br.edu.unisep.photoalbum

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.FileProvider
import kotlinx.android.synthetic.main.activity_main.*
import java.io.File

class MainActivity : AppCompatActivity() {

    private lateinit var imageUri: Uri

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonTakePicture.setOnClickListener { takePicture() }
    }

    private fun takePicture() {
        val intentCamera = Intent(MediaStore.ACTION_IMAGE_CAPTURE)

        // Verifica se a ação de acesso à câmera está disponível no dispositivo
        // e acessível a partir do app
        if (intentCamera.resolveActivity(packageManager) != null) {
            buildPhotoPath()

            intentCamera.putExtra(MediaStore.EXTRA_OUTPUT, imageUri)
            startActivityForResult(intentCamera, REQUEST_CODE_PHOTO)
        }
    }

    private fun buildPhotoPath() {
        val imageDir = getExternalFilesDir(Environment.DIRECTORY_PICTURES)
        val imageFile = File.createTempFile("photo_", ".jpg", imageDir)

        this.imageUri = FileProvider.getUriForFile(
            this,
            "${packageName}.fileprovider", imageFile
        )
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == REQUEST_CODE_PHOTO && resultCode == RESULT_OK) {
            imageView.setImageURI(imageUri)
        }
    }

    companion object {
        private const val REQUEST_CODE_PHOTO = 1
    }
}
