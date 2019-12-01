package com.wessam.movieapp.ui.movie.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;

import com.flaviofaria.kenburnsview.KenBurnsView;
import com.squareup.picasso.Picasso;
import com.wessam.movieapp.R;
import com.wessam.movieapp.data.db.moviedetails.ProductionCompanies;

import java.util.List;

public class MovieProductionCompaniesAdapter extends RecyclerView.Adapter<MovieProductionCompaniesAdapter.ProductionCompaniesViewHolder> {

    private Activity activity;
    private List<ProductionCompanies> productionCompaniesList;

    public MovieProductionCompaniesAdapter(Activity activity, List<ProductionCompanies> productionCompaniesList) {
        this.activity = activity;
        this.productionCompaniesList = productionCompaniesList;
    }

    @NonNull
    @Override
    public ProductionCompaniesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(activity).inflate(R.layout.production_companies_layout_item, parent, false);
        return new ProductionCompaniesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductionCompaniesViewHolder holder, int position) {
        final ProductionCompanies productionCompanies = productionCompaniesList.get(position);
        holder.productionCompanyName.setText(productionCompanies.getName());
        holder.setProductionCompanyImageView(productionCompanies.getLogo_path());
    }

    @Override
    public int getItemCount() {
        return productionCompaniesList.size();
    }

    public class ProductionCompaniesViewHolder extends RecyclerView.ViewHolder {

        private KenBurnsView productionCompanyImageView;
        private AppCompatTextView productionCompanyName;

        public ProductionCompaniesViewHolder(@NonNull View itemView) {
            super(itemView);
            productionCompanyImageView = itemView.findViewById(R.id.production_company_image_view);
            productionCompanyName = itemView.findViewById(R.id.production_company_name);
        }

        public void setProductionCompanyImageView(String url){
            Picasso.get().load(url).placeholder(R.drawable.logo).into(productionCompanyImageView);
        }

    }
}
