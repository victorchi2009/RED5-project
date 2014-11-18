package first;

import org.red5.server.adapter.Applic ationAdapter;
import org.red5.server.api.IConnection;

public class Application extends ApplicationAdapter {
    public boolean appConnect(IConnection conn, Object[] args) {
        System.out.println(" 连接");
        return true;
 }
    public String change(String str){
        System.out.println(" 客户端调用服务器");
        return str.toUpperCase();// 传入的字符串转换成大写后返回
 }
}