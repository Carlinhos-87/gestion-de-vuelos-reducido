package com.example;

import java.time.LocalDate;

import lombok.Builder;

@Builder
public record Pasajero(String nombre, String primerApellido, String segundoApellido, 
		LocalDate fechaNacimiento, Genero genero) implements Comparable<Pasajero> {

	@Override
	public int compareTo(Pasajero pasajero) {
		// primero se compara por el primer apellido
		int cmpPrimerApellido = this.primerApellido.compareTo(pasajero.primerApellido());

		// segundo se compara el segundoo apellido
		int cmpSegundoApellido = this.segundoApellido.compareTo(pasajero.segundoApellido());

		// Si los dos pasajeros que se comparan tuviesen igual el primer apellido, el
		// segundo
		// apellido tambien, pues entonces tiene que determinar el nombre. considerando
		// que no hay
		// dos pasajeros que tengan el mismo normbre y apellidos.
		int cmpNombre = this.nombre.compareTo(pasajero.nombre());

		return cmpPrimerApellido != 0 ? cmpPrimerApellido : 
			cmpSegundoApellido != 0 ? cmpSegundoApellido : 
				cmpNombre;

	}

}
