package org.alexandoscar.artnet.core;

import java.io.IOException;
import java.net.*;

public class ArtSocket {

    DatagramSocket Socket;

    public ArtSocket() throws SocketException, UnknownHostException {
        this.Socket = new DatagramSocket();
    }

    public void sendPacket(DatagramPacket _packet) throws IOException {
        this.Socket.send(_packet);
    }
}
