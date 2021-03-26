package controller;

import java.util.concurrent.Semaphore;

public class Corredor extends Thread {
	
	private int idPessoa;
	private static int posChegada;
	private static int posSaida;
	private Semaphore semaforo;
	
	public Corredor(int idPessoa, Semaphore semaforo) {
		this.idPessoa = idPessoa;
		this.semaforo = semaforo;
	}
	
	public void run() {
		
		pessoaAndando();
		try {
			semaforo.acquire();
			pessoaNaPorta();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			semaforo.release();
			// fim seção critica
			pessoaSaindo();
		}
		
	}

	private void pessoaSaindo() {
		// TODO Auto-generated method stub
		posSaida++;
		System.out.println("#" + idPessoa + " foi o " + posSaida + " a sair");
		
	}

	private void pessoaNaPorta() {
		// TODO Auto-generated method stub
		System.out.println("#" + idPessoa + " esta saindo ");
		int tempo = (int)((Math.random() * 2001) + 1000);
		try {
			sleep(tempo);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private void pessoaAndando() {
		// TODO Auto-generated method stub
		int distanciaTotal = 200;
		int distanciaPercorrida = 0;
		int deslocamento = (int)((Math.random() * 3) + 4);
		int tempo = 1000;
		while(distanciaPercorrida <= distanciaTotal) {
			distanciaPercorrida += deslocamento;
			try {
				sleep(tempo);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("#" + idPessoa + " já andou " + distanciaPercorrida + " m.");
		}
		posChegada++;
		System.out.println("#" + idPessoa + " foi o " + posChegada + " o. a chegar");
		
	}
	
	

}
