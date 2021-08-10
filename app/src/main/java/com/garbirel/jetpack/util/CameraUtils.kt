import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.provider.MediaStore
import androidx.fragment.app.FragmentActivity

object CameraUtils {
    /**
     * 打开相机
     */
    suspend fun openCamera(
        context: FragmentActivity,
        requestCode: Int,
        imgUri: Uri
    ) {
        /*if (PermissionHelper.checkCameraAndStoragePermissionsIsGranted(context)) {

            val cameraIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            cameraIntent.putExtra(
                MediaStore.EXTRA_OUTPUT, imgUri
            )
            grantUriPermissions(context, cameraIntent, imgUri)
            context.startActivityForResult(cameraIntent, requestCode)
        }*/

    }

    private fun grantUriPermissions(activity: FragmentActivity, intent: Intent, imageUri: Uri) {
        val packageManager: PackageManager = activity.packageManager
        val compatibleActivities =
            packageManager.queryIntentActivities(intent, PackageManager.MATCH_DEFAULT_ONLY)
        for (info in compatibleActivities) {
            activity.grantUriPermission(
                info.activityInfo.packageName,
                imageUri,
                Intent.FLAG_GRANT_READ_URI_PERMISSION or Intent.FLAG_GRANT_WRITE_URI_PERMISSION
            )
        }
    }
}