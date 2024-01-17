package org.jash.zrs13yk.Base

import org.jash.zrs13yk.net.Api
import org.jash.zrs13yk.net.Ret

abstract class BaseRepo {
    fun getApi():Api=Ret.getRet().create(Api::class.java)
}