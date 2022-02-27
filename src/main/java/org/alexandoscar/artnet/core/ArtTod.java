package org.alexandoscar.artnet.core;

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
        Arrays.fill(this.Address, (byte) 0x00);
        setByte(this.Address, (byte)0x01);
        setByte(this.Address, (byte)0x01);
        setByte(this.Address, (byte)0x01);
        new ArtTod(this.OpCodeLo, this.OpCodeHi, this.ProtVerHi, this.ProtVerLo, this.Net, this.Command, this.AddCount, this.Address);
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
        artPacketData = new byte[56];
        for (int i = 0; i < 8; i++){
            this.setByte(i+1, this.ArtNetString[i]);
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

    public static void main(String[] args) {
        System.out.println("Running ArtTod");
    }
}
