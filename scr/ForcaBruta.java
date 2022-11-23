
public class ForcaBruta {
	
	public void getForcaBruta(String padrao, String texto) {

		Integer M = padrao.length();
		Integer N = texto.length();
		Integer i, j;
		int total = 0;

		/* loop para percorrer padrao caractere por caractere */
		for (i = 0; i <= N - M; i++) {
			
			// Para cada �ndice i, verificar se ocorre correspond�ncia de padr�o
			for (j = 0; j < M; j++) {
				total = total + 1;
				if (texto.charAt(i + j) != padrao.charAt(j))
					break;
			}

			if (j == M) { // se padrao[0...M-1] = texto[i, i+1, ...i+M-1]

				System.out.println("Padr�o encontrado no �ndice " + i);
				System.out.println("Total de Compara��es: " + total);
			}
		}

	}
}
