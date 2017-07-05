import java.util.ArrayList;
import java.util.Collections;

public class ConMix {
	int num; 
	public double Calcular(int a, int c, int m, int x){
		double bla;
		int sem =x; 
		num = ((a * sem + c )% m); 
		bla = ((double)num / (double)m);
		return bla; 
	}
	public int num(){
		return num;
	}
	public boolean Hull(int m, int c, int a){
		boolean cont = false;
		if((obtenerMCD(m,c)==1)){
			cont = true; 
		}else{
			cont =false;
		}
		if((((a-1)%factorPrimo(m))==0)){
			cont=true; 
		}else{
			cont=false; 
		}
		if(4%m==0){
			if(4%(a-1)==0){
				cont=true; 
			}else{
				cont=false;
			}
		}
		return cont;
	}
	public String resHull(int m, int c, int a){
		String ans=" ";
		if(Hull(m,c,a)==true){
			ans= ("Se cumple el teorema de Hull-Dobell."+'\n'+ "El número de iteraciones para la recuperación de la semilla es: " + m);
		}else{
			ans= "No se cumple el teorema de Hull-Dobell."+'\n'+ "No se sabe el número de iteraciones para la recuperación de la semilla.";
		}
		return ans; 
	}
	public int obtenerMCD(int a, int b){
		int r;
		if(b==0){
			return a; 
		}else{
			return obtenerMCD(b, a%b); 
		}
	}
	public int factorPrimo(int num){
		ArrayList<Integer> factores = new ArrayList<Integer>();
		for(int i=2; i<=num; i++){
			while(num % i == 0){
				factores.add(i);
				num/= i; 
			}
		}
		Collections.sort(factores, Collections.reverseOrder());
		return factores.get(0); 
	}
}
