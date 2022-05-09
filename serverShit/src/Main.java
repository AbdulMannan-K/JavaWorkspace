import javax.swing.*;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Main {

    private static GameClient socketClient;
    private static GameServer socketServer;

    public static void main(String[] args) throws IOException {

        System.out.println("Do you want to run the server : ");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        if(choice==0){
            socketServer = new GameServer();
            socketServer.start();
        }


        socketClient = new GameClient("localhost");
        socketClient.start();


        socketClient.sendData("ping".getBytes(StandardCharsets.UTF_8));
    }

}
