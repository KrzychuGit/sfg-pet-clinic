package spring.myprojects.sfgpetclinic.services.map;

import spring.myprojects.sfgpetclinic.model.BaseEntity;

import java.util.*;

public abstract class AbstractMapService<T extends BaseEntity, ID extends Long> {
    protected Map<Long, T> hashMap= new HashMap<>();

    Set<T> findAll()
    {
        return new HashSet(hashMap.values());
    }

    T findById(ID id)
    {
        return hashMap.get(id);

    }

    T save(T object)
    {
        if(object != null)
        {
            if(object.getId() ==null)
            {
                object.setId(getNextId());
            }
            hashMap.put(object.getId(), object);
        }
        else{
            throw new RuntimeException("Object cannot be null");

        }
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

    private Long getNextId()
    {
        Long nextId=null;

        try{
            nextId= Collections.max(hashMap.keySet()) +1;
        }catch(NoSuchElementException e)
        {
            nextId= 1L;
        }
        return nextId;
    }
}
