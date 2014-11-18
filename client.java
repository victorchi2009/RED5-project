<?xml version="1.0" encoding="utf-8"?>
<mx:Application xmlns:mx="http://www.adobe.com/2006/mxml" layout="absolute"
fontSize="12" backgroundGradientAlphas="[1.0, 1.0]"
backgroundGradientColors="[#FDF9F9, #FDF9F9]" width="442" height="344">
<mx:Script>
<![CDATA[
import mx.controls.Alert;
private var rtmpURL:String="rtmp://localhost/chapter2";
private var conn:NetConnection=new NetConnection();
private var isConnectSuccess:Boolean=false;
private var responder:Responder=new Responder(resultFun);
private function resultFun(object:String):void{
 trace(object);
 result.text=object.toString();
}
private function clickConnect(e:MouseEvent):void{
 conn.addEventListener(NetStatusEvent.NET_STATUS,netStatus);
 conn.connect(rtmpURL);
}
private function click(e:MouseEvent):void{
 invoke();
}
private function invoke():void{
 if(isConnectSuccess){
  conn.call("change",responder,str.text);//change 是服务器端方法名称
 }else{
  Alert.show("还没连接到服务器");
 }
}
private function netStatus(e:NetStatusEvent):void{
 trace(e.info.code);
 if(e.info.code=="NetConnection.Connect.Success"){
  isConnectSuccess=true;
 }
}
]]>
</mx:Script>
<mx:Button x="224" y="175" label="调用服务器方法" click="this.click(event)"/>
<mx:T extInput x="129" y="145" id="str" width="212"/>
<mx:Label x="129" y="119" text="显示从服务器端返回的字符" id="result" width="160"
fontSize="12"/>
<mx:Button x="129" y="175" label="连接服务器" click="this.clickConnect(event)"/>
</mx:Application>