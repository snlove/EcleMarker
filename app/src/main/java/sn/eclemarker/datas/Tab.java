package sn.eclemarker.datas;

import android.widget.TabHost;

/**标签数据封装类
 * Created by acer on 2016/2/19.
 */
public class Tab  {

      private int text;
     private int image;
     private Class aClass;

    public Tab(Class aClass, int image, int text) {
        this.aClass = aClass;
        this.image = image;
        this.text = text;
    }

    public Class getaClass() {
        return aClass;
    }

    public int getImage() {
        return image;
    }

    public int getText() {
        return text;
    }

    public void setaClass(Class aClass) {
        this.aClass = aClass;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public void setText(int text) {
        this.text = text;
    }
}
