import java.io.IOException;
import java.net.*;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class GameServer extends Thread{
    private DatagramSocket socket;

    public GameServer() throws SocketException {
        this.socket = new DatagramSocket(1331);
    }

    public void run() {
        while(true){
            byte[] data = new byte[1024];
            DatagramPacket packet = new DatagramPacket(data,data.length);
            try {
                socket.receive(packet);
            } catch (IOException e) {
                e.printStackTrace();
            }

            System.out.println("Client ["+packet.getAddress().getHostAddress() + "] : " + packet.getPort() + " > " + new String(packet.getData()));
            String message = new String(packet.getData()).trim();
            if(message.trim().equalsIgnoreCase("ping")){
                try {
                    sendData("Pong".getBytes(StandardCharsets.UTF_8),packet.getAddress(),packet.getPort());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
    }

    public void sendData(byte[] data, InetAddress ipAddress , int port) throws IOException {
        DatagramPacket packet = new DatagramPacket(data,data.length,ipAddress,port);
        socket.send(packet);
    }
}
