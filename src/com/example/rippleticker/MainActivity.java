package com.example.rippleticker;

import java.util.Arrays;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;
import android.app.Activity;
import android.app.Fragment;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_refresh) {
			new HttpRequestTask().execute();
            return true;
        }
        return super.onOptionsItemSelected(item);	
        
	}
	
	/**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.activity_main, container, false);
            return rootView;
        }
    }
    
    private class HttpRequestTask extends AsyncTask<Void, Void, Currency> {
        @Override
        protected Currency doInBackground(Void... params) {
            try {
                final String url = "https://bitbns.com/order/getTickerAll";
                RestTemplate restTemplate = new RestTemplate();
                HttpHeaders headers = new HttpHeaders();
                headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
                headers.add("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36");
                HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
                restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
                ResponseEntity<Currency[]> response = restTemplate.exchange("https://bitbns.com/order/getTickerAll", HttpMethod.GET, entity, Currency[].class);
                Currency[] currencies = response.getBody();
                return prepareCurrencyPrices(currencies);
            } catch (Exception e) {
                Log.e("MainActivity", e.getMessage(), e);
            }

            return null;
        }

        private Currency prepareCurrencyPrices(Currency[] currencies) {
        	Currency finalObj = new Currency();
        	for(Currency c : currencies){
        		if(null != c.getBTC()){
        			finalObj.setBTC(c.getBTC());
        		}else if(null != c.getETH()){
        			finalObj.setETH(c.getETH());
        		}else if(null != c.getXRP()){
        			finalObj.setXRP(c.getXRP());
        		}else if(null != c.getGAS()){
        			finalObj.setGAS(c.getGAS());
        		}else if(null != c.getNEO()){
        			finalObj.setNEO(c.getNEO());
        		}
        	}
        	return finalObj;
			
		}

		@Override
        protected void onPostExecute(Currency greeting) {
            TextView buyPriceText = (TextView) findViewById(R.id.buy_price);
            TextView sellPriceText = (TextView) findViewById(R.id.sell_price);
            TextView lastTradePriceText = (TextView) findViewById(R.id.last_trade_price);

           // greetingIdText.setText(greeting.getId());
            //greetingContentText.setText(greeting.getContent());
        }
}
}
