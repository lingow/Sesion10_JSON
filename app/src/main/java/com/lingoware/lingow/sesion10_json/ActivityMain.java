package com.lingoware.lingow.sesion10_json;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.AsyncTask;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

import com.google.gson.Gson;
import com.lingoware.lingow.sesion10_json.beans.DatoResponse;
import com.lingoware.lingow.sesion10_json.beans.Tree;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;


public class ActivityMain extends ActionBarActivity {

    ProgressDialog progressDialog;
    EditText txtNid;
    EditText txtLatitud;
    EditText txtLongitud;
    EditText txtTaxonomia;
    EditText txtJardin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_activity_main);

        txtNid = (EditText) findViewById(R.id.txtNid);
        txtLatitud = (EditText) findViewById(R.id.txtLatitud);
        txtLongitud = (EditText) findViewById(R.id.txtLongitud);
        txtTaxonomia = (EditText) findViewById(R.id.txtTaxonomia);
        txtJardin = (EditText) findViewById((R.id.txtJardin));

        progressDialog = ProgressDialog.show(this, "Please wait...",
                "Retrieving data...", true, true);
        final TreesAsyncTask task = new TreesAsyncTask();
        task.execute();
        progressDialog.setOnCancelListener( new Dialog.OnCancelListener(){

            @Override
            public void onCancel(DialogInterface dialog) {
                task.cancel(true);
            }
        });

    }

    private class TreesAsyncTask extends AsyncTask<Void,Void,Void>{
        DatoResponse response;

        @Override
        protected Void doInBackground(Void... params) {
            String url = "http://papvidadigital.com/risi/?nid=83&format=json";
            HttpGet getRequest = new HttpGet(url);
            try {
                DefaultHttpClient httpClient = new DefaultHttpClient();
                HttpResponse getResponse = httpClient.execute(getRequest);
                final int statusCode = getResponse.getStatusLine().getStatusCode();
                if (statusCode != HttpStatus.SC_OK) {
                    Log.w(getClass().getSimpleName(), "Error " + statusCode
                            + " for URL " + url);
                    return null;
                }
                HttpEntity getResponseEntity = getResponse.getEntity();
                InputStream httpResponseStream = getResponseEntity.getContent();
                Reader inputStreamReader = new InputStreamReader(
                        httpResponseStream);
                Gson gson = new Gson();
                this.response = gson.fromJson(inputStreamReader, DatoResponse.class);
            } catch (IOException e) {
                getRequest.abort();
                Log.w(getClass().getSimpleName(), "Error for URL " + url, e);
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);

            for (Tree tree : this.response.getDato()) {
                txtNid.setText(tree.getNID());
                txtLatitud.setText(tree.getLatitud());
                txtLongitud.setText(tree.getLongitud());
                txtJardin.setText(tree.getJardin());
                txtTaxonomia.setText(tree.getTaxonomia());
            }
            progressDialog.cancel();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_activity_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
