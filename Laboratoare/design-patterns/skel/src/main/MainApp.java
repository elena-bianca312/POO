package main;

import dataprocessing.StepCountStrategy;
import dataprocessing.StepCountStrategyFactory;
import storage.ConsoleLogger;
import storage.DataAggregator;
import storage.DataRepository;
import storage.SensorData;
import storage.ServerCommunicationController;

import java.util.Scanner;

public class MainApp {

    public static void main(String[] args) {

        System.out.println("Choose a strategy: type 'basic or 'filtered");
        Scanner scanner = new Scanner(System.in);
        String strategyType = scanner.next();
        scanner.close();

        DataRepository dataRepository = new DataRepository();
        // TODO: use the StepCountStrategyFactory to create a strategy
        StepCountStrategy stepCountStrategy = StepCountStrategyFactory.getStrategy(strategyType, dataRepository);

        // TODO: add observers to the dataRepository
        // don't forget to provide the strategy to the DataAggregator observer
        dataRepository.getObservers().add(new ConsoleLogger(dataRepository));
        dataRepository.getObservers().add(new ServerCommunicationController(dataRepository));
        dataRepository.getObservers().add(new DataAggregator(dataRepository, stepCountStrategy));

        // TODO: uncomment
        long baseTimestamp = System.currentTimeMillis();

        dataRepository.addData(new SensorData(10, baseTimestamp + 1));
        System.out.println();

        dataRepository.addData(new SensorData(20, baseTimestamp + 2));
        System.out.println();

        dataRepository.addData(new SensorData(30, baseTimestamp + 3));
        System.out.println();

        // TODO: after the first successful run, change this to baseTimestamp + 40000 and check the result
        dataRepository.addData(new SensorData(4000, baseTimestamp + 4));
        System.out.println();

        dataRepository.addData(new SensorData(50, baseTimestamp + 5));
        System.out.println();

        dataRepository.addData(new SensorData(-100, baseTimestamp + 6));
        System.out.println();

        dataRepository.addData(new SensorData(500, baseTimestamp + 600));
        System.out.println();

    }
}
