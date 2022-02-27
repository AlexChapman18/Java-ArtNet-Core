package org.alexandoscar.artnet.core;

import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class ArtPacket {
    DatagramPacket Packet;
    public byte[] artPacketData;
    public int packetLength;
    public byte[] ArtNetString = {(byte)0x41, (byte)0x72, (byte)0x74, (byte)0x2D, (byte)0x4E, (byte)0x65, (byte)0x74, (byte)0x00};
    public byte Filler = (byte)0x00;
    public static int port = 6454;
    public static InetAddress ArtAddress;

    static {
        try {
            ArtAddress = InetAddress.getByName("2.255.255.255");
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }

    /**
     * Sets the value for a single byte by index
     * @param _index Byte index
     * @param _Value Byte Value
     */
    public void setByte(int _index, byte _Value){
        this.artPacketData[_index] = _Value;
    }

    /**
     * Returns the value of a byte specified by index
     * @param _index Byte Index
     * @return Specified Byte
     */
    public byte getByte(int _index){
        return this.artPacketData[_index];
    }

    /**
     * Used to set entire range of bytes to a singular value
     * @param _index Start index
     * @param _length Length of data
     * @param _value Data to be set
     */
    public void setByteGroup(int _index, int _length, byte _value){
        for (int i = 0; i < _length; i++){
            setByte((i + _index), _value);
        }
    }

    /**
     * Sets range of bytes to ones specified in byte array parameter
     * @param _index Start index
     * @param _length Length of data
     * @param _data Data to be set
     */
    public void setByteGroup(int _index, int _length, byte[] _data){
        for (int i = 0; i < _length; i++){
            setByte((i + _index), _data[i]);
        }
    }

    /**
     * Retrieves a Byte group from the larger byte array
     * @param _index Starting index
     * @param _length Length of byte array
     * @return A byte array consisting of specified bytes
     */
    public byte[] getByteGroup(int _index, int _length){
        byte[] tempArray = new byte[_length];
        System.arraycopy(this.artPacketData, _index, tempArray, 0, _length);
        return tempArray;
    }

    /**
     * Sets all the bytes in a packet
     * @param _packet Byte array
     */
    public void setPacket(byte[] _packet){
        this.artPacketData = _packet;
    }

    /**
     * Returns a byte array of all the values in the packet
     * @return Byte array
     */
    public byte[] getPacket(){
        return new byte[1];
    }

}
