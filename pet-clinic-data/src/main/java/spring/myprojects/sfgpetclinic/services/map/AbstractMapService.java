package spring.myprojects.sfgpetclinic.services.map;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public abstract class AbstractMapService<T, ID> {
    protected Map<ID, T> hashMap= new HashMap<>();

    Set<T> findAll()
    {
        return new HashSet(hashMap.values());
    }

    T findById(ID id)
    {
        return hashMap.get(id);

    }

    T save(T object, ID id)
    {
        hashMap.put(id, object);
        return object;
    }

    void delete(T object)
    {
        hashMap.entrySet().removeIf(t -> t.getValue().equals(object));
    }

    void deleteById(ID id)
    {
        hashMap.remove(id);
    }
}
