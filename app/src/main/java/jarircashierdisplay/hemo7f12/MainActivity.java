package jarircashierdisplay.hemo7f12;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.graphics.pdf.PdfDocument;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.view.WindowManager;
import android.webkit.WebView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;

public class MainActivity extends AppCompatActivity {
    ImageView img;
    ScrollView scrollView;
    ImageView chosen;
    EditText date;
    EditText week;
    EditText branch;
    public static Bitmap bitScroll;

    @SuppressLint("SimpleDateFormat")
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd / MMMM M / yyyy");

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        //حذف شريط التنبيهات
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        scrollView = findViewById(R.id.scroll_view);
        week = findViewById(R.id.week);
        branch = findViewById(R.id.branch_name);
        date = findViewById(R.id.today_date);
        date.setText(dateFormat.format(new Date()));

        permissionChecker();
        onKeyListener();
    }

    private void permissionChecker(){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (checkSelfPermission(Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED) {

            } else {
                if (shouldShowRequestPermissionRationale(Manifest.permission.CAMERA)) {
                    Toast.makeText(MainActivity.this, "Camera permission was not accepted", Toast.LENGTH_SHORT).show();
                }
                requestPermissions(new String[]{Manifest.permission.CAMERA}, 1);
            }
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED) {

            } else {
                if (shouldShowRequestPermissionRationale(Manifest.permission.CAMERA)) {
                    Toast.makeText(MainActivity.this, "Camera permission was not accepted", Toast.LENGTH_SHORT).show();
                }
                requestPermissions(new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);
            }
        }
    }
    private void onKeyListener() {
        week.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (keyCode == KeyEvent.KEYCODE_ENTER && event.getAction() == KeyEvent.ACTION_DOWN) {
                    clearFocus();
                    return true;
                }
                return false;
            }
        });
        date.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (keyCode == KeyEvent.KEYCODE_ENTER && event.getAction() == KeyEvent.ACTION_DOWN) {
                    clearFocus();
                    return true;
                }
                return false;
            }
        });

        findViewById(R.id.branch_name).setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (keyCode == KeyEvent.KEYCODE_ENTER && event.getAction() == KeyEvent.ACTION_DOWN) {
                    clearFocus();
                    return true;
                }
                return false;
            }
        });
    }//end onKeyListener()

    private void clearFocus() {
        date.clearFocus();
        week.clearFocus();
        branch.clearFocus();
    }

    public void clearFocusTwo(View view) {
        clearFocus();
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.c1l:
                chosen = findViewById(R.id.c1l);
                selectImage();
                clearFocus();
                break;
            case R.id.c1e:
                chosen = findViewById(R.id.c1e);
                selectImage();
                clearFocus();
                break;
            case R.id.c1r:
                chosen = findViewById(R.id.c1r);
                selectImage();
                clearFocus();
                break;

            case R.id.c2l:
                chosen = findViewById(R.id.c2l);
                selectImage();
                clearFocus();
                break;
            case R.id.c2e:
                chosen = findViewById(R.id.c2e);
                selectImage();
                clearFocus();
                break;
            case R.id.c2r:
                chosen = findViewById(R.id.c2r);
                selectImage();
                clearFocus();
                break;

            case R.id.c3l:
                chosen = findViewById(R.id.c3l);
                selectImage();
                clearFocus();
                break;
            case R.id.c3e:
                chosen = findViewById(R.id.c3e);
                selectImage();
                clearFocus();
                break;
            case R.id.c3r:
                chosen = findViewById(R.id.c3r);
                selectImage();
                clearFocus();
                break;

            case R.id.c4l:
                chosen = findViewById(R.id.c4l);
                selectImage();
                clearFocus();
                break;
            case R.id.c4e:
                chosen = findViewById(R.id.c4e);
                selectImage();
                clearFocus();
                break;
            case R.id.c4r:
                chosen = findViewById(R.id.c4r);
                selectImage();
                clearFocus();
                break;

            case R.id.c5l:
                chosen = findViewById(R.id.c5l);
                selectImage();
                clearFocus();
                break;
            case R.id.c5e:
                chosen = findViewById(R.id.c5e);
                selectImage();
                clearFocus();
                break;
            case R.id.c5r:
                chosen = findViewById(R.id.c5r);
                selectImage();
                clearFocus();
                break;

            case R.id.c6l:
                chosen = findViewById(R.id.c6l);
                selectImage();
                clearFocus();
                break;
            case R.id.c6e:
                chosen = findViewById(R.id.c6e);
                selectImage();
                clearFocus();
                break;
            case R.id.c6r:
                chosen = findViewById(R.id.c6r);
                selectImage();
                clearFocus();
                break;
            default: {
                Toast.makeText(this, "nothing", Toast.LENGTH_LONG).show();
                clearFocus();
                break;
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(android.R.menu.class.getModifiers(), menu);
        return true;
    }

    private void selectImage() {
        final CharSequence[] options = {"Preview", "Take Photo", "Choose from Gallery", "Delete", "Cancel"};
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("Add Photo!");
        builder.setItems(options, new DialogInterface.OnClickListener() {
            @SuppressLint("NewApi")
            @Override
            public void onClick(DialogInterface dialog, int item) {
                if (options[item].equals("Take Photo")) {
                    Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
//                        File f = new File(Environment.getExternalStorageDirectory(), "temp.jpg");
//                        intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(f));
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
                    img.setImageResource(R.drawable.ct);
                } else if (options[item].equals("Cancel")) {
                    dialog.dismiss();
                }
            }
        });
        builder.show();
    }//end selectImage


    @SuppressLint("LongLogTag")
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            if (requestCode == 1) {
                Bundle extras = data.getExtras();
                Bitmap imageBitmap = (Bitmap) extras.get("data");
                chosen.setImageBitmap(imageBitmap);

            } else if (requestCode == 2) {
                Uri selectedImage = data.getData();
                chosen.setImageURI(selectedImage);
            }
        }
    }//end onActivityResult


    public void takeScreenShot(View view) {
        bitScroll = getBitmapFromView(scrollView, scrollView.getChildAt(0).getHeight(), scrollView.getChildAt(0).getWidth());
        ConvertToPDF ();
    }

    private Bitmap getBitmapFromView(View view, int height, int width) {
        Bitmap bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        Drawable bgDrawable = view.getBackground();
        if (bgDrawable != null)
            bgDrawable.draw(canvas);
        else
            canvas.drawColor(Color.WHITE);
        view.draw(canvas);
        return bitmap;
    }

    public void ConvertToPDF (){
        PdfDocument pdfDocument = new PdfDocument();
        PdfDocument.PageInfo pi = new PdfDocument.PageInfo.Builder(bitScroll.getWidth(),bitScroll.getHeight(),1).create();
        PdfDocument.Page page = pdfDocument.startPage(pi);
        Canvas canvas = page.getCanvas();
        Paint paint = new Paint();
        canvas.drawPaint(paint);
        bitScroll = Bitmap.createScaledBitmap(bitScroll,bitScroll.getWidth(),bitScroll.getHeight(),true);
        paint.setColor(Color.BLUE);
        canvas.drawBitmap(bitScroll,0,0,null);
        pdfDocument.finishPage(page);

        File root = new File(Environment.getExternalStorageDirectory(), "Jarir Cashier Display");
        if (!root.exists()){
            root.mkdir();
        }
        File file = new File(root,"Cashier Display Monitoring.pdf");
        try{
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            pdfDocument.writeTo(fileOutputStream);
            Toast.makeText(this,"File Created Successfully",Toast.LENGTH_LONG).show();

        }catch (IOException e){
            e.printStackTrace();
            Toast.makeText(this,"File Not Created",Toast.LENGTH_LONG).show();
        }
        pdfDocument.close();
     Toast.makeText(this,""+file,Toast.LENGTH_LONG).show();
    }





}


