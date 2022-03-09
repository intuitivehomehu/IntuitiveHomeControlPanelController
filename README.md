# Áttekintés

Ez a leírás a MOBSEC17 Kft., intuitív otthon nevű rendszerének vezérlő panele és Android alkalmazások közötti kommunikációhoz ad segítséget. A MOBSECT17 Kft. a nyílt forráskódú Android API gyűjteményt azon fejlesztőknek szánja, akik az intuitive home vezérlő panellel saját fejlesztésű mobiltelefonos alkalmazást szeretnének fejleszteni.

Az intuitive home vezérlőpanel egy LAN kapcsolattal és I/O portokkal rendelkező vezérlő panel, szabály alapú automatizálási funkciókkal. A nyílt forráskódú komponensként publikált programcsomag a LAN kapcsolaton keresztüli I/O kezelést valósítja meg. 

Az intuitive home vezérlőpanel és az Android alapú mobil eszköz közötti kapcsolatot TCP/IP kommunikáció biztosítja. Jelen programcsomag olyan alkalmazások fejlesztésre alkalmas, melyek a vezérlő panellel egy helyi hálózatban működő Android eszközön futtathatóak. A vezérlő panel egy TCP szervert futtat, amire akár több kliens, így akár több Android alapú eszköz is tud egyszerre kapcsolódni. Az intuitive home vezérlő panel DHCP szolgáltatáson keresztül kap IP címet a helyi hálózatban, IP címe pedig megtekinthető a router web-es felületén, illetve javasoljuk, hogy a vezérlő panel MAC címe alapján fix IP cím szabályt állítsunk be a routeren. Így egy helyi hálózatban akár több intuitive home vezérlő panel is telepíthető. Amennyiben fix IP címet osztunk ki az intuitive home vezérlőpanelnek, akkor a mobilalkalmazásban erre a fix IP-címre küldjük az üzeneteket. Amennyiben DHCP-vel kapott dinamikus IP címet a vezérlő panel, akkor a http://ac11 címen érhető el a helyi hálózatban a vezérlő panel, de ebben az esetben egy helyi hálózatban csak egy vezérlőpanel telepíthető. 

A vezérlő panel funkciói közül az I/O kezelést valósítja meg jelen programcsomag. A vezérlőpanel 4 relé kimenettel rendelkezik, amelyek maximum 24V feszültségű és maximum 1A áramerősségű kapcsolás tudnak átengedni magukon. A panelen további 4 darab 12V egyenáramú vezérlési kimenet (szárazkontaktus) van, melyek külső relék működtetésére alkalmasak, jelentős teljesítményt nem tudnak átereszteni. 
A panelen található 8 db szárazkontaktus bemenet is, melyek mindegyike 2 byte-os számlálóval is el van látva. A számlálók állását minden felkapcsolásból, le kapcsolásba állapot váltás eggyel növeli és a vezérlőpanel újraindításával a számlálók nullázhatóak. Jelen programcsomag az alábbi funkciókat implementálja:

- 1. relé kimenet fel és le kapcsolása
- 2. relé kimenet fel és le kapcsolása
- 3. relé kimenet fel és le kapcsolása
- 4. relé kimenet fel és le kapcsolása

- 1. szárazkontaktus kimenet fel és le kapcsolása
- 2. szárazkontaktus kimenet fel és le kapcsolása
- 3. szárazkontaktus kimenet fel és le kapcsolása
- 4. szárazkontaktus kimenet fel és le kapcsolása

- 1. szárazkontaktus bemenet aktuális állapotának lekérdezése
- 2. szárazkontaktus bemenet aktuális állapotának lekérdezése
- 3. szárazkontaktus bemenet aktuális állapotának lekérdezése
- 4. szárazkontaktus bemenet aktuális állapotának lekérdezése
- 5. szárazkontaktus bemenet aktuális állapotának lekérdezése
- 6. szárazkontaktus bemenet aktuális állapotának lekérdezése
- 7. szárazkontaktus bemenet aktuális állapotának lekérdezése
- 8. szárazkontaktus bemenet aktuális állapotának lekérdezése

- 1. szárazkontaktus bemenet aktuális számláló állásának lekérdezése
- 2. szárazkontaktus bemenet aktuális számláló állásának lekérdezése
- 3. szárazkontaktus bemenet aktuális számláló állásának lekérdezése
- 4. szárazkontaktus bemenet aktuális számláló állásának lekérdezése
- 5. szárazkontaktus bemenet aktuális számláló állásának lekérdezése
- 6. szárazkontaktus bemenet aktuális számláló állásának lekérdezése
- 7. szárazkontaktus bemenet aktuális számláló állásának lekérdezése
- 8. szárazkontaktus bemenet aktuális számláló állásának lekérdezése

A vezérlő panelt kezelő programcsomag használatához szükségünk lesz egy natív Android alkalmazás fejlesztő környezetre. Jelen forráskód csomag egy importálható projekt, amely tartalmazza a vezérlőpanel kezeléséhez szükséges alap Java osztályokat. Szükség esetén a meglévő osztályok igény szerint átírhatóak, bővíthetőek. 

# ControllerInterface

Az interfész működéséhez a vezérlő panelt a helyi hálózathoz kell csatlakoztatni hálózati kábellel. A vezérlő interfész végpontja: “ESZKÖZ IP CÍME/outs.cgi”, pl: http://192.168.200.200/outs.cgi URL-en érhető el. Amennyiben egy darab vezérlő panel kapcsolódik csak a helyi hálózathoz, akkor az interfész végpontja elérhető a http://ac11/outs.cgi webcímen. A végpont meghívható paraméterek nélkül és paraméterezve is. A végpont hívás paramétere az reléket és a szárazkontaktus kimeneteket képes vezérelni. A végpont válasza a be- és kimenet aktuális adatait tartalmazza bináris formában. 
A végpont paraméterében az "r" mint relé, az "o" mint digitális száraz kontaktus kimenet (output) szerepelhet. A beállítani kívánt érték a kiment állapotát írja le és a hívásban a v paraméter értékeként lehet átadni. A v paraméter értéke lehet 0 vagy 1. A v paraméter 0 értéke azt jelenti, hogy a kiment off (szakadás) állapotba kerül. A v paraméter 1 értéke azt jelenti, hogy a kimenet on (rövidzár) állapotba kerül.
A következő táblázat "Példa" oszlopa csak egy db, a helyi hálózaton lévő eszközre vonatkozik. A vezérlő interfészhez a következő lekérdezés paramétereket lehet hozzáadni:

|
| Lekérdezés paraméter              | Lehetséges értékek           | Leírás                                        | Példa                        |
| ----------------------------------|:----------------------------:| ---------------------------------------------:|-----------------------------:|
| <nincs lekérdezés paraméter>      | ---                          | Visszaadja a jelenlegi értéket (leolvasás).   | http://ac11/outs.cgi         |
| r                                 | 0 (off), 1 (on)              | Relék kapcsolása                              | http://ac11/outs.cgi?r=8&v=1 |
| o                                 | 0 (off), 1 (on)              | Digitális kimenet kapcsolása                  | http://ac11/outs.cgi?o=8&v=1 |


A végpont válasz minden esetben egy JSON struktúrájú string lesz. A JSON feldolgozására a programcsomag biztosítja a szükséges metódusokat. A vezérlőpanel válaszában, nem csak az aktuálisan vezérelt kiment aktuális állapot szerepel hanem a vezérlőpanel minden ki- és bementének aktuális adata szerepel.
A válaszban kapott relé állapotok egy bájton vannak leírva. A válaszban kapott 1 bájt adatot bináris tartalom ként kell feldolgozni.  Minden relé állapotát egy dedikált bit tartalmazza. 

Ide kell egy táblázat 
relé aktuális állapota: jobbról az 1. bit 
relé aktuális állapota: jobbról az 2. bit
relé aktuális állapota: jobbról az 3. bit
relé aktuális állapota: jobbról az 4. bit
Ugyan ezt le kell írni és táblázat kell inputra és outputra.
A számlálók aktuális állását a JSON válasz utolsó „cnt” tagja tartalmazza.

Az egyes inputok számlálók állását decimális formátumban, vesszővel elválasztva, balról az 1. inputtól indulva sorolja fel a válasz.

# ControllerUtil
A ControllerUtil.java osztály alapmetódusai lehetőséget nyújtanak a vezérlő adatainak lekérdezésére, ilyen például a kontroller csatornájának lekérdezése (relé vagy digitális kimenet) és számának lekérdezése.
 
 
```
public static String getControllerChannel(Integer channel) {
   return channel > 4 ? "o" : "r";
}
public static Integer getControllerChannelNumber(Integer channel) {
   return channel > 4 ? channel - 4 : channel;
}
```
 
# ControllerResponseModel
A válasz minden esetben egy JSON adatstruktúra lesz és mindig pontosan az, amit a paraméter nélküli hívással is visszakapnánk, azaz a kontroller elküldi az összes relé, digitális kimenet, számláló aktuális állását. Ebben a válasz JSON objektumban lekérhető a kontroller input-ja { getInputs() }, output-ja { getOutputs() }, illetve a számlálók állapotai is { getCounters() }.
```
public String getInputs() {
   return inputs;
}
public String getOutputs() {
   return outputs;
}
public List<Long> getCounters() {
   return counters;
}
 
```
 
# DTO-k
ControllerResponseModel - vezérlőpanel bemeneteinek, kimeneteinek, relék on vagy off állását és a számlálók állapotát tartalmazza
ControlUnit - a panel azonosítóját, IP címét, szériaszámát tartalmazza
Device - a vezérlőpanelhez csatlakoztatott eszközök adatait tartalmazza
DeviceType - az eszköz típusának meghatározására szolgál, pl: Bluetooth kapcsolatra képes-e, mi az eszköz azonosítója
 
# ExampleCall
Ez az osztály tartalmaz egy mintha hívást, amiben egy adott kontroller aktuális adatait kérdezzük le.

# Licensz: GPLv3
Copyright (C) 2019 Mobsec17 Kft.
 
This program is free software: you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.
 
This program is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.
 
You should have received a copy of the GNU General Public License
along with this program.  If not, see <https://www.gnu.org/licenses/>.

