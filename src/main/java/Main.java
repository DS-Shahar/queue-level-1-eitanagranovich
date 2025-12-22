import java.util.*;
public class Main {	

	static Scanner reader = new Scanner(System.in);
	public static void main(String[] args) {
	    Queue<Integer> q = new Queue<>();
	    q.insert(1);
	    q.insert(5);
	    q.insert(3);
	    
	    Queue<Integer> q1 = new Queue<>();
	    q1.insert(11);
	    q1.insert(2);
	    q1.insert(33);
	    
	    System.out.println("original queue");
	    System.out.println(q);
        System.out.println("check if exist:" + checkIfExist(q, 8));
        System.out.println("exercise 1:");
        Queue<Integer> qCopy = ex1(q);
        System.out.println(qCopy);
        System.out.println("exercise 2:" + ex2(q));
        System.out.println("exercise 3:" + ex3(q, 5));
        System.out.println("exercise 4:" + ex4(q, q1));
        System.out.println("exercise 5:" + ex5(q, 3));
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
    
    public static int ex3(Queue<Integer> q, int num){
         Queue<Integer> qCopy = ex1(q); 
         int count = 0;
         while(!qCopy.isEmpty()){
            if (qCopy.remove() % num == 0){
                count++;
            } 
        }
        return count;
    }
    
    public static boolean ex4(Queue<Integer> q, Queue<Integer> q1) {
        Queue<Integer> qCopy = ex1(q);
    
        while (!qCopy.isEmpty()) {
            int a = qCopy.remove();
            boolean found = false;
    
            Queue<Integer> q1_Copy = ex1(q1);
            while (!q1_Copy.isEmpty() && !found) {
                int b = q1_Copy.remove();
                if (b % a == 0) {
                    found = true;
                }
            }
    
            if (!found) {
                return false;
            }
        }
        return true;
    }
    
    public static boolean ex5(Queue<Integer> q, int num){
        Queue<Integer> qCopy = ex1(q);
        int count = 0;
        while(!qCopy.isEmpty()){
            if (qCopy.remove() == num){
                count++;
            }else{
                count = 0;
            }
            if (count > 1){
                return true;
            } 
        }
        return false;
    }
    
    
}
