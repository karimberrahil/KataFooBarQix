package kata;
import java.util.HashMap;
import java.util.Iterator;

/*
 * Programme qui affiche les nombres de 1 à 100. Un nombre par ligne. 
 * Avec les règles suivantes :
 * Si le nombre est divisible par 3 ou contient 3, écrire “Foo” à la place de 3.
 * Si le nombre est divisible par 5 ou contient 5, écrire “Bar” à la place de 5.
 * Si le nombre est divisible par 7 ou contient 7, écrire “Qix” à la place de 7. 
 * On regarde les diviseurs avant le contenu
 * On regarde le contenu dans l'ordre où il apparait 
 * On regarde les multiples dans l'ordre Foo, Bar puis Qix 
 */
public class PrinterFooBarQix {
	
    /*
     * Si number est divisible par 3, 5 ou 7
     * retourne la combinaison de mot (Foo, Bar, Qix) correspondant
     */
    public static String convertDivisible(String number)
    {
    	String mot="";
    	//HashMap contenant la combinaison entier/mot
    	HashMap<Integer, String> translate= new HashMap<Integer, String>();
    	translate.put(3, "Foo");
    	translate.put(5, "Bar");
    	translate.put(7, "Qix");
        	
		Iterator<Integer> listeNombres = translate.keySet().iterator();
		while(listeNombres.hasNext()){//parcourt la HashMap
		  Integer key = listeNombres.next();//key recupere l'indice actuel du parcourt de la HashMap 
		  if(Integer.parseInt(number)%key==0)//Si number est divisible par un indice de la HashMap
			  mot+=translate.get(key);//Ajoute a mot le texte associe a l'indice
		}
		return mot;
    }
    
    /*
     * Remplace chaque entier de la HashMap (3, 5, 7) par le mot correspondant
     */
    public static String numberToWord(String number)
    {
    	String mot="";
    	if(number.contains("3")||number.contains("5")||number.contains("7"))
		{
			for(int i=0; i<number.length(); i++)
			{
				switch (number.charAt(i)) {
	            case '3':
	            	mot+="Foo";
	                break;
	            case '5':
	            	mot+="Bar";
	                break;
	            case '7':
	            	mot+="Qix";
	                break;
	            default:
	                break;
				}
			}
		}
    	return mot;
    }
    
    /*
     * Remplace number par la combinaison de mot(s)correspondant
     * si number contient ou est divisible par 3, 5 ou 7
     */
	public static String setWord(String number)
	{
		String mot=convertDivisible(number);	
		mot+=numberToWord(number);	
		if(mot.compareTo("")==0)
			return number;
		else
			return mot;
	}

	/*
	 * Affiche sur 100 ligne, les nombres de 1 a 100
	 * Si le nombre contient ou est divisible par 3, 5 ou 7, le nombre est change
	 * en fonction du mot correspondant Foo, Bar ou Qix
	 */
	public static void printWords()
	{
		for(int i=1; i<=100; i++)
		{
			System.out.println(setWord(Integer.toString(i)));
		}			
	}
	
}
