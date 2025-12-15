import java.util.*;
public class Main {	

	static Scanner reader = new Scanner(System.in);
	public static void main(String[] args) {
	    Queue<Integer> q = new Queue<>();
	    q.insert(1);
	    q.insert(5);
	    q.insert(3);
	    System.out.println("original queue");
	    System.out.println(q);
        System.out.println("check if exist:" + checkIfExist(q, 8));
        System.out.println("exercise 1:");
        Queue<Integer> qCopy = ex1(q);
        System.out.println(qCopy);
        System.out.println("exercise 2:" + ex2(q));
	}
	
	public static boolean checkIfExist(Queue<Integer> q1, int x){
	    Queue<Integer> temp = new Queue<>();
	    while(!q1.isEmpty()){
	        int num = q1.remove();
	        if (num == x){
	            return true;
	        }
	        temp.insert(num);
	    }
	    
	    while(!temp.isEmpty()){
	        q1.insert(temp.remove());
	    }
	    return false;
	}

    public static Queue<Integer> ex1(Queue<Integer> q){
        Queue<Integer> qNew = new Queue<>();
        Queue<Integer> temp = new Queue<>();
    
        while(!q.isEmpty()){
            int num = q.remove();
            qNew.insert(num);
            temp.insert(num);
        }
    
        while(!temp.isEmpty()){
            q.insert(temp.remove());
        }
    
        return qNew;
    }
    
    public static double ex2(Queue<Integer> q){
        Queue<Integer> qCopy = ex1(q);
        double sum = 0;
        double count = 0;
        while(!qCopy.isEmpty()){
            count = count + 1;
            int num = qCopy.remove();
            sum = sum + num;
        }
        return sum/count;
    }
    
}
