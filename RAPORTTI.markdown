# Raportit tehtävistä

Kirjaa tähän tiedostoon **jokaiseen** tehtävään liittyvät omat raporttisi ja analyysisi. Muista että raportti on myös kurssilla **arvosteltava tehtävä**.

Voit sisällyttää raporttiin tekstimuotoisia taulukoita (tasaukset välilyönnein):

```
n     Fill     Search   Total
500   7        700      707
1000  9        288      297
```

Ja näihin liittyviä kuvatiedostoja:

![Esimerkkikuva](report-sample-image.png)

Nämä näkyvät sitten VS Coden Preview -näkymässä (tai oman repositorysi webbisivulla) oikein muotoiltuna. Käytä tässä dokumentissa olevia muotoiluja esimerkkinä kun kirjoitat raporttiasi. 

Huomaa että jos laitat kuvatiedostot vaikka omaan alihakemistoonsa, Markdown -muotoilussa on oltava suhteellinen polku tiedostoon, esimerkiksi `images/report-sample-image.png`. **Älä** käytä absoluuttisia polkuja `C:\Users\tippaleipa\kurssit\TIRA\kuva.png`, koska nämä eivät tietenkään toimi opettajan koneella. Ei kannata laittaa linkkiä etärepoosikaan, vaan nimenomaan paikalliseen tiedostoon.

Voit myös sisällyttää *lyhyitä* koodinpätkiä vaikkapa Java -formaatilla:

```Java
	@Override
	public int hashCode() {
		// Oma nerokas hajautufunktioni!
	}
```
Tarvittaessa käytä myös paremmin muotoiltuja taulukoita:

| n	| Fill	| Search	| Total |
|-----|--------|--------|-------|
| 500	 | 7	| 700	| 707 |
| 1000 |	9	| 288	| 297 | 

Alaluvut jokaisen tehtävän raportille löydät alta.


## 01-TASK

Reverse on O(n) aikakompleksisuudeltaan, koska se iteroi taulukon läpi vain kerran.
Insertion sort on O(n^2)

Jos järjestelty taulukko pitää reversaa, niin reversaamalla se on nopeampi, koska reverse on O(n) ja Insertionsort on O(n^2)

## 02-TASK

| n     | F (ms) | S (us) | Total (ms) |
|-------|--------|--------|------------|
| 1000  | 10     | 1066   | 11         |
| 2000  | 7      | 715    | 7          |
| 3000  | 13     | 1021   | 14         |
| 4000  | 21     | 264    | 21         |
| 5000  | 34     | 753    | 34         |
| 6000  | 48     | 96     | 48         |
| 7000  | 61     | 113    | 61         |
| 8000  | 82     | 138    | 82         |
| 9000  | 102    | 154    | 102        |
| 10000 | 126    | 177    | 126        |
| 11000 | 153    | 201    | 153        |
| 12000 | 183    | 223    | 183        |
| 13000 | 200    | 167    | 200        |
| 14000 | 246    | 270    | 246        |
| 15000 | 280    | 303    | 280        |
| 16000 | 332    | 314    | 332        |
| 17000 | 375    | 318    | 375        |
| 18000 | 421    | 332    | 421        |
| 19000 | 471    | 371    | 471        |
| 20000 | 522    | 391    | 522        |
| 21000 | 581    | 400    | 581        |
| 22000 | 641    | 429    | 641        |
| 23000 | 698    | 445    | 698        |
| 24000 | 759    | 475    | 759        |
| 25000 | 826    | 491    | 826        |
| 26000 | 893    | 514    | 893        |
| 27000 | 961    | 541    | 961        |
| 28000 | 917    | 392    | 917        |
| 29000 | 1120   | 581    | 1120       |
| 30000 | 1192   | 602    | 1192       |
| 31000 | 1268   | 625    | 1268       |
| 32000 | 1349   | 650    | 1349       |
| 33000 | 1429   | 668    | 1429       |
| 34000 | 1523   | 688    | 1523       |
| 35000 | 1610   | 709    | 1610       |
| 36000 | 1705   | 729    | 1705       |
| 37000 | 1806   | 757    | 1806       |
| 38000 | 1782   | 711    | 1782       |
| 39000 | 2007   | 790    | 2007       |
| 40000 | 2107   | 821    | 2107       |
| 41000 | 2225   | 828    | 2225       |
| 42000 | 2329   | 846    | 2329       |
| 43000 | 2452   | 868    | 2452       |
| 44000 | 2546   | 883    | 2546       |
| 45000 | 2338   | 638    | 2338       |
| 46000 | 2800   | 927    | 2800       |
| 47000 | 2923   | 955    | 2923       |
| 48000 | 3042   | 968    | 3042       |
| 49000 | 3173   | 990    | 3173       |
| 50000 | 3289   | 1003   | 3290       |

### Sarch time
![Raportti-resources/searchtime.PNG](Raportti-resources/searchtime.PNG)
### Fill time
![Raportti-resources/filltime.PNG](Raportti-resources/filltime.PNG)

Search on O(n). Graafista näkee selvästi, että haku on lineaarinen. Teknisestä näkökulmasta haku toimii iteroimalla koko taulukon läpi vain yhden kerran, kunnes tulos löytyy tai taulukko päättyy.

Fill on O(n * log(n)). Lisäys-fukntio on lineaarinen, ja reallocate-funktio on log(n), sillä kun reallocate funktio aina tuplaa taulukon koon, niin sitä pitää kutsua vähemmän mitä pidemmälle taulukkoa laajennetaan.

Erot suoritusajassa johtuvat varmaan siitä, että kuinka pitkällä taulukossa haluttu data on, koska hakualgoritmi on lineaarinen aikakompleksisuudeltaan.
Jos haluaisin muuttaa järjestetyn taulukon järjestyksen päinvastaiseksi, niin käyttäisin reverse algoritmia. Reversen ei tarvitse tehdä ylimääräisiä tarkastuksia mm. duplikaattien osalta, kun taulukon data on jo niiden osalta kunnossa. Myöskin reverse toimii nykyisessä taulukossa lineearisessa ajassa. Insertion sort on worst- ja average casen mukaan O(n^2), joten reverse on nopeampi.

Lineaarisia algoritmeja kutsutaan lineaarisiksi, koska niiden ajoaika kasvaa samalla tahdilla taulukon koon kanssa. Eksponentiaalisessa algoritmissa ajoaika nousisi eksponentiaalisesti taulukon pituuteen nähden.

Reverse on O(n), sillä algoritmi iteroi taulukon läpi kerran.
Insertion sort on 0(n^2).

## 03-TASK

## 04-TASK

## 05-TASK

## 06-TASK

## 07-TASK

## 08-TASK

## 09-TASK