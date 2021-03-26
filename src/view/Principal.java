package view;

import java.util.concurrent.Semaphore;

import controller.Corredor;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int permissoes = 1;
		Semaphore semaforo = new Semaphore(permissoes);
		
		for(int idPessoa = 0; idPessoa < 4; idPessoa++) {
			Thread tPessoa = new Corredor(idPessoa, semaforo);
			tPessoa.start();
		}

	}

}
