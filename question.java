import java.util.PriorityQueue;
public class question{

    public static class Pair{
        char ch;
        int freq;
        Pair(char ch, int freq){
            this.ch=ch;
            this.freq=freq;
        }
    }

    public static String longestStringwithout3consecutive(int A, int B, int C){
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->{
            return b.freq-a.freq;
        });

        if(A>0) pq.add(new Pair('A',A));
        if(B>0) pq.add(new Pair('B',B));
        if(C>0) pq.add(new Pair('C',C));
        
        StringBuilder ans=new StringBuilder();

        while(pq.size()>0){
            Pair one = pq.poll();
            ans.append(one.ch);
            one.freq--;

            if(pq.size()>0){
                Pair two = pq.poll();
                if(one.freq>two.freq){
                    ans.append(one.ch);
                    one.freq--;
                    ans.append(two.ch);
                    two.freq--;
                }
                if(two.freq>0){
                    pq.add(two);
                }
            }
            else if(one.freq>0){
                ans.append(one.ch);
                one.freq--;
                return new String(ans);
            }
            if(one.freq>0){
                pq.add(one);
            }
        }
        return new String(ans);
    }

    public static void main(String[] args){
        String ans = longestStringwithout3consecutive(1,2,3);
        System.out.print(ans);
    }
}