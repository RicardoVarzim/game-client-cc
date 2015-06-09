package BusinessObjects;

import BusinessEntities.QuestionBE;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class QuestionBO implements BusinessObject<QuestionBE>  {
    
    List<QuestionBE> users;
    int nextId;

    public QuestionBO(){
        users = new ArrayList<QuestionBE>();
        nextId = 0;
    }

    @Override
    public synchronized QuestionBE create(QuestionBE o) {
        o.id = nextId;
        users.add(o);
        nextId = nextId++;
        return o;
    }

    @Override
    public synchronized QuestionBE get(int id) {
        return users.get(id);
    }

    @Override
    public synchronized List<QuestionBE> getAll() {
        return users;
    }

    @Override
    public synchronized void update(QuestionBE o) {
        users.get(o.id).update(o);
    }

    @Override
    public void delete(QuestionBE o) {
        users.remove(o.getId());
    }
    
    //METODOS AUXILIARES DE CLASSE
    
    
}