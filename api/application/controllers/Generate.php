<?php
defined('BASEPATH') OR exit('No direct script access allowed');

class Generate extends CI_Controller {

	/**
	 * Index Page for this controller.
	 *
	 * Maps to the following URL
	 * 		http://example.com/index.php/welcome
	 *	- or -
	 * 		http://example.com/index.php/welcome/index
	 *	- or -
	 * Since this controller is set as the default controller in
	 * config/routes.php, it's displayed at http://example.com/
	 *
	 * So any other public methods not prefixed with an underscore will
	 * map to /index.php/welcome/<method_name>
	 * @see http://codeigniter.com/user_guide/general/urls.html
	 */
	 function __construct()
	 {
		 parent::__construct();

	 }


	/**
   * Display a listing of the resource.
   *
   * @return Response
   */
	public function index()
	{
        $tabel = ($this->uri->segment(3)?$this->uri->segment(3):"movies");
        ?>
API PHP <br/>
<textarea style="width:100%;height:100px;">
$result["results"] = $this->db->get("<?=$tabel?>")->result_array();
$this->set_response($result, REST_Controller::HTTP_OK); // OK (200) being the HTTP response code
</textarea><br/>
Android Model<br/>
<textarea style="width:100%;height:100px;">
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class <?=ucfirst($tabel)?> {
    <?php
    $fields = $this->db->query("DESC ".$tabel)->result();
    $parameter =array ();
    $parameters =array ();
    $n = "
    ";
    foreach($fields as $row)
    {
        $attributes1[] = '@SerializedName("'.$row->Field.'") private String '.$row->Field.' ;';
        
        $parameter[] = "String ".$row->Field;
        $parameters[] = "this.{$row->Field} = {$row->Field};";
        $getter[] = "public String get".ucfirst($row->Field)."() { return ".$row->Field."; }";
        $setter[] = "public void set".ucfirst($row->Field)."() { this.".$row->Field." = {$row->Field}; }";
        
    }
    echo implode($attributes1,$n);
    echo $n;
    ?>
    public <?=ucfirst($tabel)?>(<?=implode($parameter,",")?>){
        <?= implode($parameters,$n); ?>
    }
    <?php
    echo implode($setter,$n);
    echo $n;
    echo implode($getter,$n);
    echo $n;
    ?>
}
</textarea><br/>
Android Model Response
<textarea style="width:100%;height:100px;">
import com.google.gson.annotations.SerializedName;
import java.util.List;

public class <?=ucfirst($tabel)?>Response {
    @SerializedName("page") private int page;
    @SerializedName("results") private List<<?=ucfirst($tabel)?>> results;
    @SerializedName("total_results") private int totalResults;
    @SerializedName("total_pages") private int totalPages;
    
    public int getPage() { return page; }
    public void setPage(int page) { this.page = page; }
    public List<<?=ucfirst($tabel)?>> getResults() { return results; }
    public void setResults(List<<?=ucfirst($tabel)?>> results) { this.results = results; }
    public int getTotalResults() { return totalResults; }
    public void setTotalResults(int totalResults) { this.totalResults = totalResults; }
    public int getTotalPages() { return totalPages; }
    public void setTotalPages(int totalPages) { this.totalPages = totalPages; }
}
</textarea><br/>
Android Adapter
<textarea style="width:100%;height:100px;">
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.util.List;
import info.androidhive.retrofit.R;
import info.androidhive.retrofit.model.<?=ucfirst($tabel)?>;
public class <?=ucfirst($tabel)?>Adapter extends RecyclerView.Adapter<<?=ucfirst($tabel)?>Adapter.<?=ucfirst($tabel)?>ViewHolder> {
    private List<<?=ucfirst($tabel)?>> <?=$tabel?>;
    private int rowLayout;
    private Context context;
    
    public static class <?=ucfirst($tabel)?>ViewHolder extends RecyclerView.ViewHolder {
        LinearLayout <?=$tabel?>Layout;
        // TextView movieTitle;
    
        public <?=ucfirst($tabel)?>ViewHolder(View v) {
            super(v);
            <?=$tabel?>Layout = (LinearLayout) v.findViewById(R.id.<?=$tabel?>_layout);
            // movieTitle = (TextView) v.findViewById(R.id.title);
            
        }
    }
    public <?=ucfirst($tabel)?>Adapter(List<<?=ucfirst($tabel)?>> <?=$tabel?>, int rowLayout, Context context) {
        this.<?=$tabel?> = <?=$tabel?>;
        this.rowLayout = rowLayout;
        this.context = context;
    }
    // mulai
    @Override
    public <?=ucfirst($tabel)?>Adapter.<?=ucfirst($tabel)?>ViewHolder onCreateViewHolder(ViewGroup parent,
                                                            int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(rowLayout, parent, false);
        return new <?=ucfirst($tabel)?>ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(<?=ucfirst($tabel)?>ViewHolder holder, final int position) {
        // holder.movieTitle.setText(<?=$tabel?>.get(position).getTitle());
    }

    @Override
    public int getItemCount() {
        return <?=$tabel?>.size();
    }
    
}
</textarea><br/>
APIInterface<br/>
<textarea style="width:100%;height:100px;">
@GET("<?=$tabel?>/list")
Call<<?=ucfirst($tabel)?>Response> <?=$tabel?>List();
</textarea><br/>
Layout : activity_<?=$tabel?><br/>
<textarea style="width:100%;height:100px;">
<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent">

    <android.support.v7.widget.RecyclerView
        android:id="@+id/<?=$tabel?>_recycler_view"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:scrollbars="vertical" />

</RelativeLayout>
</textarea>
Layout : list_item_<?=$tabel?><br/>
<textarea style="width:100%;height:100px;">
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:id="@+id/<?=$tabel?>_layout"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    android:gravity="center_vertical"
    android:minHeight="72dp"
    android:orientation="horizontal"
    android:padding="16dp">
    <LinearLayout
        android:layout_height="wrap_content"
        android:layout_weight="1"
        android:orientation="vertical">

        <TextView
            android:id="@+id/title"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_gravity="top"
            android:paddingRight="16dp"
            android:textStyle="bold"
            android:textColor="@color/colorBlack"
            android:textSize="16sp" />


        <TextView
            android:id="@+id/subtitle"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:paddingRight="16dp"
            android:textColor="@color/colorGreyLight" />

        <TextView
            android:id="@+id/description"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:maxLines="3"
            android:paddingRight="16dp"
            android:textColor="@color/colorGreyLight" />

    </LinearLayout>
</LinearLayout>
</textarea><br/>
Main Activity<br/>
<textarea style="width:100%;height:100px;">
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.util.List;

import info.androidhive.retrofit.R;
import info.androidhive.retrofit.RecyclerTouchListener;
import info.androidhive.retrofit.adapter.<?=ucfirst($tabel)?>Adapter;
import info.androidhive.retrofit.model.<?=ucfirst($tabel)?>;
import info.androidhive.retrofit.model.<?=ucfirst($tabel)?>Response;
import info.androidhive.retrofit.rest.ApiClient;
import info.androidhive.retrofit.rest.ApiInterface;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class <?=ucfirst($tabel)?>Activity extends AppCompatActivity {
    List<<?=ucfirst($tabel)?>> <?=$tabel?> ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_<?=$tabel?>);

        final RecyclerView recyclerView = (RecyclerView) findViewById(R.id.<?=$tabel?>_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        ApiInterface apiService =
                ApiClient.getClient().create(ApiInterface.class);
        Call<<?=ucfirst($tabel)?>Response> call = apiService.<?=$tabel?>List();

        call.enqueue(new Callback<<?=ucfirst($tabel)?>Response>() {
            @Override
            public void onResponse(Call<<?=ucfirst($tabel)?>Response> call, Response<<?=ucfirst($tabel)?>Response> response) {
                int statusCode = response.code();
                <?=$tabel?> = response.body().getResults();
                recyclerView.setAdapter(new <?=ucfirst($tabel)?>Adapter(<?=$tabel?>, R.layout.list_item_<?=$tabel?>, getApplicationContext()));
            }

            @Override
            public void onFailure(Call<<?=ucfirst($tabel)?>Response> call, Throwable t) {
                // Log error here since request failed
                //Log.e(TAG, t.toString());
            }
        });
        recyclerView.addOnItemTouchListener(new RecyclerTouchListener(getApplicationContext(), recyclerView, new RecyclerTouchListener.ClickListener() {
            @Override
            public void onClick(View view, int position) {
                Toast.makeText(getApplicationContext(), <?=$tabel?>.get(position).getTitle() + " is selected!", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));

    }
}

</textarea>
Main Simple Activity<br/>
<textarea style="width:100%;height:100px;">
        final RecyclerView recyclerView = (RecyclerView) findViewById(R.id.<?=$tabel?>_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        ApiInterface apiService =
                ApiClient.getClient().create(ApiInterface.class);
        Call<<?=ucfirst($tabel)?>Response> call = apiService.<?=$tabel?>List();
        List<<?=ucfirst($tabel)?>> <?=$tabel?> ;
        call.enqueue(new Callback<<?=ucfirst($tabel)?>Response>() {
            @Override
            public void onResponse(Call<<?=ucfirst($tabel)?>Response> call, Response<<?=ucfirst($tabel)?>Response> response) {
                int statusCode = response.code();
                <?=$tabel?> = response.body().getResults();
                recyclerView.setAdapter(new <?=ucfirst($tabel)?>Adapter(<?=$tabel?>, R.layout.list_item_<?=$tabel?>, getApplicationContext()));
            }

            @Override
            public void onFailure(Call<<?=ucfirst($tabel)?>Response> call, Throwable t) {
                // Log error here since request failed
                Log.e(TAG, t.toString());
            }
        });
        recyclerView.addOnItemTouchListener(new RecyclerTouchListener(getApplicationContext(), recyclerView, new RecyclerTouchListener.ClickListener() {
            @Override
            public void onClick(View view, int position) {
                Toast.makeText(getApplicationContext(), <?=$tabel?>.get(position).getTitle() + " is selected!", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));
</textarea><br/>
        <?php
	}
}
