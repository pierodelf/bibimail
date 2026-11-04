package net.thunderbird.android.autodiscovery

import app.k9mail.autodiscovery.api.AuthenticationType
import app.k9mail.autodiscovery.api.AutoDiscovery
import app.k9mail.autodiscovery.api.AutoDiscoveryResult
import app.k9mail.autodiscovery.api.AutoDiscoveryRunnable
import app.k9mail.autodiscovery.api.ConnectionSecurity
import app.k9mail.autodiscovery.api.ImapServerSettings
import app.k9mail.autodiscovery.api.SmtpServerSettings
import net.thunderbird.core.common.mail.EmailAddress
import net.thunderbird.core.common.net.toHostname
import net.thunderbird.core.common.net.toPort

class BibimailAutoDiscovery : AutoDiscovery {
    override fun initDiscovery(email: EmailAddress): List<AutoDiscoveryRunnable> {
        return listOf(
            AutoDiscoveryRunnable {
                if (email.domain.normalized in setOf("bibimail.it")) {
                    AutoDiscoveryResult.Settings(
                        incomingServerSettings = ImapServerSettings(
                            hostname = "imap.bibimail.it".toHostname(),
                            port = 993.toPort(),
                            connectionSecurity = ConnectionSecurity.TLS,
                            authenticationTypes = listOf(AuthenticationType.PasswordCleartext),
                            username = email.address,
                        ),
                        outgoingServerSettings = SmtpServerSettings(
                            hostname = "smtp.bibimail.it".toHostname(),
                            port = 465.toPort(),
                            connectionSecurity = ConnectionSecurity.TLS,
                            authenticationTypes = listOf(AuthenticationType.PasswordCleartext),
                            username = email.address,
                        ),
                        isTrusted = true,
                        source = "BibimailAutoDiscovery",
                    )
                } else {
                    AutoDiscoveryResult.NoUsableSettingsFound
                }
            },
        )
    }
}
