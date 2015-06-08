package Commands;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PDU implements Serializable {
    
    public byte version;
    public byte security;
    public short label;
    public byte type;
    public byte nfields;
    public short fieldsize;
    public byte[] fields;
    
    public PDU(byte v, byte s, short l, byte t, byte nf, short fs, byte[] lf){
        this.version = v;
        this.security = s;
        this.label = l;
        this.type = t;
        this.nfields = nf;
        this.fieldsize = (short) lf.length;
        this.fields = lf;
    }
    
    public PDU(byte v, byte s, short l, byte t, byte nf, short fs, ArrayList<String> alf){
        this.version = v;
        this.security = s;
        this.label = l;
        this.type = t;
        this.nfields = nf;
        this.fields = parserToByte(alf);
        this.fieldsize = (short) fields.length;
        
    }
    
    public PDU(byte v, byte s, short l, byte t, byte nf, short fs){
        this.version = v;
        this.security = s;
        this.label = l;
        this.type = t;
        this.nfields = nf;
        this.fieldsize = fs;
        this.fields = null;
    }
    
    public ArrayList<String> getFields(){
            
        ArrayList<String> result = new ArrayList<>();
        
        String str = new String(this.fields);
        result.addAll(Arrays.asList(str.split(";")));
        return result;
    }

    private byte[] parserToByte(ArrayList list) {
        String data = "";
        for (Object item : list) {
            data = data + (String) item + ";";
        }
        return data.getBytes();
    }
}
