import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.mlkit.vision.face.Face
import com.google.mlkit.vision.face.FaceDetection
import com.google.mlkit.vision.face.FaceDetectorOptions

class CameraViewModel : ViewModel() {
    private val _facesDetected = MutableLiveData<List<Face>>()
    val facesDetected: LiveData<List<Face>> get() = _facesDetected

    private val faceDetector = FaceDetection.getClient(FaceDetectorOptions.Builder()
        .setPerformanceMode(FaceDetectorOptions.PERFORMANCE_MODE_FAST)
        .setExactModeEnabled(false)
        .build())

    fun detectFaces(image: InputImage) {
        faceDetector.process(image)
            .addOnSuccessListener { faces ->
                _facesDetected.value = faces
            }
            .addOnFailureListener { e ->
                // Handle error
            }
    }
}