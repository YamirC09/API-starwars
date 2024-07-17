package coronado.yamir.principal;

import java.io.IOException;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        ConsultaPelicula consulta = new ConsultaPelicula();
        CreadorArhivos archivo = new CreadorArhivos();
        System.out.println("Escriba el numero de la pelicula que desea consultar");
        try {
            var numeroDePelicula = Integer.valueOf(teclado.nextLine());
            Pelicula pelicula = consulta.buscaPelicula(numeroDePelicula);
            archivo.guardarJson(pelicula);
            System.out.println(pelicula);
        }catch (RuntimeException e){
            System.out.println("No digitaste un numero " + e.getMessage());
            System.out.println("Programa finalizado.");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
