package br.com.dio.desafio.dominio;

import java.time.LocalDate;

public class Main {
	public static void main(String[] args) {
		
		Curso curso1 = new Curso();
		curso1.setTitulo("java");
		curso1.setDescricao("descrevendo o curso java");
		curso1.setCargaHoraria(8);
		
		Curso curso2 = new Curso();
		curso2.setTitulo("javaScript");
		curso2.setDescricao("descrevendo o curso javaScript");
		curso2.setCargaHoraria(4);
		
		Mentoria mentoria = new Mentoria();
		mentoria.setTitulo("mentoria de java");
		mentoria.setDescricao("mentoria do curso de java");
		mentoria.setData(LocalDate.now());
		
		//System.out.println(curso1);
		//System.out.println(curso2);
		
		//System.out.println(mentoria);
		
		
		Bootcamp bootcamp = new Bootcamp();
		bootcamp.setNome("Bootcamp Java Developer");
		bootcamp.setDescricao("Descrição Bootcamp Java Developer");
		bootcamp.getConteudos().add(curso1);
		bootcamp.getConteudos().add(curso2);
		bootcamp.getConteudos().add(mentoria);
		
		
		Dev devAlexania = new Dev();
		devAlexania.setNome("Alexania");
		devAlexania.inscreverBootcamp(bootcamp);
		devAlexania.inscreverBootcamp(bootcamp);
		System.out.println("Conteúdos inscritos" + devAlexania.getConteudoInscrito());
		devAlexania.progredir();
		devAlexania.progredir();
		System.out.println("Conteúdos concluidos" + devAlexania.getConteudoConcluidos());
	
		System.out.println("XP: " + devAlexania.calcularXp());
				
		System.out.println("------");
		Dev devYudyi = new Dev();
		devYudyi.setNome("Yudyi");
		devYudyi.inscreverBootcamp(bootcamp);
		System.out.println("Conteudos inscritos" + devYudyi.getConteudoInscrito());
		devYudyi.progredir();
		System.out.println("Conteúdos concluidos" + devAlexania.getConteudoConcluidos());
		System.out.println("XP: " + devYudyi.calcularXp());
		
		
	}


	
	
	
	

	

}
