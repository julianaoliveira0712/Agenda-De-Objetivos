package br.com.bandtec.AgendaDeObjetivos.resources;

import br.com.bandtec.AgendaDeObjetivos.modelos.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TodosUsuarios extends JpaRepository<Usuario, Long> {

    @Query("select o from Usuario o where o.credenciais.usuario = :login and o.credenciais.senha = :senha")
    public Usuario existe(@Param("login") String login, @Param("senha")String senha);

}
