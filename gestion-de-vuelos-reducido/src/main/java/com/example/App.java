package com.example;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class App {
	public static void main(String[] args) {

		/*
		 * A partir de las clases creadas, crear un listado de vuelos a tres destinos
		 * diferentes
		 */

		List<Vuelo> vuelos = new ArrayList<Vuelo>();

		// Vuelo 1 con destino PARIS

		Vuelo vuelo1 = Vuelo.builder().destino(Destino.PARIS).precio(new BigDecimal(150.0)).fechaSalida(LocalDate.now())
				.horaSalida(LocalTime.of(23, 30)).fechaLlegada(LocalDate.now().plusDays(1))
				.horaLlegada(LocalTime.of(12, 20)).numeroPlazas(3).build();

		// Pasajeros del vuelo 1

		Pasajero pasajero11 = Pasajero.builder().nombre("Yodalis Ninoska").primerApellido("Grillo")
				.segundoApellido("Castillo").fechaNacimiento(LocalDate.of(1990, Month.AUGUST, 4)).genero(Genero.MUJER)
				.build();

		Pasajero pasajero21 = Pasajero.builder().nombre("Juan Carlos").primerApellido("Gonzalez")
				.segundoApellido("Perez").fechaNacimiento(LocalDate.of(1985, Month.MARCH, 15)).genero(Genero.HOMBRE)
				.build();

		Pasajero pasajero31 = Pasajero.builder().nombre("Maria Fernanda").primerApellido("Lopez")
				.segundoApellido("Martinez").fechaNacimiento(LocalDate.of(1995, Month.DECEMBER, 20))
				.genero(Genero.MUJER).build();

		// Agregar los pasajeros anteriores a la lista de pasajeros el vuelo
		// que es la variable pasajeros de la clase Vuelo

//		vuelo1.getPasajeros().add(pasajero11);
//		vuelo1.getPasajeros().add(pasajero21);
//		vuelo1.getPasajeros().add(pasajero31);

		vuelo1.setPasajeros(Arrays.asList(pasajero11, pasajero21, pasajero31));

		// Vuelo 2 con destino MIAMI

		Vuelo vuelo2 = Vuelo.builder().destino(Destino.MIAMI).precio(new BigDecimal(800.0))
				.fechaSalida(LocalDate.of(2026, Month.JULY, 25)).horaSalida(LocalTime.of(22, 30))
				.fechaLlegada(LocalDate.of(2026, Month.JULY, 26)).horaLlegada(LocalTime.of(14, 20)).numeroPlazas(3)
				.build();

		// Pasajeros del vuelo 2

		Pasajero pasajero12 = Pasajero.builder().nombre("Carlos Alberto").primerApellido("Ramirez")
				.segundoApellido("Gomez").fechaNacimiento(LocalDate.of(1988, Month.JUNE, 10)).genero(Genero.HOMBRE)
				.build();

		Pasajero pasajero22 = Pasajero.builder().nombre("Ana Lucia").primerApellido("Torres").segundoApellido("Vargas")
				.fechaNacimiento(LocalDate.of(1992, Month.SEPTEMBER, 5)).genero(Genero.MUJER).build();

		vuelo2.setPasajeros(Arrays.asList(pasajero12, pasajero22));

		// Vuelo 3 con destino BARCELONA

		Vuelo vuelo3 = Vuelo.builder().destino(Destino.BARCELONA).precio(new BigDecimal(90.0))
				.fechaSalida(LocalDate.of(2026, Month.JULY, 10)).horaSalida(LocalTime.of(8, 30))
				.fechaLlegada(LocalDate.of(2026, Month.JULY, 10)).horaLlegada(LocalTime.of(22, 20)).numeroPlazas(3)
				.build();

		// Pasajeros del vuelo 3

		Pasajero pasajero13 = Pasajero.builder().nombre("Luis Fernando").primerApellido("Mendoza")
				.segundoApellido("Rojas").fechaNacimiento(LocalDate.of(1991, Month.NOVEMBER, 12)).genero(Genero.HOMBRE)
				.build();

		Pasajero pasajero23 = Pasajero.builder().nombre("Sofia Isabel").primerApellido("Castro")
				.segundoApellido("Hernandez").fechaNacimiento(LocalDate.of(1994, Month.APRIL, 18)).genero(Genero.MUJER)
				.build();

		Pasajero pasajero33 = Pasajero.builder().nombre("Diego Alejandro").primerApellido("Vega")
				.segundoApellido("Santos").fechaNacimiento(LocalDate.of(1987, Month.FEBRUARY, 25)).genero(Genero.HOMBRE)
				.build();

		vuelo3.setPasajeros(Arrays.asList(pasajero13, pasajero23, pasajero33));

		// Podemos construir la lista de vuelos

		vuelos = Arrays.asList(vuelo1, vuelo2, vuelo3);

		// Solucion al Ejercicio Preliminar

		Vuelo vueloConMasPasajeros = vuelos.stream()
				.max((v1, v2) -> Integer.valueOf(v1.getPasajeros().size()).compareTo(v2.getPasajeros().size()))
				.orElse(null);

		System.out.println("Vuelo con mas pasajeros es: ");
		System.out.println(vueloConMasPasajeros);

		// Pto 1.

		List<Vuelo> vuelosCompleto = vuelos.stream()
				.filter(vuelo -> vuelo.getPasajeros().size() == vuelo.getNumeroPlazas()).collect(Collectors.toList());

		// Modernamente, año 2026. No hace falta el metodo collect al final de la
		// tuberia
		// si quieres obtener una lista inmutable

		List<Vuelo> vuelosCompleto2 = vuelos.stream()
				.filter(vuelo -> vuelo.getPasajeros().size() == vuelo.getNumeroPlazas()).toList();

		System.out.println("Listado de vuelos completos ");
		System.out.println(vuelosCompleto2);

		// Pto 2

		List<Vuelo> vuelosHoy = vuelos.stream().filter(vuelo -> vuelo.getFechaSalida().isEqual(LocalDate.now()))
				.toList();

		System.out.println("Vuelos con salida para el dia de hoy: ");
		System.out.println(vuelosHoy);

		// Pto 3

		List<Vuelo> vuelosMasDe10Horas = vuelos.stream()
				.filter(vuelo -> ChronoUnit.HOURS.between(
						LocalDateTime.of(vuelo.getFechaSalida(), vuelo.getHoraSalida()),
						LocalDateTime.of(vuelo.getFechaLlegada(), vuelo.getHoraLlegada())) > 10)
				.toList();

		System.out.println("Vuelos que demoran mas de 10 horas en llegar a su destino ");
		System.out.println(vuelosMasDe10Horas);

		// Pto 4

		List<Vuelo> vuelosMasDe24Horas = vuelos.stream()
				.filter(vuelo -> ChronoUnit.HOURS.between(
						LocalDateTime.of(vuelo.getFechaSalida(), vuelo.getHoraSalida()),
						LocalDateTime.of(vuelo.getFechaLlegada(), vuelo.getHoraLlegada())) > 24)
				.toList();

		System.out.println("Vuelos que demoran mas de un dia en llegar a su destino ");
		System.out.println(vuelosMasDe24Horas);

		// Pto 5

		Map<Destino, List<Pasajero>> pasajerosPorDestino = vuelos.stream()
				.collect(Collectors.toMap(Vuelo::getDestino, Vuelo::getPasajeros));

		// Pto 6

		List<Vuelo> vuelosUltimos10DiasDelMes = vuelos.stream().filter(vuelo -> vuelo.getFechaSalida()
				.with(TemporalAdjusters.lastDayOfMonth()).minusDays(10).isBefore(vuelo.getFechaSalida())).toList();

		System.out.println("Vuelos que salen en los ultimos 10 dias del mes: ");
		System.out.println(vuelosUltimos10DiasDelMes);

		// Ejercicio al margen: Respecto al Pto 6, ademas de lo que se pide, que la
		// fecha de salida se corresponda con el mes actual

		List<Vuelo> vuelosUltimos10DiasDelMes2 = vuelos.stream()
				.filter(vuelo -> vuelo.getFechaSalida().with(TemporalAdjusters.lastDayOfMonth()).minusDays(10).isBefore(
						vuelo.getFechaSalida()) && vuelo.getFechaSalida().getMonth().equals(LocalDate.now().getMonth()))
				.toList();

		// Pto 7

		Map<Genero, Map<Long, List<Pasajero>>> pasajerosPorGeneroYEdad;

		pasajerosPorGeneroYEdad = vuelos.stream().flatMap(vuelo -> vuelo.getPasajeros().stream())
				.collect(Collectors.groupingBy(Pasajero::genero, Collectors.groupingBy(
						pasajero -> ChronoUnit.YEARS.between(pasajero.fechaNacimiento(), LocalDate.now()))));

		// Ejercicio al margen del Pto 7. En lugar de tener una lista de pasajeros,
		// quiero
		// una lista de nombres de pasajeros sin duplicados

		Map<Genero, Map<Long, Set<String>>> nombresDePasajerosPorGeneroYEdadSinDuplicados;

		nombresDePasajerosPorGeneroYEdadSinDuplicados = vuelos.stream().flatMap(vuelo -> vuelo.getPasajeros().stream())
				.collect(Collectors.groupingBy(Pasajero::genero,
						Collectors.groupingBy(
								pasajero -> ChronoUnit.YEARS.between(pasajero.fechaNacimiento(), LocalDate.now()),
								Collectors.mapping(pasajero -> pasajero.nombre(), Collectors.toSet()))));

		// Pto 8

		pasajerosPorGeneroYEdad.entrySet().forEach(entry1 -> {

			Genero key1 = entry1.getKey();
			System.out.println("Del Genero: " + key1);

			Map<Long, List<Pasajero>> value1 = entry1.getValue();

			value1.entrySet().forEach(entry2 -> {

				Long key2 = entry2.getKey();
				System.out.println("Con edad: " + key2);
				List<Pasajero> pasajeros = entry2.getValue();

				// Mostrar la lista de pasajeros ordenada segun el orden natural
				System.out.println("Los pasajeros, ordenados segun el Orden Natural, "
						+ "del record Pasajero son los siguientes: ");
				pasajeros.stream().sorted().forEach(System.out::println);

			});

		});

	}
}
