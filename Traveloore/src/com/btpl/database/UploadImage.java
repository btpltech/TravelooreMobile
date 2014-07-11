package com.btpl.database;

import java.io.File;

import java.io.FileOutputStream;
import java.util.Random;

import com.alexrs95.slidingmenuandviewpager.R;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class UploadImage extends Activity implements OnClickListener {

	private static final int REQ_CODE_PICK_IMAGE = 0;
	private static final int TAKE_IMAGE_CODE = 1;
	String UPLOAD_FILE_PATH = "", lat, longi, username;

	Button map, takeimage, browseimage, photo;
	String userId;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.upload_image);

		takeimage = (Button) findViewById(R.id.TAKE_IMG);
		takeimage.setOnClickListener(this);

		browseimage = (Button) findViewById(R.id.browse);
		browseimage.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {

		case R.id.TAKE_IMG:
			Intent takePictureIntent = new Intent(
					"android.media.action.IMAGE_CAPTURE");
			startActivityForResult(takePictureIntent, TAKE_IMAGE_CODE);
			break;

		case R.id.browse:
			Intent intent = new Intent(Intent.ACTION_PICK);
			intent.setType("image/*");
			startActivityForResult(intent, REQ_CODE_PICK_IMAGE);
			break;

		}

	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode,
			Intent imageReturnedIntent) {
		super.onActivityResult(requestCode, resultCode, imageReturnedIntent);

		switch (requestCode) {
		case REQ_CODE_PICK_IMAGE:
			if (resultCode == RESULT_OK) {
				Uri selectedImage = imageReturnedIntent.getData();
				String[] filePathColumn = { MediaStore.Images.Media.DATA };

				Cursor cursor = getContentResolver().query(selectedImage,
						filePathColumn, null, null, null);
				cursor.moveToFirst();

				int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
				String filePath = cursor.getString(columnIndex);
				cursor.close();
				UPLOAD_FILE_PATH = filePath;

				// Bitmap yourSelectedImage =
				// BitmapFactory.decodeFile(filePath);
				
			}
			break;
		case TAKE_IMAGE_CODE:
			if (resultCode == RESULT_OK) {

				String root = Environment.getExternalStorageDirectory()
						.toString();
				File myDir = new File(root + "/req_images");
				myDir.mkdirs();
				Random generator = new Random();
				int n = 10000;
				n = generator.nextInt(n);
				String fname = "Image-" + n + ".jpg";
				File file = new File(myDir, fname);
				UPLOAD_FILE_PATH = "" + file;
				Log.i("FILE PATH", UPLOAD_FILE_PATH);

				if (file.exists())
					file.delete();
				try {
					FileOutputStream out = new FileOutputStream(file);
					Bitmap bm = (Bitmap) imageReturnedIntent.getExtras().get(
							"data");
					bm.compress(Bitmap.CompressFormat.JPEG, 90, out);
					
					out.flush();
					out.close();
				} catch (Exception e) {
					e.printStackTrace();
				}

			}
		}
	}
}
