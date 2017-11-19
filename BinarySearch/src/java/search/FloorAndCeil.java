package search;

/**floor函数当找到当前值的时候，会去找最先出现的index
 * ceil函数当找到当前值的时候，会去找最后出现的index,当不存在目标值的时候，floor返回前1，ceil返回后1
 * Created by 18362 on 2017/11/17.
 */
public class FloorAndCeil {
    public static int floor(Comparable []arr,Comparable target)
    {
        int length=arr.length;
        int l=0;
        int r=length-1;
        while(l<=r)
        {
            int mid=l+(r-l)/2;
            if(arr[mid]==target)
            {
                int i=mid-1;
                for(;i>=0&&arr[i]==target;i--);
                return i+1;
            }
            else if(arr[mid].compareTo(target)>0)
                r=mid-1;
            else
                l=mid+1;
        }
        return l-1;
    }
    public static int ceil(Comparable []arr,Comparable target)
    {
        int length=arr.length;
        int l=0;
        int r=length-1;
        while(l<=r)
        {
            int mid=l+(r-l)/2;
            if(arr[mid]==target)
            {
                int i=mid+1;
                for(;i<length&&arr[i]==target;i++);
                return i-1;
            }
            else if(arr[mid].compareTo(target)>0)
                r=mid-1;
            else
                l=mid+1;
        }
        return l;
    }
    public static void main(String args[])
    {
        Integer arr[]={1,2,3,4,5,6,8,8,8,8,11,11,13,14,15,18};
        int res=floor(arr,9);
        System.out.println(res);
    }
}
