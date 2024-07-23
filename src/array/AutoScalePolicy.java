package array;

/**
 * https://cybergeeksquad.co/2021/06/autoscale-policy-utilization-check.html
 */
public class AutoScalePolicy {
    public static void main(String[] args) {
        int[] arr = {25,61,1,2,3,4,5,6,7,8,9,10, 76,80};
        new AutoScalePolicy().find(arr, 2);
    }

    int find(int[] scales, int instances){
        for(int i =0; i<scales.length; i++){
            if(scales[i] < 25 && scales[i] >=2){
              instances = (int)Math.ceil(instances/2);
              i += 10;
              if(i >= scales.length)
                  break;
            }
            else if(scales[i] > 60 && instances*2 < 217){
                instances = instances*2;
                i += 10;
                if(i >= scales.length)
                    break;
            }
        }
        return instances;
    }
}
