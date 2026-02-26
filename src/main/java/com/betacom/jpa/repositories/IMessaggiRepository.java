package com.betacom.jpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.betacom.jpa.models.MessageID;
import com.betacom.jpa.models.Messaggi;

@Repository
public interface IMessaggiRepository extends JpaRepository<Messaggi, MessageID>{

}

