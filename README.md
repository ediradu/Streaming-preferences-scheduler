[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-24ddc0f5d75046c5622901739e7c5dd533143b0c8e959d652212380cedb1ea36.svg)](https://classroom.github.com/a/le3-5Dzg)
# proiect2023-ediradu
proiect2023-ediradu created by GitHub Classroom
În clasa CitesteFisier citesc fișierele input și le introduc datele în HashMap-uri specifice(de exemplu datele userilor vor fi în userHashMap).
HashMap-urile sunt în clasa Singleton pentru a permite accesul mai multor clase la acelasi obiect pentru a nu fi nevoie să facem mai multe obiecte separate.
Clasa CitesteFisierDecorator folosește design pattern-ul Decorator pentru a adăuga un comportament nou în metoda parcurge care modifică comportamentul clasei CitesteFisier.
Metodei parcurge i se adaugă metoda citesteSiExecutaComanda care folosește design pattern-ul Factory din Clasa ComandaFactory.Aceasta returnează în funcție de string-ul primit
o insanță unei clase de tip Comanda.. .
Clasa Stream conține tipurile de date pentru stream,un constructor și mai multe gettere si settere.
Clasa Streamer conține comenzile pe care le poate avea,pe lângă tipurile de date,constructor,gettere,settere.La fel și clasa  User.
Clasa Util conține 3 metode:una pentru formatul în ore,minute,secunde,una pentru formatul zi,lună,an și una care printează în format Json.
Clasele PiesaMuzicala,Podcast si Audiobook sunt extinderi ale clasei abstracte Stream.Fiecare conține genurile sale.
Clasa StreamFactory are metoda creeazaStreams care creează un obiect în funcție de tipul primit ca parametru și returnează un Stream.Folosește design pattern-ul Factory.
Fiecare clasă Comanda.. conține câte o comandă.Unele dau override la ComandaUser,altele la ComandaStreamer.Pentru realizarea comenzilor s-a folosit ca design pattern Command.
Cele 4 design patterns folosite sunt:Singleton,Decorator,Factory si Command.