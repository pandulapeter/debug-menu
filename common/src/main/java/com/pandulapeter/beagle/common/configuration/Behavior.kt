package com.pandulapeter.beagle.common.configuration

import com.pandulapeter.beagle.common.contracts.BeagleContract
import com.pandulapeter.beagle.commonBase.BeagleLoggerContract
import java.text.SimpleDateFormat
import java.util.Locale

/**
 * Specifies the behavior customization options for the debug menu. All parameters are optional.
 *
 * @param shakeThreshold - The threshold value above which the debug menu will be shown when the user shakes the device. Values between 5 - 20 work best (smaller values result in more sensitive detection). Set to null to disable shake detection. 12 by default.
 * @param excludedPackageNames - The list of packages that contain Activities for which Beagle should not be triggered. Empty by default (however the library also contains a hardcoded list).
 * @param logger - The [BeagleLoggerContract] implementation in case logging is used in a pure Java / Kotlin module.
 * @param screenCaptureServiceNotificationChannelId - The ID for the notification channel that handles all notifications related to screen capture. By default it's "channel_beagle_screen_capture".
 * @param getImageFileName - The lambda used to generate screenshot image file names (without the extension). The default a name will be generated based on the current timestamp.
 * @param getVideoFileName - The lambda used to generate screen recording video file names (without the extension). The default a name will be generated based on the current timestamp.
 */
data class Behavior(
    val shakeThreshold: Int? = 12,
    val excludedPackageNames: List<String> = emptyList(),
    val logger: BeagleLoggerContract? = null,
    val screenCaptureServiceNotificationChannelId: String = "channel_beagle_screen_capture",
    val getImageFileName: () -> String = { "${simpleDateFormat.format(System.currentTimeMillis())}_image" },
    val getVideoFileName: () -> String = { "${simpleDateFormat.format(System.currentTimeMillis())}_video" }
) {

    companion object {
        private val simpleDateFormat by lazy { SimpleDateFormat(BeagleContract.FILE_NAME_DATE_TIME_FORMAT, Locale.ENGLISH) }
    }
}