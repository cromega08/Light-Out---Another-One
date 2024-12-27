package cromega.studio.light.out

import android.os.Build
import cromega.studio.light.out.utils.enums.Platforms
import cromega.studio.light.out.utils.interfaces.Functionalities

class AndroidFunctionalities : Functionalities
{
    override val platform: Platforms = Platforms.ANDROID
}

actual fun getFunctionalities(): Functionalities = AndroidFunctionalities()