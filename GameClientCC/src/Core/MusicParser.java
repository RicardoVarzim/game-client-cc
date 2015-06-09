/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Core;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;

/**
 *
 * @author Ricardo
 */
public class MusicParser {
 
    private ArrayList<Block> lista;
    private int ncampos;
    //private short totalSize;

    public MusicParser(ArrayList<Block> lista) {
        this.lista = lista;
    }

    public MusicParser() {
        this.lista = new ArrayList<>();
    }

    public MusicParser(byte[] data, short nCampos) {
        lista = new ArrayList<>();
        int i = 0, j = 0;

        byte tag;
        int size;
        byte[] dados;
        byte[] aux = new byte[4];

        while (j < nCampos) {
            tag = data[i];

            System.arraycopy(data, i + 1, aux, 0, 4);
            size = byteToInt(aux);

            if (size > 0) {
                dados = new byte[size];
                System.arraycopy(data, i + 5, dados, 0, size);

                addCampo(new Block(tag, size, dados));
            } else {
                addCampo(new Block(tag));
            }

            i += size + 5;
            j++;
        }
    }

    public MusicParser(MusicParser lc) {
        this.lista = lc.getCampos();
    }

    public ArrayList<Block> getCampos() {
        return (ArrayList<Block>) lista.clone();
    }

    public Block getCampo(int posicao) throws ArrayIndexOutOfBoundsException {
        if (lista.size() < posicao) {
            throw new ArrayIndexOutOfBoundsException();
        }
        return lista.get(posicao).clone();
    }

    public Block getCampoByTag(byte tag) throws ArrayIndexOutOfBoundsException {
        for (Block c : lista) {
            if (c.getTag() == tag) {
                return c;
            }
        }
        return null;
    }

    public boolean addCampo(Block campo) {
        //totalSize += campo.getTotalSize();
        return this.lista.add(campo);
    }

    public int getTotalSize() {
        int t = 0;
        for (Block c : lista) {
            t += c.getTotalSize();
        }
        return t;
    }

    public byte getNCampos() {
        return (byte) lista.size();
    }

    public byte[] generate() {
        byte[] ret = new byte[getTotalSize()];
        int currentSize = 0;

        for (Block campo : lista) {
            System.arraycopy(campo.generate(), 0, ret, currentSize, campo.getTotalSize());
            currentSize = currentSize + campo.getTotalSize();
        }
        return ret;
    }

    public byte[] IntToByte(int size) {
        byte[] bytes = ByteBuffer.allocate(4).putInt(size).array();
        return bytes;
    }

    public int byteToInt(byte[] data) {
        byte[] sizeBytes = {data[0], data[1], data[2], data[3]};
        return ByteBuffer.wrap(sizeBytes).order(ByteOrder.BIG_ENDIAN).getInt();
    }

    @Override
    public String toString() {
        return "ListaCampos{" + "lista=" + lista + '}';
    }

    
}
