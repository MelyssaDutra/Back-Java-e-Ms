package com.aulas.rest.servicos;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aulas.rest.dto.UsuarioDTO;
import com.aulas.rest.entidades.Usuario;
import com.aulas.rest.entidades.Vagas;
import com.aulas.rest.repositorios.VagasRepositorio;

@Service
public class VagasService {
	@Autowired
	VagasRepositorio repo;

	public List<Vagas> listTodas() {
		List<Vagas> lista = repo.findAll();
		return lista;
	}

	public Vagas pegarPorId(int idvagas) {
		Optional<Vagas> obj = repo.findById(idvagas);
		Vagas vaga = obj.get();
		return vaga;

	}

	/*public Vagas salvar(int quantidade) {
		String tipo = "C";
		for(int i=0; i<quantidade; i++) {
			
			Vagas vagas = repo.save(new Vagas(tipo,false));
		}		
		
		return vagas;
	}*/

	public Vagas alterar(int idvagas, Vagas vagas) {
		Optional<Vagas> obj = repo.findById(idvagas);
		Vagas vaga = obj.get();

		vaga.setIdvagas(vagas.getIdvagas());
		vaga.setTipo(vagas.getTipo());
		vaga.setOcupada(vagas.getOcupada());
		vaga = repo.save(vaga);
		return vaga;

	}
		public String reservar(int idvagas, boolean novoStatus) {
			Optional<Vagas> obj = repo.findById(idvagas);
			Vagas vaga = obj.get();
			vaga.setOcupada(novoStatus);
			vaga = repo.save(vaga);
			String msg = "Vaga ocupada";
			 if(!novoStatus) {
				   msg = "Vaga Livre"; 
			   }
			 
			return msg;

	}

	public void deletar(int idvagas) {
		repo.deleteById(idvagas);
	}
}