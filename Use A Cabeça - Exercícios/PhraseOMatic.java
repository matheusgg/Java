public class PhraseOMatic{
	public static void main(String[] args){
		String[] wordListOne = {"24/7", "v�rias camadas", "30.000 p�s", "B-to-B", "todos ganham", "front-end", "baseado na Web", "difundido", "inteligente", "seis sigma", "caminho cr�tico", "din�mico"};
		String[] wordListTwo = {"habilitado", "adesivo", "valor agregado", "orienta��o", "cental", "distribu�do", "agrupado", "solidificado", "independente da m�quina", "posicionado", "em rede", "dedicado", "alavancado", "alinhado", "destinado", "compartilhado", "cooperativo", "acelerado"};
		String[] wordListThree = {"processo", "ponto m�ximo", "solu��o", "arquitetura", "habilita��o no n�cleo", "estrat�gia", "mindshare", "portal", "espa�o", "vis�o", "paradigma", "miss�o"};
		
			int oneLength = wordListOne.length;
			int twoLength = wordListTwo.length;
			int threeLength = wordListThree.length;
			
			int rand1 = (int) (Math.random() * oneLength);
			int rand2 = (int) (Math.random() * twoLength);
			int rand3 = (int) (Math.random() * threeLength);
			
			String phrase = wordListOne[rand1] + " " + wordListTwo[rand2] + " " + wordListThree[rand3];
			
			System.out.println("Precisamos de " + phrase);
		}
	}