package josephvarghese.roundmelon.dell.bharathamone;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by DELL on 16-08-2016.
 */
public class PagerAdapter1 extends FragmentStatePagerAdapter {

    int mNumOfTabs;

    public PagerAdapter1(FragmentManager fm, int NumOfTabs) {
        super(fm);
        this.mNumOfTabs = NumOfTabs;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                Tab0 tab0 = new Tab0();
                return tab0;

            case 1:
                Tab1 tab1 = new Tab1();
                return tab1;

            case 2:
                Tab2 tab2 = new Tab2();
                return tab2;

            case 3:
                Tab3 tab3 = new Tab3();
                return tab3;

            case 4:
                Tab4 tab4 = new Tab4();
                return tab4;

            case 5:
                Tab5 tab5 = new Tab5();
                return tab5;

            case 6:
                Tab6 tab6 = new Tab6();
                return tab6;

            case 7:
                Tab7 tab7 = new Tab7();
                return tab7;

            case 8:
                Tab8 tab8 = new Tab8();
                return tab8;

            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }

}