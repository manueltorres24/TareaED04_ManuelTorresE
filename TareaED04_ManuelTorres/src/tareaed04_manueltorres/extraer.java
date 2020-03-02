package tareaed04_manueltorres;

import java.util.Scanner;

public class extraer extends TareaED04_ManuelTorres {

	/**
	 * @param contadorCaras
	 * @param contadorCruces
	 * @param maximoCarasDoblesConsecutivas
	 * @param maximoCrucesDoblesConsecutivas
	 */
	public static void imprime(int contadorCaras, int contadorCruces, int maximoCarasDoblesConsecutivas,
			int maximoCrucesDoblesConsecutivas) {
		System.out.println("Caras: " + contadorCaras + ", Cruces: " + contadorCruces);
		System.out.println("Maximo de caras dobles consecutivas: " + maximoCarasDoblesConsecutivas);
		System.out.println("Maximo de cruces dobles consecutivas: " + maximoCrucesDoblesConsecutivas);
	}

	public static void main(String[] args) {
	//las variables a y b servir�n para guardar el resultado de la tirada de dos monedas
			int mondenaUno, monedaDos;
			int contadorCaras = 0, contadorCruces = 0, numTiradas;
	//las variables contador1 y contador2 servir�n para guardar el n�mero de caras y cruces dobles consecutivas
			int caraDobleConsecutiva = 0, cruzDobleConsecutiva = 0;
			int maximoCarasDoblesConsecutivas = 0, maximoCrucesDoblesConsecutivas = 0;
			boolean esCruzDoble = false, esCaraDoble = false;
			String tirada1;
			String tirada2;
			Scanner teclado = new Scanner(System.in);
	
			do {
				System.out.print("Introduce el n�mero de veces que se van a lanzar las monedas (max 50): ");
				numTiradas = teclado.nextInt();
			} while (numTiradas < 1 || numTiradas > 50);
	
			for (int i = 0; i < numTiradas; i++) {
				mondenaUno = (int) (Math.random() * 2);
				monedaDos = (int) (Math.random() * 2);
	
				if (mondenaUno == 0) {
					contadorCaras++;
					tirada1 = "cara";
				} else {
					contadorCruces++;
					tirada1 = "cruz";
				}
				if (monedaDos == 0) {
					contadorCaras++;
					tirada2 = "cara";
				} else {
					contadorCruces++;
					tirada2 = "cruz";
				}
				System.out.println("Moneda 1: " + tirada1 + ", Moneda 2: " + tirada2);
	
				if (mondenaUno == monedaDos) {
					if (mondenaUno == 0) {
						esCaraDoble = true;
						esCruzDoble = false;
					} else {
						esCaraDoble = false;
						esCruzDoble = true;
					}
				} else {
					esCaraDoble = false;
					esCruzDoble = false;
				}
	
				if (esCaraDoble) {
					caraDobleConsecutiva++;
					if (caraDobleConsecutiva > maximoCarasDoblesConsecutivas) {
						maximoCarasDoblesConsecutivas = caraDobleConsecutiva;
					}
				} else {
					caraDobleConsecutiva = 0;
				}
	
				if (esCruzDoble) {
					cruzDobleConsecutiva++;
					if (cruzDobleConsecutiva > maximoCrucesDoblesConsecutivas) {
						maximoCrucesDoblesConsecutivas = cruzDobleConsecutiva;
					}
				} else {
					cruzDobleConsecutiva = 0;
				}
			}
	
			TareaED04_ManuelTorres.imprime(contadorCaras, contadorCruces, maximoCarasDoblesConsecutivas, maximoCrucesDoblesConsecutivas);
		}

}
