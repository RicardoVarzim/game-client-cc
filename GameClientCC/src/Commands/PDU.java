package Commands;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class PDU implements Serializable {
    
    public byte version;
    public byte security;
    public short label;
    public byte type;
    public byte nfields;
    public short fieldsize;
    public List<String> fields;
    
    public PDU(byte v, byte s, short l, byte t, byte nf, short fs, List<String> lf){
        this.version = v;
        this.security = s;
        this.label = l;
        this.type = t;
        this.nfields = nf;
        this.fieldsize = fs;
        this.fields = new ArrayList<String>(lf);
    }
}
