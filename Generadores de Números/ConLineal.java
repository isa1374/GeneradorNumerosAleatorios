public class ConLineal {
	int num;
	public double Calcular(int a, int c, int m, int x){
		double res;
		int sem =x; 
		num = ((a * sem + c )% m); 
		res = ((double)num / (double)m);
		return res;
	}
	public int num(){
		return num;
	}
	
}
