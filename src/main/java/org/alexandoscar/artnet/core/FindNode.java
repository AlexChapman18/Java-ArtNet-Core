package org.alexandoscar.artnet.core;

import java.io.IOException;
import java.net.DatagramPacket;

public class FindNode {

    public static void main(String[] args) throws IOException {
        ArtPacket ArtPollPacket = new ArtPoll();
        DatagramPacket rawPacketOne = new DatagramPacket(ArtPollPacket.getPacket(), 0, ArtPollPacket.packetLength, ArtPacket.ArtAddress, ArtPacket.port);

        ArtTod ArtTodPacket = new ArtTod();
        ArtTodPacket.setAddress();
        DatagramPacket rawPacketTwo = new DatagramPacket(ArtTodPacket.getPacket(), 0, ArtTodPacket.packetLength, ArtPacket.ArtAddress, ArtPacket.port);

        ArtPollPacket.setByte(12, (byte) 0x00);
        DatagramPacket rawPacketThree = new DatagramPacket(ArtPollPacket.getPacket(), 0, ArtPollPacket.packetLength, ArtPacket.ArtAddress, ArtPacket.port);

        ArtSocket Socket = new ArtSocket();

        System.out.println("SENDING PACKETSSS");
        Socket.sendPacket(rawPacketOne);
        Socket.sendPacket(rawPacketTwo);
        Socket.sendPacket(rawPacketThree);
    }



//    public ArtPacket(byte[] _data, int _length, InetAddress _address, int _port) throws IOException {
//        this.Packet = new DatagramPacket(_data, 0, _length, _address, _port);
//    };
//
//    public FindNode() throws UnknownHostException {
//    }
//
//    public void testArtPoll(){
//        System.out.println("Sending Packet");
//        //this.sendPacket();
//    }
}
