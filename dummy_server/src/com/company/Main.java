package com.company;

import javax.xml.crypto.Data;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        new DummyServer(8000).start();
    }
}

class DummyServer extends Thread {
    DummyServer(int port) throws IOException {
        this.socket = new ServerSocket(port);
    }

    private final ServerSocket socket;
    private Socket client;

    private DataInputStream inputStream;
    private DataOutputStream outputStream;

    public void run() {
        while (true) {
            final var packet = new DatagramPacket(new byte[1024], 1024);

            if (client == null) {
                try {
                    client = socket.accept();
                    inputStream = new DataInputStream(client.getInputStream());
                    outputStream = new DataOutputStream(client.getOutputStream());
                } catch (IOException e) {
                    e.printStackTrace();
                    break;
                }
            } else {
                try {
                    System.out.println(inputStream.readUTF());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

//public class GameServer extends Thread {
////    private DatagramSocket socket;
////    private ArrayList<Account> connectedAccounts = new ArrayList<>();
////    private int desiredWindows =0;
//
//    public GameServer() throws SocketException {
//        this.socket = new DatagramSocket(1441);
//    }
//
//    public void run() {
//        while (true) {
//            byte[] data = new byte[1024];
//            DatagramPacket packet = new DatagramPacket(data, data.length);
//            try {
//                socket.receive(packet);
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//
//            try {
//                parsePacket(packet.getData(), packet.getAddress(), packet.getPort());
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
////            System.out.println("Client ["+packet.getAddress().getHostAddress() + "] : " + packet.getPort() + " > " + new String(packet.getData()));
////            String message = new String(packet.getData()).trim();
////            if(message.trim().equalsIgnoreCase("ping")){
////                try {
////                    sendData("Pong".getBytes(),packet.getAddress(),packet.getPort());
////                } catch (IOException e) {
////                    e.printStackTrace();
////                }
////            }
//
//        }
//    }
//
//    public void parsePacket(byte[] data, InetAddress address, int port) throws IOException {
//        String message = new String(data).trim();
//        Packet.PacketTypes type = Packet.lookupPacket(message.substring(0, 2));
//        switch (type) {
//            case INVALID -> {
//
//            }
//            case LOGIN -> {
//                Packet00Login packet = new Packet00Login(data);
//                System.out.println("[" + address.getHostAddress() + ":" + port + " ] " + packet.getUserName() + " has connected (Server Class)");
//                for (Account account : AllData.accounts) {
//                    if (account.getUserName().equals(packet.getUserName())) {
////                        account.setIpAddress(address);
////                        account.setPort(port);
////                        this.connectedAccounts.add(account);
//                        account.setPort(port);
//                        account.setIpAddress(address);
//                        this.addConnection(account, packet);
////                        BoardInfo game = new BoardInfo();
////                        game.setPlayerOne(account);
////                        game.startGame();
//                        break;
//                    }
//                }
//
//                if (connectedAccounts.size() == 1) {
//                    BoardInfo game = new BoardInfo();
//
//                    game.setPlayerOne(connectedAccounts.get(0));
//                    game.startGame();
//                }
//                if (connectedAccounts.size() == 2) {
//                    BoardInfo game = new BoardInfo();
//
//                    game.setPlayerOne(connectedAccounts.get(0));
//                    game.setPlayerTwo(connectedAccounts.get(1));
//                    game.startGame();
//                    currentThread().stop();
//                }
//            }
//            case DISCONNECT -> {
//
//            }
//        }
//
//    }
//
//    public void addConnection(Account player, Packet00Login packet) throws IOException {
//        boolean alreadyConnected = false;
//        for (int i = 0; i < connectedAccounts.size(); i++) {
//            if (player.getUserName().equalsIgnoreCase(connectedAccounts.get(i).getUserName())) {
//                if (connectedAccounts.get(i).getIpAddress() == null)
//                    connectedAccounts.get(i).setIpAddress(player.getIpAddress());
//                if (connectedAccounts.get(i).getPort() == -1)
//                    connectedAccounts.get(i).setPort(player.getPort());
//                alreadyConnected = true;
//            } else {
//                sendData(packet.getData(), connectedAccounts.get(i).getIpAddress(), connectedAccounts.get(i).getPort());
//            }
//        }
//        if (!alreadyConnected) {
//            this.connectedAccounts.add(player);
//            packet.writeData(this);
//        }
//    }
//
//    public void sendData(byte[] data, InetAddress ipAddress, int port) throws IOException {
//        DatagramPacket packet = new DatagramPacket(data, data.length, ipAddress, port);
//        socket.send(packet);
//    }
//
//    public void sendDataToAllClients(byte[] data) throws IOException {
//        for (Account account : connectedAccounts)
//            sendData(data, account.getIpAddress(), account.getPort());
//    }
//}