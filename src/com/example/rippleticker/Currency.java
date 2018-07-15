package com.example.rippleticker;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"BTC",
"XRP",
"NEO",
"GAS",
"ETH"
})
public class Currency {

@JsonProperty("BTC")
private BTC bTC;
@JsonProperty("XRP")
private XRP xRP;
@JsonProperty("NEO")
private NEO nEO;
@JsonProperty("GAS")
private GAS gAS;
@JsonProperty("ETH")
private ETH eTH;

@JsonProperty("BTC")
public BTC getBTC() {
return bTC;
}

@JsonProperty("BTC")
public void setBTC(BTC bTC) {
this.bTC = bTC;
}

@JsonProperty("XRP")
public XRP getXRP() {
return xRP;
}

@JsonProperty("XRP")
public void setXRP(XRP xRP) {
this.xRP = xRP;
}

@JsonProperty("NEO")
public NEO getNEO() {
return nEO;
}

@JsonProperty("NEO")
public void setNEO(NEO nEO) {
this.nEO = nEO;
}

@JsonProperty("GAS")
public GAS getGAS() {
return gAS;
}

@JsonProperty("GAS")
public void setGAS(GAS gAS) {
this.gAS = gAS;
}

@JsonProperty("ETH")
public ETH getETH() {
return eTH;
}

@JsonProperty("ETH")
public void setETH(ETH eTH) {
this.eTH = eTH;
}

@Override
public String toString() {
	return "Currency [bTC=" + bTC + ", xRP=" + xRP + ", nEO=" + nEO + ", gAS=" + gAS + ", eTH=" + eTH + "]";
}




}
