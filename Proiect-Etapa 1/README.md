# Project - Part One (OOP)
# Energy system
# Dumitru Elena Bianca 324CD


## Reading data: 
The input data is provided in the main function through the parameter
args[0], in a JSON format. I decided to read the data using the ObjectMapper 
class because its main functionality is reading and writing JSON and performing
the needed conversions. <br />

Therefore, I created my reader package where I created all the classes 
that are relevant from the input, formatting them by adding only the mentioned
fields. One interesting detail is that the classes (that received certain 
arrays) did not need a special constructor and only needed the default one in 
order to function correctly. <br />

In the classes I also generated getters and setters because all the 
fields are private.


## Writing data:
Similarly to how I read the data, I used ObjectMapper. I created new
classes in the package writer because the output JSON required different information. Therefore, I put the final calculations in the arrays from the 
classes and then everything in the WriteOutput class which would later be used
by the writeValue method of the ObjectMapper function. 


## Factory and Singleton:
I used a factory to generate my instances for Consumers, respectively
Distributors. I chose to do a separate factory for each and not treat them
generally as entities because almost all of their methods and attributes are
different. Thus, this implementation would be efficient in case new consumer or
distributor types are added. <br />

Both factories are singletons because I only need one instance of 
each factory and they are not to be modified in the future


## Implementation:
-> Package reader & writer explained above
-> Package consumers:
  - contains the consumer factory and the interface implemented by
  the class MyConsumer. MyConsumer gets the data from the Consumer
  class where the input is stored and it is where I added extra
  fields and functionalities that are helpful for the simulation.
-> Package distributors:
  - similarly, it contains the factory, the interface and the main
  class whose implementation we are going to use throughout the
  program.
  - I also created the affiliated class Contract because the class
  MyDistributor needs to store an ArrayList of Contracts
-> Package stages:
  - it contains the classes that are responsible for the 
  simulation (most of them have static methods so we do not need
  to instantiate them):
    * AddData: adds consumers or distibutors to the existing
      arrays 
    * ConsumerActions: 2 actions - consumers receive their
      monthly income + consumers pay their contract
    * ConsumersChooseContracts: it contains a static 
      function that allows a consumer to choose a 
      contract depending on certain aspects (explained
      in JavaDoc)
    * ContractsPrice: sets the price for the contracts
    * DistributorsBudget: manages the money for distributors
      it adds the payment from the consumers if there
      is any and pays the monthly costs
    * DoMonthlyUpdates: adds new consumers and changes the
      costs for certain distributors.
    * FindByID: contains certain static function that find
      different entities by their id
    * RemoveBankruptOrExpired: contains 2 static methods
      that manage the contracts for consumers. They
      remove the consumer's contract from the array
      of their distributor's contracts if the consumer
      is bankrupt or has an expired contract.
    * DoStages: the class that orchestrates the simulation
      and calls the adjuvant functions in the correct
      order + has a couple of other helpful functions

## Observations:
The data from the arrays has to be erased at the end of the program
because the checker generates only one instance of the input and the information
would be overwritten.
