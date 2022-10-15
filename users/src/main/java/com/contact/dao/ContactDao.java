package com.contact.dao;

import com.contact.domain.Contact;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author Administrador
 */
public interface ContactDao extends CrudRepository<Contact, Long> {

    @Modifying
    @Query("update Contact usu set usu.document = :document where usu.id = :id")
    public void updateDocument(
            @Param(value = "id") Long id,
            @Param(value = "document") Long document
    );

    @Modifying
    @Query("update Contact usu set usu.name = :name where usu.id = :id")
    public void updateName(
            @Param(value = "id") Long id,
            @Param(value = "name") String name
    );

    @Modifying
    @Query("update Contact usu set usu.position = :position where usu.id = :id")
    public void updatePosition(
            @Param(value = "id") Long id,
            @Param(value = "position") String position
    );
}
