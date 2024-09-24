package me.ykrank.s1next.widget.net

import com.github.ykrank.androidtools.widget.hostcheck.BaseDns
import com.github.ykrank.androidtools.widget.hostcheck.BaseHostUrl
import me.ykrank.s1next.data.api.Api
import java.net.InetAddress
import java.net.UnknownHostException

class AppDns(baseHostUrl: BaseHostUrl) : BaseDns(baseHostUrl) {

    private val hosts = listOf(
        "img.saraba1st.com",
        "p.sda1.dev",
    ) + Api.HOST_LIST

    private var hostIpMap: MutableMap<String, List<InetAddress>> = mutableMapOf()

    override fun lookup(hostname: String): List<InetAddress> {
        if (hosts.contains(hostname)) {
            var exception: Exception? = null
            var address: List<InetAddress>? = null
            try {
                address = super.lookup(hostname)
            } catch (e: Exception) {
                exception = e
            }

            return if (address.isNullOrEmpty()) {
                val hostIp = hostIpMap[hostname]
                if (hostIp.isNullOrEmpty()) {
                    if (exception == null) {
                        throw UnknownHostException("Broken system behaviour for DNS lookup of $hostname.")
                    }
                    throw exception
                } else {
                    hostIp
                }
            } else {
                address
            }

        }
        return super.lookup(hostname)
    }
}