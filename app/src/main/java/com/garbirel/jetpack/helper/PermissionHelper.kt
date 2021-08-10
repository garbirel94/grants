import android.Manifest
import android.content.Context
import androidx.core.content.PermissionChecker
import androidx.core.content.PermissionChecker.PERMISSION_GRANTED
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import com.tbruyelle.rxpermissions3.RxPermissions
//import io.reactivex.rxjava3.core.Observable
import java.lang.RuntimeException
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine


object PermissionHelper {
    /*fun deviceInfoPermission(fragment: Context): Observable<Boolean> {
        return getRxPermissions(fragment).request(
            *mutableListOf(
                Manifest.permission.READ_EXTERNAL_STORAGE,
                Manifest.permission.WRITE_EXTERNAL_STORAGE,
                Manifest.permission.READ_CONTACTS,
                Manifest.permission.ACCESS_FINE_LOCATION,
                Manifest.permission.ACCESS_COARSE_LOCATION,
                Manifest.permission.READ_PHONE_STATE
            ).toTypedArray()
        )
    }*/

    private fun getRxPermissions(fragment: Context): RxPermissions {
        return when (fragment) {
            is Fragment -> {
                RxPermissions(fragment)
            }
            is FragmentActivity -> {
                RxPermissions(fragment)
            }
            else -> {
                throw RuntimeException("只支持2种类型")
            }
        }
    }

    /*suspend fun requestPermission(context: Context, vararg permissions: String): Boolean {
        return suspendCoroutine {
            getRxPermissions(context).request(
                *permissions
            ).subscribe { result ->
                it.resume(result)
            }
        }
    }

    suspend fun deviceInfoPermissionAwait(fragment: Context): Boolean {
        return suspendCoroutine {
            deviceInfoPermission(fragment).subscribe { result ->
                it.resume(result)
            }
        }
    }*/

    /**
     * 判断app是否拥有这些权限
     */
    fun checkProductPermissionIsOpenAwait(fragment: Context): Boolean {
        return checkPermissionIsOpenAwait(
            fragment,
            mutableListOf(
                Manifest.permission.READ_EXTERNAL_STORAGE,
                Manifest.permission.WRITE_EXTERNAL_STORAGE,
                Manifest.permission.READ_CONTACTS,
                Manifest.permission.ACCESS_FINE_LOCATION,
                Manifest.permission.ACCESS_COARSE_LOCATION,
                Manifest.permission.READ_PHONE_STATE
            ).toTypedArray()
        )
    }

    private fun checkPermissionIsOpenAwait(
        fragment: Context,
        permissions: Array<out String>
    ): Boolean {
        return permissions.firstOrNull {
            PermissionChecker.checkSelfPermission(
                fragment,
                Manifest.permission.READ_CONTACTS
            ) != PERMISSION_GRANTED
        } == null
    }


    /**
     * 检查某个权限是否被申请
     *
     * @param activity
     */
    fun checkPermissionsIsGranted(activity: FragmentActivity): Boolean {
        val permissions = RxPermissions(activity)
        permissions.setLogging(true)
        return permissions.isGranted(
            Manifest.permission.WRITE_EXTERNAL_STORAGE
        )
    }

    /**
     *
     *
     * @param activity
     */
    /*suspend fun checkCameraAndStoragePermissionsIsGranted(activity: FragmentActivity): Boolean {
        val permissions = RxPermissions(activity)
        permissions.setLogging(true)
        return suspendCoroutine {
            RxPermissions(activity).request(
                Manifest.permission.CAMERA,
                Manifest.permission.WRITE_EXTERNAL_STORAGE,
                Manifest.permission.READ_EXTERNAL_STORAGE
            ).subscribe { result ->
                it.resume(result)
            }

        }

    }*/
}