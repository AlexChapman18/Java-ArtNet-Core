package org.alexandoscar.artnet.core;

/**
 * ArtPoll class, extents ArtPacket
 * Used for constructing the packet needed for the ArtPoll request
 */
public class ArtPoll extends ArtPacket {

    /**
     * Defining default ArtPoll values
     */
    byte OpCodeLo = (byte)0x00;
    byte OpCodeHi = (byte)0x20;
    byte ProtVerHi = (byte)0x00;
    byte ProtVerLo = (byte)0x0e;
    byte TalkToMe = (byte)0x02;
    byte Priority = (byte)0x00;

    /**
     * Constructor for an ArtPoll packet, using default values
     */
    public ArtPoll(){
        new ArtPoll(this.OpCodeHi, this.OpCodeLo, this.ProtVerHi, this.ProtVerLo, this.TalkToMe, this.Priority);
    };

    /**
     * Constructor for ArtPoll packet, all but "Art-Net"0x00 are parameters
     * @param _OpCodeHi OpCode Hi
     * @param _OpCodeLo OpCode Lo
     * @param _ProtVerHi ProtVer Hi
     * @param _ProtVerLo ProtVer Lo
     * @param _TalkToMe TalkToMe
     * @param _Priority Priority
     */
    public ArtPoll(byte _OpCodeHi, byte _OpCodeLo, byte _ProtVerHi, byte _ProtVerLo, byte _TalkToMe, byte _Priority){
        artPollPacket = new byte[14];
        for (int i = 0; i < 8; i++){
            this.setByte(i+1, this.ArtNetString[i]);
        }
        setByte(8, _OpCodeHi);
        setByte(9, _OpCodeLo);
        setByte(10, _ProtVerHi);
        setByte(11, _ProtVerLo);
        setByte(12, _TalkToMe);
        setByte(13, _Priority);
    }

    public static void main(String[] args) {
        System.out.println("Running ArtPoll");
    }

}

