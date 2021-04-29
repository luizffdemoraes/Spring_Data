package br.com.zup.spring.data;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.zup.spring.data.orm.Cargo;
import br.com.zup.spring.data.repository.CargoRepository;
import br.com.zup.spring.data.service.CrudCargoService;
import br.com.zup.spring.data.service.CrudFuncionarioService;
import br.com.zup.spring.data.service.CrudUnidadeTrabalhoService;
import br.com.zup.spring.data.service.RelatorioFuncionarioDinamico;
import br.com.zup.spring.data.service.RelatoriosService;

@SpringBootApplication
public class SpringDataApplication implements CommandLineRunner {
	
	/* Interface CommandLineRunner ela obriga a implementar o metodo run
	 * Ela é utilizada para que após a inicialização do SpringFramework siga para o metodo run 
	 */
	
	private final CrudCargoService cargoService;

	private final CrudFuncionarioService funcionarioService;

	private final CrudUnidadeTrabalhoService unidadeTrabalhoService;
	
	private final RelatoriosService relatoriosService;
	
	private final RelatorioFuncionarioDinamico relatorioFuncionarioDinamico;
	
	private Boolean system = true; // variavel para controle do funcionamento da aplicação

	//injeção de dependencia pelo metodo construtor
	public SpringDataApplication(CrudCargoService cargoService,
			CrudFuncionarioService funcionarioService, 
			CrudUnidadeTrabalhoService unidadeTrabalhoService,
			RelatoriosService relatoriosService,
			RelatorioFuncionarioDinamico relatorioFuncionarioDinamico) {
		this.cargoService = cargoService;
		this.funcionarioService = funcionarioService;
		this.unidadeTrabalhoService = unidadeTrabalhoService;
		this.relatoriosService = relatoriosService;
		this.relatorioFuncionarioDinamico = relatorioFuncionarioDinamico;
	}

	public static void main(String[] args)  {
		SpringApplication.run(SpringDataApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Scanner scanner = new Scanner(System.in);

		while (system) {
			System.out.println("Qual função deseja executar?");
			System.out.println("0 - Sair");
			System.out.println("1 - Cargo");
			System.out.println("2 - Funcionario");
			System.out.println("3 - Unidade");
			System.out.println("4 - Relatórios");
			System.out.println("5 - Relatório dinamico");
			
			Integer function = scanner.nextInt();

			switch (function) {
				case 1:
					cargoService.inicial(scanner);
					break;
				case 2:
					funcionarioService.inicial(scanner);
					break;
				case 3:
					unidadeTrabalhoService.inicial(scanner);
					break;
				case 4:
					relatoriosService.inicial(scanner);
					break;
				case 5:
					relatorioFuncionarioDinamico.inicial(scanner);
					break;
				default:
					System.out.println("Finalizando");
					system = false;
					break;
			}
		}
	}
}
