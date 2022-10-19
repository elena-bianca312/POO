package storage;

import dataprocessing.StepCountStrategy;

public class DataAggregator extends Observer{

    StepCountStrategy stepCountStrategy;

    public DataAggregator(DataRepository dataRepository, StepCountStrategy stepCountStrategy) {
        this.dataRepository = dataRepository;
        this.stepCountStrategy = stepCountStrategy;
    }

    @Override
    public void update() {
        System.out.println("Strategy description: " + stepCountStrategy.getStrategyDescription());
        System.out.println("Total number of steps: " + stepCountStrategy.getTotalSteps());
    }
}
