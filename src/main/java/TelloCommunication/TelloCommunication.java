package TelloCommunication;

import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.List;
import java.util.Map;

public class TelloCommunication {


    private DatagramSocket ds;

    private InetAddress ipAddress;

    private int udpPort;

    public TelloCommunication() throws Exception{
        this.ipAddress=InetAddress.getByName(TelloDroneImpl.IP_Address);
        this.udpPort= TelloDroneImpl.UDP_PORT;
    }

    public boolean connect() throws Exception{
        ds= new DatagramSocket(udpPort);
        ds.connect(ipAddress,udpPort);
        return true;
    }

    public boolean executeCommand(final TelloCommand telloCommand){
        if(telloCommand==null){
            System.out.println("Tello command was null");
            return  false;
        }
        if(!ds.isConnected()){
            System.out.println("Tello Drone connection was lost");
            return  false;
        }
        final String command= telloCommand.composeCommand();
        System.out.println("Executing tello command"+command);
        sendData(command);
        String response= receiveData();
        System.out.println("Tello response: "+response);
        return true;
    }
    public Map<String,String> getTelloOnBoardData(List<String> valuesToBeObtained){
        Map<String,String> dataMap= new HasMap<>();
        return dataMap;
    }
    private String executeReadCommand(TelloCommand telloCommand) throws Exception {
        if (telloCommand == null) {
            System.out.println("TelloCommand was null");

        }
        if (!ds.isConnected()) {
            System.out.println("Tello connection lost");

        }

        final String command = telloCommand.composeCommand();
        System.out.println("Executing tello command: " + command);

        try {
            sendData(command);
            String response = receiveData();
            return response;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void executeCommands(List<TelloCommand> telloCommandList) {

    }

    @Override
    public void disconnect() {

    }


    private void sendData(String data) throws IOException {
        byte[] sendData = data.getBytes();
        final DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, ipAddress,
                udpPort);
        ds.send(sendPacket);
    }

    private String receiveData() throws IOException {
        byte[] receiveData = new byte[1024];
        final DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
        ds.receive(receivePacket);
        return trimExecutionResponse(receiveData, receivePacket);
    }

    private String trimExecutionResponse(byte[] response, DatagramPacket receivePacket) {
        response = Arrays.copyOf(response, receivePacket.getLength());
        return new String(response, StandardCharsets.UTF_8);
    }


}

}
