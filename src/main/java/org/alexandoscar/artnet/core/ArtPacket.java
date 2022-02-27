package org.alexandoscar.artnet.core;

import java.io.IOException;
import java.net.DatagramPacket;

public class ArtPacket {
    DatagramPacket Packet;
    public byte[] artPollPacket;
    public byte[] ArtNetString = {(byte)0x41, (byte)0x72, (byte)0x74, (byte)0x2D, (byte)0x4E, (byte)0x65, (byte)0x74, (byte)0x00};

    public ArtPacket() {
    }

    /**
     * Sets the value for a single byte by index
     * @param _index Byte index
     * @param _Value Byte Value
     */
    public void setByte(int _index, byte _Value){
        this.artPollPacket[_index] = _Value;
    }

    /**
     * Returns the value of a byte specified by index
     * @param _index Byte Index
     * @return Specified Byte
     */
    public byte getByte(int _index){
        return this.artPollPacket[_index];
    }

    /**
     * Sets all the bytes in a packet
     * @param _packet Byte array
     */
    public void setPacket(byte[] _packet){
        this.artPollPacket = _packet;
    }

    /**
     * Returns a byte array of all the values in the packet
     * @return Byte array
     */
    public byte[] getPacket(){
        return this.artPollPacket;
    }



//    public ArtPacket(byte[] _data, int _length, InetAddress _address, int _port) throws IOException {
//        this.Packet = new DatagramPacket(_data, 0, _length, _address, _port);
//    };

//    public void testArtPoll() throws IOException{
//        System.out.println("Sending Packet");
//        //this.sendPacket();
//    }
}
