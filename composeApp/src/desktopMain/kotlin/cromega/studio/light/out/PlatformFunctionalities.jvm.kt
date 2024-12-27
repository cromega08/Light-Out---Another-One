package cromega.studio.light.out

import cromega.studio.light.out.utils.enums.Platforms
import cromega.studio.light.out.utils.interfaces.Functionalities

class JVMFunctionalities : Functionalities
{
    override val platform: Platforms = Platforms.DESKTOP
}

actual fun getFunctionalities(): Functionalities = JVMFunctionalities()