package br.com.bandtec.AgendaDeObjetivos.resources;

import br.com.bandtec.AgendaDeObjetivos.modelos.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TodosUsuarios extends JpaRepository<Usuario, Long> {

    @Query("select o from usuarios o wherre o.login = :logim and o.senha = : senha")
    public Usuario existe(String login, String senha);


}
