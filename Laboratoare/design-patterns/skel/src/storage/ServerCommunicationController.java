package storage;

import communication.ServerMessage;
import main.Utils;

public class ServerCommunicationController extends Observer {

    private ServerMessage serverMessage;

    public ServerMessage getServerMessage() {
        return serverMessage;
    }

    public void setServerMessage(ServerMessage serverMessage) {
        this.serverMessage = serverMessage;
    }

    public ServerCommunicationController(DataRepository dataRepository) {
        this.dataRepository = dataRepository;
    }

    @Override
    public void update() {
        SensorData data = dataRepository.getNewData().get(dataRepository.getNewData().size() - 1);
        serverMessage = new ServerMessage(data.getStepsCount(), Utils.getClientId(), data.getTimestamp());
        System.out.println("Server message: " + serverMessage.toString());
    }
}
