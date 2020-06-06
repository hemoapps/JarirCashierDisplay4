package jarircashierdisplay.hemo7f12;

import java.util.List;

public class MyListView {
    public String cp;
    public int img1, img2, img3;

    public MyListView(String cp, int img1, int img2, int img3){
  this.cp=cp;
  this.img1=img1;
  this.img2=img2;
  this.img3=img3;
    }//end listView


    public String getCp() {
        return cp;
    }

    public void setCp(String cp) {
        this.cp = cp;
    }

    public int getImg1() {
        return img1;
    }

    public void setImg1(int img1) {
        this.img1 = img1;
    }

    public int getImg2() {
        return img2;
    }

    public void setImg2(int img2) {
        this.img2 = img2;
    }

    public int getImg3() {
        return img3;
    }

    public void setImg3(int img3) {
        this.img3 = img3;
    }


}//end class