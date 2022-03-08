# Áttekintés
Ez a leírás alapvető információkat tartalmaz a MOBSEC17 Kft. intuitív otthon rendszer vezérlő komponenseinek kezelésére Android operációs rendszeren.
Az Android vezérlőalkalmazás és a kontrollermodul közötti kapcsolatot helyi hálózaton TCP/IP kommunikációval javasolt megvalósítani.
A kontroller egy TCP szervert futtat, amire akár több Android TCP kliens is tud csatlakozni. Fontos, hogy ez a két eszköz (egy vezérlőpanel, illetve Android operációs rendszert futtató okostelefon(ok)) egy helyi hálózatra legyen(ek) csatlakoztatva. A kontroller DHCP szerveren keresztül kap IP címet a helyi hálózatban, IP címe pedig megtekinthető a router web-es felületén.


# ControllerInterface
A vezérlő eszközt a helyi hálózathoz kell csatlakoztatni hálózati kábellel. Az eszköz IP címét egy webböngészőbe beírva eljuthatunk az eszköz konfigurálási felületére, ahol alapvető beállításokat lehet konfigurálni.
A vezérlő interfész alap végpontja: “*ESZKÖZ IP CÍME*/outs.cgi”, pl: http://192.168.200.200/outs.cgi. Amennyiben egy darab eszközzel rendelkezünk, az elérhető (a helyi hálózatra történő csatlakoztatás után) a http://ac11 webcímen. A "Lekérdezés paraméter" oszlopban az "r" mint relé, az "o" mint digitális kimenet(output) szerepel. A következő táblázat "Példa" oszlopa csak egy db, a helyi hálozaton lévő eszközre vonatkozik. A vezérlő interfészhez a következő lekérdezés paramétereket lehet hozzáadni:


| Lekérdezés paraméter              | Lehetséges értékek           | Leírás                                        | Példa                        |
| ----------------------------------|:----------------------------:| ---------------------------------------------:|-----------------------------:|
| <nincs lekérdezés paraméter>      | ---                          | Visszaadja a jelenlegi értéket (leolvasás).   | http://ac11/outs.cgi         |
| r                                 | 0 (hamis), 1 (igaz)          | Relék kapcsolása                              | http://ac11/outs.cgi?r=8&v=1 |
| o                                 | 0 (hamis), 1 (igaz)          | Digitális kimenet kapcsolása                  | http://ac11/outs.cgi?o=8&v=1 |



# ControllerUtil
A ControllerUtil.java osztály alapmetódusai lehetőséget nyújtanak a vezérlő különféle adatainak lekérdezésére, ilyen például a relék állása, digitális kimenet állása.


# ControllerResponseModel
A válasz minden esetben egy JSON-file lesz és mindig pontosan az, amint a sima lekérdezésnél is visszakapnánk, azaz a kontroller elküldi az összes relé, digitális kimenet, számláló aktuális állását. Ebben a válasz JSON objektumban lekérhető a kontroller input-ja { getInputs() }, output-ja { getOutputs() }, illetve a számlálók állapotai is { getCounters() }.


# ConverterUtil
A getRelay()-ből visszakapott adat egy hexadecimális szám, amelyet át kell konvertálni. Ehhez nyújt segítséget a ConverterUtil osztály, amelyben különböző metódusok segítségével nyílik lehetőség különböző formátumra konvertálni a hexadecimális számokat. A számlálók 0-7-ig adnak vissza értékeket (integer).
Input, output és reléállások. Az érték úgy érkezik, hogy a lekapcsolt állapot értéke 0, a felkapcsolt állapoté 2^helyiérték, majd ezeket össze kell adni. Tehát a 0. kapcsoló értéke 1, az 1. kapcsolóé 2, a 2. kapcsolóé 4 és így tovább... Mindezt hexadecimális alakban.


# DTO-k
- ControllerResponseModel
- ControlUnit
- Device
- DeviceControlModel
- DeviceType

# ExampleCall
Ez az osztály tartalmaz egy mintha hívást, amiben egy adott kontroller aktuális adatait kérdezzük le.
