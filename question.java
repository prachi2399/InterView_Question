import java.util.PriorityQueue;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;
import java.util.HashMap;
import java.util.Arrays;
import java.util.*;
import java.util.Collections.reverseOrder;
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

    public static void longestStringwithout3consecutive(){
        String ans = longestStringwithout3consecutive(1,2,3);
        System.out.print(ans);
    }

    public static String webSite(String s){
        if(s.length()==0) return "";
        
        StringBuilder ans = new StringBuilder();
        int sidx=0;
        if(s.substring(0,3).equals("ftp")||s.substring(0,4).equals("http")){
             if(s.substring(0,3).equals("ftp")){
                 ans.append("ftp");
                 sidx=3;
             }else {
                 ans.append("http");
                 sidx=4;
             }      
        }
        ans.append("://");
        int eidx=s.indexOf("ru");
        String remaining = s.substring(sidx,eidx);
            System.out.println(remaining);
        ans.append(remaining);
        ans.append(".ru/");
        ans.append(s.substring(eidx+2));
            return new String(ans);
    }
    
    // maximum bounded array
    public static void maximumBoundedArray(int size, int ub, int lb) {
        if(size>((ub-lb)*2+1)) System.out.print("null");

        int mid = size%2==0?(size/2)-1:size/2;
        int[] result = new int[size];

        result[mid]=ub;
        int counter=1;
        for(int i=mid-1;i>=0;i--){
            result[i]=ub-counter;
            counter++;
        }

        counter=1;
        for(int i=mid+1;i<size;i++){
            result[i]=ub-counter;
            counter++;
        }

        for(int ele:result){
            System.out.print(ele+" ");
        }
    }

    // top k buzz wordsS

    public  static void getTopGames(int num, int topKGames, String[] games, int numReviews, String[] reviews) {
        HashMap<String, Integer> map = new HashMap<>();
        HashSet<String> set = new HashSet<>();
        for(String s:games){
            set.add(s);
        }

        for(int i=0;i<numReviews;i++){
            String str = reviews[i];
            String[] splitStr = str.trim().split("[ ,!]+");
            for(int k=0;k<splitStr.length;k++){
                String s = splitStr[k];
                if(set.contains(s)){
                    map.put(s,map.getOrDefault(s,0)+1);
                }
            }
        }

        List<Map.Entry<String, Integer>> sorted_map =
                map.entrySet()
                .stream()
                .sorted(reverseOrder(Map.Entry.comparingByKey()))
                .collect(Collectors.toList());

        List<String> ans = new ArrayList<>();
        int maxAns = 0;
        for(String key : sorted_map.keySet()){
            System.out.println(key +" "+ sorted_map.get(key));
        }

        
	}

    public static void getTopGames(){
        int num = 6;
        int topToys = 2;
        String[] toys = {"elmo", "elsa", "legos", "drone", "tablet", "warcraft"};
        int numQuotes = 6;
        String[] quotes = {
"Elmo is the hottest of the season! Elmo will be on every kid's wishlist!",
"The new Elmo dolls are super high quality",
"Expect the Elsa dolls to be very popular this year, Elsa!",
"Elsa and Elmo are the toys I'll be buying for my kids, Elsa is good",
"For parents of older kids, look into buying them a drone",
"Warcraft is slowly rising in popularity ahead of the holiday season"
        };
        getTopGames(num, topToys, toys, numQuotes, quotes);
    }

    public static void main(String[] args){
        //longestStringwithout3consecutive();
        //System.out.println(webSite("ftpsunrux "));
        //maximumBoundedArray(11,15,11);
        getTopGames();
    }
}