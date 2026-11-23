# Bibimail per Android

**Bibimail** è l'app di posta elettronica per Android di Bibimail. È basata su Thunderbird per Android, ha il marchio Bibimail e configura da sola i server di posta.

## Download

Scarica [`Bibimail.apk`](Bibimail.apk) da questo repository e aprilo sul telefono per installarlo.

- Serve Android 7.0 o successivo.
- La prima volta Android chiede di permettere l'installazione di app da "origini sconosciute" per il browser o il file manager che stai usando.
- Se è già installata una versione precedente di Bibimail, il nuovo APK la aggiorna senza perdere gli account.

## Cosa fa

### Configurazione automatica dei server

Per aggiungere un account basta inserire **indirizzo email e password**. L'app imposta i server così:

| Tipo di indirizzo | Server usati |
|---|---|
| Grandi provider (Gmail, Outlook/Hotmail, Yahoo, iCloud, Libero, ecc.) | I server del provider, presi dal database dei provider di Thunderbird |
| Tutti gli altri indirizzi (@bibimail.it, domini personalizzati, ecc.) | Server Bibimail / Mobile Mail (vedi sotto) |

Server Bibimail / Mobile Mail, solo con connessioni sicure e certificato valido:

| | Server | Porta | Sicurezza |
|---|---|---|---|
| Posta in arrivo (IMAP) | `imap.mobile-mail.it` | 993 | SSL/TLS |
| Posta in uscita (SMTP) | `smtp.mobile-mail.it` | 465 | SSL/TLS |

Il nome utente è l'indirizzo email completo. Se serve, i server si possono sempre cambiare a mano nelle impostazioni dell'account.

### Funzioni di posta

Le funzioni sono quelle di Thunderbird per Android:

- più account nella stessa app, con casella unificata;
- IMAP con notifiche push, sincronizzazione delle cartelle e ricerca;
- invio e ricezione con allegati, firme e identità multiple;
- crittografia OpenPGP (con app OpenKeychain);
- tema chiaro e scuro, widget e notifiche;
- nessuna pubblicità e nessun tracciamento.

### Marchio Bibimail

- Il nome dell'app è "Bibimail".
- Logo Bibimail nell'icona, nella schermata di benvenuto, nell'app e nelle notifiche.
- La schermata di benvenuto riporta i dati di FABERSOFT.

## Limiti conosciuti

- **Login Google/Microsoft (OAuth)**: il pulsante "Accedi con Google/Microsoft" non funziona, perché è registrato sull'app Thunderbird originale. Con Gmail e Outlook si usa la password oppure una "password per le app".
- I domini personalizzati ospitati da altri provider (per esempio Google Workspace o Microsoft 365) ricevono in automatico i server Mobile Mail e vanno configurati a mano.
- L'APK è una build di test (debug), non è pubblicato sul Play Store.

## Licenza

L'app è basata su [Thunderbird per Android](https://github.com/thunderbird/thunderbird-android), distribuito con licenza Apache 2.0.

## Contatti

FABERSOFT di Burattini Gabriele & C. S.n.c.
Piazzale Matteotti, 21 – 60044 Fabriano (AN)
P.IVA 02082390424
Tel. 0732 070205 – info@fabersoft.it
[www.fabersoft.it](https://www.fabersoft.it)
