package Cadastros;

public class GetDuracaoMinutos {

	private int minutosInicio;
	private int minutosTermino;
	private int duracaoMinutos;
	
	public GetDuracaoMinutos(Viagem viagem) {
		this.minutosInicio = viagem.getMinutoInicio();
		this.minutosTermino = viagem.getMinutosTermino();
	}
	
	public int compute() {
		if (minutosTermino > minutosInicio) 
			duracaoMinutos = minutosTermino - minutosInicio;
		else {
			duracaoMinutos = 60 - minutosInicio + minutosTermino;
			if (duracaoMinutos == 60) //caso especial
				duracaoMinutos = 0;
		}
		return duracaoMinutos;
	}
}
