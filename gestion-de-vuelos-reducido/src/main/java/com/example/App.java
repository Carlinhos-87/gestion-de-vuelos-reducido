package com.example;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class App {
	public static void main(String[] args) {

		/*
		 * A partir de las clases creadas, crear un listado de vuelos a tres destinos
		 * diferentes
		 */

		List<Vuelo> vuelos = new ArrayList<Vuelo>();

		// Vuelo 1 con destino PARIS

		Vuelo vuelo1 = Vuelo.builder().destino(Destino.PARIS).precio(new BigDecimal(150.0))
				.fechaSalida(LocalDate.of(2026, Month.JULY, 8)).horaSalida(LocalTime.of(23, 30))
				.fechaLlegada(LocalDate.of(2026, Month.JULY, 9)).horaLlegada(LocalTime.of(12, 20)).numeroPlazas(3)
				.build();
		
		// Pasajeros del vuelo 1
		
		Pasajero pasajero11 = Pasajero.builder()
				.nombre("Yodalis Ninoska")
				.primerApellido("Grillo")
				.segundoApellido("Castillo")
				.fechaNacimiento(LocalDate.of(1990, Month.AUGUST, 4))
				.genero(Genero.MUJER)
				.build();
		
		Pasajero pasajero21 =  Pasajero.builder()
				.nombre("Juan Carlos")
				.primerApellido("Gonzalez")
				.segundoApellido("Perez")
				.fechaNacimiento(LocalDate.of(1985, Month.MARCH, 15))
				.genero(Genero.HOMBRE)
				.build();
		
		Pasajero pasajero31 = Pasajero.builder()
				.nombre("Maria Fernanda")
				.primerApellido("Lopez")
				.segundoApellido("Martinez")
				.fechaNacimiento(LocalDate.of(1995, Month.DECEMBER, 20))
				.genero(Genero.MUJER).build();
		
		// Agregar los pasajeros anteriores a la lista de pasajeros el vuelo
		// que es la variable pasajeros de la clase Vuelo
		
//		vuelo1.getPasajeros().add(pasajero11);
//		vuelo1.getPasajeros().add(pasajero21);
//		vuelo1.getPasajeros().add(pasajero31);
		
		vuelo1.setPasajeros(Arrays.asList(pasajero11, pasajero21, pasajero31));


		// Vuelo 2 con destino MIAMI

		Vuelo vuelo2 = Vuelo.builder().destino(Destino.MIAMI).precio(new BigDecimal(800.0))
				.fechaSalida(LocalDate.of(2026, Month.JULY, 9)).horaSalida(LocalTime.of(22, 30))
				.fechaLlegada(LocalDate.of(2026, Month.JULY, 10)).horaLlegada(LocalTime.of(14, 20)).numeroPlazas(3)
				.build();
		
		// Pasajeros del vuelo 2
		
		Pasajero pasajero12 = Pasajero.builder()
				.nombre("Carlos Alberto")
				.primerApellido("Ramirez")
				.segundoApellido("Gomez")
				.fechaNacimiento(LocalDate.of(1988, Month.JUNE, 10))
				.genero(Genero.HOMBRE)
				.build();
		
		Pasajero pasajero22 =  Pasajero.builder()
				.nombre("Ana Lucia")
				.primerApellido("Torres")
				.segundoApellido("Vargas")
				.fechaNacimiento(LocalDate.of(1992, Month.SEPTEMBER, 5))
				.genero(Genero.MUJER)
				.build();
		
		vuelo2.setPasajeros(Arrays.asList(pasajero12, pasajero22));

		// Vuelo 3 con destino BARCELONA

		Vuelo vuelo3 = Vuelo.builder().destino(Destino.BARCELONA).precio(new BigDecimal(90.0))
				.fechaSalida(LocalDate.of(2026, Month.JULY, 10)).horaSalida(LocalTime.of(8, 30))
				.fechaLlegada(LocalDate.of(2026, Month.JULY, 10)).horaLlegada(LocalTime.of(22, 20)).numeroPlazas(3)
				.build();
		
		// Pasajeros del vuelo 3
		
		Pasajero pasajero13 = Pasajero.builder()
				.nombre("Luis Fernando")
				.primerApellido("Mendoza")
				.segundoApellido("Rojas")
				.fechaNacimiento(LocalDate.of(1991, Month.NOVEMBER, 12))
				.genero(Genero.HOMBRE)
				.build();
		
		Pasajero pasajero23 =  Pasajero.builder()
				.nombre("Sofia Isabel")
				.primerApellido("Castro")
				.segundoApellido("Hernandez")
				.fechaNacimiento(LocalDate.of(1994, Month.APRIL, 18))
				.genero(Genero.MUJER)
				.build();
		
		Pasajero pasajero33 = Pasajero.builder()
				.nombre("Diego Alejandro")
				.primerApellido("Vega")
				.segundoApellido("Santos")
				.fechaNacimiento(LocalDate.of(1987, Month.FEBRUARY, 25))
				.genero(Genero.HOMBRE)
				.build();
		
		vuelo3.setPasajeros(Arrays.asList(pasajero13, pasajero23, pasajero33));
		
		// Podemos construir la lista de vuelos 
		
		vuelos = Arrays.asList(vuelo1, vuelo2, vuelo3);

	}
}
