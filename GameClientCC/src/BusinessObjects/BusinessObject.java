package BusinessObjects;

import java.util.List;

public interface BusinessObject<T> {
    
    public T create(T o);
    public T get(int id);
    public List<T> getAll();
    public void update(T o);
    public void delete(T o);
    
}
