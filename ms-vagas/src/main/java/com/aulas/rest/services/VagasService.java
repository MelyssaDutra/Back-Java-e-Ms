package com.aulas.rest.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aulas.rest.entities.Vagas;
import com.aulas.rest.repository.VagasRepository;

@Service
public class VagasService {
	@Autowired
	VagasRepository repo;

	public List<Vagas> listTodas() {
		List<Vagas> lista = repo.findAll();
		return lista;
	}

	public Vagas pegarPorId(int idvagas) {
		Optional<Vagas> obj = repo.findById(idvagas);
		Vagas vaga = obj.get();
		return vaga;

	}

	public String salvar(int quantidade) {
		String tipo = "EI";
		int qtdVagaIdoso = Math.round((quantidade * 5) / 100);
		int qtdVagaPcd = Math.round((quantidade * 2) / 100);
		int qtdVagaGestante = Math.round((quantidade * 1) / 100);
		for (int i = 0; i < quantidade; i++) {
			if (i == qtdVagaIdoso) {
				tipo = "ED";
			}

			else if (i == qtdVagaIdoso + qtdVagaPcd) {
				tipo = "EG";
			} else if (i == qtdVagaIdoso + qtdVagaPcd + qtdVagaGestante) {
				tipo = "C";
			}
			repo.save(new Vagas(i, tipo, false));
		}
		System.out.println(qtdVagaPcd);
		System.out.println(qtdVagaGestante);

		return "Vagas criadas com sucesso!";

	}

	public Vagas alterar(int idvaga, Vagas vagas) {
		Optional<Vagas> obj = repo.findById(idvaga);
		Vagas vaga = obj.get();

		vaga.setTipo(vagas.getTipo());
		vaga.setOcupada(vaga.isOcupada());
		vaga = repo.save(vaga);

		return vaga;
	}

	public String reservarVaga(int idvaga, boolean novoStatus) {
		Optional<Vagas> obj = repo.findById(idvaga);
		Vagas vaga = obj.get();
		vaga.setOcupada(novoStatus);
		vaga = repo.save(vaga);

		String msg = "vaga ocupada!";
		if (!novoStatus) {
			msg = "vaga livre!";
		}
		return msg;
	}
	
	
	public int  sugerirVaga(String tipoVaga) {
		List<Vagas> lista = listTodas();
	    int pegaIdVaga= -1;
		for(Vagas vaga: lista ) {
			if(!vaga.isOcupada() && vaga.getTipo().equals(tipoVaga)) {
				pegaIdVaga= vaga.getId();
				break;
				
			}
		}
		return pegaIdVaga;
	}

	public void deletar(int idvagas) {
		repo.deleteById(idvagas);
	}
}
