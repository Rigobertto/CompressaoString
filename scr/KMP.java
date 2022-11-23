
public class KMP {
	
	public void getKMP(String padrao, String texto) {
		int M = padrao.length();
		int N = texto.length();

		// criar lps[] que ir� manter o mais longo
		// valores de sufixo de prefixo para padr�o
		int lps[] = new int[M];
		int j = 0; // index for pat[]

		// Pr�-processar o padr�o (calcular lps[]
		// array)
		//computeLPSArray(padrao, M, lps);
		int len = 0;
		int i = 1;
		lps[0] = 0; // lps[0] � sempre 0

		// o loop calcula lps[i] para i = 1 a M-1
		while (i < M) {
			if (padrao.charAt(i) == padrao.charAt(len)) {
				len++;
				lps[i] = len;
				i++;
			} else // (pat[i] != pat[len])
			{
				// Isso � complicado. Considere o exemplo.
				// AAACAAAA e i = 7. A ideia � semelhante
				// para a etapa de pesquisa.
				if (len != 0) {
					len = lps[len - 1];

					// Al�m disso, observe que n�o incrementamos
					// i aqui
				} else // se (len == 0)
				{
					lps[i] = len;
					i++;
				}
			}
		}
		

		int total = 0;
		i = 0; // �ndice para txt[]
		while ((N - i) >= (M - j)) {
			total = total + 1;
			if (padrao.charAt(j) == texto.charAt(i)) {
				j++;
				i++;

			}
			if (j == M) {
				System.out.println("Padr�o encontrado no �ndice: " + (i - j));
				j = lps[j - 1];
				// total = total +1;
				System.out.println("Total de Compara��es: " + total);

			}

			// incompatibilidade ap�s j correspond�ncias
			else if (i < N && padrao.charAt(j) != texto.charAt(i)) {
				// N�o corresponda aos caracteres lps[0..lps[j-1]],
				// eles v�o combinar de qualquer maneira

				if (j != 0) {
					j = lps[j - 1];

				} else {
					i = i + 1;
				}
			}
		}

	}
	
}
