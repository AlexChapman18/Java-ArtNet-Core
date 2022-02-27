package org.alexandoscar.artnet.core;

public class ArtDiag extends ArtPacket {

    /**
     * Defining default ArtDiag values
     */
    byte OpCodeLo = (byte)0x00;
    byte OpCodeHi = (byte)0x20;
    byte ProtVerHi = (byte)0x00;
    byte ProtVerLo = (byte)0x0e;
    byte Priority = (byte)0x00;
    byte LengthHi = (byte)0x00;

    /**
     * Constructor for an ArtPoll packet, using default values
     */
    public ArtDiag(){
        new ArtDiag(this.OpCodeHi, this.OpCodeLo, this.ProtVerHi, this.ProtVerLo, this.Priority, this.LengthHi);
    }

    /**
     * Constructor for ArtDiag packet, all but "Art-Net"0x00 are parameters
     * @param _OpCodeLo OpCode Lo
     * @param _OpCodeHi OpCode Hi
     * @param _ProtVerHi ProtVer Hi
     * @param _ProtVerLo ProtVer Lo
     * @param _Priority Priority
     * @param _LengthHi Length Hi
     */
    public ArtDiag(byte _OpCodeLo, byte _OpCodeHi, byte _ProtVerHi, byte _ProtVerLo, byte _Priority, byte _LengthHi){
        this.packetLength = 14;
        artPacketData = new byte[14];
        for (int i = 0; i < 8; i++){
            this.setByte(i, this.ArtNetString[i]);
        }
        setByte(8, _OpCodeLo);
        setByte(9, _OpCodeHi);
        setByte(10, _ProtVerHi);
        setByte(11, _ProtVerLo);
        setByte(12, this.Filler);
        setByte(13, _Priority);
        setByteGroup(14, 2, this.Filler);
        setByte(16, _LengthHi);
    }

    public static void main(String[] args) {
        System.out.println("Running ArtDiag");
    }
}
