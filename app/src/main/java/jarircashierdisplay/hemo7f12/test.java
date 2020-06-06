package jarircashierdisplay.hemo7f12;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.Menu;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

@SuppressWarnings("ALL")
public class test extends AppCompatActivity {
    RecyclerView recyclerView;
    MyAdapter myAdapter;
    List<MyListView> cashierList = new ArrayList<>();
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd / MMMM M / yyyy");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //حذف شريط التنبيهات
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.test);
        EditText date = findViewById(R.id.date);
        date.setText(dateFormat.format(new Date()));

        recyclerView = findViewById(R.id.list_view);

        myAdapter = new MyAdapter(cashierList);
        RecyclerView.LayoutManager myLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(myLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayout.VERTICAL));
        recyclerView.setAdapter(myAdapter);

        prepareCashierData();
        recyclerView.addOnItemTouchListener(new RecyclerTouchListener(
                getApplicationContext(), recyclerView, new RecyclerTouchListener.ClickListener() {
            @Override

            public void onClick(View view, int position) {
                MyListView cashier = cashierList.get(position);
                selectImage();
            }//end onClick

            @Override
            public void onLongClick(View view, int position) {

            }//end onLongClick
        }
        ));//end addOnItemTouchListener


    }//end onCreate

    void prepareCashierData() {


        MyListView cashier1 = new MyListView("Cashier 1", R.drawable.ct, R.drawable.ct, R.drawable.ct);
        cashierList.add(cashier1);

        MyListView cashier2 = new MyListView("Cashier 2", R.drawable.ct, R.drawable.ct, R.drawable.ct);
        cashierList.add(cashier2);

        MyListView cashier3 = new MyListView("Cashier 3", R.drawable.ct, R.drawable.ct, R.drawable.ct);
        cashierList.add(cashier3);

        MyListView cashier4 = new MyListView("Cashier 4", R.drawable.ct, R.drawable.ct, R.drawable.ct);
        cashierList.add(cashier4);

        MyListView cashier5 = new MyListView("Cashier 5", R.drawable.ct, R.drawable.ct, R.drawable.ct);
        cashierList.add(cashier5);

        MyListView cashier6 = new MyListView("Cashier 6", R.drawable.ct, R.drawable.ct, R.drawable.ct);
        cashierList.add(cashier6);

        MyListView cashier7 = new MyListView("Cashier 7", R.drawable.ct, R.drawable.ct, R.drawable.ct);
        cashierList.add(cashier7);

        MyListView cashier8 = new MyListView("Cashier 8", R.drawable.ct, R.drawable.ct, R.drawable.ct);
        cashierList.add(cashier8);

        MyListView cashier9 = new MyListView("Cashier 9", R.drawable.ct, R.drawable.ct, R.drawable.ct);
        cashierList.add(cashier9);

        MyListView cashier10 = new MyListView("Cashier 10", R.drawable.ct, R.drawable.ct, R.drawable.ct);
        cashierList.add(cashier10);

        myAdapter.notifyDataSetChanged();
    }//end prepareCashierData


    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(android.R.menu.class.getModifiers(), menu);
        return true;
    }//end onCreateOptionsMenu

    public void selectImage() {

        final CharSequence[] options = {"Preview", "Take Photo", "Choose from Gallery", "Delete", "Cancel"};
        AlertDialog.Builder builder = new AlertDialog.Builder(test.this);
        builder.setTitle("Add Photo!");
        builder.setItems(options, new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int item) {
                if (options[item].equals("Take Photo")) {
                    Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                    startActivityForResult(intent, 1);
                } else if (options[item].equals("Choose from Gallery")) {
                    Intent intent = new Intent(Intent.ACTION_PICK);
                    intent.setType("image/*");
                    String[] mimeTypes = {"image/jpeg", "image/png"};
                    intent.putExtra(Intent.EXTRA_MIME_TYPES, mimeTypes);
                    startActivityForResult(intent, 2);
                } else if (options[item].equals("Preview")) {
                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    intent.setType("image/*");
                } else if (options[item].equals("Delete")) {
//                                imageleft.setImageResource(R.drawable.ct);
                } else if (options[item].equals("Cancel")) {
                    dialog.dismiss();
                }

            }
        });
        builder.show();
    }// end selectImage


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
     try {
         if (resultCode == RESULT_OK) {
             if (requestCode == 1) {
                 Bundle extras = data.getExtras();
                 Bitmap imageBitmap = (Bitmap) extras.get("data");
//                imgleft.setImageBitmap(imageBitmap);
//                imageleft.setImageResource(R.drawable.lla);

             } else if (requestCode == 2) {
                 Uri selectedImage = data.getData();
//                imageleft.setImageURI(selectedImage);
             }
         }
     }catch (Exception E){
         Toast.makeText(getApplicationContext(),"Error",Toast.LENGTH_LONG).show();
     }
    }//end onActivityResult
}//end class

