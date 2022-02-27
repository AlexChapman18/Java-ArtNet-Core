package org.alexandoscar.artnet.core;

/**
 * Used for all byte specific operations with ArtPacket
 */
public class ByteCore {

    protected byte[] Data;

    public void initialiseData(int _Length){
        Data = new byte[_Length];
    }

    /**
     * Sets the value for a single byte by index
     * @param _index Byte index
     * @param _Value Byte Value
     */
    public void setByte(int _index, byte _Value){
        this.Data[_index] = _Value;
    }

    /**
     * Returns the value of a byte specified by index
     * @param _index Byte Index
     * @return Specified Byte
     */
    public byte getByte(int _index){
        return this.Data[_index];
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
        System.arraycopy(this.Data, _index, tempArray, 0, _length);
        return tempArray;
    }
}
