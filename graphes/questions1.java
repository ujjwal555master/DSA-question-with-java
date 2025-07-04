// Question Steps :
// 1. take the input first text in String array and take the array size
// 2. find the odd length word and store the word in the another array 
// 3. find the maximum length of these array

import java.util.*;
class questions{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the array number");
        int n = sc.nextInt();

        String arr[] = new String[n];
        System.out.println("Enter the number");

        for(int i=0; i<n; i++){
            arr[i] = sc.next();
        }

        ArrayList<String> ans = new ArrayList<>();

        for(int i=0; i<n; i++){
            if(arr[i].length()%2==1){
                ans.add(arr[i]);
            }
        }
        if(ans.size()==0){
            System.out.println("Better LUCK Next time");
        }else{
            Iterator itr = ans.iterator();
            int max=-1;
            String res = "";

            while(itr.hasNext()){
                String temp = (String)itr.next();
                if(temp.length()>max){
                    res = temp;
                    max = temp.length();
                }
            }
            System.out.println(res);
        }

        

        System.out.println("heeloo");
    }
}