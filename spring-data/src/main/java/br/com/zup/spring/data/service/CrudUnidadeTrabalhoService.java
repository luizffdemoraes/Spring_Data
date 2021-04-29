package br.com.zup.spring.data.service;

import java.util.Scanner;

import org.springframework.stereotype.Service;

import br.com.zup.spring.data.orm.UnidadeTrabalho;
import br.com.zup.spring.data.repository.UnidadeTrabalhoRepository;

@Service
public class CrudUnidadeTrabalhoService {
	
	private Boolean system = true;
	
	private UnidadeTrabalhoRepository unidadeTrabalhoRepository;

	public CrudUnidadeTrabalhoService(UnidadeTrabalhoRepository unidadeTrabalhoRepository) {
		this.unidadeTrabalhoRepository = unidadeTrabalhoRepository;
	}
	
	public void inicial(Scanner scanner) {
		while(system) {
			
			System.out.println("Qual ação de unidade de trabalho deseja executar:");
			System.out.println("0 - Sair");
			System.out.println("1 - Salvar");
			System.out.println("2 - Atualizar");
			System.out.println("3 - Visualizar");
			System.out.println("4 - Deletado");
			
			int action = scanner.nextInt();
			
			switch (action) {
			case 1:
				salvar(scanner);
				break;
				
			case 2:
				atualizar(scanner);
				break;
				
			case 3:
				visualizar();
				break;
				
			case 4:
				deletar(scanner);
				break;

			default:
				system = false;
				break;
			}
			
		}
		
	}

	private void deletar(Scanner scanner) {
		System.out.println("Digite o id que deseja remover");
		Integer id = scanner.nextInt();
		unidadeTrabalhoRepository.deleteById(id);
		System.out.println("Deletado");
	}

	private void visualizar() {
		Iterable<UnidadeTrabalho> unidades = unidadeTrabalhoRepository.findAll();
		unidades.forEach(unidade -> unidadeTrabalhoRepository.toString());
	}

	private void atualizar(Scanner scanner) {
		System.out.println("Digite o id que deseja atualizar");
		Integer id = scanner.nextInt();
		System.out.println("Digite a descrição que deseja atualizar");
		String descricao = scanner.next();
		System.out.println("Digite a endereço que deseja atualizar");
		String endereco = scanner.next();
		
		UnidadeTrabalho unidadeTrabalho = new UnidadeTrabalho();
		unidadeTrabalho.setId(id);
		unidadeTrabalho.setDescricao(descricao);
		unidadeTrabalho.setEndereco(endereco);
		
		unidadeTrabalhoRepository.save(unidadeTrabalho);
        System.out.println("Alterado");
	}

	private void salvar(Scanner scanner) {
		System.out.println("Digite a descricao da unidade");
        String descricao = scanner.next();
        System.out.println();
        System.out.println("Digite o endereco");
        String endereco = scanner.next();
        
        UnidadeTrabalho unidade = new UnidadeTrabalho();
        unidade.setDescricao(descricao);
        unidade.setEndereco(endereco);
        unidadeTrabalhoRepository.save(unidade);
        System.out.println("Salvo");
		
		
	}
	
	
	

}
