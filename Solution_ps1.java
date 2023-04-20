import java.util.*;
public class MyClass {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        Song[] sng=new Song[4];
        for(int i=0;i<4;i++){
            int a;
            a=sc.nextInt();
            sc.nextLine();
            String b;
           b= sc.nextLine();
            String c;
           c=sc.nextLine();
            double d;
            d=sc.nextDouble();
            sc.nextLine();

            sng[i]=new Song(a,b,c,d);
        }
    String st1=sc.nextLine();
    String st2=sc.nextLine();

   double ans1=findSongDurationForArtist(sng,st1);
   if(ans1!=0){
       System.out.println(ans1);
   }
   else{
       System.out.println("There are no songs with given artist");
   }
   Song[] ans2= getSongsInAscendingOrder(sng,st2);
   if(ans2!=null){
     for(int i=0;i<ans2.length;i++){
         System.out.println(ans2[i].getId());
         System.out.println(ans2[i].getTitle());
     }
   }
   else{
       System.out.println("There are no songs with given artist");
   }
}
    public static double findSongDurationForArtist(Song[] s,String st){
       double sumans=0;
       for(int i=0;i<s.length;i++){
           if(s[i].getArtist().equalsIgnoreCase(st))sumans+=s[i].getDuration();
       }
       return sumans;
    }

    //Method 2
    public static Song[] getSongsInAscendingOrder(Song[] s,String st){
       Song[] arr=new Song[0];
       for(int i=0;i<s.length;i++){
          if(s[i].getArtist().equalsIgnoreCase(st)){
              arr=Arrays.copyOf(arr,arr.length+1);
              arr[arr.length-1]=s[i];
          }
       }

       for(int i=0;i<arr.length-1;i++){
           for(int j=i;j< arr.length;j++){
               if(arr[i].getDuration()>arr[j].getDuration()){
                   Song k = arr[i];
                   arr[i]=arr[j];
                   arr[j]=k;
               }
           }
       }

       if(arr.length>0)return arr;
       else
            return null;
    }
}



class Song
{
    int id;
    String title;
    String artist;
    double duration;
    public Song(int id, String title, String artist, double duration) {
        this.id = id;
        this.title = title;
        this.artist = artist;
        this.duration = duration;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getArtist() {
        return artist;
    }
    public void setArtist(String artist) {
        this.artist = artist;
    }
    public double getDuration() {
        return duration;
    }
    public void setDuration(double duration) {
        this.duration = duration;
    }

}
