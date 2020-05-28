package com.pandulapeter.beagle

import com.pandulapeter.beagle.implementation.BottomSheetUiManager
import com.pandulapeter.beagle.shared.contracts.BeagleContract
import com.pandulapeter.beagle.core.BeagleImplementation

/**
 * Bottom sheet UI implementation to be used in internal builds. See [BeagleContract] for function documentation.
 */
@Suppress("unused")
object Beagle : BeagleContract by BeagleImplementation(BottomSheetUiManager())