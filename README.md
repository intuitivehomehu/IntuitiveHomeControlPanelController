# Áttekintés
Ez a leírás alapvető információkat tartalmaz a MOBSEC17 Kft. intuitív otthon rendszer vezérlő komponenseinek kezelésére Android operációs rendszeren.
Az Android vezérlőalkalmazás és a kontrollermodul közötti kapcsolatot helyi hálózaton TCP/IP kommunikációval javasolt megvalósítani.
A kontrolleren kell egy TCP szervert futtatni, amire akár több Android TCP kliens is tud csatlakozni.


# ControllerInterface
A vezérlő interfész alap végpontja: “/outs.cgi”. Ehhez a következő lekérdezés paramétereket lehet hozzáadni:

Lekérdezés paraméter                Lehetséges értékek          Leírás                                                 Példa
-> <nincs lekérdezés paraméter>     -> --                       -> Visszaadja a jelenlegi értéket (leolvasás).         -> http://ac11/outs.cgi
-> r                                -> 0 (hamis), 1 (igaz)      -> Relék kapcsolása                                    -> http://ac11/outs.cgi?r=8&v=1
-> o                                -> 0 (hamis), 1 (igaz)      -> Digitális kimenet kapcsolása                        -> http://ac11/outs.cgi?o=8&v=1


# ControllerUtil
Ennek a segítségével lekérdezhető a kontroller csatronája (o vagy r).


# Válaszok
A válasz minden esetben egy JSON-file lesz és mindig pontosan az, amint a sima lekérdezésnél is visszakapnánk, azaz a kontroller elküldi az összes relé, digitális kimenet, számláló aktuális állását. 


# Számlálók: 0-7
A számlálók 0-7-ig adnak vissza értékeket (integer).
Input, output és reléállások. Az érték úgy érkezik, hogy a lekapcsolt állapot értéke 0, a felkapcsolt állapoté 2^helyiérték, majd ezeket össze kell adni. Tehát a 0. kapcsoló értéke 1, az 1. kapcsolóé 2, a 2. kapcsolóé 4 és így tovább... Mindezt hexadecimális alakban.

# DTO-k
- ControllerResponseModel
- ControlUnit
- Device
- DeviceControlModel
- DeviceType

# ExampleCall
Ez az osztály tartalmaz egy mintha hívást, amiben egy adott kontroller aktuális adatait kérdezzük le.
