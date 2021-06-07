public class Solution2 {
    public int minDays(int[] bloomDay, int m, int k) {
        if(bloomDay.length < m*k){
            return -1;
        }
        int min = bloomDay[0];
        int max = bloomDay[0];
        for(int i=0;i<bloomDay.length;i++){
            if(bloomDay[i]<min){
                min = bloomDay[i];
            }
            if(bloomDay[i]>max){
                max = bloomDay[i];
            }
        }
        int low =min, high=max;
        int day = Integer.MAX_VALUE;
        while(low<=high){
            int mid = low + (high-low)/2;
            
            if(feasible(bloomDay, m,k,mid)){
                day = Math.min(day, mid);
                high = mid-1;
            } else {
                low = mid+1;
            }
        }
        
        if(day == Integer.MAX_VALUE){
            return -1;
        } else {
            return day;
        }
    }
    
    
    
    static boolean feasible(int[] bloomDay, int m,int k,int mid){
        
        int count =0,b = 0;
        for(int i=0;i<bloomDay.length;i++){
            if(bloomDay[i]<=mid){
                int j = i;
                while(j<bloomDay.length && bloomDay[j]<= mid ){
                     count++;j++;
                     if(count == k){
                         b++;
                         count = 0;
                     }
                     if(b == m){
                         return true;
                     }
                    
                    
                    }
                i=j;
                count =0;
                }
           
            }
         return false;
        }
    }
