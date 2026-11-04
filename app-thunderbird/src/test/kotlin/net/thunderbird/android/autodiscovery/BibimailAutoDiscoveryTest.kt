package net.thunderbird.android.autodiscovery

import app.k9mail.autodiscovery.api.AuthenticationType
import app.k9mail.autodiscovery.api.AutoDiscoveryResult
import app.k9mail.autodiscovery.api.ConnectionSecurity
import app.k9mail.autodiscovery.api.ImapServerSettings
import app.k9mail.autodiscovery.api.SmtpServerSettings
import assertk.assertThat
import assertk.assertions.isEqualTo
import kotlinx.coroutines.test.runTest
import net.thunderbird.core.common.mail.toUserEmailAddress
import net.thunderbird.core.common.net.toHostname
import net.thunderbird.core.common.net.toPort
import org.junit.Test

class BibimailAutoDiscoveryTest {
    private val testSubject = BibimailAutoDiscovery()

    @Test
    fun `should return Bibimail settings for bibimail it email`() = runTest {
        val result = testSubject.initDiscovery("mario@bibimail.it".toUserEmailAddress()).single().run()

        assertThat(result).isEqualTo(
            AutoDiscoveryResult.Settings(
                incomingServerSettings = ImapServerSettings(
                    hostname = "imap.bibimail.it".toHostname(),
                    port = 993.toPort(),
                    connectionSecurity = ConnectionSecurity.TLS,
                    authenticationTypes = listOf(AuthenticationType.PasswordCleartext),
                    username = "mario@bibimail.it",
                ),
                outgoingServerSettings = SmtpServerSettings(
                    hostname = "smtp.bibimail.it".toHostname(),
                    port = 465.toPort(),
                    connectionSecurity = ConnectionSecurity.TLS,
                    authenticationTypes = listOf(AuthenticationType.PasswordCleartext),
                    username = "mario@bibimail.it",
                ),
                isTrusted = true,
                source = "BibimailAutoDiscovery",
            ),
        )
    }

    @Test
    fun `should match Bibimail domain case insensitively`() = runTest {
        val result = testSubject.initDiscovery("Mario@BibiMail.IT".toUserEmailAddress()).single().run()

        assertThat(result).isEqualTo(
            AutoDiscoveryResult.Settings(
                incomingServerSettings = ImapServerSettings(
                    hostname = "imap.bibimail.it".toHostname(),
                    port = 993.toPort(),
                    connectionSecurity = ConnectionSecurity.TLS,
                    authenticationTypes = listOf(AuthenticationType.PasswordCleartext),
                    username = "Mario@BibiMail.IT",
                ),
                outgoingServerSettings = SmtpServerSettings(
                    hostname = "smtp.bibimail.it".toHostname(),
                    port = 465.toPort(),
                    connectionSecurity = ConnectionSecurity.TLS,
                    authenticationTypes = listOf(AuthenticationType.PasswordCleartext),
                    username = "Mario@BibiMail.IT",
                ),
                isTrusted = true,
                source = "BibimailAutoDiscovery",
            ),
        )
    }

    @Test
    fun `should not return settings for other domains`() = runTest {
        val result = testSubject.initDiscovery("mario@gmail.com".toUserEmailAddress()).single().run()

        assertThat(result).isEqualTo(AutoDiscoveryResult.NoUsableSettingsFound)
    }
}
