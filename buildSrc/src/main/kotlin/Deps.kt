
object Versions {
    const val androidx_constraintLayout = "2.0.0-alpha2"
    const val arch_navigationFragment = "1.0.0"
    const val arch_navigationUi = "1.0.0"
    const val test_junit = "4.12"
    const val androidx_junit = "1.1.1"
    const val androidx_espressoCore = "3.2.0"
}

object Deps {
    const val test_junit = "junit:junit:${Versions.test_junit}"

    // <editor-fold desc="arch">
    const val arch_navigationFragment = "android.arch.navigation:navigation-fragment:${Versions.arch_navigationFragment}"
    const val arch_navigationUi = "android.arch.navigation:navigation-ui:${Versions.arch_navigationUi}"
    // </editor-fold>

    const val androidx_constraintLayout = "androidx.constraintlayout:constraintlayout:${Versions.androidx_constraintLayout}"
    const val androidx_junit = "androidx.test.ext:junit:${Versions.androidx_junit}"
    const val androidx_espressoCore = "androidx.test.espresso:espresso-core:${Versions.androidx_espressoCore}"
}