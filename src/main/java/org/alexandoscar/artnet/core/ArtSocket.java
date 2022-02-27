package org.alexandoscar.artnet.core;

import java.io.IOException;
import java.net.*;

public class ArtSocket {

    DatagramSocket Socket;
    int port = 6454;
    InetAddress ArtPollAddress = InetAddress.getByName("2.255.255.255");

    public ArtSocket() throws SocketException, UnknownHostException {
        this.Socket = new DatagramSocket();
    }
    public void sendPacket(DatagramPacket _packet) throws IOException {
        this.Socket.send(_packet);
    }
}
