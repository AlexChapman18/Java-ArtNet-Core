package org.alexandoscar.artnet.core;

import java.lang.reflect.Array;
import java.util.Arrays;


public class ArtTod extends ArtPacket{
    /**
     * Defining default ArtDiag values
     */
    byte OpCodeLo = (byte)0x00;
    byte OpCodeHi = (byte)0x80;
    byte ProtVerHi = (byte)0x00;
    byte ProtVerLo = (byte)0x0e;
    byte Net = (byte)0x00;
    byte Command = (byte) 0x00;
    byte AddCount = (byte) 0x04;
    byte[] Address = new byte[32];

    /**
     * Constructor for an ArtTod packet, using default values
     */
    public ArtTod(){
        this((byte)0x00, (byte)0x80, (byte)0x00, (byte)0x0e, (byte)0x00, (byte) 0x00, (byte) 0x04, new byte[32]);
    }

    /**
     * Constructor for ArtTod packet, all but "Art-Net"0x00 are parameters
     * @param _OpCodeLo OpCode Lo
     * @param _OpCodeHi OpCode Hi
     * @param _ProtVerHi ProtVer Hi
     * @param _ProtVerLo ProtVer Lo
     * @param _Net Net
     * @param _Command Command
     * @param _AddCount AddCount
     * @param _Address Address byte array
     */
    public ArtTod(byte _OpCodeLo, byte _OpCodeHi, byte _ProtVerHi, byte _ProtVerLo, byte _Net, byte _Command, byte _AddCount, byte[] _Address){
        this.packetLength = 56;
        artPacketData = new byte[56];
        for (int i = 0; i < 8; i++){
            this.setByte(i, this.ArtNetString[i]);
        }
        setByte(8, _OpCodeLo);
        setByte(9, _OpCodeHi);
        setByte(10, _ProtVerHi);
        setByte(11, _ProtVerLo);
        setByteGroup(12, 9, this.Filler);
        setByte(21, _Net);
        setByte(22, _Command);
        setByte(23, _AddCount);
        for (int i = 0; i < 32; i++){
            this.setByte(i+23, _Address[i]);
        }
    }

    public void setAddress(){
        byte[] _Address = new byte[32];
        Arrays.fill(_Address, (byte)0x00);
        _Address[1] = (byte)0x01;
        _Address[2] = (byte)0x02;
        _Address[3] = (byte)0x03;
        for (int i = 0; i < 32; i++){
            this.setByte(i+23, _Address[i]);
        }
    }

    public static void main(String[] args) {
        System.out.println("Running ArtTod");
    }
}
