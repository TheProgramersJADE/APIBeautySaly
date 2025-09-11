package org.esfe.repositorios;

import org.esfe.modelos.Servicio;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICitaRepository extends JpaRepository<Servicio, Integer> {
}
