package clear.back;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.net.Uri;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ImageView;



public class ClearBackActivity extends Activity {

	private Uri mImageUri;


	public void onBasicClick(View view) {
	    Intent intent = new Intent();
	    intent.setAction(MediaStore.ACTION_IMAGE_CAPTURE);
	    startActivityForResult(intent, 1);
	}


	public void onExtraClick(View view) {
	    String filename = System.currentTimeMillis() + ".jpg";
	    
	    ContentValues values = new ContentValues();
	    values.put(MediaStore.Images.Media.TITLE, filename);
	    values.put(MediaStore.Images.Media.MIME_TYPE, "image/jpeg");
	    mImageUri = getContentResolver().insert(
	            MediaStore.Images.Media.EXTERNAL_CONTENT_URI, values);
	    
	    Intent intent = new Intent();
	    intent.setAction(MediaStore.ACTION_IMAGE_CAPTURE);
	    intent.putExtra(MediaStore.EXTRA_OUTPUT, mImageUri);
	    startActivityForResult(intent, 2);
	}
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
	    if (requestCode == 2) {
	        // ImageView‚É•\Ž¦‚·‚é‚È‚ç
	        ImageView imageView = (ImageView) findViewById(R.id.main_image);
	        imageView.setImageURI(mImageUri);
	    }

}
