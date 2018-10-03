package pt.andreiaribeiro.com.andreiaribeiro.view.services.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import pt.andreiaribeiro.com.andreiaribeiro.R;

public class ViewPagerAdapter extends PagerAdapter {

    private Context context;
    private String[] imageUrls;
    private LayoutInflater layoutInflater;

    public ViewPagerAdapter(Context context, String[] imageUrls){
        this.context = context;
        this.imageUrls= imageUrls;
    }

    @Override
    public int getCount() {
        return imageUrls.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        ImageView imageView = new ImageView(context);
        //layoutInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        //View view = layoutInflater.inflate(R.layout.custom_gallery, null);
        //ImageView imageView = (ImageView) view.findViewById(R.id.detail_gallimage);
        Picasso.with(context)
                .load(imageUrls[position])
                .fit()
                .centerCrop()
                .into(imageView);
        container.addView(imageView);
        return imageView;
    }


    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View )object);
    }
}
