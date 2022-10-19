# Proiect Energy System Etapa 2

## Despre

Proiectare Orientata pe Obiecte, Seriile CA, CD
2020-2021

<https://ocw.cs.pub.ro/courses/poo-ca-cd/teme/proiect/etapa2>

Student: Dumitru Elena-Bianca 324CD

## Rulare teste

Clasa Test#main
  * ruleaza solutia pe testele din checker/, comparand rezultatele cu cele de referinta
  * ruleaza checkstyle

Detalii despre teste: checker/README

Biblioteci necesare pentru implementare:
* Jackson Core 
* Jackson Databind 
* Jackson Annotations

Tutorial Jackson JSON: 
<https://ocw.cs.pub.ro/courses/poo-ca-cd/laboratoare/tutorial-json-jackson>


## Implementare

### Entitati


Clasele folosite sunt aceleasi ca cele din prima parte a proiectului, cu cateva
clase in plus in functie de adaugarile din cerinta.

In pachetul reader, am toate clasele de citire, care contin campurile asa cum
apar ele in fisierele JSON. Acestea vor fi citite cu ObjectMapper, deci nu putem
adauga campuri suplimentare. 
Avem "Consumer", "Distributor" si "Producer" cu clasele care deriva din acestea, respectiv "DistributorChanges" si "ProducerChanges", pentru schimbarile care 
vor inregistrate in "MonthlyUpdates". De asemenea, mai avem clasele 
"InitialData" si "Input" care reprezinta imaginea de ansamblu a intregului fisi-
informational.

Analog, am construit si clasele din pachetul writer, care se ocupa cu scrierea
in fisier. "WriteConsumer", "WriteDistributor" si "WriteProducer" se ocupa cu
formatarea informatiilor necesare/relevante despre entitatile principale. 
Deoarece acestea au in componenta lor si array-uri de alte entitati, am facut si
clasele ajutatoare "WriteContract" pentru contractele distribuitorilor si 
"WriteMonthlyStats" pentru a putea contoriza starea producatorilor.
"WriteOutput" este clasa care incorporeaza toate aceste informatii si va fi 
folosita pentru scriere.

Pe langa aceste clasele si pachete de input/output, am nevoie de alte clase 
pe care le pot formata dupa necesitate.
Asadar, pentru fiecare entitate, am cate un pachet, fiecare desemnat eponim: consumers, distributors si producers.

In fiecare pachet, am cate o implementare de tip factory care permite crearea
unor eventuale variatiuni ale celor 3 entitati pe viitor. Pentru ca acest lucru 
sa fie posibil, fiecare entitate va implementa o interfata care va contine meto-
de comune pentru clasele respective: "ConsumerInterface", "DistributorInterface"
si "ProducerInterface". 
Clasele "Contract" si "MonthlyStats" au fost implementate pentru a putea retine
informatii in clasele de mai sus. 

### Flow


Asemanator cu prima parte a proiectului, derularea simularii va avea loc cu aju-
torul claselor din pachetul stages, in speta clasa "DoStages" care se ocupa de
apelarea metodelor statice din celelalte clase.

Astfel, am impartit simularea in mai multe momente cheie, conform precizarilor
din cerinta. In "DoStages" avem toate instantele entitatilor principale, repre-
zentate prin ArrayList-urile de myConsumers, myDistributors si myProducers.
Acestea vor primi la inceput datele de inceput, pe baza carora se vor desfasura
rundele viitoare.

In prima runda, distribuitorii isi vor alege producatorii in functie de tipul de
strategie pe care o au, pret, cantitate, etc. Acest fapt are loc cu ajutorul me-
todei distributorsChooseProducers din clasa DistributorsAndProducers, clasa me-
nita sa surprinda interactiunile dintre cele 2 entitati. Asadar, in functie de
strategie, in functia respectiva producatorii vor fi prelucrati si sortati
astfel incat sa se respecte prioritatile impuse de strategie.
Calculam costul de productie pentru distributori pentru a putea fi folosit in
viitoarele operatii.
Pentru a putea urmari numarul de producatori de care un distribuitor are nevoie,
trebuie sa monitorizam permanent cantitatea de energie primita odata cu fiecare
producator -> avem campul energyProvided din distributor care trebuie sa fie cel
putin la fel de mult ca energia de care acesta are nevoie.

Pentru celelate luni, la inceput trebuie sa facem update-uri pentru eventualele
modificari: noi consumatori, schimbari de cost sau energie pentru distribuitori
si producatori. Calculam costul de productie pentru distributori.
De asemenea, incepand cu prima luna, trebuie sa contabilizam numarul si id-ul
distribuitorilor unui producator in fiecare etapa a simularii. Cum acest proces
are loc lunar, metoda calculateMonthlyStats din clasa "DoMonthlyUpdates" va face
acest lucru, printr-un update la campul monthlyStats din producer.

In continuare, simularea va urma acelasi curs ca in prima parte a proiectului.
Etapele sunt urmatoarele:
	-> distribuitorii stabilesc suma contractelor prin functia 
	setContractsPrice din clasa "ContractsPrice"
	-> consumatorii isi aleg contractele; functia consumersChooseContract 
	din clasa "ConsumersChooseContracts"
	-> facem un update la lunile contractelor pentru a sti cand expira
	-> stergem contractele expirate; functia removeExpiredContracts din 
	clasa "RemoveBankruptOrExpired"
	-> consumatorii sunt platiti; functia consumersGetPaid din clasa 
	"ConsumerActions"
	-> consumatorii platesc contractul; functia consumersPayContract din 
	clasa "ConsumerActions"
	-> distribuitorii isi primesc banii pentru contracte; functia
	distributorsGetContractMoney din clasa "DistributorsBudget"
	-> distribuitorii isi platesc costurile la producatori, adica doar li se
	extrag bani deoarece producatorii nu contorizeaza profitul; functia
	distributorsPayCosts din clasa "DistributorsBudget"
	-> se elimina consumatorii bankrupt; functia removeBankruptConsumers din
	clasa "RemoveBankruptOrExpired"
	-> se elimina distribuitorii bankrupt si se anuleaza contractele acesto-
	ra; functia removeBankruptDistributorsContracts din clasa 		"RemoveBankruptOrExpired"
	-> daca toti distribuitorii sunt bankrupt, se opreste simularea. Verifi-
	carea se face cu ajutorul functiei ankruptDistributors din clasa
	"RemoveBankruptOrExpired"

Comenzile pentru citirea si scrierea in fisierele JSON au loc in main si se fo-
loseste de toate clasele mentionate mai sus.


### Design patterns


Dupa cum am mentionat mai sus, am folosit design pattern-ul factory pentru a 
crea instantele de consumatori, distribuitori si producatori. Toate acestea sunt
implementate sub forma de singleton deoarece avem nevoie doar de o instanta de
factory si aceasta nu va mai fi modificata in viitor. 

Aceste design pattern-uri au fost mostenite din prima parte a proiectului. 
In aceasta noua parte noutatea se manifeste prin design pattern-urile Strategy 
si Observer.

In mod evident si eficient, Strategy a fost folosit pentru insasi strategia dis-
tribuitorilor de alegere a producatorilor din clasa "DistributorsAndProducers".
Aceasta este implementata direct prin functia distributorsChooseProducers, care,
printr-un switch asigneaza producatorii distribuitorilor in mod corect. Aceasta 
triaza producatorii in functie de preferintele distribuitorilor si apoi apeleaza
functia assignProducersToDistributors pentru a face legaturile propriu-zise.

Observer a fost folosit in cazul update-urilor producatorilor. In acest caz, 
distribuitorii trebuie sa-si gaseasca un nou producator, deci ei vor trebui
stersi din listele de distribuitori ale producatorilor cu care au un contract.
Astfel, in clasa "DoMonthlyUpdates", vom implementa acest design pattern. Pentru
fiecare distributor care trebuie sa-si reinnoiasca contractul, vom notifica toti
producatorii cu care avea contract pana acum. Deci, distributorul este Subject,
iar producatorii sunt Observerii.
Pentru a le transmite informatia, apelam functia notifyAllObservers care, mai
departe, va apela functia update pentru fiecare Observer in parte. Functia 
update sterge distribuitorul din lista de distribuitori a producatorului 
respectiv.



### Dificultati intalnite, limitari, probleme


Pentru a rezolva erorile de checkstyle, am reformatat codul in functie de fisi-
erul checkstyle-idea.xml si am facut parametrii functiilor final.

Am desemnat variabile final si statice pentru a evita eventuale hardcodari. De
exemplu, pentru impartirea la 10 din formula costului de productie, mi-am luat
variabila "rivate static final double DIVISOR = 10".

Am pus elemente JavaDoc pentru a explica constructia si functionalitatea functi-
ilor. In rest, nu am mai intampinat alte erori de checkstyle.

