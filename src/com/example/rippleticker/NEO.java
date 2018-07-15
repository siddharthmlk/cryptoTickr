package com.example.rippleticker;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"sellPrice",
"buyPrice",
"lastTradePrice"
})
public class NEO {

@JsonProperty("sellPrice")
private Integer sellPrice;
@JsonProperty("buyPrice")
private Integer buyPrice;
@JsonProperty("lastTradePrice")
private Integer lastTradePrice;

@JsonProperty("sellPrice")
public Integer getSellPrice() {
return sellPrice;
}

@JsonProperty("sellPrice")
public void setSellPrice(Integer sellPrice) {
this.sellPrice = sellPrice;
}

@JsonProperty("buyPrice")
public Integer getBuyPrice() {
return buyPrice;
}

@JsonProperty("buyPrice")
public void setBuyPrice(Integer buyPrice) {
this.buyPrice = buyPrice;
}

@JsonProperty("lastTradePrice")
public Integer getLastTradePrice() {
return lastTradePrice;
}

@JsonProperty("lastTradePrice")
public void setLastTradePrice(Integer lastTradePrice) {
this.lastTradePrice = lastTradePrice;
}
}
