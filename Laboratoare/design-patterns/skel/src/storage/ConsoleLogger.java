package storage;

public class ConsoleLogger extends Observer{

    public ConsoleLogger(DataRepository dataRepository) {
        this.dataRepository = dataRepository;
    }

    @Override
    public void update() {
//        System.out.println("Changes: ");
//        if(dataRepository.getNewData() != null) {
//            for(SensorData sensorData : dataRepository.getNewData()) {
//                System.out.println(sensorData.toString());
//            }
//        }
        System.out.println("Changes: " + dataRepository.getNewData().get(dataRepository.getNewData().size() - 1));
    }
}
