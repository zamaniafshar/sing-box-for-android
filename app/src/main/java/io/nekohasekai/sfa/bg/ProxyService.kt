package io.nekohasekai.sfa.bg

import android.app.Service
import android.content.Intent
import io.nekohasekai.libbox.LocalDNSTransport
import io.nekohasekai.libbox.Notification
import io.nekohasekai.libbox.StringIterator

class ProxyService : Service(), PlatformInterfaceWrapper {

    private val service = BoxService(this, this)
    
    override fun localDNSTransport(): LocalDNSTransport = LocalResolver
    
    override fun systemCertificates(): StringIterator? = null

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int) =
        service.onStartCommand()

    override fun onBind(intent: Intent) = service.onBind()
    override fun onDestroy() = service.onDestroy()

    override fun writeLog(message: String) = service.writeLog(message)

    override fun sendNotification(notification: Notification) =
        service.sendNotification(notification)

}