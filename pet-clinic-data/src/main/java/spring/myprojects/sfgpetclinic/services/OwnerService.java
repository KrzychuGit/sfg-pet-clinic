package spring.myprojects.sfgpetclinic.services;

import spring.myprojects.sfgpetclinic.model.Owner;

public interface OwnerService extends CrudService<Owner, Long>{

    Owner findByLastName(String lastName);

}
