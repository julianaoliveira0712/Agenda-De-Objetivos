package br.com.bandtec.AgendaDeObjetivos.resources;

import static java.util.stream.Collectors.toList;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import br.com.bandtec.AgendaDeObjetivos.modelos.Objetivo;
import com.sun.xml.internal.bind.v2.model.core.ID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodosObjetivos extends JpaRepository<Objetivo, Integer> {


    public void save(Objetivo objetivo);

    public List<Objetivo> ate(LocalDate data);

}
