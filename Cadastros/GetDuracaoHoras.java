package Cadastros;

public class GetDuracaoHoras {
	private int horaInicio;
	private int horaTermino;
	private int minutosInicio;
	private int minutosTermino;
	private int duracaoHoras;
	
	public GetDuracaoHoras(Viagem viagem) {
		this.horaInicio = viagem.getHoraInicio();
		this.horaTermino = viagem.getHoraTermino();
		this.minutosInicio = viagem.getMinutoInicio();
		this.minutosTermino = viagem.getMinutosTermino();
	}
	
	public int compute() {
		if (horaTermino == horaInicio)
			duracaoHoras = 0;
		if (horaTermino > horaInicio) //varias possibilidades... 
			if (horaTermino == horaInicio + 1) {  
				if (minutosTermino < minutosInicio)  //nao chegou a uma hora
					duracaoHoras = 0;
				else //durou pelo menos uma hora
					duracaoHoras = 1;
			} else { //possivelmente ultrapassou duas horas
				if (horaTermino - horaInicio > 2) //
					duracaoHoras = horaTermino - horaInicio;
				else if (horaTermino - horaInicio == 2 &&   //certamente menos de duas horas  
						 minutosTermino < minutosInicio)    //e mais de uma hora
					duracaoHoras = 1;
				else //duracao de duas horas, certamente
					duracaoHoras = 2;
					
			}
		if (horaTermino < horaInicio) 
			duracaoHoras = -1; //para casos em que a hora de termino nao foi registrada
		return duracaoHoras;
	}
}
