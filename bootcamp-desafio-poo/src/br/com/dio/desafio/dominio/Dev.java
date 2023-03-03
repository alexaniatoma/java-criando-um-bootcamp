package br.com.dio.desafio.dominio;

import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

public class Dev {
	
	private String nome; 
	private Set<Conteudo> conteudoInscrito = new LinkedHashSet<>();
	private Set<Conteudo> conteudoConcluidos = new LinkedHashSet<>();
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Set<Conteudo> getConteudoInscrito() {
		return conteudoInscrito;
	}

	public void setConteudoInscrito(Set<Conteudo> conteudoInscrito) {
		this.conteudoInscrito = conteudoInscrito;
	}

	public Set<Conteudo> getConteudoConcluidos() {
		return conteudoConcluidos;
	}

	public void setConteudoConcluidos(Set<Conteudo> conteudoConcluidos) {
		this.conteudoConcluidos = conteudoConcluidos;
	}

	
	public void inscreverBootcamp(Bootcamp bootcamp) {
		this.conteudoInscrito.addAll(bootcamp.getConteudos());
		bootcamp.getDevsInscritos().add(this);
		
	}
	
	public void progredir() {
		Optional<Conteudo> conteudo = this.conteudoInscrito.stream().findFirst();
		if(conteudo.isPresent()) {
			this.conteudoConcluidos.add(conteudo.get());
			this.conteudoInscrito.remove(conteudo.get());
		}else {
			System.err.println("Você não está matriculado em nenhum conteúdo");
		}
	}
	
	public Double calcularXp() {
		return this.conteudoConcluidos
		.stream()
		.mapToDouble(conteudo -> conteudo.calcularXp())
		.sum();
	}

	
	
	@Override
	public int hashCode() {
		return Objects.hash(conteudoConcluidos, conteudoInscrito, nome);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Dev other = (Dev) obj;
		return Objects.equals(conteudoConcluidos, other.conteudoConcluidos)
				&& Objects.equals(conteudoInscrito, other.conteudoInscrito) && Objects.equals(nome, other.nome);
	}
	
	
}
